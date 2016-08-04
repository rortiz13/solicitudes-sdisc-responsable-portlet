/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package la.netco.solicitudes_sdisc.model.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Solicitante}.
 * </p>
 *
 * @author    smontanez
 * @see       Solicitante
 * @generated
 */
public class SolicitanteWrapper implements Solicitante,
	ModelWrapper<Solicitante> {
	public SolicitanteWrapper(Solicitante solicitante) {
		_solicitante = solicitante;
	}

	public Class<?> getModelClass() {
		return Solicitante.class;
	}

	public String getModelClassName() {
		return Solicitante.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_solicitante", getId_solicitante());
		attributes.put("nombres", getNombres());
		attributes.put("apellidos", getApellidos());
		attributes.put("num_documento", getNum_documento());
		attributes.put("telefono", getTelefono());
		attributes.put("email", getEmail());
		attributes.put("direccion", getDireccion());
		attributes.put("id_tipo_doc", getId_tipo_doc());
		attributes.put("id_ciudad", getId_ciudad());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_solicitante = (Integer)attributes.get("id_solicitante");

		if (id_solicitante != null) {
			setId_solicitante(id_solicitante);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String num_documento = (String)attributes.get("num_documento");

		if (num_documento != null) {
			setNum_documento(num_documento);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		Integer id_tipo_doc = (Integer)attributes.get("id_tipo_doc");

		if (id_tipo_doc != null) {
			setId_tipo_doc(id_tipo_doc);
		}

		Integer id_ciudad = (Integer)attributes.get("id_ciudad");

		if (id_ciudad != null) {
			setId_ciudad(id_ciudad);
		}
	}

	/**
	* Returns the primary key of this solicitante.
	*
	* @return the primary key of this solicitante
	*/
	public int getPrimaryKey() {
		return _solicitante.getPrimaryKey();
	}

	/**
	* Sets the primary key of this solicitante.
	*
	* @param primaryKey the primary key of this solicitante
	*/
	public void setPrimaryKey(int primaryKey) {
		_solicitante.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_solicitante of this solicitante.
	*
	* @return the id_solicitante of this solicitante
	*/
	public int getId_solicitante() {
		return _solicitante.getId_solicitante();
	}

	/**
	* Sets the id_solicitante of this solicitante.
	*
	* @param id_solicitante the id_solicitante of this solicitante
	*/
	public void setId_solicitante(int id_solicitante) {
		_solicitante.setId_solicitante(id_solicitante);
	}

	/**
	* Returns the nombres of this solicitante.
	*
	* @return the nombres of this solicitante
	*/
	public java.lang.String getNombres() {
		return _solicitante.getNombres();
	}

	/**
	* Sets the nombres of this solicitante.
	*
	* @param nombres the nombres of this solicitante
	*/
	public void setNombres(java.lang.String nombres) {
		_solicitante.setNombres(nombres);
	}

	/**
	* Returns the apellidos of this solicitante.
	*
	* @return the apellidos of this solicitante
	*/
	public java.lang.String getApellidos() {
		return _solicitante.getApellidos();
	}

	/**
	* Sets the apellidos of this solicitante.
	*
	* @param apellidos the apellidos of this solicitante
	*/
	public void setApellidos(java.lang.String apellidos) {
		_solicitante.setApellidos(apellidos);
	}

	/**
	* Returns the num_documento of this solicitante.
	*
	* @return the num_documento of this solicitante
	*/
	public java.lang.String getNum_documento() {
		return _solicitante.getNum_documento();
	}

	/**
	* Sets the num_documento of this solicitante.
	*
	* @param num_documento the num_documento of this solicitante
	*/
	public void setNum_documento(java.lang.String num_documento) {
		_solicitante.setNum_documento(num_documento);
	}

	/**
	* Returns the telefono of this solicitante.
	*
	* @return the telefono of this solicitante
	*/
	public java.lang.String getTelefono() {
		return _solicitante.getTelefono();
	}

	/**
	* Sets the telefono of this solicitante.
	*
	* @param telefono the telefono of this solicitante
	*/
	public void setTelefono(java.lang.String telefono) {
		_solicitante.setTelefono(telefono);
	}

	/**
	* Returns the email of this solicitante.
	*
	* @return the email of this solicitante
	*/
	public java.lang.String getEmail() {
		return _solicitante.getEmail();
	}

	/**
	* Sets the email of this solicitante.
	*
	* @param email the email of this solicitante
	*/
	public void setEmail(java.lang.String email) {
		_solicitante.setEmail(email);
	}

	/**
	* Returns the direccion of this solicitante.
	*
	* @return the direccion of this solicitante
	*/
	public java.lang.String getDireccion() {
		return _solicitante.getDireccion();
	}

	/**
	* Sets the direccion of this solicitante.
	*
	* @param direccion the direccion of this solicitante
	*/
	public void setDireccion(java.lang.String direccion) {
		_solicitante.setDireccion(direccion);
	}

	/**
	* Returns the id_tipo_doc of this solicitante.
	*
	* @return the id_tipo_doc of this solicitante
	*/
	public java.lang.Integer getId_tipo_doc() {
		return _solicitante.getId_tipo_doc();
	}

	/**
	* Sets the id_tipo_doc of this solicitante.
	*
	* @param id_tipo_doc the id_tipo_doc of this solicitante
	*/
	public void setId_tipo_doc(java.lang.Integer id_tipo_doc) {
		_solicitante.setId_tipo_doc(id_tipo_doc);
	}

	/**
	* Returns the id_ciudad of this solicitante.
	*
	* @return the id_ciudad of this solicitante
	*/
	public java.lang.Integer getId_ciudad() {
		return _solicitante.getId_ciudad();
	}

	/**
	* Sets the id_ciudad of this solicitante.
	*
	* @param id_ciudad the id_ciudad of this solicitante
	*/
	public void setId_ciudad(java.lang.Integer id_ciudad) {
		_solicitante.setId_ciudad(id_ciudad);
	}

	public boolean isNew() {
		return _solicitante.isNew();
	}

	public void setNew(boolean n) {
		_solicitante.setNew(n);
	}

	public boolean isCachedModel() {
		return _solicitante.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_solicitante.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _solicitante.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _solicitante.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_solicitante.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _solicitante.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_solicitante.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SolicitanteWrapper((Solicitante)_solicitante.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.Solicitante solicitante) {
		return _solicitante.compareTo(solicitante);
	}

	@Override
	public int hashCode() {
		return _solicitante.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Solicitante> toCacheModel() {
		return _solicitante.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Solicitante toEscapedModel() {
		return new SolicitanteWrapper(_solicitante.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _solicitante.toString();
	}

	public java.lang.String toXmlString() {
		return _solicitante.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_solicitante.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Solicitante getWrappedSolicitante() {
		return _solicitante;
	}

	public Solicitante getWrappedModel() {
		return _solicitante;
	}

	public void resetOriginalValues() {
		_solicitante.resetOriginalValues();
	}

	private Solicitante _solicitante;
}