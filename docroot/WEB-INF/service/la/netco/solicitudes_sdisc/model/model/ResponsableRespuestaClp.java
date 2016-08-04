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

import la.netco.solicitudes_sdisc.model.service.ResponsableRespuestaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class ResponsableRespuestaClp extends BaseModelImpl<ResponsableRespuesta>
	implements ResponsableRespuesta {
	public ResponsableRespuestaClp() {
	}

	public Class<?> getModelClass() {
		return ResponsableRespuesta.class;
	}

	public String getModelClassName() {
		return ResponsableRespuesta.class.getName();
	}

	public int getPrimaryKey() {
		return _id_responsable;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_responsable(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_responsable);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_responsable", getId_responsable());
		attributes.put("respuesta", getRespuesta());
		attributes.put("fecha_respuesta", getFecha_respuesta());
		attributes.put("nombre_usuario", getNombre_usuario());
		attributes.put("id_solicitud", getId_solicitud());

		return attributes;
	}

	@Override
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

	public int getId_responsable() {
		return _id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		_id_responsable = id_responsable;
	}

	public String getRespuesta() {
		return _respuesta;
	}

	public void setRespuesta(String respuesta) {
		_respuesta = respuesta;
	}

	public Date getFecha_respuesta() {
		return _fecha_respuesta;
	}

	public void setFecha_respuesta(Date fecha_respuesta) {
		_fecha_respuesta = fecha_respuesta;
	}

	public String getNombre_usuario() {
		return _nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		_nombre_usuario = nombre_usuario;
	}

	public int getId_solicitud() {
		return _id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		_id_solicitud = id_solicitud;
	}

	public BaseModel<?> getResponsableRespuestaRemoteModel() {
		return _responsableRespuestaRemoteModel;
	}

	public void setResponsableRespuestaRemoteModel(
		BaseModel<?> responsableRespuestaRemoteModel) {
		_responsableRespuestaRemoteModel = responsableRespuestaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ResponsableRespuestaLocalServiceUtil.addResponsableRespuesta(this);
		}
		else {
			ResponsableRespuestaLocalServiceUtil.updateResponsableRespuesta(this);
		}
	}

	@Override
	public ResponsableRespuesta toEscapedModel() {
		return (ResponsableRespuesta)Proxy.newProxyInstance(ResponsableRespuesta.class.getClassLoader(),
			new Class[] { ResponsableRespuesta.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ResponsableRespuestaClp clone = new ResponsableRespuestaClp();

		clone.setId_responsable(getId_responsable());
		clone.setRespuesta(getRespuesta());
		clone.setFecha_respuesta(getFecha_respuesta());
		clone.setNombre_usuario(getNombre_usuario());
		clone.setId_solicitud(getId_solicitud());

		return clone;
	}

	public int compareTo(ResponsableRespuesta responsableRespuesta) {
		int primaryKey = responsableRespuesta.getPrimaryKey();

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

		ResponsableRespuestaClp responsableRespuesta = null;

		try {
			responsableRespuesta = (ResponsableRespuestaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = responsableRespuesta.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id_responsable=");
		sb.append(getId_responsable());
		sb.append(", respuesta=");
		sb.append(getRespuesta());
		sb.append(", fecha_respuesta=");
		sb.append(getFecha_respuesta());
		sb.append(", nombre_usuario=");
		sb.append(getNombre_usuario());
		sb.append(", id_solicitud=");
		sb.append(getId_solicitud());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_responsable</column-name><column-value><![CDATA[");
		sb.append(getId_responsable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respuesta</column-name><column-value><![CDATA[");
		sb.append(getRespuesta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_respuesta</column-name><column-value><![CDATA[");
		sb.append(getFecha_respuesta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre_usuario</column-name><column-value><![CDATA[");
		sb.append(getNombre_usuario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_solicitud</column-name><column-value><![CDATA[");
		sb.append(getId_solicitud());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_responsable;
	private String _respuesta;
	private Date _fecha_respuesta;
	private String _nombre_usuario;
	private int _id_solicitud;
	private BaseModel<?> _responsableRespuestaRemoteModel;
}