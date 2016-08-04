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
 * This class is a wrapper for {@link TipoDocumento}.
 * </p>
 *
 * @author    smontanez
 * @see       TipoDocumento
 * @generated
 */
public class TipoDocumentoWrapper implements TipoDocumento,
	ModelWrapper<TipoDocumento> {
	public TipoDocumentoWrapper(TipoDocumento tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public Class<?> getModelClass() {
		return TipoDocumento.class;
	}

	public String getModelClassName() {
		return TipoDocumento.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_tipo_doc", getId_tipo_doc());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_tipo_doc = (Integer)attributes.get("id_tipo_doc");

		if (id_tipo_doc != null) {
			setId_tipo_doc(id_tipo_doc);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this tipo documento.
	*
	* @return the primary key of this tipo documento
	*/
	public int getPrimaryKey() {
		return _tipoDocumento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tipo documento.
	*
	* @param primaryKey the primary key of this tipo documento
	*/
	public void setPrimaryKey(int primaryKey) {
		_tipoDocumento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_tipo_doc of this tipo documento.
	*
	* @return the id_tipo_doc of this tipo documento
	*/
	public int getId_tipo_doc() {
		return _tipoDocumento.getId_tipo_doc();
	}

	/**
	* Sets the id_tipo_doc of this tipo documento.
	*
	* @param id_tipo_doc the id_tipo_doc of this tipo documento
	*/
	public void setId_tipo_doc(int id_tipo_doc) {
		_tipoDocumento.setId_tipo_doc(id_tipo_doc);
	}

	/**
	* Returns the nombre of this tipo documento.
	*
	* @return the nombre of this tipo documento
	*/
	public java.lang.String getNombre() {
		return _tipoDocumento.getNombre();
	}

	/**
	* Sets the nombre of this tipo documento.
	*
	* @param nombre the nombre of this tipo documento
	*/
	public void setNombre(java.lang.String nombre) {
		_tipoDocumento.setNombre(nombre);
	}

	public boolean isNew() {
		return _tipoDocumento.isNew();
	}

	public void setNew(boolean n) {
		_tipoDocumento.setNew(n);
	}

	public boolean isCachedModel() {
		return _tipoDocumento.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tipoDocumento.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tipoDocumento.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tipoDocumento.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tipoDocumento.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tipoDocumento.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tipoDocumento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TipoDocumentoWrapper((TipoDocumento)_tipoDocumento.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.TipoDocumento tipoDocumento) {
		return _tipoDocumento.compareTo(tipoDocumento);
	}

	@Override
	public int hashCode() {
		return _tipoDocumento.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.TipoDocumento> toCacheModel() {
		return _tipoDocumento.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.TipoDocumento toEscapedModel() {
		return new TipoDocumentoWrapper(_tipoDocumento.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tipoDocumento.toString();
	}

	public java.lang.String toXmlString() {
		return _tipoDocumento.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipoDocumento.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TipoDocumento getWrappedTipoDocumento() {
		return _tipoDocumento;
	}

	public TipoDocumento getWrappedModel() {
		return _tipoDocumento;
	}

	public void resetOriginalValues() {
		_tipoDocumento.resetOriginalValues();
	}

	private TipoDocumento _tipoDocumento;
}