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
public class DelegadoSoap implements Serializable {
	public static DelegadoSoap toSoapModel(Delegado model) {
		DelegadoSoap soapModel = new DelegadoSoap();

		soapModel.setId_delegado(model.getId_delegado());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static DelegadoSoap[] toSoapModels(Delegado[] models) {
		DelegadoSoap[] soapModels = new DelegadoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DelegadoSoap[][] toSoapModels(Delegado[][] models) {
		DelegadoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DelegadoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DelegadoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DelegadoSoap[] toSoapModels(List<Delegado> models) {
		List<DelegadoSoap> soapModels = new ArrayList<DelegadoSoap>(models.size());

		for (Delegado model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DelegadoSoap[soapModels.size()]);
	}

	public DelegadoSoap() {
	}

	public int getPrimaryKey() {
		return _id_delegado;
	}

	public void setPrimaryKey(int pk) {
		setId_delegado(pk);
	}

	public int getId_delegado() {
		return _id_delegado;
	}

	public void setId_delegado(int id_delegado) {
		_id_delegado = id_delegado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _id_delegado;
	private String _nombre;
}