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

import la.netco.solicitudes_sdisc.model.model.PerfilImplicado;

import java.io.Serializable;

/**
 * The cache model class for representing PerfilImplicado in entity cache.
 *
 * @author smontanez
 * @see PerfilImplicado
 * @generated
 */
public class PerfilImplicadoCacheModel implements CacheModel<PerfilImplicado>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_perfil=");
		sb.append(id_perfil);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public PerfilImplicado toEntityModel() {
		PerfilImplicadoImpl perfilImplicadoImpl = new PerfilImplicadoImpl();

		perfilImplicadoImpl.setId_perfil(id_perfil);

		if (nombre == null) {
			perfilImplicadoImpl.setNombre(StringPool.BLANK);
		}
		else {
			perfilImplicadoImpl.setNombre(nombre);
		}

		perfilImplicadoImpl.resetOriginalValues();

		return perfilImplicadoImpl;
	}

	public int id_perfil;
	public String nombre;
}