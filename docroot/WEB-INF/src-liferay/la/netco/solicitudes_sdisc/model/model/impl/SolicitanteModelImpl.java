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

package la.netco.solicitudes_sdisc.model.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import la.netco.solicitudes_sdisc.model.model.Solicitante;
import la.netco.solicitudes_sdisc.model.model.SolicitanteModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Solicitante service. Represents a row in the &quot;SOLISALAD_SOLICITANTE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link la.netco.solicitudes_sdisc.model.model.SolicitanteModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SolicitanteImpl}.
 * </p>
 *
 * @author smontanez
 * @see SolicitanteImpl
 * @see la.netco.solicitudes_sdisc.model.model.Solicitante
 * @see la.netco.solicitudes_sdisc.model.model.SolicitanteModel
 * @generated
 */
public class SolicitanteModelImpl extends BaseModelImpl<Solicitante>
	implements SolicitanteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a solicitante model instance should use the {@link la.netco.solicitudes_sdisc.model.model.Solicitante} interface instead.
	 */
	public static final String TABLE_NAME = "SOLISALAD_SOLICITANTE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_solicitante", Types.INTEGER },
			{ "nombres", Types.VARCHAR },
			{ "apellidos", Types.VARCHAR },
			{ "num_documento", Types.VARCHAR },
			{ "telefono", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "direccion", Types.VARCHAR },
			{ "id_tipo_doc", Types.INTEGER },
			{ "id_ciudad", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table SOLISALAD_SOLICITANTE (id_solicitante INTEGER not null primary key IDENTITY,nombres VARCHAR(75) null,apellidos VARCHAR(75) null,num_documento VARCHAR(75) null,telefono VARCHAR(75) null,email VARCHAR(75) null,direccion VARCHAR(75) null,id_tipo_doc INTEGER,id_ciudad INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table SOLISALAD_SOLICITANTE";
	public static final String DATA_SOURCE = "csjDBDatasource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.la.netco.solicitudes_sdisc.model.model.Solicitante"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.la.netco.solicitudes_sdisc.model.model.Solicitante"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.la.netco.solicitudes_sdisc.model.model.Solicitante"));

	public SolicitanteModelImpl() {
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

	public Class<?> getModelClass() {
		return Solicitante.class;
	}

	public String getModelClassName() {
		return Solicitante.class.getName();
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
		if (_nombres == null) {
			return StringPool.BLANK;
		}
		else {
			return _nombres;
		}
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		if (_apellidos == null) {
			return StringPool.BLANK;
		}
		else {
			return _apellidos;
		}
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getNum_documento() {
		if (_num_documento == null) {
			return StringPool.BLANK;
		}
		else {
			return _num_documento;
		}
	}

	public void setNum_documento(String num_documento) {
		_num_documento = num_documento;
	}

	public String getTelefono() {
		if (_telefono == null) {
			return StringPool.BLANK;
		}
		else {
			return _telefono;
		}
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDireccion() {
		if (_direccion == null) {
			return StringPool.BLANK;
		}
		else {
			return _direccion;
		}
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

	@Override
	public Solicitante toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Solicitante)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		SolicitanteImpl solicitanteImpl = new SolicitanteImpl();

		solicitanteImpl.setId_solicitante(getId_solicitante());
		solicitanteImpl.setNombres(getNombres());
		solicitanteImpl.setApellidos(getApellidos());
		solicitanteImpl.setNum_documento(getNum_documento());
		solicitanteImpl.setTelefono(getTelefono());
		solicitanteImpl.setEmail(getEmail());
		solicitanteImpl.setDireccion(getDireccion());
		solicitanteImpl.setId_tipo_doc(getId_tipo_doc());
		solicitanteImpl.setId_ciudad(getId_ciudad());

		solicitanteImpl.resetOriginalValues();

		return solicitanteImpl;
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

		Solicitante solicitante = null;

		try {
			solicitante = (Solicitante)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Solicitante> toCacheModel() {
		SolicitanteCacheModel solicitanteCacheModel = new SolicitanteCacheModel();

		solicitanteCacheModel.id_solicitante = getId_solicitante();

		solicitanteCacheModel.nombres = getNombres();

		String nombres = solicitanteCacheModel.nombres;

		if ((nombres != null) && (nombres.length() == 0)) {
			solicitanteCacheModel.nombres = null;
		}

		solicitanteCacheModel.apellidos = getApellidos();

		String apellidos = solicitanteCacheModel.apellidos;

		if ((apellidos != null) && (apellidos.length() == 0)) {
			solicitanteCacheModel.apellidos = null;
		}

		solicitanteCacheModel.num_documento = getNum_documento();

		String num_documento = solicitanteCacheModel.num_documento;

		if ((num_documento != null) && (num_documento.length() == 0)) {
			solicitanteCacheModel.num_documento = null;
		}

		solicitanteCacheModel.telefono = getTelefono();

		String telefono = solicitanteCacheModel.telefono;

		if ((telefono != null) && (telefono.length() == 0)) {
			solicitanteCacheModel.telefono = null;
		}

		solicitanteCacheModel.email = getEmail();

		String email = solicitanteCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			solicitanteCacheModel.email = null;
		}

		solicitanteCacheModel.direccion = getDireccion();

		String direccion = solicitanteCacheModel.direccion;

		if ((direccion != null) && (direccion.length() == 0)) {
			solicitanteCacheModel.direccion = null;
		}

		solicitanteCacheModel.id_tipo_doc = getId_tipo_doc();

		solicitanteCacheModel.id_ciudad = getId_ciudad();

		return solicitanteCacheModel;
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

	private static ClassLoader _classLoader = Solicitante.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Solicitante.class
		};
	private int _id_solicitante;
	private String _nombres;
	private String _apellidos;
	private String _num_documento;
	private String _telefono;
	private String _email;
	private String _direccion;
	private Integer _id_tipo_doc;
	private Integer _id_ciudad;
	private Solicitante _escapedModelProxy;
}