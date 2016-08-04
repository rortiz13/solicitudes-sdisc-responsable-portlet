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
public class EntidadSoap implements Serializable {
	public static EntidadSoap toSoapModel(Entidad model) {
		EntidadSoap soapModel = new EntidadSoap();

		soapModel.setCodigo(model.getCodigo());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static EntidadSoap[] toSoapModels(Entidad[] models) {
		EntidadSoap[] soapModels = new EntidadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntidadSoap[][] toSoapModels(Entidad[][] models) {
		EntidadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EntidadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntidadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntidadSoap[] toSoapModels(List<Entidad> models) {
		List<EntidadSoap> soapModels = new ArrayList<EntidadSoap>(models.size());

		for (Entidad model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntidadSoap[soapModels.size()]);
	}

	public EntidadSoap() {
	}

	public String getPrimaryKey() {
		return _codigo;
	}

	public void setPrimaryKey(String pk) {
		setCodigo(pk);
	}

	public String getCodigo() {
		return _codigo;
	}

	public void setCodigo(String codigo) {
		_codigo = codigo;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private String _codigo;
	private String _nombre;
}