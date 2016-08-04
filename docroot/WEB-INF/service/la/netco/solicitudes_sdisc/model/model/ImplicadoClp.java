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

import la.netco.solicitudes_sdisc.model.service.ImplicadoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class ImplicadoClp extends BaseModelImpl<Implicado> implements Implicado {
	public ImplicadoClp() {
	}

	public Class<?> getModelClass() {
		return Implicado.class;
	}

	public String getModelClassName() {
		return Implicado.class.getName();
	}

	public int getPrimaryKey() {
		return _id_implicado;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_implicado(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_implicado);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_implicado", getId_implicado());
		attributes.put("nombre", getNombre());
		attributes.put("despacho_entidad", getDespacho_entidad());
		attributes.put("id_perfil", getId_perfil());
		attributes.put("id_ciudad", getId_ciudad());
		attributes.put("cod_entidad", getCod_entidad());
		attributes.put("cod_especialidad", getCod_especialidad());
		attributes.put("id_delegado", getId_delegado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_implicado = (Integer)attributes.get("id_implicado");

		if (id_implicado != null) {
			setId_implicado(id_implicado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String despacho_entidad = (String)attributes.get("despacho_entidad");

		if (despacho_entidad != null) {
			setDespacho_entidad(despacho_entidad);
		}

		Integer id_perfil = (Integer)attributes.get("id_perfil");

		if (id_perfil != null) {
			setId_perfil(id_perfil);
		}

		Integer id_ciudad = (Integer)attributes.get("id_ciudad");

		if (id_ciudad != null) {
			setId_ciudad(id_ciudad);
		}

		String cod_entidad = (String)attributes.get("cod_entidad");

		if (cod_entidad != null) {
			setCod_entidad(cod_entidad);
		}

		String cod_especialidad = (String)attributes.get("cod_especialidad");

		if (cod_especialidad != null) {
			setCod_especialidad(cod_especialidad);
		}

		Integer id_delegado = (Integer)attributes.get("id_delegado");

		if (id_delegado != null) {
			setId_delegado(id_delegado);
		}
	}

	public int getId_implicado() {
		return _id_implicado;
	}

	public void setId_implicado(int id_implicado) {
		_id_implicado = id_implicado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getDespacho_entidad() {
		return _despacho_entidad;
	}

	public void setDespacho_entidad(String despacho_entidad) {
		_despacho_entidad = despacho_entidad;
	}

	public int getId_perfil() {
		return _id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		_id_perfil = id_perfil;
	}

	public Integer getId_ciudad() {
		return _id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		_id_ciudad = id_ciudad;
	}

	public String getCod_entidad() {
		return _cod_entidad;
	}

	public void setCod_entidad(String cod_entidad) {
		_cod_entidad = cod_entidad;
	}

	public String getCod_especialidad() {
		return _cod_especialidad;
	}

	public void setCod_especialidad(String cod_especialidad) {
		_cod_especialidad = cod_especialidad;
	}

	public Integer getId_delegado() {
		return _id_delegado;
	}

	public void setId_delegado(Integer id_delegado) {
		_id_delegado = id_delegado;
	}

	public BaseModel<?> getImplicadoRemoteModel() {
		return _implicadoRemoteModel;
	}

	public void setImplicadoRemoteModel(BaseModel<?> implicadoRemoteModel) {
		_implicadoRemoteModel = implicadoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ImplicadoLocalServiceUtil.addImplicado(this);
		}
		else {
			ImplicadoLocalServiceUtil.updateImplicado(this);
		}
	}

	@Override
	public Implicado toEscapedModel() {
		return (Implicado)Proxy.newProxyInstance(Implicado.class.getClassLoader(),
			new Class[] { Implicado.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ImplicadoClp clone = new ImplicadoClp();

		clone.setId_implicado(getId_implicado());
		clone.setNombre(getNombre());
		clone.setDespacho_entidad(getDespacho_entidad());
		clone.setId_perfil(getId_perfil());
		clone.setId_ciudad(getId_ciudad());
		clone.setCod_entidad(getCod_entidad());
		clone.setCod_especialidad(getCod_especialidad());
		clone.setId_delegado(getId_delegado());

		return clone;
	}

	public int compareTo(Implicado implicado) {
		int primaryKey = implicado.getPrimaryKey();

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

		ImplicadoClp implicado = null;

		try {
			implicado = (ImplicadoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = implicado.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{id_implicado=");
		sb.append(getId_implicado());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append(", despacho_entidad=");
		sb.append(getDespacho_entidad());
		sb.append(", id_perfil=");
		sb.append(getId_perfil());
		sb.append(", id_ciudad=");
		sb.append(getId_ciudad());
		sb.append(", cod_entidad=");
		sb.append(getCod_entidad());
		sb.append(", cod_especialidad=");
		sb.append(getCod_especialidad());
		sb.append(", id_delegado=");
		sb.append(getId_delegado());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.Implicado");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_implicado</column-name><column-value><![CDATA[");
		sb.append(getId_implicado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despacho_entidad</column-name><column-value><![CDATA[");
		sb.append(getDespacho_entidad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_perfil</column-name><column-value><![CDATA[");
		sb.append(getId_perfil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_ciudad</column-name><column-value><![CDATA[");
		sb.append(getId_ciudad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cod_entidad</column-name><column-value><![CDATA[");
		sb.append(getCod_entidad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cod_especialidad</column-name><column-value><![CDATA[");
		sb.append(getCod_especialidad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_delegado</column-name><column-value><![CDATA[");
		sb.append(getId_delegado());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_implicado;
	private String _nombre;
	private String _despacho_entidad;
	private int _id_perfil;
	private Integer _id_ciudad;
	private String _cod_entidad;
	private String _cod_especialidad;
	private Integer _id_delegado;
	private BaseModel<?> _implicadoRemoteModel;
}