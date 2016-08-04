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

import la.netco.solicitudes_sdisc.model.service.EstadoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class EstadoClp extends BaseModelImpl<Estado> implements Estado {
	public EstadoClp() {
	}

	public Class<?> getModelClass() {
		return Estado.class;
	}

	public String getModelClassName() {
		return Estado.class.getName();
	}

	public int getPrimaryKey() {
		return _id_estado;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_estado(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_estado);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_estado", getId_estado());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_estado = (Integer)attributes.get("id_estado");

		if (id_estado != null) {
			setId_estado(id_estado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public int getId_estado() {
		return _id_estado;
	}

	public void setId_estado(int id_estado) {
		_id_estado = id_estado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getEstadoRemoteModel() {
		return _estadoRemoteModel;
	}

	public void setEstadoRemoteModel(BaseModel<?> estadoRemoteModel) {
		_estadoRemoteModel = estadoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EstadoLocalServiceUtil.addEstado(this);
		}
		else {
			EstadoLocalServiceUtil.updateEstado(this);
		}
	}

	@Override
	public Estado toEscapedModel() {
		return (Estado)Proxy.newProxyInstance(Estado.class.getClassLoader(),
			new Class[] { Estado.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EstadoClp clone = new EstadoClp();

		clone.setId_estado(getId_estado());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(Estado estado) {
		int value = 0;

		value = getNombre().compareTo(estado.getNombre());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EstadoClp estado = null;

		try {
			estado = (EstadoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = estado.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{id_estado=");
		sb.append(getId_estado());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Estado");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_estado</column-name><column-value><![CDATA[");
		sb.append(getId_estado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_estado;
	private String _nombre;
	private BaseModel<?> _estadoRemoteModel;
}