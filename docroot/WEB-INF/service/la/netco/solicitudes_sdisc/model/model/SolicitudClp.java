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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class SolicitudClp extends BaseModelImpl<Solicitud> implements Solicitud {
	public SolicitudClp() {
	}

	public Class<?> getModelClass() {
		return Solicitud.class;
	}

	public String getModelClassName() {
		return Solicitud.class.getName();
	}

	public int getPrimaryKey() {
		return _id_solicitud;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_solicitud(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_solicitud);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
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

	@Override
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

	public int getId_solicitud() {
		return _id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		_id_solicitud = id_solicitud;
	}

	public String getHechos() {
		return _hechos;
	}

	public void setHechos(String hechos) {
		_hechos = hechos;
	}

	public String getPruebas() {
		return _pruebas;
	}

	public void setPruebas(String pruebas) {
		_pruebas = pruebas;
	}

	public int getId_estado() {
		return _id_estado;
	}

	public void setId_estado(int id_estado) {
		_id_estado = id_estado;
	}

	public int getId_implicado() {
		return _id_implicado;
	}

	public void setId_implicado(int id_implicado) {
		_id_implicado = id_implicado;
	}

	public int getId_solicitante() {
		return _id_solicitante;
	}

	public void setId_solicitante(int id_solicitante) {
		_id_solicitante = id_solicitante;
	}

	public Date getFechaRegistro() {
		return _fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		_fechaRegistro = fechaRegistro;
	}

	public BaseModel<?> getSolicitudRemoteModel() {
		return _solicitudRemoteModel;
	}

	public void setSolicitudRemoteModel(BaseModel<?> solicitudRemoteModel) {
		_solicitudRemoteModel = solicitudRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SolicitudLocalServiceUtil.addSolicitud(this);
		}
		else {
			SolicitudLocalServiceUtil.updateSolicitud(this);
		}
	}

	@Override
	public Solicitud toEscapedModel() {
		return (Solicitud)Proxy.newProxyInstance(Solicitud.class.getClassLoader(),
			new Class[] { Solicitud.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SolicitudClp clone = new SolicitudClp();

		clone.setId_solicitud(getId_solicitud());
		clone.setHechos(getHechos());
		clone.setPruebas(getPruebas());
		clone.setId_estado(getId_estado());
		clone.setId_implicado(getId_implicado());
		clone.setId_solicitante(getId_solicitante());
		clone.setFechaRegistro(getFechaRegistro());

		return clone;
	}

	public int compareTo(Solicitud solicitud) {
		int primaryKey = solicitud.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SolicitudClp solicitud = null;

		try {
			solicitud = (SolicitudClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = solicitud.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_solicitud=");
		sb.append(getId_solicitud());
		sb.append(", hechos=");
		sb.append(getHechos());
		sb.append(", pruebas=");
		sb.append(getPruebas());
		sb.append(", id_estado=");
		sb.append(getId_estado());
		sb.append(", id_implicado=");
		sb.append(getId_implicado());
		sb.append(", id_solicitante=");
		sb.append(getId_solicitante());
		sb.append(", fechaRegistro=");
		sb.append(getFechaRegistro());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Solicitud");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_solicitud</column-name><column-value><![CDATA[");
		sb.append(getId_solicitud());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hechos</column-name><column-value><![CDATA[");
		sb.append(getHechos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pruebas</column-name><column-value><![CDATA[");
		sb.append(getPruebas());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_estado</column-name><column-value><![CDATA[");
		sb.append(getId_estado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_implicado</column-name><column-value><![CDATA[");
		sb.append(getId_implicado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_solicitante</column-name><column-value><![CDATA[");
		sb.append(getId_solicitante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaRegistro</column-name><column-value><![CDATA[");
		sb.append(getFechaRegistro());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_solicitud;
	private String _hechos;
	private String _pruebas;
	private int _id_estado;
	private int _id_implicado;
	private int _id_solicitante;
	private Date _fechaRegistro;
	private BaseModel<?> _solicitudRemoteModel;
}