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

import la.netco.solicitudes_sdisc.model.model.Entidad;

import java.io.Serializable;

/**
 * The cache model class for representing Entidad in entity cache.
 *
 * @author smontanez
 * @see Entidad
 * @generated
 */
public class EntidadCacheModel implements CacheModel<Entidad>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{codigo=");
		sb.append(codigo);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public Entidad toEntityModel() {
		EntidadImpl entidadImpl = new EntidadImpl();

		if (codigo == null) {
			entidadImpl.setCodigo(StringPool.BLANK);
		}
		else {
			entidadImpl.setCodigo(codigo);
		}

		if (nombre == null) {
			entidadImpl.setNombre(StringPool.BLANK);
		}
		else {
			entidadImpl.setNombre(nombre);
		}

		entidadImpl.resetOriginalValues();

		return entidadImpl;
	}

	public String codigo;
	public String nombre;
}