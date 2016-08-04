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

import la.netco.solicitudes_sdisc.model.model.Estado;

import java.util.List;

/**
 * The persistence utility for the estado service. This utility wraps {@link EstadoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see EstadoPersistence
 * @see EstadoPersistenceImpl
 * @generated
 */
public class EstadoUtil {
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
	public static void clearCache(Estado estado) {
		getPersistence().clearCache(estado);
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
	public static List<Estado> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Estado> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Estado> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Estado update(Estado estado, boolean merge)
		throws SystemException {
		return getPersistence().update(estado, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Estado update(Estado estado, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(estado, merge, serviceContext);
	}

	/**
	* Caches the estado in the entity cache if it is enabled.
	*
	* @param estado the estado
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Estado estado) {
		getPersistence().cacheResult(estado);
	}

	/**
	* Caches the estados in the entity cache if it is enabled.
	*
	* @param estados the estados
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Estado> estados) {
		getPersistence().cacheResult(estados);
	}

	/**
	* Creates a new estado with the primary key. Does not add the estado to the database.
	*
	* @param id_estado the primary key for the new estado
	* @return the new estado
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado create(
		int id_estado) {
		return getPersistence().create(id_estado);
	}

	/**
	* Removes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_estado the primary key of the estado
	* @return the estado that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a estado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado remove(
		int id_estado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEstadoException {
		return getPersistence().remove(id_estado);
	}

	public static la.netco.solicitudes_sdisc.model.model.Estado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Estado estado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(estado, merge);
	}

	/**
	* Returns the estado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEstadoException} if it could not be found.
	*
	* @param id_estado the primary key of the estado
	* @return the estado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a estado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado findByPrimaryKey(
		int id_estado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEstadoException {
		return getPersistence().findByPrimaryKey(id_estado);
	}

	/**
	* Returns the estado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_estado the primary key of the estado
	* @return the estado, or <code>null</code> if a estado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado fetchByPrimaryKey(
		int id_estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_estado);
	}

	/**
	* Returns the estado where nombre = &#63; or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEstadoException} if it could not be found.
	*
	* @param nombre the nombre
	* @return the matching estado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a matching estado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado findByNombre(
		java.lang.String nombre)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEstadoException {
		return getPersistence().findByNombre(nombre);
	}

	/**
	* Returns the estado where nombre = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param nombre the nombre
	* @return the matching estado, or <code>null</code> if a matching estado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado fetchByNombre(
		java.lang.String nombre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNombre(nombre);
	}

	/**
	* Returns the estado where nombre = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param nombre the nombre
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching estado, or <code>null</code> if a matching estado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado fetchByNombre(
		java.lang.String nombre, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNombre(nombre, retrieveFromCache);
	}

	/**
	* Returns all the estados.
	*
	* @return the estados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Estado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Estado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the estados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of estados
	* @param end the upper bound of the range of estados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of estados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Estado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the estado where nombre = &#63; from the database.
	*
	* @param nombre the nombre
	* @return the estado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Estado removeByNombre(
		java.lang.String nombre)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEstadoException {
		return getPersistence().removeByNombre(nombre);
	}

	/**
	* Removes all the estados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of estados where nombre = &#63;.
	*
	* @param nombre the nombre
	* @return the number of matching estados
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNombre(java.lang.String nombre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNombre(nombre);
	}

	/**
	* Returns the number of estados.
	*
	* @return the number of estados
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EstadoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EstadoPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					EstadoPersistence.class.getName());

			ReferenceRegistry.registerReference(EstadoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EstadoPersistence persistence) {
	}

	private static EstadoPersistence _persistence;
}