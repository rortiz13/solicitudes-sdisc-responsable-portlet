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

import la.netco.solicitudes_sdisc.model.service.DelegadoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class DelegadoClp extends BaseModelImpl<Delegado> implements Delegado {
	public DelegadoClp() {
	}

	public Class<?> getModelClass() {
		return Delegado.class;
	}

	public String getModelClassName() {
		return Delegado.class.getName();
	}

	public int getPrimaryKey() {
		return _id_delegado;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_delegado(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_delegado);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_delegado", getId_delegado());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_delegado = (Integer)attributes.get("id_delegado");

		if (id_delegado != null) {
			setId_delegado(id_delegado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public int getId_delegado() {
		return _id_delegado;
	}

	public void setId_delegado(int id_delegado) {
		_id_delegado = id_delegado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getDelegadoRemoteModel() {
		return _delegadoRemoteModel;
	}

	public void setDelegadoRemoteModel(BaseModel<?> delegadoRemoteModel) {
		_delegadoRemoteModel = delegadoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DelegadoLocalServiceUtil.addDelegado(this);
		}
		else {
			DelegadoLocalServiceUtil.updateDelegado(this);
		}
	}

	@Override
	public Delegado toEscapedModel() {
		return (Delegado)Proxy.newProxyInstance(Delegado.class.getClassLoader(),
			new Class[] { Delegado.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DelegadoClp clone = new DelegadoClp();

		clone.setId_delegado(getId_delegado());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(Delegado delegado) {
		int value = 0;

		value = getNombre().compareTo(delegado.getNombre());

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

		DelegadoClp delegado = null;

		try {
			delegado = (DelegadoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = delegado.getPrimaryKey();

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

		sb.append("{id_delegado=");
		sb.append(getId_delegado());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Delegado");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_delegado</column-name><column-value><![CDATA[");
		sb.append(getId_delegado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_delegado;
	private String _nombre;
	private BaseModel<?> _delegadoRemoteModel;
}