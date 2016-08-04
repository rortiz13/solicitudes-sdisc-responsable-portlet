package la.netco.admin_sdisc.uilayer.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

import la.netco.admin_sdisc.uilayer.list.SolicitudWrapper;
import la.netco.solicitudes_sdisc.model.model.Ciudad;
import la.netco.solicitudes_sdisc.model.model.Delegado;
import la.netco.solicitudes_sdisc.model.model.Departamento;
import la.netco.solicitudes_sdisc.model.model.Entidad;
import la.netco.solicitudes_sdisc.model.model.Especialidad;
import la.netco.solicitudes_sdisc.model.model.Estado;
import la.netco.solicitudes_sdisc.model.model.Implicado;
import la.netco.solicitudes_sdisc.model.model.Parametros;
import la.netco.solicitudes_sdisc.model.model.PerfilImplicado;
import la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta;
import la.netco.solicitudes_sdisc.model.model.Solicitante;
import la.netco.solicitudes_sdisc.model.model.Solicitud;
import la.netco.solicitudes_sdisc.model.model.TipoDocumento;
import la.netco.solicitudes_sdisc.model.service.CiudadLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.DelegadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.DepartamentoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.EntidadLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.EspecialidadLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.EstadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ImplicadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ParametrosLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.PerfilImplicadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ResponsableRespuestaLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitanteLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.TipoDocumentoLocalServiceUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.jsf.common.FacesMessageUtil;


@ManagedBean(name = "adminSolicitudesBean")
@ViewScoped
public class AdminSolicitudesBean implements Serializable {


	private static Log _log = LogFactoryUtil.getLog(AdminSolicitudesBean.class);

	
	private static final long serialVersionUID = 1L;
	
	private Date fechaInicial;
	private Date fechaFinal=null;
	private Integer id_ciudad_solicitante;
	
	private SolicitudDataModel solicitudes;

	private List<SelectItem> ciudadesItems;
	private List<SelectItem> departametosItems;
	private List<SelectItem> perfilesItems;	
	private List<SelectItem> estadosItems;	

	private Integer id_departamento;
	private Integer id_perfil;
	private Integer id_estado;

	private Integer idRegSeleccionado;

	private SolicitudWrapper registroSelecionado;
	
	private String respuesta;
	
	private long tiempoProximoCaducar;
	private long tiempoCaducidad;
	
	private static String PERFIL_JUEZ = "Juez";
	private static String PERFIL_MAGISTRADO = "Magistrado";
	private static String PERFIL_ABOGADO = "Abogado";
	private static String PERFIL_FISCAL = "Fiscal";
	
