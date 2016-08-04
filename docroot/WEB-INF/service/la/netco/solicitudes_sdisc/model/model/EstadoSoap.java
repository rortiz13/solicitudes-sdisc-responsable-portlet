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
public class EstadoSoap implements Serializable {
	public static EstadoSoap toSoapModel(Estado model) {
		EstadoSoap soapModel = new EstadoSoap();

		soapModel.setId_estado(model.getId_estado());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static EstadoSoap[] toSoapModels(Estado[] models) {
		EstadoSoap[] soapModels = new EstadoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EstadoSoap[][] toSoapModels(Estado[][] models) {
		EstadoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EstadoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EstadoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EstadoSoap[] toSoapModels(List<Estado> models) {
		List<EstadoSoap> soapModels = new ArrayList<EstadoSoap>(models.size());

		for (Estado model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EstadoSoap[soapModels.size()]);
	}

	public EstadoSoap() {
	}

	public int getPrimaryKey() {
		return _id_estado;
	}

	public void setPrimaryKey(int pk) {
		setId_estado(pk);
	}

	public int getId_estado() {
		return _id_estado;
	}

	public void setId_estado(int id_estado) {
		_id_estado = id_estado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _id_estado;
	private String _nombre;
}