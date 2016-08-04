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
 * This class is a wrapper for {@link Implicado}.
 * </p>
 *
 * @author    smontanez
 * @see       Implicado
 * @generated
 */
public class ImplicadoWrapper implements Implicado, ModelWrapper<Implicado> {
	public ImplicadoWrapper(Implicado implicado) {
		_implicado = implicado;
	}

	public Class<?> getModelClass() {
		return Implicado.class;
	}

	public String getModelClassName() {
		return Implicado.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_implicado", getId_implicado());
		attributes.put("nombre", getNombre());
		attributes.put("despacho_entidad", getDespacho_entidad());
		attributes.put("id_perfil", getId_perfil());
		attributes.put("id_ciudad", getId_ciudad());
		attributes.put("cod_entidad", getCod_entidad());
		attributes.put("cod_especialidad", getCod_especialidad());
		attributes.put("id_delegado", getId_delegado());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_implicado = (Integer)attributes.get("id_implicado");

		if (id_implicado != null) {
			setId_implicado(id_implicado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String despacho_entidad = (String)attributes.get("despacho_entidad");

		if (despacho_entidad != null) {
			setDespacho_entidad(despacho_entidad);
		}

		Integer id_perfil = (Integer)attributes.get("id_perfil");

		if (id_perfil != null) {
			setId_perfil(id_perfil);
		}

		Integer id_ciudad = (Integer)attributes.get("id_ciudad");

		if (id_ciudad != null) {
			setId_ciudad(id_ciudad);
		}

		String cod_entidad = (String)attributes.get("cod_entidad");

		if (cod_entidad != null) {
			setCod_entidad(cod_entidad);
		}

		String cod_especialidad = (String)attributes.get("cod_especialidad");

		if (cod_especialidad != null) {
			setCod_especialidad(cod_especialidad);
		}

		Integer id_delegado = (Integer)attributes.get("id_delegado");

		if (id_delegado != null) {
			setId_delegado(id_delegado);
		}
	}

	/**
	* Returns the primary key of this implicado.
	*
	* @return the primary key of this implicado
	*/
	public int getPrimaryKey() {
		return _implicado.getPrimaryKey();
	}

	/**
	* Sets the primary key of this implicado.
	*
	* @param primaryKey the primary key of this implicado
	*/
	public void setPrimaryKey(int primaryKey) {
		_implicado.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_implicado of this implicado.
	*
	* @return the id_implicado of this implicado
	*/
	public int getId_implicado() {
		return _implicado.getId_implicado();
	}

	/**
	* Sets the id_implicado of this implicado.
	*
	* @param id_implicado the id_implicado of this implicado
	*/
	public void setId_implicado(int id_implicado) {
		_implicado.setId_implicado(id_implicado);
	}

	/**
	* Returns the nombre of this implicado.
	*
	* @return the nombre of this implicado
	*/
	public java.lang.String getNombre() {
		return _implicado.getNombre();
	}

	/**
	* Sets the nombre of this implicado.
	*
	* @param nombre the nombre of this implicado
	*/
	public void setNombre(java.lang.String nombre) {
		_implicado.setNombre(nombre);
	}

	/**
	* Returns the despacho_entidad of this implicado.
	*
	* @return the despacho_entidad of this implicado
	*/
	public java.lang.String getDespacho_entidad() {
		return _implicado.getDespacho_entidad();
	}

	/**
	* Sets the despacho_entidad of this implicado.
	*
	* @param despacho_entidad the despacho_entidad of this implicado
	*/
	public void setDespacho_entidad(java.lang.String despacho_entidad) {
		_implicado.setDespacho_entidad(despacho_entidad);
	}

	/**
	* Returns the id_perfil of this implicado.
	*
	* @return the id_perfil of this implicado
	*/
	public int getId_perfil() {
		return _implicado.getId_perfil();
	}

	/**
	* Sets the id_perfil of this implicado.
	*
	* @param id_perfil the id_perfil of this implicado
	*/
	public void setId_perfil(int id_perfil) {
		_implicado.setId_perfil(id_perfil);
	}

	/**
	* Returns the id_ciudad of this implicado.
	*
	* @return the id_ciudad of this implicado
	*/
	public java.lang.Integer getId_ciudad() {
		return _implicado.getId_ciudad();
	}

	/**
	* Sets the id_ciudad of this implicado.
	*
	* @param id_ciudad the id_ciudad of this implicado
	*/
	public void setId_ciudad(java.lang.Integer id_ciudad) {
		_implicado.setId_ciudad(id_ciudad);
	}

	/**
	* Returns the cod_entidad of this implicado.
	*
	* @return the cod_entidad of this implicado
	*/
	public java.lang.String getCod_entidad() {
		return _implicado.getCod_entidad();
	}

	/**
	* Sets the cod_entidad of this implicado.
	*
	* @param cod_entidad the cod_entidad of this implicado
	*/
	public void setCod_entidad(java.lang.String cod_entidad) {
		_implicado.setCod_entidad(cod_entidad);
	}

	/**
	* Returns the cod_especialidad of this implicado.
	*
	* @return the cod_especialidad of this implicado
	*/
	public java.lang.String getCod_especialidad() {
		return _implicado.getCod_especialidad();
	}

	/**
	* Sets the cod_especialidad of this implicado.
	*
	* @param cod_especialidad the cod_especialidad of this implicado
	*/
	public void setCod_especialidad(java.lang.String cod_especialidad) {
		_implicado.setCod_especialidad(cod_especialidad);
	}

	/**
	* Returns the id_delegado of this implicado.
	*
	* @return the id_delegado of this implicado
	*/
	public java.lang.Integer getId_delegado() {
		return _implicado.getId_delegado();
	}

	/**
	* Sets the id_delegado of this implicado.
	*
	* @param id_delegado the id_delegado of this implicado
	*/
	public void setId_delegado(java.lang.Integer id_delegado) {
		_implicado.setId_delegado(id_delegado);
	}

	public boolean isNew() {
		return _implicado.isNew();
	}

	public void setNew(boolean n) {
		_implicado.setNew(n);
	}

	public boolean isCachedModel() {
		return _implicado.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_implicado.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _implicado.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _implicado.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_implicado.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _implicado.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_implicado.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImplicadoWrapper((Implicado)_implicado.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado) {
		return _implicado.compareTo(implicado);
	}

	@Override
	public int hashCode() {
		return _implicado.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Implicado> toCacheModel() {
		return _implicado.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Implicado toEscapedModel() {
		return new ImplicadoWrapper(_implicado.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _implicado.toString();
	}

	public java.lang.String toXmlString() {
		return _implicado.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_implicado.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Implicado getWrappedImplicado() {
		return _implicado;
	}

	public Implicado getWrappedModel() {
		return _implicado;
	}

	public void resetOriginalValues() {
		_implicado.resetOriginalValues();
	}

	private Implicado _implicado;
}