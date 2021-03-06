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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the delegado local service. This utility wraps {@link la.netco.solicitudes_sdisc.model.service.impl.DelegadoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author smontanez
 * @see DelegadoLocalService
 * @see la.netco.solicitudes_sdisc.model.service.base.DelegadoLocalServiceBaseImpl
 * @see la.netco.solicitudes_sdisc.model.service.impl.DelegadoLocalServiceImpl
 * @generated
 */
public class DelegadoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link la.netco.solicitudes_sdisc.model.service.impl.DelegadoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the delegado to the database. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @return the delegado that was added
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado addDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDelegado(delegado);
	}

	/**
	* Creates a new delegado with the primary key. Does not add the delegado to the database.
	*
	* @param id_delegado the primary key for the new delegado
	* @return the new delegado
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado createDelegado(
		int id_delegado) {
		return getService().createDelegado(id_delegado);
	}

	/**
	* Deletes the delegado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado that was removed
	* @throws PortalException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado deleteDelegado(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDelegado(id_delegado);
	}

	/**
	* Deletes the delegado from the database. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @return the delegado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado deleteDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDelegado(delegado);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static la.netco.solicitudes_sdisc.model.model.Delegado fetchDelegado(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDelegado(id_delegado);
	}

	/**
	* Returns the delegado with the primary key.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado
	* @throws PortalException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado getDelegado(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDelegado(id_delegado);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> getDelegados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDelegados(start, end);
	}

	/**
	* Returns the number of delegados.
	*
	* @return the number of delegados
	* @throws SystemException if a system exception occurred
	*/
	public static int getDelegadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDelegadosCount();
	}

	/**
	* Updates the delegado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @return the delegado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado updateDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDelegado(delegado);
	}

	/**
	* Updates the delegado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param delegado the delegado
	* @param merge whether to merge the delegado with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the delegado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado updateDelegado(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDelegado(delegado, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static DelegadoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DelegadoLocalService.class.getName());

			if (invokableLocalService instanceof DelegadoLocalService) {
				_service = (DelegadoLocalService)invokableLocalService;
			}
			else {
				_service = new DelegadoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DelegadoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(DelegadoLocalService service) {
	}

	private static DelegadoLocalService _service;
}