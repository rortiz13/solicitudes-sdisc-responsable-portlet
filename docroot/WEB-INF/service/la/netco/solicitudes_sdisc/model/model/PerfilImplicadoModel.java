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
 * The base model interface for the PerfilImplicado service. Represents a row in the &quot;SOLISALAD_PERFIL_IMPL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link la.netco.solicitudes_sdisc.model.model.impl.PerfilImplicadoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link la.netco.solicitudes_sdisc.model.model.impl.PerfilImplicadoImpl}.
 * </p>
 *
 * @author smontanez
 * @see PerfilImplicado
 * @see la.netco.solicitudes_sdisc.model.model.impl.PerfilImplicadoImpl
 * @see la.netco.solicitudes_sdisc.model.model.impl.PerfilImplicadoModelImpl
 * @generated
 */
public interface PerfilImplicadoModel extends BaseModel<PerfilImplicado> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a perfil implicado model instance should use the {@link PerfilImplicado} interface instead.
	 */

	/**
	 * Returns the primary key of this perfil implicado.
	 *
	 * @return the primary key of this perfil implicado
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this perfil implicado.
	 *
	 * @param primaryKey the primary key of this perfil implicado
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the id_perfil of this perfil implicado.
	 *
	 * @return the id_perfil of this perfil implicado
	 */
	public int getId_perfil();

	/**
	 * Sets the id_perfil of this perfil implicado.
	 *
	 * @param id_perfil the id_perfil of this perfil implicado
	 */
	public void setId_perfil(int id_perfil);

	/**
	 * Returns the nombre of this perfil implicado.
	 *
	 * @return the nombre of this perfil implicado
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this perfil implicado.
	 *
	 * @param nombre the nombre of this perfil implicado
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

	public int compareTo(PerfilImplicado perfilImplicado);

	public int hashCode();

	public CacheModel<PerfilImplicado> toCacheModel();

	public PerfilImplicado toEscapedModel();

	public String toString();

	public String toXmlString();
}