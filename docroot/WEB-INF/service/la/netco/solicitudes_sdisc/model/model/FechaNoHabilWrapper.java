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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FechaNoHabil}.
 * </p>
 *
 * @author    smontanez
 * @see       FechaNoHabil
 * @generated
 */
public class FechaNoHabilWrapper implements FechaNoHabil,
	ModelWrapper<FechaNoHabil> {
	public FechaNoHabilWrapper(FechaNoHabil fechaNoHabil) {
		_fechaNoHabil = fechaNoHabil;
	}

	public Class<?> getModelClass() {
		return FechaNoHabil.class;
	}

	public String getModelClassName() {
		return FechaNoHabil.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("fecha", getFecha());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this fecha no habil.
	*
	* @return the primary key of this fecha no habil
	*/
	public int getPrimaryKey() {
		return _fechaNoHabil.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fecha no habil.
	*
	* @param primaryKey the primary key of this fecha no habil
	*/
	public void setPrimaryKey(int primaryKey) {
		_fechaNoHabil.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this fecha no habil.
	*
	* @return the ID of this fecha no habil
	*/
	public int getId() {
		return _fechaNoHabil.getId();
	}

	/**
	* Sets the ID of this fecha no habil.
	*
	* @param id the ID of this fecha no habil
	*/
	public void setId(int id) {
		_fechaNoHabil.setId(id);
	}

	/**
	* Returns the fecha of this fecha no habil.
	*
	* @return the fecha of this fecha no habil
	*/
	public java.util.Date getFecha() {
		return _fechaNoHabil.getFecha();
	}

	/**
	* Sets the fecha of this fecha no habil.
	*
	* @param fecha the fecha of this fecha no habil
	*/
	public void setFecha(java.util.Date fecha) {
		_fechaNoHabil.setFecha(fecha);
	}

	/**
	* Returns the nombre of this fecha no habil.
	*
	* @return the nombre of this fecha no habil
	*/
	public java.lang.String getNombre() {
		return _fechaNoHabil.getNombre();
	}

	/**
	* Sets the nombre of this fecha no habil.
	*
	* @param nombre the nombre of this fecha no habil
	*/
	public void setNombre(java.lang.String nombre) {
		_fechaNoHabil.setNombre(nombre);
	}

	public boolean isNew() {
		return _fechaNoHabil.isNew();
	}

	public void setNew(boolean n) {
		_fechaNoHabil.setNew(n);
	}

	public boolean isCachedModel() {
		return _fechaNoHabil.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_fechaNoHabil.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _fechaNoHabil.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _fechaNoHabil.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fechaNoHabil.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fechaNoHabil.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fechaNoHabil.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FechaNoHabilWrapper((FechaNoHabil)_fechaNoHabil.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.FechaNoHabil fechaNoHabil) {
		return _fechaNoHabil.compareTo(fechaNoHabil);
	}

	@Override
	public int hashCode() {
		return _fechaNoHabil.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> toCacheModel() {
		return _fechaNoHabil.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.FechaNoHabil toEscapedModel() {
		return new FechaNoHabilWrapper(_fechaNoHabil.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fechaNoHabil.toString();
	}

	public java.lang.String toXmlString() {
		return _fechaNoHabil.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fechaNoHabil.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FechaNoHabil getWrappedFechaNoHabil() {
		return _fechaNoHabil;
	}

	public FechaNoHabil getWrappedModel() {
		return _fechaNoHabil;
	}

	public void resetOriginalValues() {
		_fechaNoHabil.resetOriginalValues();
	}

	private FechaNoHabil _fechaNoHabil;
}