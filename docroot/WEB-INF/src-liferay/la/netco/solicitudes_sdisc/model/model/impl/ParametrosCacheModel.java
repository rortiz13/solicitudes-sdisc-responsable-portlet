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

import la.netco.solicitudes_sdisc.model.model.Parametros;

import java.io.Serializable;

/**
 * The cache model class for representing Parametros in entity cache.
 *
 * @author smontanez
 * @see Parametros
 * @generated
 */
public class ParametrosCacheModel implements CacheModel<Parametros>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{tiempo_proximo_caducar=");
		sb.append(tiempo_proximo_caducar);
		sb.append(", tiempo_caducidad=");
		sb.append(tiempo_caducidad);
		sb.append(", email_resposable=");
		sb.append(email_resposable);
		sb.append(", mensaje_email=");
		sb.append(mensaje_email);
		sb.append(", asunto_email=");
		sb.append(asunto_email);
		sb.append(", id=");
		sb.append(id);
		sb.append(", repositoryId=");
		sb.append(repositoryId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", userRepositoryId=");
		sb.append(userRepositoryId);
		sb.append("}");

		return sb.toString();
	}

	public Parametros toEntityModel() {
		ParametrosImpl parametrosImpl = new ParametrosImpl();

		parametrosImpl.setTiempo_proximo_caducar(tiempo_proximo_caducar);
		parametrosImpl.setTiempo_caducidad(tiempo_caducidad);

		if (email_resposable == null) {
			parametrosImpl.setEmail_resposable(StringPool.BLANK);
		}
		else {
			parametrosImpl.setEmail_resposable(email_resposable);
		}

		if (mensaje_email == null) {
			parametrosImpl.setMensaje_email(StringPool.BLANK);
		}
		else {
			parametrosImpl.setMensaje_email(mensaje_email);
		}

		if (asunto_email == null) {
			parametrosImpl.setAsunto_email(StringPool.BLANK);
		}
		else {
			parametrosImpl.setAsunto_email(asunto_email);
		}

		parametrosImpl.setId(id);
		parametrosImpl.setRepositoryId(repositoryId);
		parametrosImpl.setFolderId(folderId);
		parametrosImpl.setUserRepositoryId(userRepositoryId);

		parametrosImpl.resetOriginalValues();

		return parametrosImpl;
	}

	public int tiempo_proximo_caducar;
	public int tiempo_caducidad;
	public String email_resposable;
	public String mensaje_email;
	public String asunto_email;
	public int id;
	public long repositoryId;
	public long folderId;
	public long userRepositoryId;
}