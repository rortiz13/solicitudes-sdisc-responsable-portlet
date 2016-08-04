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

import la.netco.solicitudes_sdisc.model.service.PerfilImplicadoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class PerfilImplicadoClp extends BaseModelImpl<PerfilImplicado>
	implements PerfilImplicado {
	public PerfilImplicadoClp() {
	}

	public Class<?> getModelClass() {
		return PerfilImplicado.class;
	}

	public String getModelClassName() {
		return PerfilImplicado.class.getName();
	}

	public int getPrimaryKey() {
		return _id_perfil;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_perfil(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_perfil);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_perfil", getId_perfil());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_perfil = (Integer)attributes.get("id_perfil");

		if (id_perfil != null) {
			setId_perfil(id_perfil);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public int getId_perfil() {
		return _id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		_id_perfil = id_perfil;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getPerfilImplicadoRemoteModel() {
		return _perfilImplicadoRemoteModel;
	}

	public void setPerfilImplicadoRemoteModel(
		BaseModel<?> perfilImplicadoRemoteModel) {
		_perfilImplicadoRemoteModel = perfilImplicadoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PerfilImplicadoLocalServiceUtil.addPerfilImplicado(this);
		}
		else {
			PerfilImplicadoLocalServiceUtil.updatePerfilImplicado(this);
		}
	}

	@Override
	public PerfilImplicado toEscapedModel() {
		return (PerfilImplicado)Proxy.newProxyInstance(PerfilImplicado.class.getClassLoader(),
			new Class[] { PerfilImplicado.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PerfilImplicadoClp clone = new PerfilImplicadoClp();

		clone.setId_perfil(getId_perfil());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(PerfilImplicado perfilImplicado) {
		int primaryKey = perfilImplicado.getPrimaryKey();

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

		PerfilImplicadoClp perfilImplicado = null;

		try {
			perfilImplicado = (PerfilImplicadoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = perfilImplicado.getPrimaryKey();

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

		sb.append("{id_perfil=");
		sb.append(getId_perfil());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.PerfilImplicado");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_perfil</column-name><column-value><![CDATA[");
		sb.append(getId_perfil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_perfil;
	private String _nombre;
	private BaseModel<?> _perfilImplicadoRemoteModel;
}