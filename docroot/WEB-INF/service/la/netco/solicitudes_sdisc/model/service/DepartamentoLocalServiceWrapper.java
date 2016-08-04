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
 * This class is a wrapper for {@link DepartamentoLocalService}.
 * </p>
 *
 * @author    smontanez
 * @see       DepartamentoLocalService
 * @generated
 */
public class DepartamentoLocalServiceWrapper implements DepartamentoLocalService,
	ServiceWrapper<DepartamentoLocalService> {
	public DepartamentoLocalServiceWrapper(
		DepartamentoLocalService departamentoLocalService) {
		_departamentoLocalService = departamentoLocalService;
	}

	/**
	* Adds the departamento to the database. Also notifies the appropriate model listeners.
	*
	* @param departamento the departamento
	* @return the departamento that was added
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento addDepartamento(
		la.netco.solicitudes_sdisc.model.model.Departamento departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.addDepartamento(departamento);
	}

	/**
	* Creates a new departamento with the primary key. Does not add the departamento to the database.
	*
	* @param id_departamento the primary key for the new departamento
	* @return the new departamento
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento createDepartamento(
		int id_departamento) {
		return _departamentoLocalService.createDepartamento(id_departamento);
	}

	/**
	* Deletes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_departamento the primary key of the departamento
	* @return the departamento that was removed
	* @throws PortalException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento deleteDepartamento(
		int id_departamento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.deleteDepartamento(id_departamento);
	}

	/**
	* Deletes the departamento from the database. Also notifies the appropriate model listeners.
	*
	* @param departamento the departamento
	* @return the departamento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento deleteDepartamento(
		la.netco.solicitudes_sdisc.model.model.Departamento departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.deleteDepartamento(departamento);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _departamentoLocalService.dynamicQuery();
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
		return _departamentoLocalService.dynamicQuery(dynamicQuery);
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
		return _departamentoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _departamentoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _departamentoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public la.netco.solicitudes_sdisc.model.model.Departamento fetchDepartamento(
		int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.fetchDepartamento(id_departamento);
	}

	/**
	* Returns the departamento with the primary key.
	*
	* @param id_departamento the primary key of the departamento
	* @return the departamento
	* @throws PortalException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento getDepartamento(
		int id_departamento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.getDepartamento(id_departamento);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the departamentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departamentos
	* @param end the upper bound of the range of departamentos (not inclusive)
	* @return the range of departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Departamento> getDepartamentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.getDepartamentos(start, end);
	}

	/**
	* Returns the number of departamentos.
	*
	* @return the number of departamentos
	* @throws SystemException if a system exception occurred
	*/
	public int getDepartamentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.getDepartamentosCount();
	}

	/**
	* Updates the departamento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param departamento the departamento
	* @return the departamento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento updateDepartamento(
		la.netco.solicitudes_sdisc.model.model.Departamento departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.updateDepartamento(departamento);
	}

	/**
	* Updates the departamento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param departamento the departamento
	* @param merge whether to merge the departamento with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the departamento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Departamento updateDepartamento(
		la.netco.solicitudes_sdisc.model.model.Departamento departamento,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departamentoLocalService.updateDepartamento(departamento, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _departamentoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_departamentoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _departamentoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DepartamentoLocalService getWrappedDepartamentoLocalService() {
		return _departamentoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDepartamentoLocalService(
		DepartamentoLocalService departamentoLocalService) {
		_departamentoLocalService = departamentoLocalService;
	}

	public DepartamentoLocalService getWrappedService() {
		return _departamentoLocalService;
	}

	public void setWrappedService(
		DepartamentoLocalService departamentoLocalService) {
		_departamentoLocalService = departamentoLocalService;
	}

	private DepartamentoLocalService _departamentoLocalService;
}