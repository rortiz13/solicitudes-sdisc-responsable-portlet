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
public class SolicitanteSoap implements Serializable {
	public static SolicitanteSoap toSoapModel(Solicitante model) {
		SolicitanteSoap soapModel = new SolicitanteSoap();

		soapModel.setId_solicitante(model.getId_solicitante());
		soapModel.setNombres(model.getNombres());
		soapModel.setApellidos(model.getApellidos());
		soapModel.setNum_documento(model.getNum_documento());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setEmail(model.getEmail());
		soapModel.setDireccion(model.getDireccion());
		soapModel.setId_tipo_doc(model.getId_tipo_doc());
		soapModel.setId_ciudad(model.getId_ciudad());

		return soapModel;
	}

	public static SolicitanteSoap[] toSoapModels(Solicitante[] models) {
		SolicitanteSoap[] soapModels = new SolicitanteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SolicitanteSoap[][] toSoapModels(Solicitante[][] models) {
		SolicitanteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SolicitanteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SolicitanteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SolicitanteSoap[] toSoapModels(List<Solicitante> models) {
		List<SolicitanteSoap> soapModels = new ArrayList<SolicitanteSoap>(models.size());

		for (Solicitante model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SolicitanteSoap[soapModels.size()]);
	}

	public SolicitanteSoap() {
	}

	public int getPrimaryKey() {
		return _id_solicitante;
	}

	public void setPrimaryKey(int pk) {
		setId_solicitante(pk);
	}

	public int getId_solicitante() {
		return _id_solicitante;
	}

	public void setId_solicitante(int id_solicitante) {
		_id_solicitante = id_solicitante;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getNum_documento() {
		return _num_documento;
	}

	public void setNum_documento(String num_documento) {
		_num_documento = num_documento;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public Integer getId_tipo_doc() {
		return _id_tipo_doc;
	}

	public void setId_tipo_doc(Integer id_tipo_doc) {
		_id_tipo_doc = id_tipo_doc;
	}

	public Integer getId_ciudad() {
		return _id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		_id_ciudad = id_ciudad;
	}

	private int _id_solicitante;
	private String _nombres;
	private String _apellidos;
	private String _num_documento;
	private String _telefono;
	private String _email;
	private String _direccion;
	private Integer _id_tipo_doc;
	private Integer _id_ciudad;
}