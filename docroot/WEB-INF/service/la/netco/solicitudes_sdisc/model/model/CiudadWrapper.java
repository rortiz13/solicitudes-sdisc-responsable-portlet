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
 * This class is a wrapper for {@link Ciudad}.
 * </p>
 *
 * @author    smontanez
 * @see       Ciudad
 * @generated
 */
public class CiudadWrapper implements Ciudad, ModelWrapper<Ciudad> {
	public CiudadWrapper(Ciudad ciudad) {
		_ciudad = ciudad;
	}

	public Class<?> getModelClass() {
		return Ciudad.class;
	}

	public String getModelClassName() {
		return Ciudad.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_ciudad", getId_ciudad());
		attributes.put("nombre", getNombre());
		attributes.put("id_departamento", getId_departamento());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_ciudad = (Integer)attributes.get("id_ciudad");

		if (id_ciudad != null) {
			setId_ciudad(id_ciudad);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		Integer id_departamento = (Integer)attributes.get("id_departamento");

		if (id_departamento != null) {
			setId_departamento(id_departamento);
		}
	}

	/**
	* Returns the primary key of this ciudad.
	*
	* @return the primary key of this ciudad
	*/
	public int getPrimaryKey() {
		return _ciudad.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ciudad.
	*
	* @param primaryKey the primary key of this ciudad
	*/
	public void setPrimaryKey(int primaryKey) {
		_ciudad.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_ciudad of this ciudad.
	*
	* @return the id_ciudad of this ciudad
	*/
	public int getId_ciudad() {
		return _ciudad.getId_ciudad();
	}

	/**
	* Sets the id_ciudad of this ciudad.
	*
	* @param id_ciudad the id_ciudad of this ciudad
	*/
	public void setId_ciudad(int id_ciudad) {
		_ciudad.setId_ciudad(id_ciudad);
	}

	/**
	* Returns the nombre of this ciudad.
	*
	* @return the nombre of this ciudad
	*/
	public java.lang.String getNombre() {
		return _ciudad.getNombre();
	}

	/**
	* Sets the nombre of this ciudad.
	*
	* @param nombre the nombre of this ciudad
	*/
	public void setNombre(java.lang.String nombre) {
		_ciudad.setNombre(nombre);
	}

	/**
	* Returns the id_departamento of this ciudad.
	*
	* @return the id_departamento of this ciudad
	*/
	public int getId_departamento() {
		return _ciudad.getId_departamento();
	}

	/**
	* Sets the id_departamento of this ciudad.
	*
	* @param id_departamento the id_departamento of this ciudad
	*/
	public void setId_departamento(int id_departamento) {
		_ciudad.setId_departamento(id_departamento);
	}

	public boolean isNew() {
		return _ciudad.isNew();
	}

	public void setNew(boolean n) {
		_ciudad.setNew(n);
	}

	public boolean isCachedModel() {
		return _ciudad.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ciudad.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ciudad.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ciudad.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ciudad.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ciudad.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ciudad.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CiudadWrapper((Ciudad)_ciudad.clone());
	}

	public int compareTo(la.netco.solicitudes_sdisc.model.model.Ciudad ciudad) {
		return _ciudad.compareTo(ciudad);
	}

	@Override
	public int hashCode() {
		return _ciudad.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Ciudad> toCacheModel() {
		return _ciudad.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Ciudad toEscapedModel() {
		return new CiudadWrapper(_ciudad.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ciudad.toString();
	}

	public java.lang.String toXmlString() {
		return _ciudad.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ciudad.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Ciudad getWrappedCiudad() {
		return _ciudad;
	}

	public Ciudad getWrappedModel() {
		return _ciudad;
	}

	public void resetOriginalValues() {
		_ciudad.resetOriginalValues();
	}

	private Ciudad _ciudad;
}