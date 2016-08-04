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
public class EspecialidadSoap implements Serializable {
	public static EspecialidadSoap toSoapModel(Especialidad model) {
		EspecialidadSoap soapModel = new EspecialidadSoap();

		soapModel.setCodigo(model.getCodigo());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static EspecialidadSoap[] toSoapModels(Especialidad[] models) {
		EspecialidadSoap[] soapModels = new EspecialidadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EspecialidadSoap[][] toSoapModels(Especialidad[][] models) {
		EspecialidadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EspecialidadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EspecialidadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EspecialidadSoap[] toSoapModels(List<Especialidad> models) {
		List<EspecialidadSoap> soapModels = new ArrayList<EspecialidadSoap>(models.size());

		for (Especialidad model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EspecialidadSoap[soapModels.size()]);
	}

	public EspecialidadSoap() {
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