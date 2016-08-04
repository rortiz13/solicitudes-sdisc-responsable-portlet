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
public class ResponsableRespuestaSoap implements Serializable {
	public static ResponsableRespuestaSoap toSoapModel(
		ResponsableRespuesta model) {
		ResponsableRespuestaSoap soapModel = new ResponsableRespuestaSoap();

		soapModel.setId_responsable(model.getId_responsable());
		soapModel.setRespuesta(model.getRespuesta());
		soapModel.setFecha_respuesta(model.getFecha_respuesta());
		soapModel.setNombre_usuario(model.getNombre_usuario());
		soapModel.setId_solicitud(model.getId_solicitud());

		return soapModel;
	}

	public static ResponsableRespuestaSoap[] toSoapModels(
		ResponsableRespuesta[] models) {
		ResponsableRespuestaSoap[] soapModels = new ResponsableRespuestaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResponsableRespuestaSoap[][] toSoapModels(
		ResponsableRespuesta[][] models) {
		ResponsableRespuestaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResponsableRespuestaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResponsableRespuestaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResponsableRespuestaSoap[] toSoapModels(
		List<ResponsableRespuesta> models) {
		List<ResponsableRespuestaSoap> soapModels = new ArrayList<ResponsableRespuestaSoap>(models.size());

		for (ResponsableRespuesta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResponsableRespuestaSoap[soapModels.size()]);
	}

	public ResponsableRespuestaSoap() {
	}

	public int getPrimaryKey() {
		return _id_responsable;
	}

	public void setPrimaryKey(int pk) {
		setId_responsable(pk);
	}

	public int getId_responsable() {
		return _id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		_id_responsable = id_responsable;
	}

	public String getRespuesta() {
		return _respuesta;
	}

	public void setRespuesta(String respuesta) {
		_respuesta = respuesta;
	}

	public Date getFecha_respuesta() {
		return _fecha_respuesta;
	}

	public void setFecha_respuesta(Date fecha_respuesta) {
		_fecha_respuesta = fecha_respuesta;
	}

	public String getNombre_usuario() {
		return _nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		_nombre_usuario = nombre_usuario;
	}

	public int getId_solicitud() {
		return _id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		_id_solicitud = id_solicitud;
	}

	private int _id_responsable;
	private String _respuesta;
	private Date _fecha_respuesta;
	private String _nombre_usuario;
	private int _id_solicitud;
}