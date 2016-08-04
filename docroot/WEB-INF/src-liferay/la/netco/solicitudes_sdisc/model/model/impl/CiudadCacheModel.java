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

import la.netco.solicitudes_sdisc.model.model.Ciudad;

import java.io.Serializable;

/**
 * The cache model class for representing Ciudad in entity cache.
 *
 * @author smontanez
 * @see Ciudad
 * @generated
 */
public class CiudadCacheModel implements CacheModel<Ciudad>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_ciudad=");
		sb.append(id_ciudad);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", id_departamento=");
		sb.append(id_departamento);
		sb.append("}");

		return sb.toString();
	}

	public Ciudad toEntityModel() {
		CiudadImpl ciudadImpl = new CiudadImpl();

		ciudadImpl.setId_ciudad(id_ciudad);

		if (nombre == null) {
			ciudadImpl.setNombre(StringPool.BLANK);
		}
		else {
			ciudadImpl.setNombre(nombre);
		}

		ciudadImpl.setId_departamento(id_departamento);

		ciudadImpl.resetOriginalValues();

		return ciudadImpl;
	}

	public int id_ciudad;
	public String nombre;
	public int id_departamento;
}