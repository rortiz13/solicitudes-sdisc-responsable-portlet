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
public class CiudadSoap implements Serializable {
	public static CiudadSoap toSoapModel(Ciudad model) {
		CiudadSoap soapModel = new CiudadSoap();

		soapModel.setId_ciudad(model.getId_ciudad());
		soapModel.setNombre(model.getNombre());
		soapModel.setId_departamento(model.getId_departamento());

		return soapModel;
	}

	public static CiudadSoap[] toSoapModels(Ciudad[] models) {
		CiudadSoap[] soapModels = new CiudadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CiudadSoap[][] toSoapModels(Ciudad[][] models) {
		CiudadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CiudadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CiudadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CiudadSoap[] toSoapModels(List<Ciudad> models) {
		List<CiudadSoap> soapModels = new ArrayList<CiudadSoap>(models.size());

		for (Ciudad model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CiudadSoap[soapModels.size()]);
	}

	public CiudadSoap() {
	}

	public int getPrimaryKey() {
		return _id_ciudad;
	}

	public void setPrimaryKey(int pk) {
		setId_ciudad(pk);
	}

	public int getId_ciudad() {
		return _id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		_id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public int getId_departamento() {
		return _id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		_id_departamento = id_departamento;
	}

	private int _id_ciudad;
	private String _nombre;
	private int _id_departamento;
}