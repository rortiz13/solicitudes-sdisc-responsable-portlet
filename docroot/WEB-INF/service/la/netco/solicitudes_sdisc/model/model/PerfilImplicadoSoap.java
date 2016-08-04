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
public class PerfilImplicadoSoap implements Serializable {
	public static PerfilImplicadoSoap toSoapModel(PerfilImplicado model) {
		PerfilImplicadoSoap soapModel = new PerfilImplicadoSoap();

		soapModel.setId_perfil(model.getId_perfil());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static PerfilImplicadoSoap[] toSoapModels(PerfilImplicado[] models) {
		PerfilImplicadoSoap[] soapModels = new PerfilImplicadoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PerfilImplicadoSoap[][] toSoapModels(
		PerfilImplicado[][] models) {
		PerfilImplicadoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PerfilImplicadoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PerfilImplicadoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PerfilImplicadoSoap[] toSoapModels(
		List<PerfilImplicado> models) {
		List<PerfilImplicadoSoap> soapModels = new ArrayList<PerfilImplicadoSoap>(models.size());

		for (PerfilImplicado model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PerfilImplicadoSoap[soapModels.size()]);
	}

	public PerfilImplicadoSoap() {
	}

	public int getPrimaryKey() {
		return _id_perfil;
	}

	public void setPrimaryKey(int pk) {
		setId_perfil(pk);
	}

	public int getId_perfil() {
		return _id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		_id_perfil = id_perfil;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _id_perfil;
	private String _nombre;
}