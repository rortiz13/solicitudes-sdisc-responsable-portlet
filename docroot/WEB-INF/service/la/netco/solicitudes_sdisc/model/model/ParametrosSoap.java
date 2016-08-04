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
public class ParametrosSoap implements Serializable {
	public static ParametrosSoap toSoapModel(Parametros model) {
		ParametrosSoap soapModel = new ParametrosSoap();

		soapModel.setTiempo_proximo_caducar(model.getTiempo_proximo_caducar());
		soapModel.setTiempo_caducidad(model.getTiempo_caducidad());
		soapModel.setEmail_resposable(model.getEmail_resposable());
		soapModel.setMensaje_email(model.getMensaje_email());
		soapModel.setAsunto_email(model.getAsunto_email());
		soapModel.setId(model.getId());
		soapModel.setRepositoryId(model.getRepositoryId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setUserRepositoryId(model.getUserRepositoryId());

		return soapModel;
	}

	public static ParametrosSoap[] toSoapModels(Parametros[] models) {
		ParametrosSoap[] soapModels = new ParametrosSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParametrosSoap[][] toSoapModels(Parametros[][] models) {
		ParametrosSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParametrosSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParametrosSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParametrosSoap[] toSoapModels(List<Parametros> models) {
		List<ParametrosSoap> soapModels = new ArrayList<ParametrosSoap>(models.size());

		for (Parametros model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParametrosSoap[soapModels.size()]);
	}

	public ParametrosSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getTiempo_proximo_caducar() {
		return _tiempo_proximo_caducar;
	}

	public void setTiempo_proximo_caducar(int tiempo_proximo_caducar) {
		_tiempo_proximo_caducar = tiempo_proximo_caducar;
	}

	public int getTiempo_caducidad() {
		return _tiempo_caducidad;
	}

	public void setTiempo_caducidad(int tiempo_caducidad) {
		_tiempo_caducidad = tiempo_caducidad;
	}

	public String getEmail_resposable() {
		return _email_resposable;
	}

	public void setEmail_resposable(String email_resposable) {
		_email_resposable = email_resposable;
	}

	public String getMensaje_email() {
		return _mensaje_email;
	}

	public void setMensaje_email(String mensaje_email) {
		_mensaje_email = mensaje_email;
	}

	public String getAsunto_email() {
		return _asunto_email;
	}

	public void setAsunto_email(String asunto_email) {
		_asunto_email = asunto_email;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public long getUserRepositoryId() {
		return _userRepositoryId;
	}

	public void setUserRepositoryId(long userRepositoryId) {
		_userRepositoryId = userRepositoryId;
	}

	private int _tiempo_proximo_caducar;
	private int _tiempo_caducidad;
	private String _email_resposable;
	private String _mensaje_email;
	private String _asunto_email;
	private int _id;
	private long _repositoryId;
	private long _folderId;
	private long _userRepositoryId;
}