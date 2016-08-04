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

package la.netco.solicitudes_sdisc.model.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ResponsableRespuestaLocalService}.
 * </p>
 *
 * @author    smontanez
 * @see       ResponsableRespuestaLocalService
 * @generated
 */
public class ResponsableRespuestaLocalServiceWrapper
	implements ResponsableRespuestaLocalService,
		ServiceWrapper<ResponsableRespuestaLocalService> {
	public ResponsableRespuestaLocalServiceWrapper(
		ResponsableRespuestaLocalService responsableRespuestaLocalService) {
		_responsableRespuestaLocalService = responsableRespuestaLocalService;
	}

	/**
	* Adds the responsable respuesta to the database. Also notifies the appropriate model listeners.
	*
	* @param responsableRespuesta the responsable respuesta
	* @return the responsable respuesta that was added
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta addResponsableRespuesta(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.addResponsableRespuesta(responsableRespuesta);
	}

	/**
	* Creates a new responsable respuesta with the primary key. Does not add the responsable respuesta to the database.
	*
	* @param id_responsable the primary key for the new responsable respuesta
	* @return the new responsable respuesta
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta createResponsableRespuesta(
		int id_responsable) {
		return _responsableRespuestaLocalService.createResponsableRespuesta(id_responsable);
	}

	/**
	* Deletes the responsable respuesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta that was removed
	* @throws PortalException if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta deleteResponsableRespuesta(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.deleteResponsableRespuesta(id_responsable);
	}

	/**
	* Deletes the responsable respuesta from the database. Also notifies the appropriate model listeners.
	*
	* @param responsableRespuesta the responsable respuesta
	* @return the responsable respuesta that was removed
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta deleteResponsableRespuesta(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.deleteResponsableRespuesta(responsableRespuesta);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _responsableRespuestaLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta fetchResponsableRespuesta(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.fetchResponsableRespuesta(id_responsable);
	}

	/**
	* Returns the responsable respuesta with the primary key.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta
	* @throws PortalException if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta getResponsableRespuesta(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.getResponsableRespuesta(id_responsable);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the responsable respuestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of responsable respuestas
	* @param end the upper bound of the range of responsable respuestas (not inclusive)
	* @return the range of responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> getResponsableRespuestas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.getResponsableRespuestas(start,
			end);
	}

	/**
	* Returns the number of responsable respuestas.
	*
	* @return the number of responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public int getResponsableRespuestasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.getResponsableRespuestasCount();
	}

	/**
	* Updates the responsable respuesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param responsableRespuesta the responsable respuesta
	* @return the responsable respuesta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta updateResponsableRespuesta(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.updateResponsableRespuesta(responsableRespuesta);
	}

	/**
	* Updates the responsable respuesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param responsableRespuesta the responsable respuesta
	* @param merge whether to merge the responsable respuesta with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the responsable respuesta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta updateResponsableRespuesta(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _responsableRespuestaLocalService.updateResponsableRespuesta(responsableRespuesta,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _responsableRespuestaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_responsableRespuestaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _responsableRespuestaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ResponsableRespuestaLocalService getWrappedResponsableRespuestaLocalService() {
		return _responsableRespuestaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedResponsableRespuestaLocalService(
		ResponsableRespuestaLocalService responsableRespuestaLocalService) {
		_responsableRespuestaLocalService = responsableRespuestaLocalService;
	}

	public ResponsableRespuestaLocalService getWrappedService() {
		return _responsableRespuestaLocalService;
	}

	public void setWrappedService(
		ResponsableRespuestaLocalService responsableRespuestaLocalService) {
		_responsableRespuestaLocalService = responsableRespuestaLocalService;
	}

	private ResponsableRespuestaLocalService _responsableRespuestaLocalService;
}