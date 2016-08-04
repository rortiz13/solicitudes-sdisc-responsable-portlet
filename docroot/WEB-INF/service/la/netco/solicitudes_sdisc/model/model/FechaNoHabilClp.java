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

import la.netco.solicitudes_sdisc.model.service.FechaNoHabilLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class FechaNoHabilClp extends BaseModelImpl<FechaNoHabil>
	implements FechaNoHabil {
	public FechaNoHabilClp() {
	}

	public Class<?> getModelClass() {
		return FechaNoHabil.class;
	}

	public String getModelClassName() {
		return FechaNoHabil.class.getName();
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("fecha", getFecha());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
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

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getFechaNoHabilRemoteModel() {
		return _fechaNoHabilRemoteModel;
	}

	public void setFechaNoHabilRemoteModel(BaseModel<?> fechaNoHabilRemoteModel) {
		_fechaNoHabilRemoteModel = fechaNoHabilRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FechaNoHabilLocalServiceUtil.addFechaNoHabil(this);
		}
		else {
			FechaNoHabilLocalServiceUtil.updateFechaNoHabil(this);
		}
	}

	@Override
	public FechaNoHabil toEscapedModel() {
		return (FechaNoHabil)Proxy.newProxyInstance(FechaNoHabil.class.getClassLoader(),
			new Class[] { FechaNoHabil.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FechaNoHabilClp clone = new FechaNoHabilClp();

		clone.setId(getId());
		clone.setFecha(getFecha());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(FechaNoHabil fechaNoHabil) {
		int primaryKey = fechaNoHabil.getPrimaryKey();

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

		FechaNoHabilClp fechaNoHabil = null;

		try {
			fechaNoHabil = (FechaNoHabilClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = fechaNoHabil.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.FechaNoHabil");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id;
	private Date _fecha;
	private String _nombre;
	private BaseModel<?> _fechaNoHabilRemoteModel;
}