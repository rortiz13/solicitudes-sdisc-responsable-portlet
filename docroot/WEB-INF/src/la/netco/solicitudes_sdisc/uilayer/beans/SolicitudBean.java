package la.netco.solicitudes_sdisc.uilayer.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletPreferences;

import la.netco.solicitudes_sdisc.model.model.Ciudad;
import la.netco.solicitudes_sdisc.model.model.Delegado;
import la.netco.solicitudes_sdisc.model.model.Departamento;
import la.netco.solicitudes_sdisc.model.model.Entidad;
import la.netco.solicitudes_sdisc.model.model.Especialidad;
import la.netco.solicitudes_sdisc.model.model.Estado;
import la.netco.solicitudes_sdisc.model.model.Implicado;
import la.netco.solicitudes_sdisc.model.model.Parametros;
import la.netco.solicitudes_sdisc.model.model.PerfilImplicado;
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
import la.netco.solicitudes_sdisc.model.service.SolicitanteLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.TipoDocumentoLocalServiceUtil;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.persistence.PortletUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.jsf.common.FacesMessageUtil;
import com.liferay.util.bridges.jsf.common.JSFPortletUtil;

@ManagedBean(name = "solicitudBean")
@ViewScoped
public class SolicitudBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private DatosSolicitudTO datosSolicitud;
	private List<SelectItem> ciudadesItems;
	private List<SelectItem> perfilesItems;
	private List<SelectItem> tipoDocumentosItems;
	private List<SelectItem> departametosItems;
	private List<SelectItem> entidadesItems;
	private List<SelectItem> especilidadesItems;
	private List<SelectItem> ciudadesImplicadoItems;
	private List<SelectItem> delegadoItems=null;

	private static String PERFIL_JUEZ = "Juez";
	private static String PERFIL_MAGISTRADO = "Magistrado";
	private static String PERFIL_ABOGADO = "Abogado";
	private static String PERFIL_FISCAL = "Fiscal";
	
	private String fileSizeLimit;
	private List<UploadedFile> filesUploads = new ArrayList<UploadedFile>();

	private long repositoryId;
	private long folderId;
	private long userRepositoryId;
	private String numeroDespacho;
	public String getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(String numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	public SolicitudBean() {
		datosSolicitud = new DatosSolicitudTO();
		try {
			fileSizeLimit = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE)	+ "";
			Parametros parametro = ParametrosLocalServiceUtil.getParametroses(QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			repositoryId=parametro.getRepositoryId();
			folderId=parametro.getFolderId();
			userRepositoryId=parametro.getUserRepositoryId();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public String crearRegistro() {
		String page = null;
		try {

			PortletPreferences test = JSFPortletUtil.getPortletPreferences(FacesContext.getCurrentInstance());
			test.setValue("repositoryID", repositoryId+"");
			
			JSFPortletUtil.getPreferenceValue(FacesContext.getCurrentInstance(), "repositoryID");
			
			Solicitante solicitante = SolicitanteLocalServiceUtil
					.createSolicitante(0);
			solicitante.setNombres(datosSolicitud.getNombres_solicitante());
			solicitante.setApellidos(datosSolicitud.getApellidos_solicitante());
			solicitante.setNum_documento(datosSolicitud
					.getNum_documento_solicitante());
			solicitante.setDireccion(datosSolicitud.getDireccion_solicitante());
			solicitante.setTelefono(datosSolicitud.getTelefono_solicitante());
			solicitante.setEmail(datosSolicitud.getEmail_solicitante());

			if (datosSolicitud.getId_tipo_doc_solicitante() != null) {
				System.out.println("setea id documentos");
				solicitante.setId_tipo_doc(datosSolicitud
						.getId_tipo_doc_solicitante());
			}

			if (datosSolicitud.getId_ciudad_solicitante() != null) {
				solicitante.setId_ciudad(datosSolicitud
						.getId_ciudad_solicitante());
			}

			solicitante = SolicitanteLocalServiceUtil
					.addSolicitante(solicitante);

			Implicado implicado = ImplicadoLocalServiceUtil.createImplicado(0);
			implicado.setNombre(datosSolicitud.getNombre_implicado());
			implicado.setDespacho_entidad(datosSolicitud.getDespacho_entidad());
			implicado.setId_perfil(datosSolicitud.getId_perfil());

			if (datosSolicitud.getId_ciudad_implicado() != null) {
				implicado.setId_ciudad(datosSolicitud.getId_ciudad_implicado());
			}

			if (datosSolicitud.getId_entidad_implicado() != null) {
				implicado.setCod_entidad(datosSolicitud
						.getId_entidad_implicado());
			}

			if (datosSolicitud.getId_especialidad_implicado() != null) {
				implicado.setCod_especialidad(datosSolicitud
						.getId_especialidad_implicado());
			}

			if (datosSolicitud.getId_delegado() != null) {
				implicado.setId_delegado(datosSolicitud.getId_delegado());
			}

			implicado = ImplicadoLocalServiceUtil.addImplicado(implicado);

			Solicitud solicitud = SolicitudLocalServiceUtil.createSolicitud(0);
			solicitud.setHechos(datosSolicitud.getHechos());
			solicitud.setPruebas(datosSolicitud.getPruebas());
			solicitud.setId_implicado(implicado.getId_implicado());
			
			Estado estado = null;
			if ((datosSolicitud.getDireccion_solicitante() == null || datosSolicitud
					.getDireccion_solicitante().trim().equals(""))
					&& (datosSolicitud.getEmail_solicitante() == null || datosSolicitud
							.getEmail_solicitante().trim().equals(""))) {
				estado = EstadoLocalServiceUtil
						.findByNombre(Constants.ESTADO_DE_OFICIO);
			} else {
				estado = EstadoLocalServiceUtil
						.findByNombre(Constants.ESTADO_SIN_LEER);
			}
			solicitud.setId_solicitante(solicitante.getId_solicitante());
			solicitud.setId_estado(estado.getId_estado());
			solicitud.setFechaRegistro(new Date(System.currentTimeMillis()));

			solicitud = SolicitudLocalServiceUtil.addSolicitud(solicitud);
			if (solicitud.getId_solicitud() != 0) {
				page = "transaccionExitosa";
				FacesMessageUtil.info(FacesContext.getCurrentInstance(),
						Constants.OPERACION_EXITOSA);

				System.out.println(" files " + filesUploads.size());

				try {
					Folder folder = null;
					try {
						folder = DLAppLocalServiceUtil.addFolder(
								userRepositoryId, repositoryId, folderId,
								"" + solicitud.getId_solicitud(), "",
								new ServiceContext());
					} catch (DuplicateFolderNameException e) {
						
						folder = DLAppLocalServiceUtil.getFolder(repositoryId,
								folderId, "" + solicitud.getId_solicitud());
					}

					// DLAppServiceUtil
					for (UploadedFile file : filesUploads) {
						
						DLAppLocalServiceUtil.addFileEntry(userRepositoryId,
								repositoryId, folder.getFolderId(),
								file.getFileName(), file.getContentType(),
								null, null, null, file.getContents(),
								new ServiceContext());
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				// ENVIA CORREO
				sendMailResponsable();

			} else {

				FacesMessageUtil.error(FacesContext.getCurrentInstance(),
						Constants.ERROR_OPERACION);

			}

		} catch (Exception e) {
			FacesMessageUtil.error(FacesContext.getCurrentInstance(),
					Constants.ERROR_OPERACION);
			e.printStackTrace();
		}

		return page;
	}

	public void pruebaArchivo() {
		System.out.println(" files " + filesUploads.size());

	}

	public void uploadFile(FileUploadEvent event) {
		try {
			filesUploads.add(event.getFile());

			// filesUploads = event.getFile();
		} catch (Exception e) {

			FacesMessageUtil.error(FacesContext.getCurrentInstance(),
					Constants.ERROR_OPERACION);
			e.printStackTrace();
		}
	}

	public void sendMailResponsable() {

		InternetAddress to;
		try {

			Parametros parametro = ParametrosLocalServiceUtil.getParametroses(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			to = new InternetAddress(parametro.getEmail_resposable());
			String from = MailServiceUtil.getService().getSession()
					.getProperties().getProperty("mail.smtp.user");
			MailMessage mailMessage = new MailMessage(
					new InternetAddress(from), to, parametro.getAsunto_email(),
					parametro.getMensaje_email(), true);

			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public DatosSolicitudTO getDatosSolicitud() {
		return datosSolicitud;
	}

	public void setDatosSolicitud(DatosSolicitudTO datosSolicitud) {
		this.datosSolicitud = datosSolicitud;
	}

	public List<SelectItem> getCiudadesItems() {
		if (datosSolicitud != null
				&& datosSolicitud.getId_departamento_solicitante() != null) {
			try {
				List<Ciudad> allCiudades = CiudadLocalServiceUtil
						.findBydepartamento(datosSolicitud
								.getId_departamento_solicitante());
				ciudadesItems = new ArrayList<SelectItem>();
				for (Ciudad ciudad : allCiudades) {
					ciudadesItems.add(new SelectItem(ciudad.getId_ciudad(),
							ciudad.getNombre()));
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

	public List<SelectItem> getPerfilesItems() {
		if (perfilesItems == null) {
			try {
				List<PerfilImplicado> datos = PerfilImplicadoLocalServiceUtil
						.getPerfilImplicados(QueryUtil.ALL_POS,
								QueryUtil.ALL_POS);
				perfilesItems = new ArrayList<SelectItem>();
				for (PerfilImplicado dato : datos) {
					perfilesItems.add(new SelectItem(dato.getId_perfil(), dato
							.getNombre()));
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

	public List<SelectItem> getTipoDocumentosItems() {
		if (tipoDocumentosItems == null) {
			try {
				List<TipoDocumento> datos = TipoDocumentoLocalServiceUtil
						.getTipoDocumentos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				tipoDocumentosItems = new ArrayList<SelectItem>();
				for (TipoDocumento dato : datos) {
					tipoDocumentosItems.add(new SelectItem(dato
							.getId_tipo_doc(), dato.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return tipoDocumentosItems;
	}

	public void setTipoDocumentosItems(List<SelectItem> tipoDocumentosItems) {
		this.tipoDocumentosItems = tipoDocumentosItems;
	}

	public List<SelectItem> getDepartametosItems() {
		if (departametosItems == null) {
			try {
				List<Departamento> datos = DepartamentoLocalServiceUtil
						.getDepartamentos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				departametosItems = new ArrayList<SelectItem>();
				for (Departamento dato : datos) {
					departametosItems.add(new SelectItem(dato
							.getId_departamento(), dato.getNombre()));
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

	public List<SelectItem> getEntidadesItems() {
		if (entidadesItems == null) {
			try {
				List<Entidad> datos = EntidadLocalServiceUtil.getEntidads(
						QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				entidadesItems = new ArrayList<SelectItem>();
				for (Entidad dato : datos) {
					entidadesItems.add(new SelectItem(dato.getCodigo(), dato
							.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return entidadesItems;
	}

	public List<SelectItem> getEspecilidadesItems() {
		if (especilidadesItems == null) {
			try {
				List<Especialidad> datos = EspecialidadLocalServiceUtil
						.getEspecialidads(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				especilidadesItems = new ArrayList<SelectItem>();
				for (Especialidad dato : datos) {
					especilidadesItems.add(new SelectItem(dato.getCodigo(),
							dato.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return especilidadesItems;
	}

	public void setEntidadesItems(List<SelectItem> entidadesItems) {
		this.entidadesItems = entidadesItems;
	}

	public void setEspecilidadesItems(List<SelectItem> especilidadesItems) {
		this.especilidadesItems = especilidadesItems;
	}

	public List<SelectItem> getCiudadesImplicadoItems() {
		if (datosSolicitud != null
				&& datosSolicitud.getId_departamento_implicado() != null) {
			try {
				List<Ciudad> allCiudades = CiudadLocalServiceUtil
						.findBydepartamento(datosSolicitud
								.getId_departamento_implicado());
				ciudadesImplicadoItems = new ArrayList<SelectItem>();
				for (Ciudad ciudad : allCiudades) {
					ciudadesImplicadoItems.add(new SelectItem(ciudad
							.getId_ciudad(), ciudad.getNombre()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ciudadesImplicadoItems;
	}

	public void setCiudadesImplicadoItems(
			List<SelectItem> ciudadesImplicadoItems) {
		this.ciudadesImplicadoItems = ciudadesImplicadoItems;
	}

	public boolean isPerfilJuezMagistrado() {
		try {
			if (datosSolicitud.getId_perfil() != null) {
				PerfilImplicado perfil = PerfilImplicadoLocalServiceUtil
						.getPerfilImplicado(datosSolicitud.getId_perfil());
				if (perfil.getNombre().equals(PERFIL_JUEZ)
						|| perfil.getNombre().equals(PERFIL_MAGISTRADO))
					return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean isPerfilJuezMagistradoAbogado() {
		try {
			if (datosSolicitud.getId_perfil() != null) {
				PerfilImplicado perfil = PerfilImplicadoLocalServiceUtil
						.getPerfilImplicado(datosSolicitud.getId_perfil());
				if (perfil.getNombre().equals(PERFIL_JUEZ)
						|| perfil.getNombre().equals(PERFIL_MAGISTRADO)
						|| perfil.getNombre().equals(PERFIL_ABOGADO))
					return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean isPerfilFiscal() {
		try {
			if (datosSolicitud.getId_perfil() != null) {
				PerfilImplicado perfil = PerfilImplicadoLocalServiceUtil
						.getPerfilImplicado(datosSolicitud.getId_perfil());
				if (perfil.getNombre().equals(PERFIL_FISCAL))
					return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<SelectItem> getDelegadoItems() {
		if (delegadoItems == null) {
			try {
				List<Delegado> datos = DelegadoLocalServiceUtil.getDelegados(
						QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				delegadoItems = new ArrayList<SelectItem>();
				for (Delegado dato : datos) {
					delegadoItems.add(new SelectItem(dato.getId_delegado(),
							dato.getNombre()));
				}
				delegadoItems.add(new SelectItem("001","Juzgados Promiscuos Municipales y Promiscuos del Circuito"));
				delegadoItems.add(new SelectItem("002","Juzgados Penal con función de garantías"));
				delegadoItems.add(new SelectItem("003","Juzgados Penales del Circuito de conocimiento"));
				delegadoItems.add(new SelectItem("004","Juzgados de Adolescentes"));
				delegadoItems.add(new SelectItem("005","Juzgados Especializados"));
				delegadoItems.add(new SelectItem("006","Tribunales Superiores Sala Penal"));
				delegadoItems.add(new SelectItem("007","Corte Suprema de Justicia"));
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return delegadoItems;
	}

	public void setDelegadoItems(List<SelectItem> delegadoItems) {
		this.delegadoItems = delegadoItems;
	}

	public String getFileSizeLimit() {
		return fileSizeLimit;
	}

	public void setFileSizeLimit(String fileSizeLimit) {
		this.fileSizeLimit = fileSizeLimit;
	}

	public List<UploadedFile> getFilesUploads() {
		return filesUploads;
	}

	public void setFilesUploads(List<UploadedFile> filesUploads) {
		this.filesUploads = filesUploads;
	}

}