	private long repositoryId;
	private long folderId;
	private List<ArchivoSolicitud> urlArchivos = new ArrayList<ArchivoSolicitud>();

	
	public  AdminSolicitudesBean(){
		
		//if(tiempoProximoCaducar == null || tiempoCaducidad == null){
			try {
				Parametros parametro = ParametrosLocalServiceUtil.getParametroses(QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			
				tiempoCaducidad = parametro.getTiempo_caducidad();
				tiempoProximoCaducar = parametro.getTiempo_proximo_caducar();
				repositoryId=parametro.getRepositoryId();
				folderId=parametro.getFolderId();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			
		//}
	}
	
	public String  actualizarRegistro() {
		String page =null;
		try {
			
			ResponsableRespuesta responsable = ResponsableRespuestaLocalServiceUtil.createResponsableRespuesta(0);
			responsable.setId_solicitud(registroSelecionado.getId_solicitud());
			responsable.setRespuesta(respuesta);
			responsable.setFecha_respuesta(new Date(System.currentTimeMillis()));
			
			User user = PermissionCheckerUtil.getCurrentUser();
			
			responsable.setNombre_usuario(user.getScreenName());
			
			//CREA RESPONSABLE
			ResponsableRespuestaLocalServiceUtil.addResponsableRespuesta(responsable);
			
			//ACTUALIZA ESTADO
			Solicitud solicitud = registroSelecionado.getWrapped();
			Estado  estadoAct = EstadoLocalServiceUtil.findByNombre(Constants.ESTADO_ATENDIDA);
			solicitud.setId_estado(estadoAct.getId_estado());
			SolicitudLocalServiceUtil.updateSolicitud(solicitud);
			
			//ENVIA CORREO
			
			
			if (solicitud != null
					&& registroSelecionado.getSolicitante() != null
					&& registroSelecionado.getSolicitante().getEmail() != null
					&& !registroSelecionado.getSolicitante().getEmail().equals("")) {
				
				sendMailRespuesta(Constants.ASUNTO_RESPUESTA, respuesta,registroSelecionado.getSolicitante().getEmail()); 
				
			}
			
			FacesMessageUtil.info(FacesContext.getCurrentInstance(), Constants.OPERACION_EXITOSA);
			
			page = "transaccionExitosa";
			registroSelecionado = null;
		} catch (Exception e) {
			FacesMessageUtil.error(FacesContext.getCurrentInstance(), Constants.ERROR_OPERACION);
			e.printStackTrace();
		}
		
		return page;
	}
	
	
public  void sendMailRespuesta(String asunto, String respuesta, String emailsolicitante) {
		
		InternetAddress to;
		try {
					
			to = new InternetAddress(emailsolicitante);
			String from =  MailServiceUtil.getService().getSession().getProperties().getProperty("mail.smtp.user"); 
			MailMessage mailMessage = new MailMessage(new InternetAddress(from), to, asunto,respuesta, true);
			
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public String cargaFiltrosDataModel() {
		
		
		if(solicitudes == null)
			solicitudes = new SolicitudDataModel();
			
		Map<String, Object> filtros = new HashMap<String, Object>();
		
		filtros.put("fechaIni", fechaInicial);
		filtros.put("fechaFin", fechaFinal);
		filtros.put("id_ciudad_solicitante", id_ciudad_solicitante);		
		filtros.put("id_perfil", id_perfil);
		filtros.put("id_estado", id_estado);

		solicitudes.setFiltros(filtros);
		return "";
	}
	
	public void cargarObjeto(){	
		try {
			if(idRegSeleccionado == null){
				 FacesContext facesContext = FacesContext.getCurrentInstance();
			     String idRegSeleccionado = facesContext.getExternalContext().getRequestParameterMap().get("idRegSeleccionado");
			     
			     if(idRegSeleccionado != null) this.idRegSeleccionado = Integer.parseInt(idRegSeleccionado);
			}
		
			
			if((registroSelecionado == null || registroSelecionado.getId_solicitud() == 0)&&  (idRegSeleccionado != null && !idRegSeleccionado.equals(""))){
				
				Solicitud solicitud = SolicitudLocalServiceUtil.getSolicitud(idRegSeleccionado);
				
				Estado estado = EstadoLocalServiceUtil.getEstado(solicitud.getId_estado());
				Solicitante solicitante = SolicitanteLocalServiceUtil.getSolicitante(solicitud.getId_solicitante());
				Implicado implicado =ImplicadoLocalServiceUtil.getImplicado(solicitud.getId_implicado());	
				PerfilImplicado perfil =PerfilImplicadoLocalServiceUtil.getPerfilImplicado(implicado.getId_perfil());
				TipoDocumento tipoDocSolicitante = null;
				Ciudad ciudadSolicitante = null;
				Departamento departamentoSolicitante =  null;
				
				Ciudad ciudadImplicado = null;
				Departamento departamentoImplicado=  null;
				

				Entidad entidadImplicado=  null;
				Especialidad especialidadImplicado=  null;
				Delegado delegadoImplicado=  null;
				
				if(solicitante.getId_tipo_doc() != null){
					tipoDocSolicitante = TipoDocumentoLocalServiceUtil.getTipoDocumento(solicitante.getId_tipo_doc());
				}
				
				if(solicitante.getId_ciudad() != null){
					ciudadSolicitante = CiudadLocalServiceUtil.getCiudad(solicitante.getId_ciudad());
				}
				
				if(ciudadSolicitante != null){
					departamentoSolicitante = DepartamentoLocalServiceUtil.getDepartamento(ciudadSolicitante.getId_departamento());
				}
				
				
				if(implicado.getId_ciudad() != null){
					ciudadImplicado = CiudadLocalServiceUtil.getCiudad(implicado.getId_ciudad());
				}
				
				if(ciudadImplicado != null){
					departamentoImplicado = DepartamentoLocalServiceUtil.getDepartamento(ciudadImplicado.getId_departamento());
				}
				
				if(implicado.getCod_entidad() != null && !implicado.getCod_entidad().isEmpty()){
					entidadImplicado = EntidadLocalServiceUtil.getEntidad(implicado.getCod_entidad());
				}
				
				if(implicado.getCod_especialidad() != null && !implicado.getCod_especialidad().isEmpty()){
					especialidadImplicado = EspecialidadLocalServiceUtil.getEspecialidad(implicado.getCod_especialidad());
				}
				
				if(implicado.getId_delegado() != null){
					delegadoImplicado = DelegadoLocalServiceUtil.getDelegado(implicado.getId_delegado());
				}
				
				registroSelecionado = new SolicitudWrapper(solicitud, estado, solicitante,implicado,perfil, tipoDocSolicitante,departamentoSolicitante,ciudadSolicitante,ciudadImplicado, departamentoImplicado, entidadImplicado, especialidadImplicado, delegadoImplicado);
				
				if (registroSelecionado.getEstado().getNombre().equals(Constants.ESTADO_SIN_LEER)){
					Estado  estadoAct = EstadoLocalServiceUtil.findByNombre(Constants.ESTADO_LEIDA);
					solicitud.setId_estado(estadoAct.getId_estado());
					SolicitudLocalServiceUtil.updateSolicitud(solicitud);
				}
				cargarUrlArchivos(idRegSeleccionado);
			}
		} catch (Exception e) {
			_log.error("Error leyendo objeto ", e);
		}
	}
	
	private void cargarUrlArchivos(Integer idSolicitud){
		
		try {
			Folder folder = DLAppLocalServiceUtil.getFolder(repositoryId, folderId, "" + idSolicitud);
			List<FileEntry> filesEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
		
			for (FileEntry fileEntry : filesEntries) {
				fileEntry = fileEntry.toEscapedModel();
				long folderId = fileEntry.getFolderId();
				String title = fileEntry.getTitle();

			
				PortletRequest portletRequest = (PortletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
				ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				String fileUrl = themeDisplay.getPortalURL()
						+ themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "//" + folderId
						+ "//" + HttpUtil.encodeURL(HtmlUtil.unescape(title));
				ArchivoSolicitud archivo = new ArchivoSolicitud();
				archivo.setUrl(fileUrl);
				archivo.setNombre(title);
				urlArchivos.add(archivo);

			}
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public Integer getId_ciudad_solicitante() {
		return id_ciudad_solicitante;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
		if(fechaFinal==null || fechaFinal.equals(""))
		{
			SimpleDateFormat SD= new SimpleDateFormat("dd/MM/yyyy");
			fechaFinal=new Date();
			try {
				fechaFinal= SD.parse(SD.format(fechaFinal));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.err.println("ERROR*****:El parseo de la fecha fina en consulta administracion es erronea");
			}
		}
	}
	public void setId_ciudad_solicitante(Integer id_ciudad_solicitante) {
		this.id_ciudad_solicitante = id_ciudad_solicitante;
	}
	public SolicitudDataModel getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(SolicitudDataModel solicitudes) {
		this.solicitudes = solicitudes;
	}
	public List<SelectItem> getCiudadesItems() {
		if (id_departamento != null && id_departamento != null) {
			try {
				List<Ciudad> allCiudades = CiudadLocalServiceUtil.findBydepartamento(id_departamento);
				ciudadesItems = new ArrayList<SelectItem>();
				for (Ciudad ciudad : allCiudades) {
					ciudadesItems.add(new SelectItem(ciudad.getId_ciudad(), ciudad.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ciudadesItems;
	}

	public void setCiudadesItems(List<SelectItem> ciudadesItems) {
		this.ciudadesItems = ciudadesItems;
	}
	public List<SelectItem> getDepartametosItems() {
		if (departametosItems == null) {
			try {
				List<Departamento> datos = DepartamentoLocalServiceUtil.getDepartamentos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				departametosItems = new ArrayList<SelectItem>();
				for (Departamento dato : datos) {
					departametosItems.add(new SelectItem(dato.getId_departamento(), dato.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return departametosItems;
	}
	public void setDepartametosItems(List<SelectItem> departametosItems) {
		this.departametosItems = departametosItems;
	}

	public Integer getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
	}
	public List<SelectItem> getPerfilesItems() {
		if (perfilesItems == null) {
			try {
				List<PerfilImplicado> datos = PerfilImplicadoLocalServiceUtil.getPerfilImplicados(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				perfilesItems = new ArrayList<SelectItem>();
				for (PerfilImplicado dato : datos) {
					perfilesItems.add(new SelectItem(dato.getId_perfil(), dato.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return perfilesItems;
	}

	public void setPerfilesItems(List<SelectItem> perfilesItems) {
		this.perfilesItems = perfilesItems;
	}

	public Integer getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}

	public List<SelectItem> getEstadosItems() {
		if (estadosItems == null) {
			try {
				List<Estado> datos = EstadoLocalServiceUtil.getEstados(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				estadosItems = new ArrayList<SelectItem>();
				for (Estado dato : datos) {
					estadosItems.add(new SelectItem(dato.getId_estado(), dato.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return estadosItems;
	}

	public void setEstadosItems(List<SelectItem> estadosItems) {
		this.estadosItems = estadosItems;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}


	public Integer getIdRegSeleccionado() {
		return idRegSeleccionado;
	}


	public void setIdRegSeleccionado(Integer idRegSeleccionado) {
		this.idRegSeleccionado = idRegSeleccionado;
	}


	public SolicitudWrapper getRegistroSelecionado() {
		return registroSelecionado;
	}


	public void setRegistroSelecionado(SolicitudWrapper registroSelecionado) {
		this.registroSelecionado = registroSelecionado;
	}


	public String getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public long getTiempoProximoCaducar() {
		return tiempoProximoCaducar;
	}


	public long getTiempoCaducidad() {
		return tiempoCaducidad;
	}


	public void setTiempoProximoCaducar(Integer tiempoProximoCaducar) {
		this.tiempoProximoCaducar = tiempoProximoCaducar;
	}


	public void setTiempoCaducidad(Integer tiempoCaducidad) {
		this.tiempoCaducidad = tiempoCaducidad;
	}
	
	
	public String colorBandera(long antiguedad){
		
		if((antiguedad  >= tiempoProximoCaducar)  && (antiguedad < tiempoCaducidad )){
			return "styleAmarillo";			
		}else if((antiguedad  >= tiempoCaducidad)){
			return "styleRojo";			
		}else if((antiguedad  <= tiempoProximoCaducar)){
			return "styleVerde";			
		}
		
		return "styleVerde";
	}
	
	public boolean isPerfilJuezMagistrado(){
		try {
			if(registroSelecionado.getPerfil()!= null){
				PerfilImplicado perfil = registroSelecionado.getPerfil();
				if(perfil.getNombre().equals(PERFIL_JUEZ) || perfil.getNombre().equals(PERFIL_MAGISTRADO))
					return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean isPerfilJuezMagistradoAbogado(){
		try {
			if(registroSelecionado.getPerfil()!= null){
				PerfilImplicado perfil = registroSelecionado.getPerfil();				
				if(perfil.getNombre().equals(PERFIL_JUEZ) || perfil.getNombre().equals(PERFIL_MAGISTRADO) || perfil.getNombre().equals(PERFIL_ABOGADO))
					return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean isPerfilFiscal(){
		try {
			if(registroSelecionado.getPerfil()!= null){
				PerfilImplicado perfil = registroSelecionado.getPerfil();
				if(perfil.getNombre().equals(PERFIL_FISCAL))
					return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<ArchivoSolicitud> getUrlArchivos() {
		return urlArchivos;
	}

	public void setUrlArchivos(List<ArchivoSolicitud> urlArchivos) {
		this.urlArchivos = urlArchivos;
	}

}
