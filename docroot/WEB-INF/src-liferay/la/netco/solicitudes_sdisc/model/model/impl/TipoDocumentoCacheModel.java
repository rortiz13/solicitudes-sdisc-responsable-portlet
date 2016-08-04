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

import la.netco.solicitudes_sdisc.model.model.TipoDocumento;

import java.io.Serializable;

/**
 * The cache model class for representing TipoDocumento in entity cache.
 *
 * @author smontanez
 * @see TipoDocumento
 * @generated
 */
public class TipoDocumentoCacheModel implements CacheModel<TipoDocumento>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_tipo_doc=");
		sb.append(id_tipo_doc);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public TipoDocumento toEntityModel() {
		TipoDocumentoImpl tipoDocumentoImpl = new TipoDocumentoImpl();

		tipoDocumentoImpl.setId_tipo_doc(id_tipo_doc);

		if (nombre == null) {
			tipoDocumentoImpl.setNombre(StringPool.BLANK);
		}
		else {
			tipoDocumentoImpl.setNombre(nombre);
		}

		tipoDocumentoImpl.resetOriginalValues();

		return tipoDocumentoImpl;
	}

	public int id_tipo_doc;
	public String nombre;
}