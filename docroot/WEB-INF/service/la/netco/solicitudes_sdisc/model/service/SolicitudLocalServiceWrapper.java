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
 * This class is a wrapper for {@link SolicitudLocalService}.
 * </p>
 *
 * @author    smontanez
 * @see       SolicitudLocalService
 * @generated
 */
public class SolicitudLocalServiceWrapper implements SolicitudLocalService,
	ServiceWrapper<SolicitudLocalService> {
	public SolicitudLocalServiceWrapper(
		SolicitudLocalService solicitudLocalService) {
		_solicitudLocalService = solicitudLocalService;
	}

	/**
	* Adds the Solicitud to the database. Also notifies the appropriate model listeners.
	*
	* @param solicitud the Solicitud
	* @return the Solicitud that was added
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud addSolicitud(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.addSolicitud(solicitud);
	}

	/**
	* Creates a new Solicitud with the primary key. Does not add the Solicitud to the database.
	*
	* @param id_solicitud the primary key for the new Solicitud
	* @return the new Solicitud
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud createSolicitud(
		int id_solicitud) {
		return _solicitudLocalService.createSolicitud(id_solicitud);
	}

	/**
	* Deletes the Solicitud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud that was removed
	* @throws PortalException if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud deleteSolicitud(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.deleteSolicitud(id_solicitud);
	}

	/**
	* Deletes the Solicitud from the database. Also notifies the appropriate model listeners.
	*
	* @param solicitud the Solicitud
	* @return the Solicitud that was removed
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud deleteSolicitud(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.deleteSolicitud(solicitud);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _solicitudLocalService.dynamicQuery();
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
		return _solicitudLocalService.dynamicQuery(dynamicQuery);
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
		return _solicitudLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _solicitudLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _solicitudLocalService.dynamicQueryCount(dynamicQuery);
	}

	public la.netco.solicitudes_sdisc.model.model.Solicitud fetchSolicitud(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.fetchSolicitud(id_solicitud);
	}

	/**
	* Returns the Solicitud with the primary key.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud
	* @throws PortalException if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud getSolicitud(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.getSolicitud(id_solicitud);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Solicituds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Solicituds
	* @param end the upper bound of the range of Solicituds (not inclusive)
	* @return the range of Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> getSolicituds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.getSolicituds(start, end);
	}

	/**
	* Returns the number of Solicituds.
	*
	* @return the number of Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public int getSolicitudsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.getSolicitudsCount();
	}

	/**
	* Updates the Solicitud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param solicitud the Solicitud
	* @return the Solicitud that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud updateSolicitud(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.updateSolicitud(solicitud);
	}

	/**
	* Updates the Solicitud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param solicitud the Solicitud
	* @param merge whether to merge the Solicitud with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Solicitud that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud updateSolicitud(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.updateSolicitud(solicitud, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _solicitudLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_solicitudLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _solicitudLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findByFields(
		java.util.Date fechaIni, java.util.Date fechaFin,
		java.lang.Integer id_ciudad_solicitante, java.lang.Integer id_perfil,
		java.lang.Integer id_estado, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.findByFields(fechaIni, fechaFin,
			id_ciudad_solicitante, id_perfil, id_estado, begin, end);
	}

	public int countByFields(java.util.Date fechaIni, java.util.Date fechaFin,
		java.lang.Integer id_ciudad_solicitante, java.lang.Integer id_perfil,
		java.lang.Integer id_estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudLocalService.countByFields(fechaIni, fechaFin,
			id_ciudad_solicitante, id_perfil, id_estado);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SolicitudLocalService getWrappedSolicitudLocalService() {
		return _solicitudLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSolicitudLocalService(
		SolicitudLocalService solicitudLocalService) {
		_solicitudLocalService = solicitudLocalService;
	}

	public SolicitudLocalService getWrappedService() {
		return _solicitudLocalService;
	}

	public void setWrappedService(SolicitudLocalService solicitudLocalService) {
		_solicitudLocalService = solicitudLocalService;
	}

	private SolicitudLocalService _solicitudLocalService;
}