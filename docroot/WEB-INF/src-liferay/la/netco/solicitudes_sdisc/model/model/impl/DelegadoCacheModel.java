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

import la.netco.solicitudes_sdisc.model.model.Delegado;

import java.io.Serializable;

/**
 * The cache model class for representing Delegado in entity cache.
 *
 * @author smontanez
 * @see Delegado
 * @generated
 */
public class DelegadoCacheModel implements CacheModel<Delegado>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_delegado=");
		sb.append(id_delegado);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public Delegado toEntityModel() {
		DelegadoImpl delegadoImpl = new DelegadoImpl();

		delegadoImpl.setId_delegado(id_delegado);

		if (nombre == null) {
			delegadoImpl.setNombre(StringPool.BLANK);
		}
		else {
			delegadoImpl.setNombre(nombre);
		}

		delegadoImpl.resetOriginalValues();

		return delegadoImpl;
	}

	public int id_delegado;
	public String nombre;
}