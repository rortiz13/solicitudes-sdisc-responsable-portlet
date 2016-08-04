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
public class SolicitudSoap implements Serializable {
	public static SolicitudSoap toSoapModel(Solicitud model) {
		SolicitudSoap soapModel = new SolicitudSoap();

		soapModel.setId_solicitud(model.getId_solicitud());
		soapModel.setHechos(model.getHechos());
		soapModel.setPruebas(model.getPruebas());
		soapModel.setId_estado(model.getId_estado());
		soapModel.setId_implicado(model.getId_implicado());
		soapModel.setId_solicitante(model.getId_solicitante());
		soapModel.setFechaRegistro(model.getFechaRegistro());

		return soapModel;
	}

	public static SolicitudSoap[] toSoapModels(Solicitud[] models) {
		SolicitudSoap[] soapModels = new SolicitudSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SolicitudSoap[][] toSoapModels(Solicitud[][] models) {
		SolicitudSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SolicitudSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SolicitudSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SolicitudSoap[] toSoapModels(List<Solicitud> models) {
		List<SolicitudSoap> soapModels = new ArrayList<SolicitudSoap>(models.size());

		for (Solicitud model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SolicitudSoap[soapModels.size()]);
	}

	public SolicitudSoap() {
	}

	public int getPrimaryKey() {
		return _id_solicitud;
	}

	public void setPrimaryKey(int pk) {
		setId_solicitud(pk);
	}

	public int getId_solicitud() {
		return _id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		_id_solicitud = id_solicitud;
	}

	public String getHechos() {
		return _hechos;
	}

	public void setHechos(String hechos) {
		_hechos = hechos;
	}

	public String getPruebas() {
		return _pruebas;
	}

	public void setPruebas(String pruebas) {
		_pruebas = pruebas;
	}

	public int getId_estado() {
		return _id_estado;
	}

	public void setId_estado(int id_estado) {
		_id_estado = id_estado;
	}

	public int getId_implicado() {
		return _id_implicado;
	}

	public void setId_implicado(int id_implicado) {
		_id_implicado = id_implicado;
	}

	public int getId_solicitante() {
		return _id_solicitante;
	}

	public void setId_solicitante(int id_solicitante) {
		_id_solicitante = id_solicitante;
	}

	public Date getFechaRegistro() {
		return _fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		_fechaRegistro = fechaRegistro;
	}

	private int _id_solicitud;
	private String _hechos;
	private String _pruebas;
	private int _id_estado;
	private int _id_implicado;
	private int _id_solicitante;
	private Date _fechaRegistro;
}