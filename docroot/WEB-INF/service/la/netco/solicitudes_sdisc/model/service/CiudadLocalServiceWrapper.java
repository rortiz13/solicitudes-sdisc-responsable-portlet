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
 * This class is a wrapper for {@link CiudadLocalService}.
 * </p>
 *
 * @author    smontanez
 * @see       CiudadLocalService
 * @generated
 */
public class CiudadLocalServiceWrapper implements CiudadLocalService,
	ServiceWrapper<CiudadLocalService> {
	public CiudadLocalServiceWrapper(CiudadLocalService ciudadLocalService) {
		_ciudadLocalService = ciudadLocalService;
	}

	/**
	* Adds the ciudad to the database. Also notifies the appropriate model listeners.
	*
	* @param ciudad the ciudad
	* @return the ciudad that was added
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad addCiudad(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.addCiudad(ciudad);
	}

	/**
	* Creates a new ciudad with the primary key. Does not add the ciudad to the database.
	*
	* @param id_ciudad the primary key for the new ciudad
	* @return the new ciudad
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad createCiudad(
		int id_ciudad) {
		return _ciudadLocalService.createCiudad(id_ciudad);
	}

	/**
	* Deletes the ciudad with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad that was removed
	* @throws PortalException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad deleteCiudad(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.deleteCiudad(id_ciudad);
	}

	/**
	* Deletes the ciudad from the database. Also notifies the appropriate model listeners.
	*
	* @param ciudad the ciudad
	* @return the ciudad that was removed
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad deleteCiudad(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.deleteCiudad(ciudad);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ciudadLocalService.dynamicQuery();
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
		return _ciudadLocalService.dynamicQuery(dynamicQuery);
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
		return _ciudadLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _ciudadLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ciudadLocalService.dynamicQueryCount(dynamicQuery);
	}

	public la.netco.solicitudes_sdisc.model.model.Ciudad fetchCiudad(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.fetchCiudad(id_ciudad);
	}

	/**
	* Returns the ciudad with the primary key.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad
	* @throws PortalException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad getCiudad(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.getCiudad(id_ciudad);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ciudads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ciudads
	* @param end the upper bound of the range of ciudads (not inclusive)
	* @return the range of ciudads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> getCiudads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.getCiudads(start, end);
	}

	/**
	* Returns the number of ciudads.
	*
	* @return the number of ciudads
	* @throws SystemException if a system exception occurred
	*/
	public int getCiudadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.getCiudadsCount();
	}

	/**
	* Updates the ciudad in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ciudad the ciudad
	* @return the ciudad that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad updateCiudad(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.updateCiudad(ciudad);
	}

	/**
	* Updates the ciudad in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ciudad the ciudad
	* @param merge whether to merge the ciudad with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ciudad that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad updateCiudad(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ciudadLocalService.updateCiudad(ciudad, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ciudadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ciudadLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ciudadLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException {
		return _ciudadLocalService.findBydepartamento(id_departamento);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CiudadLocalService getWrappedCiudadLocalService() {
		return _ciudadLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCiudadLocalService(
		CiudadLocalService ciudadLocalService) {
		_ciudadLocalService = ciudadLocalService;
	}

	public CiudadLocalService getWrappedService() {
		return _ciudadLocalService;
	}

	public void setWrappedService(CiudadLocalService ciudadLocalService) {
		_ciudadLocalService = ciudadLocalService;
	}

	private CiudadLocalService _ciudadLocalService;
}