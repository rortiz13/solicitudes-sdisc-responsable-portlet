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

import la.netco.solicitudes_sdisc.model.model.FechaNoHabil;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FechaNoHabil in entity cache.
 *
 * @author smontanez
 * @see FechaNoHabil
 * @generated
 */
public class FechaNoHabilCacheModel implements CacheModel<FechaNoHabil>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public FechaNoHabil toEntityModel() {
		FechaNoHabilImpl fechaNoHabilImpl = new FechaNoHabilImpl();

		fechaNoHabilImpl.setId(id);

		if (fecha == Long.MIN_VALUE) {
			fechaNoHabilImpl.setFecha(null);
		}
		else {
			fechaNoHabilImpl.setFecha(new Date(fecha));
		}

		if (nombre == null) {
			fechaNoHabilImpl.setNombre(StringPool.BLANK);
		}
		else {
			fechaNoHabilImpl.setNombre(nombre);
		}

		fechaNoHabilImpl.resetOriginalValues();

		return fechaNoHabilImpl;
	}

	public int id;
	public long fecha;
	public String nombre;
}