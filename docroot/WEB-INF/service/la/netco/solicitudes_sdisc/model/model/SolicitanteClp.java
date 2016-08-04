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

import la.netco.solicitudes_sdisc.model.service.SolicitanteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class SolicitanteClp extends BaseModelImpl<Solicitante>
	implements Solicitante {
	public SolicitanteClp() {
	}

	public Class<?> getModelClass() {
		return Solicitante.class;
	}

	public String getModelClassName() {
		return Solicitante.class.getName();
	}

	public int getPrimaryKey() {
		return _id_solicitante;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_solicitante(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_solicitante);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_solicitante", getId_solicitante());
		attributes.put("nombres", getNombres());
		attributes.put("apellidos", getApellidos());
		attributes.put("num_documento", getNum_documento());
		attributes.put("telefono", getTelefono());
		attributes.put("email", getEmail());
		attributes.put("direccion", getDireccion());
		attributes.put("id_tipo_doc", getId_tipo_doc());
		attributes.put("id_ciudad", getId_ciudad());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_solicitante = (Integer)attributes.get("id_solicitante");

		if (id_solicitante != null) {
			setId_solicitante(id_solicitante);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String num_documento = (String)attributes.get("num_documento");

		if (num_documento != null) {
			setNum_documento(num_documento);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		Integer id_tipo_doc = (Integer)attributes.get("id_tipo_doc");

		if (id_tipo_doc != null) {
			setId_tipo_doc(id_tipo_doc);
		}

		Integer id_ciudad = (Integer)attributes.get("id_ciudad");

		if (id_ciudad != null) {
			setId_ciudad(id_ciudad);
		}
	}

	public int getId_solicitante() {
		return _id_solicitante;
	}

	public void setId_solicitante(int id_solicitante) {
		_id_solicitante = id_solicitante;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getNum_documento() {
		return _num_documento;
	}

	public void setNum_documento(String num_documento) {
		_num_documento = num_documento;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public Integer getId_tipo_doc() {
		return _id_tipo_doc;
	}

	public void setId_tipo_doc(Integer id_tipo_doc) {
		_id_tipo_doc = id_tipo_doc;
	}

	public Integer getId_ciudad() {
		return _id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		_id_ciudad = id_ciudad;
	}

	public BaseModel<?> getSolicitanteRemoteModel() {
		return _solicitanteRemoteModel;
	}

	public void setSolicitanteRemoteModel(BaseModel<?> solicitanteRemoteModel) {
		_solicitanteRemoteModel = solicitanteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SolicitanteLocalServiceUtil.addSolicitante(this);
		}
		else {
			SolicitanteLocalServiceUtil.updateSolicitante(this);
		}
	}

	@Override
	public Solicitante toEscapedModel() {
		return (Solicitante)Proxy.newProxyInstance(Solicitante.class.getClassLoader(),
			new Class[] { Solicitante.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SolicitanteClp clone = new SolicitanteClp();

		clone.setId_solicitante(getId_solicitante());
		clone.setNombres(getNombres());
		clone.setApellidos(getApellidos());
		clone.setNum_documento(getNum_documento());
		clone.setTelefono(getTelefono());
		clone.setEmail(getEmail());
		clone.setDireccion(getDireccion());
		clone.setId_tipo_doc(getId_tipo_doc());
		clone.setId_ciudad(getId_ciudad());

		return clone;
	}

	public int compareTo(Solicitante solicitante) {
		int primaryKey = solicitante.getPrimaryKey();

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

		SolicitanteClp solicitante = null;

		try {
			solicitante = (SolicitanteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = solicitante.getPrimaryKey();

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

		sb.append("{id_solicitante=");
		sb.append(getId_solicitante());
		sb.append(", nombres=");
		sb.append(getNombres());
		sb.append(", apellidos=");
		sb.append(getApellidos());
		sb.append(", num_documento=");
		sb.append(getNum_documento());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", direccion=");
		sb.append(getDireccion());
		sb.append(", id_tipo_doc=");
		sb.append(getId_tipo_doc());
		sb.append(", id_ciudad=");
		sb.append(getId_ciudad());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Solicitante");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_solicitante</column-name><column-value><![CDATA[");
		sb.append(getId_solicitante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombres</column-name><column-value><![CDATA[");
		sb.append(getNombres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidos</column-name><column-value><![CDATA[");
		sb.append(getApellidos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>num_documento</column-name><column-value><![CDATA[");
		sb.append(getNum_documento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>direccion</column-name><column-value><![CDATA[");
		sb.append(getDireccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_tipo_doc</column-name><column-value><![CDATA[");
		sb.append(getId_tipo_doc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_ciudad</column-name><column-value><![CDATA[");
		sb.append(getId_ciudad());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_solicitante;
	private String _nombres;
	private String _apellidos;
	private String _num_documento;
	private String _telefono;
	private String _email;
	private String _direccion;
	private Integer _id_tipo_doc;
	private Integer _id_ciudad;
	private BaseModel<?> _solicitanteRemoteModel;
}