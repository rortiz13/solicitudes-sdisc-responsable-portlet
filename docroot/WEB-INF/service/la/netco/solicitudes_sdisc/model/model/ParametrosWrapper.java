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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Parametros}.
 * </p>
 *
 * @author    smontanez
 * @see       Parametros
 * @generated
 */
public class ParametrosWrapper implements Parametros, ModelWrapper<Parametros> {
	public ParametrosWrapper(Parametros parametros) {
		_parametros = parametros;
	}

	public Class<?> getModelClass() {
		return Parametros.class;
	}

	public String getModelClassName() {
		return Parametros.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tiempo_proximo_caducar", getTiempo_proximo_caducar());
		attributes.put("tiempo_caducidad", getTiempo_caducidad());
		attributes.put("email_resposable", getEmail_resposable());
		attributes.put("mensaje_email", getMensaje_email());
		attributes.put("asunto_email", getAsunto_email());
		attributes.put("id", getId());
		attributes.put("repositoryId", getRepositoryId());
		attributes.put("folderId", getFolderId());
		attributes.put("userRepositoryId", getUserRepositoryId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer tiempo_proximo_caducar = (Integer)attributes.get(
				"tiempo_proximo_caducar");

		if (tiempo_proximo_caducar != null) {
			setTiempo_proximo_caducar(tiempo_proximo_caducar);
		}

		Integer tiempo_caducidad = (Integer)attributes.get("tiempo_caducidad");

		if (tiempo_caducidad != null) {
			setTiempo_caducidad(tiempo_caducidad);
		}

		String email_resposable = (String)attributes.get("email_resposable");

		if (email_resposable != null) {
			setEmail_resposable(email_resposable);
		}

		String mensaje_email = (String)attributes.get("mensaje_email");

		if (mensaje_email != null) {
			setMensaje_email(mensaje_email);
		}

		String asunto_email = (String)attributes.get("asunto_email");

		if (asunto_email != null) {
			setAsunto_email(asunto_email);
		}

		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		Long userRepositoryId = (Long)attributes.get("userRepositoryId");

		if (userRepositoryId != null) {
			setUserRepositoryId(userRepositoryId);
		}
	}

	/**
	* Returns the primary key of this parametros.
	*
	* @return the primary key of this parametros
	*/
	public int getPrimaryKey() {
		return _parametros.getPrimaryKey();
	}

	/**
	* Sets the primary key of this parametros.
	*
	* @param primaryKey the primary key of this parametros
	*/
	public void setPrimaryKey(int primaryKey) {
		_parametros.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tiempo_proximo_caducar of this parametros.
	*
	* @return the tiempo_proximo_caducar of this parametros
	*/
	public int getTiempo_proximo_caducar() {
		return _parametros.getTiempo_proximo_caducar();
	}

	/**
	* Sets the tiempo_proximo_caducar of this parametros.
	*
	* @param tiempo_proximo_caducar the tiempo_proximo_caducar of this parametros
	*/
	public void setTiempo_proximo_caducar(int tiempo_proximo_caducar) {
		_parametros.setTiempo_proximo_caducar(tiempo_proximo_caducar);
	}

	/**
	* Returns the tiempo_caducidad of this parametros.
	*
	* @return the tiempo_caducidad of this parametros
	*/
	public int getTiempo_caducidad() {
		return _parametros.getTiempo_caducidad();
	}

	/**
	* Sets the tiempo_caducidad of this parametros.
	*
	* @param tiempo_caducidad the tiempo_caducidad of this parametros
	*/
	public void setTiempo_caducidad(int tiempo_caducidad) {
		_parametros.setTiempo_caducidad(tiempo_caducidad);
	}

	/**
	* Returns the email_resposable of this parametros.
	*
	* @return the email_resposable of this parametros
	*/
	public java.lang.String getEmail_resposable() {
		return _parametros.getEmail_resposable();
	}

	/**
	* Sets the email_resposable of this parametros.
	*
	* @param email_resposable the email_resposable of this parametros
	*/
	public void setEmail_resposable(java.lang.String email_resposable) {
		_parametros.setEmail_resposable(email_resposable);
	}

	/**
	* Returns the mensaje_email of this parametros.
	*
	* @return the mensaje_email of this parametros
	*/
	public java.lang.String getMensaje_email() {
		return _parametros.getMensaje_email();
	}

	/**
	* Sets the mensaje_email of this parametros.
	*
	* @param mensaje_email the mensaje_email of this parametros
	*/
	public void setMensaje_email(java.lang.String mensaje_email) {
		_parametros.setMensaje_email(mensaje_email);
	}

	/**
	* Returns the asunto_email of this parametros.
	*
	* @return the asunto_email of this parametros
	*/
	public java.lang.String getAsunto_email() {
		return _parametros.getAsunto_email();
	}

	/**
	* Sets the asunto_email of this parametros.
	*
	* @param asunto_email the asunto_email of this parametros
	*/
	public void setAsunto_email(java.lang.String asunto_email) {
		_parametros.setAsunto_email(asunto_email);
	}

	/**
	* Returns the ID of this parametros.
	*
	* @return the ID of this parametros
	*/
	public int getId() {
		return _parametros.getId();
	}

	/**
	* Sets the ID of this parametros.
	*
	* @param id the ID of this parametros
	*/
	public void setId(int id) {
		_parametros.setId(id);
	}

	/**
	* Returns the repository ID of this parametros.
	*
	* @return the repository ID of this parametros
	*/
	public long getRepositoryId() {
		return _parametros.getRepositoryId();
	}

	/**
	* Sets the repository ID of this parametros.
	*
	* @param repositoryId the repository ID of this parametros
	*/
	public void setRepositoryId(long repositoryId) {
		_parametros.setRepositoryId(repositoryId);
	}

	/**
	* Returns the folder ID of this parametros.
	*
	* @return the folder ID of this parametros
	*/
	public long getFolderId() {
		return _parametros.getFolderId();
	}

	/**
	* Sets the folder ID of this parametros.
	*
	* @param folderId the folder ID of this parametros
	*/
	public void setFolderId(long folderId) {
		_parametros.setFolderId(folderId);
	}

	/**
	* Returns the user repository ID of this parametros.
	*
	* @return the user repository ID of this parametros
	*/
	public long getUserRepositoryId() {
		return _parametros.getUserRepositoryId();
	}

	/**
	* Sets the user repository ID of this parametros.
	*
	* @param userRepositoryId the user repository ID of this parametros
	*/
	public void setUserRepositoryId(long userRepositoryId) {
		_parametros.setUserRepositoryId(userRepositoryId);
	}

	public boolean isNew() {
		return _parametros.isNew();
	}

	public void setNew(boolean n) {
		_parametros.setNew(n);
	}

	public boolean isCachedModel() {
		return _parametros.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_parametros.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _parametros.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _parametros.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_parametros.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _parametros.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_parametros.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ParametrosWrapper((Parametros)_parametros.clone());
	}

	public int compareTo(
		la.netco.solicitudes_sdisc.model.model.Parametros parametros) {
		return _parametros.compareTo(parametros);
	}

	@Override
	public int hashCode() {
		return _parametros.hashCode();
	}

	public com.liferay.portal.model.CacheModel<la.netco.solicitudes_sdisc.model.model.Parametros> toCacheModel() {
		return _parametros.toCacheModel();
	}

	public la.netco.solicitudes_sdisc.model.model.Parametros toEscapedModel() {
		return new ParametrosWrapper(_parametros.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _parametros.toString();
	}

	public java.lang.String toXmlString() {
		return _parametros.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_parametros.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Parametros getWrappedParametros() {
		return _parametros;
	}

	public Parametros getWrappedModel() {
		return _parametros;
	}

	public void resetOriginalValues() {
		_parametros.resetOriginalValues();
	}

	private Parametros _parametros;
}