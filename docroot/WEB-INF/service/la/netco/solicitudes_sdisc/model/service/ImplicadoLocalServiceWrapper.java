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
 * This class is a wrapper for {@link ImplicadoLocalService}.
 * </p>
 *
 * @author    smontanez
 * @see       ImplicadoLocalService
 * @generated
 */
public class ImplicadoLocalServiceWrapper implements ImplicadoLocalService,
	ServiceWrapper<ImplicadoLocalService> {
	public ImplicadoLocalServiceWrapper(
		ImplicadoLocalService implicadoLocalService) {
		_implicadoLocalService = implicadoLocalService;
	}

	/**
	* Adds the implicado to the database. Also notifies the appropriate model listeners.
	*
	* @param implicado the implicado
	* @return the implicado that was added
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado addImplicado(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.addImplicado(implicado);
	}

	/**
	* Creates a new implicado with the primary key. Does not add the implicado to the database.
	*
	* @param id_implicado the primary key for the new implicado
	* @return the new implicado
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado createImplicado(
		int id_implicado) {
		return _implicadoLocalService.createImplicado(id_implicado);
	}

	/**
	* Deletes the implicado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado that was removed
	* @throws PortalException if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado deleteImplicado(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.deleteImplicado(id_implicado);
	}

	/**
	* Deletes the implicado from the database. Also notifies the appropriate model listeners.
	*
	* @param implicado the implicado
	* @return the implicado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado deleteImplicado(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.deleteImplicado(implicado);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _implicadoLocalService.dynamicQuery();
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
		return _implicadoLocalService.dynamicQuery(dynamicQuery);
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
		return _implicadoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _implicadoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _implicadoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public la.netco.solicitudes_sdisc.model.model.Implicado fetchImplicado(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.fetchImplicado(id_implicado);
	}

	/**
	* Returns the implicado with the primary key.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado
	* @throws PortalException if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado getImplicado(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.getImplicado(id_implicado);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the implicados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of implicados
	* @param end the upper bound of the range of implicados (not inclusive)
	* @return the range of implicados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> getImplicados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.getImplicados(start, end);
	}

	/**
	* Returns the number of implicados.
	*
	* @return the number of implicados
	* @throws SystemException if a system exception occurred
	*/
	public int getImplicadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.getImplicadosCount();
	}

	/**
	* Updates the implicado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param implicado the implicado
	* @return the implicado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado updateImplicado(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.updateImplicado(implicado);
	}

	/**
	* Updates the implicado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param implicado the implicado
	* @param merge whether to merge the implicado with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the implicado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado updateImplicado(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _implicadoLocalService.updateImplicado(implicado, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _implicadoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_implicadoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _implicadoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ImplicadoLocalService getWrappedImplicadoLocalService() {
		return _implicadoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedImplicadoLocalService(
		ImplicadoLocalService implicadoLocalService) {
		_implicadoLocalService = implicadoLocalService;
	}

	public ImplicadoLocalService getWrappedService() {
		return _implicadoLocalService;
	}

	public void setWrappedService(ImplicadoLocalService implicadoLocalService) {
		_implicadoLocalService = implicadoLocalService;
	}

	private ImplicadoLocalService _implicadoLocalService;
}