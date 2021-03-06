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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Ciudad service. Represents a row in the &quot;GEO_CIUDAD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link la.netco.solicitudes_sdisc.model.model.impl.CiudadModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link la.netco.solicitudes_sdisc.model.model.impl.CiudadImpl}.
 * </p>
 *
 * @author smontanez
 * @see Ciudad
 * @see la.netco.solicitudes_sdisc.model.model.impl.CiudadImpl
 * @see la.netco.solicitudes_sdisc.model.model.impl.CiudadModelImpl
 * @generated
 */
public interface CiudadModel extends BaseModel<Ciudad> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ciudad model instance should use the {@link Ciudad} interface instead.
	 */

	/**
	 * Returns the primary key of this ciudad.
	 *
	 * @return the primary key of this ciudad
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this ciudad.
	 *
	 * @param primaryKey the primary key of this ciudad
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the id_ciudad of this ciudad.
	 *
	 * @return the id_ciudad of this ciudad
	 */
	public int getId_ciudad();

	/**
	 * Sets the id_ciudad of this ciudad.
	 *
	 * @param id_ciudad the id_ciudad of this ciudad
	 */
	public void setId_ciudad(int id_ciudad);

	/**
	 * Returns the nombre of this ciudad.
	 *
	 * @return the nombre of this ciudad
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this ciudad.
	 *
	 * @param nombre the nombre of this ciudad
	 */
	public void setNombre(String nombre);

	/**
	 * Returns the id_departamento of this ciudad.
	 *
	 * @return the id_departamento of this ciudad
	 */
	public int getId_departamento();

	/**
	 * Sets the id_departamento of this ciudad.
	 *
	 * @param id_departamento the id_departamento of this ciudad
	 */
	public void setId_departamento(int id_departamento);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Ciudad ciudad);

	public int hashCode();

	public CacheModel<Ciudad> toCacheModel();

	public Ciudad toEscapedModel();

	public String toString();

	public String toXmlString();
}