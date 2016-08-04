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
 * This class is a wrapper for {@link Estado}.
 * </p>
 *
 * @author    smontanez
 * @see       Estado
 * @generated
 */
public class EstadoWrapper implements Estado, ModelWrapper<Estado> {
	public EstadoWrapper(Estado estado) {
		_estado = estado;
	}

	public Class<?> getModelClass() {
		return Estado.class;
	}

	public String getModelClassName() {
		return Estado.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_estado", getId_estado());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_estado = (Integer)attributes.get("id_estado");

		if (id_estado != null) {
			setId_estado(id_estado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this estado.
	*
	* @return the primary key of this estado
	*/
	public int getPrimaryKey() {
		return _estado.getPrimaryKey();
	}

	/**
	* Sets the primary key of this estado.
	*
	* @param primaryKey the primary key of this estado
	*/
	public void setPrimaryKey(int primaryKey) {
		_estado.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_estado of this estado.
	*
	* @return the id_estado of this estado
	*/
	public int getId_estado() {
		return _estado.getId_estado();
	}

	/**
	* Sets the id_estado of this estado.
	*
	* @param id_estado the id_estado of this estado
	*/
	public void setId_estado(int id_estado) {
		_estado.setId_estado(id_estado);
	}

	/**
	* Returns the nombre of this estado.
	*
	* @return the nombre of this estado
	*/
	public java.lang.String getNombre() {
		return _estado.getNombre();
	}

	/**
	* Sets the nombre of this estado.
	*
	* @param nombre the nombre of this estado
	*/
	public void setNombre(java.lang.String nombre) {
		_estado.setNombre(nombre);
	}

	public boolean isNew() {
		return _estado.isNew();
	}

	public void setNew(boolean n) {
		_estado.setNew(n);
	}

	public boolean isCachedModel() {
		return _estado.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_estado.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _estado.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _estado.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_estado.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _estado.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_estado.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EstadoWrapper((Estado)_estado.clone());
	}

	public int compareTo(la.netco.solicitudes_sdisc.model.model.Estado estado) {
		return _estado.compareTo(estado);
	}

	@Override
	public int hashCode() {
		return _estado.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Estado> toCacheModel() {
		return _estado.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Estado toEscapedModel() {
		return new EstadoWrapper(_estado.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _estado.toString();
	}

	public java.lang.String toXmlString() {
		return _estado.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_estado.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Estado getWrappedEstado() {
		return _estado;
	}

	public Estado getWrappedModel() {
		return _estado;
	}

	public void resetOriginalValues() {
		_estado.resetOriginalValues();
	}

	private Estado _estado;
}