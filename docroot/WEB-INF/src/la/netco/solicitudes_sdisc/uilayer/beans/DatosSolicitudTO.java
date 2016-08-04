package la.netco.solicitudes_sdisc.uilayer.beans;

import java.io.Serializable;

public class DatosSolicitudTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String hechos;
	private String pruebas;
	private String nombre_implicado;
	private String despacho_entidad;
	private Integer id_perfil;
	private String nombres_solicitante;
	private String apellidos_solicitante;
	private Integer id_tipo_doc_solicitante;
	private String num_documento_solicitante;
	private String telefono_solicitante;
	private String email_solicitante;
	private String direccion_solicitante;
	private Integer id_ciudad_solicitante;
	private Integer id_departamento_solicitante;

	private Integer id_ciudad_implicado;
	private Integer id_departamento_implicado;
	private String id_entidad_implicado;
	private String id_especialidad_implicado;
	private Integer id_delegado;
	
	private Integer id_estado;
	private String todosEstados;
	
	
	public String getHechos() {
		return hechos;
	}
	public String getPruebas() {
		return pruebas;
	}
	public String getNombre_implicado() {
		return nombre_implicado;
	}
	public String getDespacho_entidad() {
		return despacho_entidad;
	}
	public Integer getId_perfil() {
		return id_perfil;
	}
	public String getNombres_solicitante() {
		return nombres_solicitante;
	}
	public String getApellidos_solicitante() {
		return apellidos_solicitante;
	}
	public Integer getId_tipo_doc_solicitante() {
		return id_tipo_doc_solicitante;
	}
	public String getNum_documento_solicitante() {
		return num_documento_solicitante;
	}
	public String getTelefono_solicitante() {
		return telefono_solicitante;
	}
	public String getEmail_solicitante() {
		return email_solicitante;
	}
	public String getDireccion_solicitante() {
		return direccion_solicitante;
	}
	public Integer getId_ciudad_solicitante() {
		return id_ciudad_solicitante;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public String getTodosEstados() {
		return todosEstados;
	}
	public void setHechos(String hechos) {
		this.hechos = hechos;
	}
	public void setPruebas(String pruebas) {
		this.pruebas = pruebas;
	}
	public void setNombre_implicado(String nombre_implicado) {
		this.nombre_implicado = nombre_implicado;
	}
	public void setDespacho_entidad(String despacho_entidad) {
		this.despacho_entidad = despacho_entidad;
	}
	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}
	public void setNombres_solicitante(String nombres_solicitante) {
		this.nombres_solicitante = nombres_solicitante;
	}
	public void setApellidos_solicitante(String apellidos_solicitante) {
		this.apellidos_solicitante = apellidos_solicitante;
	}
	public void setId_tipo_doc_solicitante(Integer id_tipo_doc_solicitante) {
		this.id_tipo_doc_solicitante = id_tipo_doc_solicitante;
	}
	public void setNum_documento_solicitante(String num_documento_solicitante) {
		this.num_documento_solicitante = num_documento_solicitante;
	}
	public void setTelefono_solicitante(String telefono_solicitante) {
		this.telefono_solicitante = telefono_solicitante;
	}
	public void setEmail_solicitante(String email_solicitante) {
		this.email_solicitante = email_solicitante;
	}
	public void setDireccion_solicitante(String direccion_solicitante) {
		this.direccion_solicitante = direccion_solicitante;
	}
	public void setId_ciudad_solicitante(Integer id_ciudad_solicitante) {
		this.id_ciudad_solicitante = id_ciudad_solicitante;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public void setTodosEstados(String todosEstados) {
		this.todosEstados = todosEstados;
	}
	public Integer getId_departamento_solicitante() {
		return id_departamento_solicitante;
	}
	public void setId_departamento_solicitante(
			Integer id_departamento_solicitante) {
		this.id_departamento_solicitante = id_departamento_solicitante;
	}
	public Integer getId_ciudad_implicado() {
		return id_ciudad_implicado;
	}
	public Integer getId_departamento_implicado() {
		return id_departamento_implicado;
	}
	public String getId_entidad_implicado() {
		return id_entidad_implicado;
	}
	public String getId_especialidad_implicado() {
		return id_especialidad_implicado;
	}
	public void setId_ciudad_implicado(Integer id_ciudad_implicado) {
		this.id_ciudad_implicado = id_ciudad_implicado;
	}
	public void setId_departamento_implicado(Integer id_departamento_implicado) {
		this.id_departamento_implicado = id_departamento_implicado;
	}
	public void setId_entidad_implicado(String id_entidad_implicado) {
		this.id_entidad_implicado = id_entidad_implicado;
	}
	public void setId_especialidad_implicado(String id_especialidad_implicado) {
		this.id_especialidad_implicado = id_especialidad_implicado;
	}
	public Integer getId_delegado() {
		return id_delegado;
	}
	public void setId_delegado(Integer id_delegado) {
		this.id_delegado = id_delegado;
	}
	

}
