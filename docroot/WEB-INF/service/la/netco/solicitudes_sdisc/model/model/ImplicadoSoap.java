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
public class ImplicadoSoap implements Serializable {
	public static ImplicadoSoap toSoapModel(Implicado model) {
		ImplicadoSoap soapModel = new ImplicadoSoap();

		soapModel.setId_implicado(model.getId_implicado());
		soapModel.setNombre(model.getNombre());
		soapModel.setDespacho_entidad(model.getDespacho_entidad());
		soapModel.setId_perfil(model.getId_perfil());
		soapModel.setId_ciudad(model.getId_ciudad());
		soapModel.setCod_entidad(model.getCod_entidad());
		soapModel.setCod_especialidad(model.getCod_especialidad());
		soapModel.setId_delegado(model.getId_delegado());

		return soapModel;
	}

	public static ImplicadoSoap[] toSoapModels(Implicado[] models) {
		ImplicadoSoap[] soapModels = new ImplicadoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImplicadoSoap[][] toSoapModels(Implicado[][] models) {
		ImplicadoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImplicadoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImplicadoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImplicadoSoap[] toSoapModels(List<Implicado> models) {
		List<ImplicadoSoap> soapModels = new ArrayList<ImplicadoSoap>(models.size());

		for (Implicado model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImplicadoSoap[soapModels.size()]);
	}

	public ImplicadoSoap() {
	}

	public int getPrimaryKey() {
		return _id_implicado;
	}

	public void setPrimaryKey(int pk) {
		setId_implicado(pk);
	}

	public int getId_implicado() {
		return _id_implicado;
	}

	public void setId_implicado(int id_implicado) {
		_id_implicado = id_implicado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getDespacho_entidad() {
		return _despacho_entidad;
	}

	public void setDespacho_entidad(String despacho_entidad) {
		_despacho_entidad = despacho_entidad;
	}

	public int getId_perfil() {
		return _id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		_id_perfil = id_perfil;
	}

	public Integer getId_ciudad() {
		return _id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		_id_ciudad = id_ciudad;
	}

	public String getCod_entidad() {
		return _cod_entidad;
	}

	public void setCod_entidad(String cod_entidad) {
		_cod_entidad = cod_entidad;
	}

	public String getCod_especialidad() {
		return _cod_especialidad;
	}

	public void setCod_especialidad(String cod_especialidad) {
		_cod_especialidad = cod_especialidad;
	}

	public Integer getId_delegado() {
		return _id_delegado;
	}

	public void setId_delegado(Integer id_delegado) {
		_id_delegado = id_delegado;
	}

	private int _id_implicado;
	private String _nombre;
	private String _despacho_entidad;
	private int _id_perfil;
	private Integer _id_ciudad;
	private String _cod_entidad;
	private String _cod_especialidad;
	private Integer _id_delegado;
}