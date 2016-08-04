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
 * This class is a wrapper for {@link PerfilImplicado}.
 * </p>
 *
 * @author    smontanez
 * @see       PerfilImplicado
 * @generated
 */
public class PerfilImplicadoWrapper implements PerfilImplicado,
	ModelWrapper<PerfilImplicado> {
	public PerfilImplicadoWrapper(PerfilImplicado perfilImplicado) {
		_perfilImplicado = perfilImplicado;
	}

	public Class<?> getModelClass() {
		return PerfilImplicado.class;
	}

	public String getModelClassName() {
		return PerfilImplicado.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_perfil", getId_perfil());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_perfil = (Integer)attributes.get("id_perfil");

		if (id_perfil != null) {
			setId_perfil(id_perfil);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this perfil implicado.
	*
	* @return the primary key of this perfil implicado
	*/
	public int getPrimaryKey() {
		return _perfilImplicado.getPrimaryKey();
	}

	/**
	* Sets the primary key of this perfil implicado.
	*
	* @param primaryKey the primary key of this perfil implicado
	*/
	public void setPrimaryKey(int primaryKey) {
		_perfilImplicado.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_perfil of this perfil implicado.
	*
	* @return the id_perfil of this perfil implicado
	*/
	public int getId_perfil() {
		return _perfilImplicado.getId_perfil();
	}

	/**
	* Sets the id_perfil of this perfil implicado.
	*
	* @param id_perfil the id_perfil of this perfil implicado
	*/
	public void setId_perfil(int id_perfil) {
		_perfilImplicado.setId_perfil(id_perfil);
	}

	/**
	* Returns the nombre of this perfil implicado.
	*
	* @return the nombre of this perfil implicado
	*/
	public java.lang.String getNombre() {
		return _perfilImplicado.getNombre();
	}

	/**
	* Sets the nombre of this perfil implicado.
	*
	* @param nombre the nombre of this perfil implicado
	*/
	public void setNombre(java.lang.String nombre) {
		_perfilImplicado.setNombre(nombre);
	}

	public boolean isNew() {
		return _perfilImplicado.isNew();
	}

	public void setNew(boolean n) {
		_perfilImplicado.setNew(n);
	}

	public boolean isCachedModel() {
		return _perfilImplicado.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_perfilImplicado.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _perfilImplicado.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _perfilImplicado.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_perfilImplicado.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _perfilImplicado.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_perfilImplicado.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PerfilImplicadoWrapper((PerfilImplicado)_perfilImplicado.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.PerfilImplicado perfilImplicado) {
		return _perfilImplicado.compareTo(perfilImplicado);
	}

	@Override
	public int hashCode() {
		return _perfilImplicado.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.PerfilImplicado> toCacheModel() {
		return _perfilImplicado.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.PerfilImplicado toEscapedModel() {
		return new PerfilImplicadoWrapper(_perfilImplicado.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _perfilImplicado.toString();
	}

	public java.lang.String toXmlString() {
		return _perfilImplicado.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_perfilImplicado.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PerfilImplicado getWrappedPerfilImplicado() {
		return _perfilImplicado;
	}

	public PerfilImplicado getWrappedModel() {
		return _perfilImplicado;
	}

	public void resetOriginalValues() {
		_perfilImplicado.resetOriginalValues();
	}

	private PerfilImplicado _perfilImplicado;
}