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
 * This class is a wrapper for {@link DelegadoLocalService}.
 * </p>
 *
 * @author    smontanez
 * @see       DelegadoLocalService
 * @generated
 */
public class DelegadoLocalServiceWrapper implements DelegadoLocalService,
	ServiceWrapper<DelegadoLocalService> {
	public DelegadoLocalServiceWrapper(
		DelegadoLocalService delegadoLocalService) {
		_delegadoLocalService = delegadoLocalService;
	}

	/**
	* Adds the delegado to the database. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @return the delegado that was added
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado addDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.addDelegado(delegado);
	}

	/**
	* Creates a new delegado with the primary key. Does not add the delegado to the database.
	*
	* @param id_delegado the primary key for the new delegado
	* @return the new delegado
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado createDelegado(
		int id_delegado) {
		return _delegadoLocalService.createDelegado(id_delegado);
	}

	/**
	* Deletes the delegado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado that was removed
	* @throws PortalException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado deleteDelegado(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.deleteDelegado(id_delegado);
	}

	/**
	* Deletes the delegado from the database. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @return the delegado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado deleteDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.deleteDelegado(delegado);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _delegadoLocalService.dynamicQuery();
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
		return _delegadoLocalService.dynamicQuery(dynamicQuery);
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
		return _delegadoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _delegadoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _delegadoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public la.netco.solicitudes_sdisc.model.model.Delegado fetchDelegado(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.fetchDelegado(id_delegado);
	}

	/**
	* Returns the delegado with the primary key.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado
	* @throws PortalException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado getDelegado(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.getDelegado(id_delegado);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the delegados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of delegados
	* @param end the upper bound of the range of delegados (not inclusive)
	* @return the range of delegados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> getDelegados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.getDelegados(start, end);
	}

	/**
	* Returns the number of delegados.
	*
	* @return the number of delegados
	* @throws SystemException if a system exception occurred
	*/
	public int getDelegadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.getDelegadosCount();
	}

	/**
	* Updates the delegado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @return the delegado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado updateDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.updateDelegado(delegado);
	}

	/**
	* Updates the delegado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @param merge whether to merge the delegado with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the delegado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado updateDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _delegadoLocalService.updateDelegado(delegado, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _delegadoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_delegadoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _delegadoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DelegadoLocalService getWrappedDelegadoLocalService() {
		return _delegadoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDelegadoLocalService(
		DelegadoLocalService delegadoLocalService) {
		_delegadoLocalService = delegadoLocalService;
	}

	public DelegadoLocalService getWrappedService() {
		return _delegadoLocalService;
	}

	public void setWrappedService(DelegadoLocalService delegadoLocalService) {
		_delegadoLocalService = delegadoLocalService;
	}

	private DelegadoLocalService _delegadoLocalService;
}