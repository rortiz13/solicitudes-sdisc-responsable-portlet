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

import la.netco.solicitudes_sdisc.model.model.Solicitante;

import java.io.Serializable;

/**
 * The cache model class for representing Solicitante in entity cache.
 *
 * @author smontanez
 * @see Solicitante
 * @generated
 */
public class SolicitanteCacheModel implements CacheModel<Solicitante>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id_solicitante=");
		sb.append(id_solicitante);
		sb.append(", nombres=");
		sb.append(nombres);
		sb.append(", apellidos=");
		sb.append(apellidos);
		sb.append(", num_documento=");
		sb.append(num_documento);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", email=");
		sb.append(email);
		sb.append(", direccion=");
		sb.append(direccion);
		sb.append(", id_tipo_doc=");
		sb.append(id_tipo_doc);
		sb.append(", id_ciudad=");
		sb.append(id_ciudad);
		sb.append("}");

		return sb.toString();
	}

	public Solicitante toEntityModel() {
		SolicitanteImpl solicitanteImpl = new SolicitanteImpl();

		solicitanteImpl.setId_solicitante(id_solicitante);

		if (nombres == null) {
			solicitanteImpl.setNombres(StringPool.BLANK);
		}
		else {
			solicitanteImpl.setNombres(nombres);
		}

		if (apellidos == null) {
			solicitanteImpl.setApellidos(StringPool.BLANK);
		}
		else {
			solicitanteImpl.setApellidos(apellidos);
		}

		if (num_documento == null) {
			solicitanteImpl.setNum_documento(StringPool.BLANK);
		}
		else {
			solicitanteImpl.setNum_documento(num_documento);
		}

		if (telefono == null) {
			solicitanteImpl.setTelefono(StringPool.BLANK);
		}
		else {
			solicitanteImpl.setTelefono(telefono);
		}

		if (email == null) {
			solicitanteImpl.setEmail(StringPool.BLANK);
		}
		else {
			solicitanteImpl.setEmail(email);
		}

		if (direccion == null) {
			solicitanteImpl.setDireccion(StringPool.BLANK);
		}
		else {
			solicitanteImpl.setDireccion(direccion);
		}

		solicitanteImpl.setId_tipo_doc(id_tipo_doc);
		solicitanteImpl.setId_ciudad(id_ciudad);

		solicitanteImpl.resetOriginalValues();

		return solicitanteImpl;
	}

	public int id_solicitante;
	public String nombres;
	public String apellidos;
	public String num_documento;
	public String telefono;
	public String email;
	public String direccion;
	public Integer id_tipo_doc;
	public Integer id_ciudad;
}