package la.netco.admin_sdisc.uilayer.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import la.netco.solicitudes_sdisc.model.model.Parametros;
import la.netco.solicitudes_sdisc.model.service.ParametrosLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.jsf.common.FacesMessageUtil;


@ManagedBean(name = "parametrosBean")
@ViewScoped
public class ParametrosBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	//private static Log _log = LogFactoryUtil.getLog(ParametrosBean.class);

	
	private Integer tiempoProximoCaducar;
	private Integer tiempoCaducidad;
	private String emailResposable;
	private String mensajeEmail;
	private String asuntoEmail;
	
	private long repositoryId;
	private long folderId;
	private long userRepositoryId;
	
	public ParametrosBean(){
		if(emailResposable ==null){
			try {
				Parametros parametro = ParametrosLocalServiceUtil.getParametroses(QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			
				tiempoCaducidad = parametro.getTiempo_caducidad();
				tiempoProximoCaducar = parametro.getTiempo_proximo_caducar();
			
				emailResposable = parametro.getEmail_resposable();
				mensajeEmail = parametro.getMensaje_email();
				asuntoEmail = parametro.getAsunto_email();
				
				repositoryId = parametro.getRepositoryId();
				folderId= parametro.getFolderId();
				userRepositoryId = parametro.getRepositoryId(); 
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public String  actualizarRegistro() {
		String page =null;
		try {
			
			Parametros parametro = ParametrosLocalServiceUtil.getParametroses(QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			
			parametro.setAsunto_email(asuntoEmail);
			parametro.setEmail_resposable(emailResposable);
			parametro.setMensaje_email(mensajeEmail);
			parametro.setTiempo_caducidad(tiempoCaducidad);
			parametro.setTiempo_proximo_caducar(tiempoProximoCaducar);
			parametro.setRepositoryId(repositoryId);
			parametro.setFolderId(folderId);
			parametro.setUserRepositoryId(userRepositoryId);
			
			ParametrosLocalServiceUtil.updateParametros(parametro);
		
			FacesMessageUtil.info(FacesContext.getCurrentInstance(), Constants.OPERACION_EXITOSA);			
			page = "transaccionExitosa";
		} catch (Exception e) {
			FacesMessageUtil.error(FacesContext.getCurrentInstance(), Constants.ERROR_OPERACION);
			e.printStackTrace();
		}
		
		return page;
	}
	
	
	public Integer getTiempoProximoCaducar() {
		return tiempoProximoCaducar;
	}
	public Integer getTiempoCaducidad() {
		return tiempoCaducidad;
	}
	public String getEmailResposable() {
		return emailResposable;
	}
	public String getMensajeEmail() {
		return mensajeEmail;
	}
	public String getAsuntoEmail() {
		return asuntoEmail;
	}
	public void setTiempoProximoCaducar(Integer tiempoProximoCaducar) {
		this.tiempoProximoCaducar = tiempoProximoCaducar;
	}
	public void setTiempoCaducidad(Integer tiempoCaducidad) {
		this.tiempoCaducidad = tiempoCaducidad;
	}
	public void setEmailResposable(String emailResposable) {
		this.emailResposable = emailResposable;
	}
	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
	}
	public void setAsuntoEmail(String asuntoEmail) {
		this.asuntoEmail = asuntoEmail;
	}


	public long getRepositoryId() {
		return repositoryId;
	}


	public long getFolderId() {
		return folderId;
	}


	public long getUserRepositoryId() {
		return userRepositoryId;
	}


	public void setRepositoryId(long repositoryId) {
		this.repositoryId = repositoryId;
	}


	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}


	public void setUserRepositoryId(long userRepositoryId) {
		this.userRepositoryId = userRepositoryId;
	}

	
}
