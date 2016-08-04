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

import la.netco.solicitudes_sdisc.model.model.Estado;

import java.io.Serializable;

/**
 * The cache model class for representing Estado in entity cache.
 *
 * @author smontanez
 * @see Estado
 * @generated
 */
public class EstadoCacheModel implements CacheModel<Estado>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_estado=");
		sb.append(id_estado);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public Estado toEntityModel() {
		EstadoImpl estadoImpl = new EstadoImpl();

		estadoImpl.setId_estado(id_estado);

		if (nombre == null) {
			estadoImpl.setNombre(StringPool.BLANK);
		}
		else {
			estadoImpl.setNombre(nombre);
		}

		estadoImpl.resetOriginalValues();

		return estadoImpl;
	}

	public int id_estado;
	public String nombre;
}