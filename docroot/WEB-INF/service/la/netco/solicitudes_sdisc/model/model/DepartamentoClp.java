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

import la.netco.solicitudes_sdisc.model.service.DepartamentoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class DepartamentoClp extends BaseModelImpl<Departamento>
	implements Departamento {
	public DepartamentoClp() {
	}

	public Class<?> getModelClass() {
		return Departamento.class;
	}

	public String getModelClassName() {
		return Departamento.class.getName();
	}

	public int getPrimaryKey() {
		return _id_departamento;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_departamento(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_departamento);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_departamento", getId_departamento());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_departamento = (Integer)attributes.get("id_departamento");

		if (id_departamento != null) {
			setId_departamento(id_departamento);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public int getId_departamento() {
		return _id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		_id_departamento = id_departamento;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getDepartamentoRemoteModel() {
		return _departamentoRemoteModel;
	}

	public void setDepartamentoRemoteModel(BaseModel<?> departamentoRemoteModel) {
		_departamentoRemoteModel = departamentoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DepartamentoLocalServiceUtil.addDepartamento(this);
		}
		else {
			DepartamentoLocalServiceUtil.updateDepartamento(this);
		}
	}

	@Override
	public Departamento toEscapedModel() {
		return (Departamento)Proxy.newProxyInstance(Departamento.class.getClassLoader(),
			new Class[] { Departamento.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DepartamentoClp clone = new DepartamentoClp();

		clone.setId_departamento(getId_departamento());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(Departamento departamento) {
		int primaryKey = departamento.getPrimaryKey();

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

		DepartamentoClp departamento = null;

		try {
			departamento = (DepartamentoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = departamento.getPrimaryKey();

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

		sb.append("{id_departamento=");
		sb.append(getId_departamento());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Departamento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_departamento</column-name><column-value><![CDATA[");
		sb.append(getId_departamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_departamento;
	private String _nombre;
	private BaseModel<?> _departamentoRemoteModel;
}