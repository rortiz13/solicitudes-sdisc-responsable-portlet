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

import la.netco.solicitudes_sdisc.model.service.EntidadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class EntidadClp extends BaseModelImpl<Entidad> implements Entidad {
	public EntidadClp() {
	}

	public Class<?> getModelClass() {
		return Entidad.class;
	}

	public String getModelClassName() {
		return Entidad.class.getName();
	}

	public String getPrimaryKey() {
		return _codigo;
	}

	public void setPrimaryKey(String primaryKey) {
		setCodigo(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _codigo;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codigo", getCodigo());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public String getCodigo() {
		return _codigo;
	}

	public void setCodigo(String codigo) {
		_codigo = codigo;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getEntidadRemoteModel() {
		return _entidadRemoteModel;
	}

	public void setEntidadRemoteModel(BaseModel<?> entidadRemoteModel) {
		_entidadRemoteModel = entidadRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EntidadLocalServiceUtil.addEntidad(this);
		}
		else {
			EntidadLocalServiceUtil.updateEntidad(this);
		}
	}

	@Override
	public Entidad toEscapedModel() {
		return (Entidad)Proxy.newProxyInstance(Entidad.class.getClassLoader(),
			new Class[] { Entidad.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EntidadClp clone = new EntidadClp();

		clone.setCodigo(getCodigo());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(Entidad entidad) {
		String primaryKey = entidad.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EntidadClp entidad = null;

		try {
			entidad = (EntidadClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = entidad.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{codigo=");
		sb.append(getCodigo());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Entidad");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codigo</column-name><column-value><![CDATA[");
		sb.append(getCodigo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _codigo;
	private String _nombre;
	private BaseModel<?> _entidadRemoteModel;
}