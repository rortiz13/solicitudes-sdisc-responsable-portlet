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

import java.util.Date;

/**
 * The base model interface for the ResponsableRespuesta service. Represents a row in the &quot;SOLISALAD_RESPONSABLE_RESPUESTA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaImpl}.
 * </p>
 *
 * @author smontanez
 * @see ResponsableRespuesta
 * @see la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaImpl
 * @see la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaModelImpl
 * @generated
 */
public interface ResponsableRespuestaModel extends BaseModel<ResponsableRespuesta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a responsable respuesta model instance should use the {@link ResponsableRespuesta} interface instead.
	 */

	/**
	 * Returns the primary key of this responsable respuesta.
	 *
	 * @return the primary key of this responsable respuesta
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this responsable respuesta.
	 *
	 * @param primaryKey the primary key of this responsable respuesta
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the id_responsable of this responsable respuesta.
	 *
	 * @return the id_responsable of this responsable respuesta
	 */
	public int getId_responsable();

	/**
	 * Sets the id_responsable of this responsable respuesta.
	 *
	 * @param id_responsable the id_responsable of this responsable respuesta
	 */
	public void setId_responsable(int id_responsable);

	/**
	 * Returns the respuesta of this responsable respuesta.
	 *
	 * @return the respuesta of this responsable respuesta
	 */
	@AutoEscape
	public String getRespuesta();

	/**
	 * Sets the respuesta of this responsable respuesta.
	 *
	 * @param respuesta the respuesta of this responsable respuesta
	 */
	public void setRespuesta(String respuesta);

	/**
	 * Returns the fecha_respuesta of this responsable respuesta.
	 *
	 * @return the fecha_respuesta of this responsable respuesta
	 */
	public Date getFecha_respuesta();

	/**
	 * Sets the fecha_respuesta of this responsable respuesta.
	 *
	 * @param fecha_respuesta the fecha_respuesta of this responsable respuesta
	 */
	public void setFecha_respuesta(Date fecha_respuesta);

	/**
	 * Returns the nombre_usuario of this responsable respuesta.
	 *
	 * @return the nombre_usuario of this responsable respuesta
	 */
	@AutoEscape
	public String getNombre_usuario();

	/**
	 * Sets the nombre_usuario of this responsable respuesta.
	 *
	 * @param nombre_usuario the nombre_usuario of this responsable respuesta
	 */
	public void setNombre_usuario(String nombre_usuario);

	/**
	 * Returns the id_solicitud of this responsable respuesta.
	 *
	 * @return the id_solicitud of this responsable respuesta
	 */
	public int getId_solicitud();

	/**
	 * Sets the id_solicitud of this responsable respuesta.
	 *
	 * @param id_solicitud the id_solicitud of this responsable respuesta
	 */
	public void setId_solicitud(int id_solicitud);

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

	public int compareTo(ResponsableRespuesta responsableRespuesta);

	public int hashCode();

	public CacheModel<ResponsableRespuesta> toCacheModel();

	public ResponsableRespuesta toEscapedModel();

	public String toString();

	public String toXmlString();
}