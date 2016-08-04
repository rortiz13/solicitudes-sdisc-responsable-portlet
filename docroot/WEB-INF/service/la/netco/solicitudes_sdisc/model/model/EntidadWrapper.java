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
 * This class is a wrapper for {@link Entidad}.
 * </p>
 *
 * @author    smontanez
 * @see       Entidad
 * @generated
 */
public class EntidadWrapper implements Entidad, ModelWrapper<Entidad> {
	public EntidadWrapper(Entidad entidad) {
		_entidad = entidad;
	}

	public Class<?> getModelClass() {
		return Entidad.class;
	}

	public String getModelClassName() {
		return Entidad.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codigo", getCodigo());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this entidad.
	*
	* @return the primary key of this entidad
	*/
	public java.lang.String getPrimaryKey() {
		return _entidad.getPrimaryKey();
	}

	/**
	* Sets the primary key of this entidad.
	*
	* @param primaryKey the primary key of this entidad
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_entidad.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codigo of this entidad.
	*
	* @return the codigo of this entidad
	*/
	public java.lang.String getCodigo() {
		return _entidad.getCodigo();
	}

	/**
	* Sets the codigo of this entidad.
	*
	* @param codigo the codigo of this entidad
	*/
	public void setCodigo(java.lang.String codigo) {
		_entidad.setCodigo(codigo);
	}

	/**
	* Returns the nombre of this entidad.
	*
	* @return the nombre of this entidad
	*/
	public java.lang.String getNombre() {
		return _entidad.getNombre();
	}

	/**
	* Sets the nombre of this entidad.
	*
	* @param nombre the nombre of this entidad
	*/
	public void setNombre(java.lang.String nombre) {
		_entidad.setNombre(nombre);
	}

	public boolean isNew() {
		return _entidad.isNew();
	}

	public void setNew(boolean n) {
		_entidad.setNew(n);
	}

	public boolean isCachedModel() {
		return _entidad.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_entidad.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _entidad.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _entidad.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_entidad.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _entidad.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_entidad.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EntidadWrapper((Entidad)_entidad.clone());
	}

	public int compareTo(la.netco.solicitudes_sdisc.model.model.Entidad entidad) {
		return _entidad.compareTo(entidad);
	}

	@Override
	public int hashCode() {
		return _entidad.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Entidad> toCacheModel() {
		return _entidad.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Entidad toEscapedModel() {
		return new EntidadWrapper(_entidad.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _entidad.toString();
	}

	public java.lang.String toXmlString() {
		return _entidad.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_entidad.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Entidad getWrappedEntidad() {
		return _entidad;
	}

	public Entidad getWrappedModel() {
		return _entidad;
	}

	public void resetOriginalValues() {
		_entidad.resetOriginalValues();
	}

	private Entidad _entidad;
}