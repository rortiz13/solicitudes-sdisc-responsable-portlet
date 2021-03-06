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
 * The base model interface for the Entidad service. Represents a row in the &quot;T051BAENTIGENE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link la.netco.solicitudes_sdisc.model.model.impl.EntidadModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link la.netco.solicitudes_sdisc.model.model.impl.EntidadImpl}.
 * </p>
 *
 * @author smontanez
 * @see Entidad
 * @see la.netco.solicitudes_sdisc.model.model.impl.EntidadImpl
 * @see la.netco.solicitudes_sdisc.model.model.impl.EntidadModelImpl
 * @generated
 */
public interface EntidadModel extends BaseModel<Entidad> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a entidad model instance should use the {@link Entidad} interface instead.
	 */

	/**
	 * Returns the primary key of this entidad.
	 *
	 * @return the primary key of this entidad
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this entidad.
	 *
	 * @param primaryKey the primary key of this entidad
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the codigo of this entidad.
	 *
	 * @return the codigo of this entidad
	 */
	@AutoEscape
	public String getCodigo();

	/**
	 * Sets the codigo of this entidad.
	 *
	 * @param codigo the codigo of this entidad
	 */
	public void setCodigo(String codigo);

	/**
	 * Returns the nombre of this entidad.
	 *
	 * @return the nombre of this entidad
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this entidad.
	 *
	 * @param nombre the nombre of this entidad
	 */
	public void setNombre(String nombre);

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

	public int compareTo(Entidad entidad);

	public int hashCode();

	public CacheModel<Entidad> toCacheModel();

	public Entidad toEscapedModel();

	public String toString();

	public String toXmlString();
}