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

import la.netco.solicitudes_sdisc.model.service.ParametrosLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class ParametrosClp extends BaseModelImpl<Parametros>
	implements Parametros {
	public ParametrosClp() {
	}

	public Class<?> getModelClass() {
		return Parametros.class;
	}

	public String getModelClassName() {
		return Parametros.class.getName();
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

		attributes.put("tiempo_proximo_caducar", getTiempo_proximo_caducar());
		attributes.put("tiempo_caducidad", getTiempo_caducidad());
		attributes.put("email_resposable", getEmail_resposable());
		attributes.put("mensaje_email", getMensaje_email());
		attributes.put("asunto_email", getAsunto_email());
		attributes.put("id", getId());
		attributes.put("repositoryId", getRepositoryId());
		attributes.put("folderId", getFolderId());
		attributes.put("userRepositoryId", getUserRepositoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer tiempo_proximo_caducar = (Integer)attributes.get(
				"tiempo_proximo_caducar");

		if (tiempo_proximo_caducar != null) {
			setTiempo_proximo_caducar(tiempo_proximo_caducar);
		}

		Integer tiempo_caducidad = (Integer)attributes.get("tiempo_caducidad");

		if (tiempo_caducidad != null) {
			setTiempo_caducidad(tiempo_caducidad);
		}

		String email_resposable = (String)attributes.get("email_resposable");

		if (email_resposable != null) {
			setEmail_resposable(email_resposable);
		}

		String mensaje_email = (String)attributes.get("mensaje_email");

		if (mensaje_email != null) {
			setMensaje_email(mensaje_email);
		}

		String asunto_email = (String)attributes.get("asunto_email");

		if (asunto_email != null) {
			setAsunto_email(asunto_email);
		}

		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		Long userRepositoryId = (Long)attributes.get("userRepositoryId");

		if (userRepositoryId != null) {
			setUserRepositoryId(userRepositoryId);
		}
	}

	public int getTiempo_proximo_caducar() {
		return _tiempo_proximo_caducar;
	}

	public void setTiempo_proximo_caducar(int tiempo_proximo_caducar) {
		_tiempo_proximo_caducar = tiempo_proximo_caducar;
	}

	public int getTiempo_caducidad() {
		return _tiempo_caducidad;
	}

	public void setTiempo_caducidad(int tiempo_caducidad) {
		_tiempo_caducidad = tiempo_caducidad;
	}

	public String getEmail_resposable() {
		return _email_resposable;
	}

	public void setEmail_resposable(String email_resposable) {
		_email_resposable = email_resposable;
	}

	public String getMensaje_email() {
		return _mensaje_email;
	}

	public void setMensaje_email(String mensaje_email) {
		_mensaje_email = mensaje_email;
	}

	public String getAsunto_email() {
		return _asunto_email;
	}

	public void setAsunto_email(String asunto_email) {
		_asunto_email = asunto_email;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public long getUserRepositoryId() {
		return _userRepositoryId;
	}

	public void setUserRepositoryId(long userRepositoryId) {
		_userRepositoryId = userRepositoryId;
	}

	public BaseModel<?> getParametrosRemoteModel() {
		return _parametrosRemoteModel;
	}

	public void setParametrosRemoteModel(BaseModel<?> parametrosRemoteModel) {
		_parametrosRemoteModel = parametrosRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ParametrosLocalServiceUtil.addParametros(this);
		}
		else {
			ParametrosLocalServiceUtil.updateParametros(this);
		}
	}

	@Override
	public Parametros toEscapedModel() {
		return (Parametros)Proxy.newProxyInstance(Parametros.class.getClassLoader(),
			new Class[] { Parametros.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ParametrosClp clone = new ParametrosClp();

		clone.setTiempo_proximo_caducar(getTiempo_proximo_caducar());
		clone.setTiempo_caducidad(getTiempo_caducidad());
		clone.setEmail_resposable(getEmail_resposable());
		clone.setMensaje_email(getMensaje_email());
		clone.setAsunto_email(getAsunto_email());
		clone.setId(getId());
		clone.setRepositoryId(getRepositoryId());
		clone.setFolderId(getFolderId());
		clone.setUserRepositoryId(getUserRepositoryId());

		return clone;
	}

	public int compareTo(Parametros parametros) {
		int primaryKey = parametros.getPrimaryKey();

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

		ParametrosClp parametros = null;

		try {
			parametros = (ParametrosClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = parametros.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{tiempo_proximo_caducar=");
		sb.append(getTiempo_proximo_caducar());
		sb.append(", tiempo_caducidad=");
		sb.append(getTiempo_caducidad());
		sb.append(", email_resposable=");
		sb.append(getEmail_resposable());
		sb.append(", mensaje_email=");
		sb.append(getMensaje_email());
		sb.append(", asunto_email=");
		sb.append(getAsunto_email());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", repositoryId=");
		sb.append(getRepositoryId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", userRepositoryId=");
		sb.append(getUserRepositoryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Parametros");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tiempo_proximo_caducar</column-name><column-value><![CDATA[");
		sb.append(getTiempo_proximo_caducar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tiempo_caducidad</column-name><column-value><![CDATA[");
		sb.append(getTiempo_caducidad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email_resposable</column-name><column-value><![CDATA[");
		sb.append(getEmail_resposable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mensaje_email</column-name><column-value><![CDATA[");
		sb.append(getMensaje_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>asunto_email</column-name><column-value><![CDATA[");
		sb.append(getAsunto_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userRepositoryId</column-name><column-value><![CDATA[");
		sb.append(getUserRepositoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _tiempo_proximo_caducar;
	private int _tiempo_caducidad;
	private String _email_resposable;
	private String _mensaje_email;
	private String _asunto_email;
	private int _id;
	private long _repositoryId;
	private long _folderId;
	private long _userRepositoryId;
	private BaseModel<?> _parametrosRemoteModel;
}