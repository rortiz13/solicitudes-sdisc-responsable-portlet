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

package la.netco.solicitudes_sdisc.model.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    smontanez
 * @generated
 */
public class TipoDocumentoSoap implements Serializable {
	public static TipoDocumentoSoap toSoapModel(TipoDocumento model) {
		TipoDocumentoSoap soapModel = new TipoDocumentoSoap();

		soapModel.setId_tipo_doc(model.getId_tipo_doc());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static TipoDocumentoSoap[] toSoapModels(TipoDocumento[] models) {
		TipoDocumentoSoap[] soapModels = new TipoDocumentoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipoDocumentoSoap[][] toSoapModels(TipoDocumento[][] models) {
		TipoDocumentoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipoDocumentoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipoDocumentoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipoDocumentoSoap[] toSoapModels(List<TipoDocumento> models) {
		List<TipoDocumentoSoap> soapModels = new ArrayList<TipoDocumentoSoap>(models.size());

		for (TipoDocumento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipoDocumentoSoap[soapModels.size()]);
	}

	public TipoDocumentoSoap() {
	}

	public int getPrimaryKey() {
		return _id_tipo_doc;
	}

	public void setPrimaryKey(int pk) {
		setId_tipo_doc(pk);
	}

	public int getId_tipo_doc() {
		return _id_tipo_doc;
	}

	public void setId_tipo_doc(int id_tipo_doc) {
		_id_tipo_doc = id_tipo_doc;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _id_tipo_doc;
	private String _nombre;
}