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

import la.netco.solicitudes_sdisc.model.model.Implicado;
import la.netco.solicitudes_sdisc.model.model.ImplicadoModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Implicado service. Represents a row in the &quot;SOLISALAD_IMPLICADO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link la.netco.solicitudes_sdisc.model.model.ImplicadoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImplicadoImpl}.
 * </p>
 *
 * @author smontanez
 * @see ImplicadoImpl
 * @see la.netco.solicitudes_sdisc.model.model.Implicado
 * @see la.netco.solicitudes_sdisc.model.model.ImplicadoModel
 * @generated
 */
public class ImplicadoModelImpl extends BaseModelImpl<Implicado>
	implements ImplicadoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a implicado model instance should use the {@link la.netco.solicitudes_sdisc.model.model.Implicado} interface instead.
	 */
	public static final String TABLE_NAME = "SOLISALAD_IMPLICADO";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_implicado", Types.INTEGER },
			{ "nombre", Types.VARCHAR },
			{ "despacho_entidad", Types.VARCHAR },
			{ "id_perfil", Types.INTEGER },
			{ "id_ciudad", Types.INTEGER },
			{ "cod_entidad", Types.VARCHAR },
			{ "cod_especialidad", Types.VARCHAR },
			{ "id_delegado", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table SOLISALAD_IMPLICADO (id_implicado INTEGER not null primary key IDENTITY,nombre VARCHAR(75) null,despacho_entidad VARCHAR(75) null,id_perfil INTEGER,id_ciudad INTEGER,cod_entidad VARCHAR(75) null,cod_especialidad VARCHAR(75) null,id_delegado INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table SOLISALAD_IMPLICADO";
	public static final String DATA_SOURCE = "csjDBDatasource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.la.netco.solicitudes_sdisc.model.model.Implicado"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.la.netco.solicitudes_sdisc.model.model.Implicado"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.la.netco.solicitudes_sdisc.model.model.Implicado"));

	public ImplicadoModelImpl() {
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

	public Class<?> getModelClass() {
		return Implicado.class;
	}

	public String getModelClassName() {
		return Implicado.class.getName();
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
		if (_nombre == null) {
			return StringPool.BLANK;
		}
		else {
			return _nombre;
		}
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getDespacho_entidad() {
		if (_despacho_entidad == null) {
			return StringPool.BLANK;
		}
		else {
			return _despacho_entidad;
		}
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

	@Override
	public Implicado toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Implicado)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ImplicadoImpl implicadoImpl = new ImplicadoImpl();

		implicadoImpl.setId_implicado(getId_implicado());
		implicadoImpl.setNombre(getNombre());
		implicadoImpl.setDespacho_entidad(getDespacho_entidad());
		implicadoImpl.setId_perfil(getId_perfil());
		implicadoImpl.setId_ciudad(getId_ciudad());
		implicadoImpl.setCod_entidad(getCod_entidad());
		implicadoImpl.setCod_especialidad(getCod_especialidad());
		implicadoImpl.setId_delegado(getId_delegado());

		implicadoImpl.resetOriginalValues();

		return implicadoImpl;
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

		Implicado implicado = null;

		try {
			implicado = (Implicado)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Implicado> toCacheModel() {
		ImplicadoCacheModel implicadoCacheModel = new ImplicadoCacheModel();

		implicadoCacheModel.id_implicado = getId_implicado();

		implicadoCacheModel.nombre = getNombre();

		String nombre = implicadoCacheModel.nombre;

		if ((nombre != null) && (nombre.length() == 0)) {
			implicadoCacheModel.nombre = null;
		}

		implicadoCacheModel.despacho_entidad = getDespacho_entidad();

		String despacho_entidad = implicadoCacheModel.despacho_entidad;

		if ((despacho_entidad != null) && (despacho_entidad.length() == 0)) {
			implicadoCacheModel.despacho_entidad = null;
		}

		implicadoCacheModel.id_perfil = getId_perfil();

		implicadoCacheModel.id_ciudad = getId_ciudad();

		implicadoCacheModel.cod_entidad = getCod_entidad();

		String cod_entidad = implicadoCacheModel.cod_entidad;

		if ((cod_entidad != null) && (cod_entidad.length() == 0)) {
			implicadoCacheModel.cod_entidad = null;
		}

		implicadoCacheModel.cod_especialidad = getCod_especialidad();

		String cod_especialidad = implicadoCacheModel.cod_especialidad;

		if ((cod_especialidad != null) && (cod_especialidad.length() == 0)) {
			implicadoCacheModel.cod_especialidad = null;
		}

		implicadoCacheModel.id_delegado = getId_delegado();

		return implicadoCacheModel;
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

	private static ClassLoader _classLoader = Implicado.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Implicado.class
		};
	private int _id_implicado;
	private String _nombre;
	private String _despacho_entidad;
	private int _id_perfil;
	private Integer _id_ciudad;
	private String _cod_entidad;
	private String _cod_especialidad;
	private Integer _id_delegado;
	private Implicado _escapedModelProxy;
}