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
 * The utility for the estado local service. This utility wraps {@link la.netco.solicitudes_sdisc.model.service.impl.EstadoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author smontanez
 * @see EstadoLocalService
 * @see la.netco.solicitudes_sdisc.model.service.base.EstadoLocalServiceBaseImpl
 * @see la.netco.solicitudes_sdisc.model.service.impl.EstadoLocalServiceImpl
 * @generated
 */
public class EstadoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link la.netco.solicitudes_sdisc.model.service.impl.EstadoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the estado to the database. Also notifies the appropriate model listeners.
	*
	* @param estado the estado
	* @return the estado that was added
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado addEstado(
		la.netco.solicitudes_sdisc.model.model.Estado estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEstado(estado);
	}

	/**
	* Creates a new estado with the primary key. Does not add the estado to the database.
	*
	* @param id_estado the primary key for the new estado
	* @return the new estado
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado createEstado(
		int id_estado) {
		return getService().createEstado(id_estado);
	}

	/**
	* Deletes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_estado the primary key of the estado
	* @return the estado that was removed
	* @throws PortalException if a estado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado deleteEstado(
		int id_estado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEstado(id_estado);
	}

	/**
	* Deletes the estado from the database. Also notifies the appropriate model listeners.
	*
	* @param estado the estado
	* @return the estado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado deleteEstado(
		la.netco.solicitudes_sdisc.model.model.Estado estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEstado(estado);
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

	public static la.netco.solicitudes_sdisc.model.model.Estado fetchEstado(
		int id_estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEstado(id_estado);
	}

	/**
	* Returns the estado with the primary key.
	*
	* @param id_estado the primary key of the estado
	* @return the estado
	* @throws PortalException if a estado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado getEstado(
		int id_estado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEstado(id_estado);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the estados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of estados
	* @param end the upper bound of the range of estados (not inclusive)
	* @return the range of estados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Estado> getEstados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEstados(start, end);
	}

	/**
	* Returns the number of estados.
	*
	* @return the number of estados
	* @throws SystemException if a system exception occurred
	*/
	public static int getEstadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEstadosCount();
	}

	/**
	* Updates the estado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param estado the estado
	* @return the estado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado updateEstado(
		la.netco.solicitudes_sdisc.model.model.Estado estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEstado(estado);
	}

	/**
	* Updates the estado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param estado the estado
	* @param merge whether to merge the estado with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the estado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado updateEstado(
		la.netco.solicitudes_sdisc.model.model.Estado estado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEstado(estado, merge);
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

	public static la.netco.solicitudes_sdisc.model.model.Estado findByNombre(
		java.lang.String nombre)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEstadoException {
		return getService().findByNombre(nombre);
	}

	public static void clearService() {
		_service = null;
	}

	public static EstadoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EstadoLocalService.class.getName());

			if (invokableLocalService instanceof EstadoLocalService) {
				_service = (EstadoLocalService)invokableLocalService;
			}
			else {
				_service = new EstadoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EstadoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EstadoLocalService service) {
	}

	private static EstadoLocalService _service;
}