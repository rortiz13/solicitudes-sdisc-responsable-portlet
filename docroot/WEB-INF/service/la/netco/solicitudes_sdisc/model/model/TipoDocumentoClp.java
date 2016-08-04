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

import la.netco.solicitudes_sdisc.model.service.TipoDocumentoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smontanez
 */
public class TipoDocumentoClp extends BaseModelImpl<TipoDocumento>
	implements TipoDocumento {
	public TipoDocumentoClp() {
	}

	public Class<?> getModelClass() {
		return TipoDocumento.class;
	}

	public String getModelClassName() {
		return TipoDocumento.class.getName();
	}

	public int getPrimaryKey() {
		return _id_tipo_doc;
	}

	public void setPrimaryKey(int primaryKey) {
		setId_tipo_doc(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id_tipo_doc);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_tipo_doc", getId_tipo_doc());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id_tipo_doc = (Integer)attributes.get("id_tipo_doc");

		if (id_tipo_doc != null) {
			setId_tipo_doc(id_tipo_doc);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public int getId_tipo_doc() {
		return _id_tipo_doc;
	}

	public void setId_tipo_doc(int id_tipo_doc) {
		_id_tipo_doc = id_tipo_doc;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getTipoDocumentoRemoteModel() {
		return _tipoDocumentoRemoteModel;
	}

	public void setTipoDocumentoRemoteModel(
		BaseModel<?> tipoDocumentoRemoteModel) {
		_tipoDocumentoRemoteModel = tipoDocumentoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TipoDocumentoLocalServiceUtil.addTipoDocumento(this);
		}
		else {
			TipoDocumentoLocalServiceUtil.updateTipoDocumento(this);
		}
	}

	@Override
	public TipoDocumento toEscapedModel() {
		return (TipoDocumento)Proxy.newProxyInstance(TipoDocumento.class.getClassLoader(),
			new Class[] { TipoDocumento.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TipoDocumentoClp clone = new TipoDocumentoClp();

		clone.setId_tipo_doc(getId_tipo_doc());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(TipoDocumento tipoDocumento) {
		int primaryKey = tipoDocumento.getPrimaryKey();

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

		TipoDocumentoClp tipoDocumento = null;

		try {
			tipoDocumento = (TipoDocumentoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = tipoDocumento.getPrimaryKey();

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

		sb.append("{id_tipo_doc=");
		sb.append(getId_tipo_doc());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("la.netco.solicitudes_sdisc.model.model.TipoDocumento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_tipo_doc</column-name><column-value><![CDATA[");
		sb.append(getId_tipo_doc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _id_tipo_doc;
	private String _nombre;
	private BaseModel<?> _tipoDocumentoRemoteModel;
}