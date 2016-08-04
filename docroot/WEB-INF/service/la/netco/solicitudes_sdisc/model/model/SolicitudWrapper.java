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
 * This class is a wrapper for {@link Solicitud}.
 * </p>
 *
 * @author    smontanez
 * @see       Solicitud
 * @generated
 */
public class SolicitudWrapper implements Solicitud, ModelWrapper<Solicitud> {
	public SolicitudWrapper(Solicitud solicitud) {
		_solicitud = solicitud;
	}

	public Class<?> getModelClass() {
		return Solicitud.class;
	}

	public String getModelClassName() {
		return Solicitud.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_solicitud", getId_solicitud());
		attributes.put("hechos", getHechos());
		attributes.put("pruebas", getPruebas());
		attributes.put("id_estado", getId_estado());
		attributes.put("id_implicado", getId_implicado());
		attributes.put("id_solicitante", getId_solicitante());
		attributes.put("fechaRegistro", getFechaRegistro());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_solicitud = (Integer)attributes.get("id_solicitud");

		if (id_solicitud != null) {
			setId_solicitud(id_solicitud);
		}

		String hechos = (String)attributes.get("hechos");

		if (hechos != null) {
			setHechos(hechos);
		}

		String pruebas = (String)attributes.get("pruebas");

		if (pruebas != null) {
			setPruebas(pruebas);
		}

		Integer id_estado = (Integer)attributes.get("id_estado");

		if (id_estado != null) {
			setId_estado(id_estado);
		}

		Integer id_implicado = (Integer)attributes.get("id_implicado");

		if (id_implicado != null) {
			setId_implicado(id_implicado);
		}

		Integer id_solicitante = (Integer)attributes.get("id_solicitante");

		if (id_solicitante != null) {
			setId_solicitante(id_solicitante);
		}

		Date fechaRegistro = (Date)attributes.get("fechaRegistro");

		if (fechaRegistro != null) {
			setFechaRegistro(fechaRegistro);
		}
	}

	/**
	* Returns the primary key of this Solicitud.
	*
	* @return the primary key of this Solicitud
	*/
	public int getPrimaryKey() {
		return _solicitud.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Solicitud.
	*
	* @param primaryKey the primary key of this Solicitud
	*/
	public void setPrimaryKey(int primaryKey) {
		_solicitud.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_solicitud of this Solicitud.
	*
	* @return the id_solicitud of this Solicitud
	*/
	public int getId_solicitud() {
		return _solicitud.getId_solicitud();
	}

	/**
	* Sets the id_solicitud of this Solicitud.
	*
	* @param id_solicitud the id_solicitud of this Solicitud
	*/
	public void setId_solicitud(int id_solicitud) {
		_solicitud.setId_solicitud(id_solicitud);
	}

	/**
	* Returns the hechos of this Solicitud.
	*
	* @return the hechos of this Solicitud
	*/
	public java.lang.String getHechos() {
		return _solicitud.getHechos();
	}

	/**
	* Sets the hechos of this Solicitud.
	*
	* @param hechos the hechos of this Solicitud
	*/
	public void setHechos(java.lang.String hechos) {
		_solicitud.setHechos(hechos);
	}

	/**
	* Returns the pruebas of this Solicitud.
	*
	* @return the pruebas of this Solicitud
	*/
	public java.lang.String getPruebas() {
		return _solicitud.getPruebas();
	}

	/**
	* Sets the pruebas of this Solicitud.
	*
	* @param pruebas the pruebas of this Solicitud
	*/
	public void setPruebas(java.lang.String pruebas) {
		_solicitud.setPruebas(pruebas);
	}

	/**
	* Returns the id_estado of this Solicitud.
	*
	* @return the id_estado of this Solicitud
	*/
	public int getId_estado() {
		return _solicitud.getId_estado();
	}

	/**
	* Sets the id_estado of this Solicitud.
	*
	* @param id_estado the id_estado of this Solicitud
	*/
	public void setId_estado(int id_estado) {
		_solicitud.setId_estado(id_estado);
	}

	/**
	* Returns the id_implicado of this Solicitud.
	*
	* @return the id_implicado of this Solicitud
	*/
	public int getId_implicado() {
		return _solicitud.getId_implicado();
	}

	/**
	* Sets the id_implicado of this Solicitud.
	*
	* @param id_implicado the id_implicado of this Solicitud
	*/
	public void setId_implicado(int id_implicado) {
		_solicitud.setId_implicado(id_implicado);
	}

	/**
	* Returns the id_solicitante of this Solicitud.
	*
	* @return the id_solicitante of this Solicitud
	*/
	public int getId_solicitante() {
		return _solicitud.getId_solicitante();
	}

	/**
	* Sets the id_solicitante of this Solicitud.
	*
	* @param id_solicitante the id_solicitante of this Solicitud
	*/
	public void setId_solicitante(int id_solicitante) {
		_solicitud.setId_solicitante(id_solicitante);
	}

	/**
	* Returns the fecha registro of this Solicitud.
	*
	* @return the fecha registro of this Solicitud
	*/
	public java.util.Date getFechaRegistro() {
		return _solicitud.getFechaRegistro();
	}

	/**
	* Sets the fecha registro of this Solicitud.
	*
	* @param fechaRegistro the fecha registro of this Solicitud
	*/
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		_solicitud.setFechaRegistro(fechaRegistro);
	}

	public boolean isNew() {
		return _solicitud.isNew();
	}

	public void setNew(boolean n) {
		_solicitud.setNew(n);
	}

	public boolean isCachedModel() {
		return _solicitud.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_solicitud.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _solicitud.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _solicitud.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_solicitud.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _solicitud.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_solicitud.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SolicitudWrapper((Solicitud)_solicitud.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud) {
		return _solicitud.compareTo(solicitud);
	}

	@Override
	public int hashCode() {
		return _solicitud.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Solicitud> toCacheModel() {
		return _solicitud.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Solicitud toEscapedModel() {
		return new SolicitudWrapper(_solicitud.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _solicitud.toString();
	}

	public java.lang.String toXmlString() {
		return _solicitud.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_solicitud.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Solicitud getWrappedSolicitud() {
		return _solicitud;
	}

	public Solicitud getWrappedModel() {
		return _solicitud;
	}

	public void resetOriginalValues() {
		_solicitud.resetOriginalValues();
	}

	private Solicitud _solicitud;
}