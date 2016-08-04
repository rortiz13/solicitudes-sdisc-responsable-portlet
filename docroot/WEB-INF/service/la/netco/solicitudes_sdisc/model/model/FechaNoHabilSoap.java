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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    smontanez
 * @generated
 */
public class FechaNoHabilSoap implements Serializable {
	public static FechaNoHabilSoap toSoapModel(FechaNoHabil model) {
		FechaNoHabilSoap soapModel = new FechaNoHabilSoap();

		soapModel.setId(model.getId());
		soapModel.setFecha(model.getFecha());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static FechaNoHabilSoap[] toSoapModels(FechaNoHabil[] models) {
		FechaNoHabilSoap[] soapModels = new FechaNoHabilSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FechaNoHabilSoap[][] toSoapModels(FechaNoHabil[][] models) {
		FechaNoHabilSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FechaNoHabilSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FechaNoHabilSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FechaNoHabilSoap[] toSoapModels(List<FechaNoHabil> models) {
		List<FechaNoHabilSoap> soapModels = new ArrayList<FechaNoHabilSoap>(models.size());

		for (FechaNoHabil model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FechaNoHabilSoap[soapModels.size()]);
	}

	public FechaNoHabilSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _id;
	private Date _fecha;
	private String _nombre;
}