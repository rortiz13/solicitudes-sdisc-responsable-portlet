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
 * This class is a wrapper for {@link Delegado}.
 * </p>
 *
 * @author    smontanez
 * @see       Delegado
 * @generated
 */
public class DelegadoWrapper implements Delegado, ModelWrapper<Delegado> {
	public DelegadoWrapper(Delegado delegado) {
		_delegado = delegado;
	}

	public Class<?> getModelClass() {
		return Delegado.class;
	}

	public String getModelClassName() {
		return Delegado.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_delegado", getId_delegado());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_delegado = (Integer)attributes.get("id_delegado");

		if (id_delegado != null) {
			setId_delegado(id_delegado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this delegado.
	*
	* @return the primary key of this delegado
	*/
	public int getPrimaryKey() {
		return _delegado.getPrimaryKey();
	}

	/**
	* Sets the primary key of this delegado.
	*
	* @param primaryKey the primary key of this delegado
	*/
	public void setPrimaryKey(int primaryKey) {
		_delegado.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_delegado of this delegado.
	*
	* @return the id_delegado of this delegado
	*/
	public int getId_delegado() {
		return _delegado.getId_delegado();
	}

	/**
	* Sets the id_delegado of this delegado.
	*
	* @param id_delegado the id_delegado of this delegado
	*/
	public void setId_delegado(int id_delegado) {
		_delegado.setId_delegado(id_delegado);
	}

	/**
	* Returns the nombre of this delegado.
	*
	* @return the nombre of this delegado
	*/
	public java.lang.String getNombre() {
		return _delegado.getNombre();
	}

	/**
	* Sets the nombre of this delegado.
	*
	* @param nombre the nombre of this delegado
	*/
	public void setNombre(java.lang.String nombre) {
		_delegado.setNombre(nombre);
	}

	public boolean isNew() {
		return _delegado.isNew();
	}

	public void setNew(boolean n) {
		_delegado.setNew(n);
	}

	public boolean isCachedModel() {
		return _delegado.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_delegado.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _delegado.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _delegado.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_delegado.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _delegado.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_delegado.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DelegadoWrapper((Delegado)_delegado.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado) {
		return _delegado.compareTo(delegado);
	}

	@Override
	public int hashCode() {
		return _delegado.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Delegado> toCacheModel() {
		return _delegado.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Delegado toEscapedModel() {
		return new DelegadoWrapper(_delegado.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _delegado.toString();
	}

	public java.lang.String toXmlString() {
		return _delegado.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_delegado.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Delegado getWrappedDelegado() {
		return _delegado;
	}

	public Delegado getWrappedModel() {
		return _delegado;
	}

	public void resetOriginalValues() {
		_delegado.resetOriginalValues();
	}

	private Delegado _delegado;
}