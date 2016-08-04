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
 * This class is a wrapper for {@link ResponsableRespuesta}.
 * </p>
 *
 * @author    smontanez
 * @see       ResponsableRespuesta
 * @generated
 */
public class ResponsableRespuestaWrapper implements ResponsableRespuesta,
	ModelWrapper<ResponsableRespuesta> {
	public ResponsableRespuestaWrapper(
		ResponsableRespuesta responsableRespuesta) {
		_responsableRespuesta = responsableRespuesta;
	}

	public Class<?> getModelClass() {
		return ResponsableRespuesta.class;
	}

	public String getModelClassName() {
		return ResponsableRespuesta.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_responsable", getId_responsable());
		attributes.put("respuesta", getRespuesta());
		attributes.put("fecha_respuesta", getFecha_respuesta());
		attributes.put("nombre_usuario", getNombre_usuario());
		attributes.put("id_solicitud", getId_solicitud());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_responsable = (Integer)attributes.get("id_responsable");

		if (id_responsable != null) {
			setId_responsable(id_responsable);
		}

		String respuesta = (String)attributes.get("respuesta");

		if (respuesta != null) {
			setRespuesta(respuesta);
		}

		Date fecha_respuesta = (Date)attributes.get("fecha_respuesta");

		if (fecha_respuesta != null) {
			setFecha_respuesta(fecha_respuesta);
		}

		String nombre_usuario = (String)attributes.get("nombre_usuario");

		if (nombre_usuario != null) {
			setNombre_usuario(nombre_usuario);
		}

		Integer id_solicitud = (Integer)attributes.get("id_solicitud");

		if (id_solicitud != null) {
			setId_solicitud(id_solicitud);
		}
	}

	/**
	* Returns the primary key of this responsable respuesta.
	*
	* @return the primary key of this responsable respuesta
	*/
	public int getPrimaryKey() {
		return _responsableRespuesta.getPrimaryKey();
	}

	/**
	* Sets the primary key of this responsable respuesta.
	*
	* @param primaryKey the primary key of this responsable respuesta
	*/
	public void setPrimaryKey(int primaryKey) {
		_responsableRespuesta.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_responsable of this responsable respuesta.
	*
	* @return the id_responsable of this responsable respuesta
	*/
	public int getId_responsable() {
		return _responsableRespuesta.getId_responsable();
	}

	/**
	* Sets the id_responsable of this responsable respuesta.
	*
	* @param id_responsable the id_responsable of this responsable respuesta
	*/
	public void setId_responsable(int id_responsable) {
		_responsableRespuesta.setId_responsable(id_responsable);
	}

	/**
	* Returns the respuesta of this responsable respuesta.
	*
	* @return the respuesta of this responsable respuesta
	*/
	public java.lang.String getRespuesta() {
		return _responsableRespuesta.getRespuesta();
	}

	/**
	* Sets the respuesta of this responsable respuesta.
	*
	* @param respuesta the respuesta of this responsable respuesta
	*/
	public void setRespuesta(java.lang.String respuesta) {
		_responsableRespuesta.setRespuesta(respuesta);
	}

	/**
	* Returns the fecha_respuesta of this responsable respuesta.
	*
	* @return the fecha_respuesta of this responsable respuesta
	*/
	public java.util.Date getFecha_respuesta() {
		return _responsableRespuesta.getFecha_respuesta();
	}

	/**
	* Sets the fecha_respuesta of this responsable respuesta.
	*
	* @param fecha_respuesta the fecha_respuesta of this responsable respuesta
	*/
	public void setFecha_respuesta(java.util.Date fecha_respuesta) {
		_responsableRespuesta.setFecha_respuesta(fecha_respuesta);
	}

	/**
	* Returns the nombre_usuario of this responsable respuesta.
	*
	* @return the nombre_usuario of this responsable respuesta
	*/
	public java.lang.String getNombre_usuario() {
		return _responsableRespuesta.getNombre_usuario();
	}

	/**
	* Sets the nombre_usuario of this responsable respuesta.
	*
	* @param nombre_usuario the nombre_usuario of this responsable respuesta
	*/
	public void setNombre_usuario(java.lang.String nombre_usuario) {
		_responsableRespuesta.setNombre_usuario(nombre_usuario);
	}

	/**
	* Returns the id_solicitud of this responsable respuesta.
	*
	* @return the id_solicitud of this responsable respuesta
	*/
	public int getId_solicitud() {
		return _responsableRespuesta.getId_solicitud();
	}

	/**
	* Sets the id_solicitud of this responsable respuesta.
	*
	* @param id_solicitud the id_solicitud of this responsable respuesta
	*/
	public void setId_solicitud(int id_solicitud) {
		_responsableRespuesta.setId_solicitud(id_solicitud);
	}

	public boolean isNew() {
		return _responsableRespuesta.isNew();
	}

	public void setNew(boolean n) {
		_responsableRespuesta.setNew(n);
	}

	public boolean isCachedModel() {
		return _responsableRespuesta.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_responsableRespuesta.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _responsableRespuesta.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _responsableRespuesta.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_responsableRespuesta.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _responsableRespuesta.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_responsableRespuesta.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResponsableRespuestaWrapper((ResponsableRespuesta)_responsableRespuesta.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta) {
		return _responsableRespuesta.compareTo(responsableRespuesta);
	}

	@Override
	public int hashCode() {
		return _responsableRespuesta.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> toCacheModel() {
		return _responsableRespuesta.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta toEscapedModel() {
		return new ResponsableRespuestaWrapper(_responsableRespuesta.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _responsableRespuesta.toString();
	}

	public java.lang.String toXmlString() {
		return _responsableRespuesta.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_responsableRespuesta.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ResponsableRespuesta getWrappedResponsableRespuesta() {
		return _responsableRespuesta;
	}

	public ResponsableRespuesta getWrappedModel() {
		return _responsableRespuesta;
	}

	public void resetOriginalValues() {
		_responsableRespuesta.resetOriginalValues();
	}

	private ResponsableRespuesta _responsableRespuesta;
}