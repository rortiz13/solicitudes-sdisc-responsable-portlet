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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ResponsableRespuesta in entity cache.
 *
 * @author smontanez
 * @see ResponsableRespuesta
 * @generated
 */
public class ResponsableRespuestaCacheModel implements CacheModel<ResponsableRespuesta>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id_responsable=");
		sb.append(id_responsable);
		sb.append(", respuesta=");
		sb.append(respuesta);
		sb.append(", fecha_respuesta=");
		sb.append(fecha_respuesta);
		sb.append(", nombre_usuario=");
		sb.append(nombre_usuario);
		sb.append(", id_solicitud=");
		sb.append(id_solicitud);
		sb.append("}");

		return sb.toString();
	}

	public ResponsableRespuesta toEntityModel() {
		ResponsableRespuestaImpl responsableRespuestaImpl = new ResponsableRespuestaImpl();

		responsableRespuestaImpl.setId_responsable(id_responsable);

		if (respuesta == null) {
			responsableRespuestaImpl.setRespuesta(StringPool.BLANK);
		}
		else {
			responsableRespuestaImpl.setRespuesta(respuesta);
		}

		if (fecha_respuesta == Long.MIN_VALUE) {
			responsableRespuestaImpl.setFecha_respuesta(null);
		}
		else {
			responsableRespuestaImpl.setFecha_respuesta(new Date(
					fecha_respuesta));
		}

		if (nombre_usuario == null) {
			responsableRespuestaImpl.setNombre_usuario(StringPool.BLANK);
		}
		else {
			responsableRespuestaImpl.setNombre_usuario(nombre_usuario);
		}

		responsableRespuestaImpl.setId_solicitud(id_solicitud);

		responsableRespuestaImpl.resetOriginalValues();

		return responsableRespuestaImpl;
	}

	public int id_responsable;
	public String respuesta;
	public long fecha_respuesta;
	public String nombre_usuario;
	public int id_solicitud;
}