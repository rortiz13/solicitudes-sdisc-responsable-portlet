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

package la.netco.solicitudes_sdisc.model.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import la.netco.solicitudes_sdisc.model.model.Solicitud;

import java.util.List;

/**
 * The persistence utility for the Solicitud service. This utility wraps {@link SolicitudPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see SolicitudPersistence
 * @see SolicitudPersistenceImpl
 * @generated
 */
public class SolicitudUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Solicitud solicitud) {
		getPersistence().clearCache(solicitud);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Solicitud> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Solicitud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Solicitud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Solicitud update(Solicitud solicitud, boolean merge)
		throws SystemException {
		return getPersistence().update(solicitud, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Solicitud update(Solicitud solicitud, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(solicitud, merge, serviceContext);
	}

	/**
	* Caches the Solicitud in the entity cache if it is enabled.
	*
	* @param solicitud the Solicitud
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud) {
		getPersistence().cacheResult(solicitud);
	}

	/**
	* Caches the Solicituds in the entity cache if it is enabled.
	*
	* @param solicituds the Solicituds
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> solicituds) {
		getPersistence().cacheResult(solicituds);
	}

	/**
	* Creates a new Solicitud with the primary key. Does not add the Solicitud to the database.
	*
	* @param id_solicitud the primary key for the new Solicitud
	* @return the new Solicitud
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitud create(
		int id_solicitud) {
		return getPersistence().create(id_solicitud);
	}

	/**
	* Removes the Solicitud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitud remove(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchSolicitudException {
		return getPersistence().remove(id_solicitud);
	}

	public static la.netco.solicitudes_sdisc.model.model.Solicitud updateImpl(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(solicitud, merge);
	}

	/**
	* Returns the Solicitud with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchSolicitudException} if it could not be found.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud
	* @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitud findByPrimaryKey(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchSolicitudException {
		return getPersistence().findByPrimaryKey(id_solicitud);
	}

	/**
	* Returns the Solicitud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud, or <code>null</code> if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitud fetchByPrimaryKey(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_solicitud);
	}

	/**
	* Returns all the Solicituds.
	*
	* @return the Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Solicituds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Solicituds
	* @param end the upper bound of the range of Solicituds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Solicituds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Solicituds.
	*
	* @return the number of Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SolicitudPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SolicitudPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					SolicitudPersistence.class.getName());

			ReferenceRegistry.registerReference(SolicitudUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SolicitudPersistence persistence) {
	}

	private static SolicitudPersistence _persistence;
}