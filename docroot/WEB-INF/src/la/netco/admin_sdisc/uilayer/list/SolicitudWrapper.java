package la.netco.admin_sdisc.uilayer.list;

import java.util.Date;

import javax.faces.FacesWrapper;

import la.netco.solicitudes_sdisc.model.model.Ciudad;
import la.netco.solicitudes_sdisc.model.model.Delegado;
import la.netco.solicitudes_sdisc.model.model.Departamento;
import la.netco.solicitudes_sdisc.model.model.Entidad;
import la.netco.solicitudes_sdisc.model.model.Especialidad;
import la.netco.solicitudes_sdisc.model.model.Estado;
import la.netco.solicitudes_sdisc.model.model.Implicado;
import la.netco.solicitudes_sdisc.model.model.PerfilImplicado;
import la.netco.solicitudes_sdisc.model.model.Solicitante;
import la.netco.solicitudes_sdisc.model.model.Solicitud;
import la.netco.solicitudes_sdisc.model.model.TipoDocumento;

public class SolicitudWrapper  extends la.netco.solicitudes_sdisc.model.model.SolicitudWrapper implements FacesWrapper<Solicitud>  {

	
	private static final long serialVersionUID = 1L;
	// Private Data Members
	private Solicitud wrappedSolicitud;
	private Estado estado;
	private Solicitante solicitante;
	private Implicado implicado;
	private PerfilImplicado perfil;
	private long 		antiguedad;

	private TipoDocumento tipoDocSolicitante;
	private Departamento departamentoSolicitante;
	private Ciudad ciudadSolicitante;
	
	private Ciudad ciudadImplicado;
	private Departamento departamentoImplicado;	

	private Entidad entidadImplicado;
	private Especialidad especialidadImplicado;
	private Delegado delegadoImplicado;

	
	public SolicitudWrapper(Solicitud wrappedSolicitud, Estado estado, Solicitante solicitante, Implicado implicado,  PerfilImplicado perfil ) {
		super(wrappedSolicitud);
		this.wrappedSolicitud = wrappedSolicitud;
		setEstado(estado);
		setSolicitante(solicitante);
		setImplicado(implicado);
		setPerfil(perfil);
	}
	
	public SolicitudWrapper(Solicitud wrappedSolicitud, Estado estado, Solicitante solicitante, 
			Implicado implicado,  PerfilImplicado perfil,  
			TipoDocumento tipoDocSolicitante,  Departamento departamentoSolicitante, Ciudad ciudadSolicitante, 
			Ciudad ciudadImplicado, Departamento departamentoImplicado, Entidad entidadImplicado,
			Especialidad especialidadImplicado,Delegado delegadoImplicado) {
		super(wrappedSolicitud);
		this.wrappedSolicitud = wrappedSolicitud;
		setEstado(estado);
		setSolicitante(solicitante);
		setImplicado(implicado);
		setPerfil(perfil);
		setTipoDocSolicitante(tipoDocSolicitante);
		setDepartamentoSolicitante(departamentoSolicitante);
		setCiudadSolicitante(ciudadSolicitante);
		setCiudadImplicado(ciudadImplicado);
		setDepartamentoImplicado(departamentoImplicado);
		setDelegadoImplicado(delegadoImplicado);
		setEntidadImplicado(entidadImplicado);
		setEspecialidadImplicado(especialidadImplicado);
	}

	@Override
	public Solicitud getWrapped() {
		return wrappedSolicitud;
	}

	@Override
	public int getId_solicitud() {
		return getWrapped().getId_solicitud();
	}

	@Override
	public String getHechos() {
		return getWrapped().getHechos();
	}

	@Override
	public String getPruebas() {
		return getWrapped().getPruebas();
	}

	@Override
	public int getId_estado() {
		return getWrapped().getId_estado();
	}

	@Override
	public int getId_implicado() {
		return getWrapped().getId_implicado();
	}

	@Override
	public int getId_solicitante() {
		return getWrapped().getId_solicitante();
	}

	@Override
	public Date getFechaRegistro() {
		return getWrapped().getFechaRegistro();
	}

	public Estado getEstado() {
		return estado;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public Implicado getImplicado() {
		return implicado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public void setImplicado(Implicado implicado) {
		this.implicado = implicado;
	}

	public PerfilImplicado getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilImplicado perfil) {
		this.perfil = perfil;
	}

	public TipoDocumento getTipoDocSolicitante() {
		return tipoDocSolicitante;
	}

	public Departamento getDepartamentoSolicitante() {
		return departamentoSolicitante;
	}

	public Ciudad getCiudadSolicitante() {
		return ciudadSolicitante;
	}

	public void setTipoDocSolicitante(TipoDocumento tipoDocSolicitante) {
		this.tipoDocSolicitante = tipoDocSolicitante;
	}

	public void setDepartamentoSolicitante(Departamento departamentoSolicitante) {
		this.departamentoSolicitante = departamentoSolicitante;
	}

	public void setCiudadSolicitante(Ciudad ciudadSolicitante) {
		this.ciudadSolicitante = ciudadSolicitante;
	}

	public long getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(long antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Ciudad getCiudadImplicado() {
		return ciudadImplicado;
	}

	public Departamento getDepartamentoImplicado() {
		return departamentoImplicado;
	}

	public Entidad getEntidadImplicado() {
		return entidadImplicado;
	}

	public Especialidad getEspecialidadImplicado() {
		return especialidadImplicado;
	}

	public Delegado getDelegadoImplicado() {
		return delegadoImplicado;
	}

	public void setCiudadImplicado(Ciudad ciudadImplicado) {
		this.ciudadImplicado = ciudadImplicado;
	}

	public void setDepartamentoImplicado(Departamento departamentoImplicado) {
		this.departamentoImplicado = departamentoImplicado;
	}

	public void setEntidadImplicado(Entidad entidadImplicado) {
		this.entidadImplicado = entidadImplicado;
	}

	public void setEspecialidadImplicado(Especialidad especialidadImplicado) {
		this.especialidadImplicado = especialidadImplicado;
	}

	public void setDelegadoImplicado(Delegado delegadoImplicado) {
		this.delegadoImplicado = delegadoImplicado;
	}


}
