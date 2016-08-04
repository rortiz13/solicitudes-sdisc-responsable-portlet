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

import la.netco.solicitudes_sdisc.model.service.CiudadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class CiudadClp extends BaseModelImpl<Ciudad> implements Ciudad {
	public CiudadClp() {
	}

	public Class<?> getModelClass() {
		return Ciudad.class;
	}

	public String getModelClassName() {
		return Ciudad.class.getName();
	}

	public int getPrimaryKey() {
		return _id_ciudad;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_ciudad(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_ciudad);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_ciudad", getId_ciudad());
		attributes.put("nombre", getNombre());
		attributes.put("id_departamento", getId_departamento());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_ciudad = (Integer)attributes.get("id_ciudad");

		if (id_ciudad != null) {
			setId_ciudad(id_ciudad);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		Integer id_departamento = (Integer)attributes.get("id_departamento");

		if (id_departamento != null) {
			setId_departamento(id_departamento);
		}
	}

	public int getId_ciudad() {
		return _id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		_id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public int getId_departamento() {
		return _id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		_id_departamento = id_departamento;
	}

	public BaseModel<?> getCiudadRemoteModel() {
		return _ciudadRemoteModel;
	}

	public void setCiudadRemoteModel(BaseModel<?> ciudadRemoteModel) {
		_ciudadRemoteModel = ciudadRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CiudadLocalServiceUtil.addCiudad(this);
		}
		else {
			CiudadLocalServiceUtil.updateCiudad(this);
		}
	}

	@Override
	public Ciudad toEscapedModel() {
		return (Ciudad)Proxy.newProxyInstance(Ciudad.class.getClassLoader(),
			new Class[] { Ciudad.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CiudadClp clone = new CiudadClp();

		clone.setId_ciudad(getId_ciudad());
		clone.setNombre(getNombre());
		clone.setId_departamento(getId_departamento());

		return clone;
	}

	public int compareTo(Ciudad ciudad) {
		int value = 0;

		value = getNombre().compareTo(ciudad.getNombre());

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

		CiudadClp ciudad = null;

		try {
			ciudad = (CiudadClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = ciudad.getPrimaryKey();

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

		sb.append("{id_ciudad=");
		sb.append(getId_ciudad());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append(", id_departamento=");
		sb.append(getId_departamento());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Ciudad");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_ciudad</column-name><column-value><![CDATA[");
		sb.append(getId_ciudad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_departamento</column-name><column-value><![CDATA[");
		sb.append(getId_departamento());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_ciudad;
	private String _nombre;
	private int _id_departamento;
	private BaseModel<?> _ciudadRemoteModel;
}