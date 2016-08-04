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

import la.netco.solicitudes_sdisc.model.model.Implicado;

import java.io.Serializable;

/**
 * The cache model class for representing Implicado in entity cache.
 *
 * @author smontanez
 * @see Implicado
 * @generated
 */
public class ImplicadoCacheModel implements CacheModel<Implicado>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id_implicado=");
		sb.append(id_implicado);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", despacho_entidad=");
		sb.append(despacho_entidad);
		sb.append(", id_perfil=");
		sb.append(id_perfil);
		sb.append(", id_ciudad=");
		sb.append(id_ciudad);
		sb.append(", cod_entidad=");
		sb.append(cod_entidad);
		sb.append(", cod_especialidad=");
		sb.append(cod_especialidad);
		sb.append(", id_delegado=");
		sb.append(id_delegado);
		sb.append("}");

		return sb.toString();
	}

	public Implicado toEntityModel() {
		ImplicadoImpl implicadoImpl = new ImplicadoImpl();

		implicadoImpl.setId_implicado(id_implicado);

		if (nombre == null) {
			implicadoImpl.setNombre(StringPool.BLANK);
		}
		else {
			implicadoImpl.setNombre(nombre);
		}

		if (despacho_entidad == null) {
			implicadoImpl.setDespacho_entidad(StringPool.BLANK);
		}
		else {
			implicadoImpl.setDespacho_entidad(despacho_entidad);
		}

		implicadoImpl.setId_perfil(id_perfil);
		implicadoImpl.setId_ciudad(id_ciudad);

		if (cod_entidad == null) {
			implicadoImpl.setCod_entidad(StringPool.BLANK);
		}
		else {
			implicadoImpl.setCod_entidad(cod_entidad);
		}

		if (cod_especialidad == null) {
			implicadoImpl.setCod_especialidad(StringPool.BLANK);
		}
		else {
			implicadoImpl.setCod_especialidad(cod_especialidad);
		}

		implicadoImpl.setId_delegado(id_delegado);

		implicadoImpl.resetOriginalValues();

		return implicadoImpl;
	}

	public int id_implicado;
	public String nombre;
	public String despacho_entidad;
	public int id_perfil;
	public Integer id_ciudad;
	public String cod_entidad;
	public String cod_especialidad;
	public Integer id_delegado;
}