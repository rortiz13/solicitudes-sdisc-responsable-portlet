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

import la.netco.solicitudes_sdisc.model.model.Solicitud;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Solicitud in entity cache.
 *
 * @author smontanez
 * @see Solicitud
 * @generated
 */
public class SolicitudCacheModel implements CacheModel<Solicitud>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_solicitud=");
		sb.append(id_solicitud);
		sb.append(", hechos=");
		sb.append(hechos);
		sb.append(", pruebas=");
		sb.append(pruebas);
		sb.append(", id_estado=");
		sb.append(id_estado);
		sb.append(", id_implicado=");
		sb.append(id_implicado);
		sb.append(", id_solicitante=");
		sb.append(id_solicitante);
		sb.append(", fechaRegistro=");
		sb.append(fechaRegistro);
		sb.append("}");

		return sb.toString();
	}

	public Solicitud toEntityModel() {
		SolicitudImpl solicitudImpl = new SolicitudImpl();

		solicitudImpl.setId_solicitud(id_solicitud);

		if (hechos == null) {
			solicitudImpl.setHechos(StringPool.BLANK);
		}
		else {
			solicitudImpl.setHechos(hechos);
		}

		if (pruebas == null) {
			solicitudImpl.setPruebas(StringPool.BLANK);
		}
		else {
			solicitudImpl.setPruebas(pruebas);
		}

		solicitudImpl.setId_estado(id_estado);
		solicitudImpl.setId_implicado(id_implicado);
		solicitudImpl.setId_solicitante(id_solicitante);

		if (fechaRegistro == Long.MIN_VALUE) {
			solicitudImpl.setFechaRegistro(null);
		}
		else {
			solicitudImpl.setFechaRegistro(new Date(fechaRegistro));
		}

		solicitudImpl.resetOriginalValues();

		return solicitudImpl;
	}

	public int id_solicitud;
	public String hechos;
	public String pruebas;
	public int id_estado;
	public int id_implicado;
	public int id_solicitante;
	public long fechaRegistro;
}