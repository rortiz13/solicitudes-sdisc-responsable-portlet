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

import la.netco.solicitudes_sdisc.model.model.Ciudad;

import java.util.List;

/**
 * The persistence utility for the ciudad service. This utility wraps {@link CiudadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see CiudadPersistence
 * @see CiudadPersistenceImpl
 * @generated
 */
public class CiudadUtil {
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
	public static void clearCache(Ciudad ciudad) {
		getPersistence().clearCache(ciudad);
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
	public static List<Ciudad> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ciudad> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ciudad> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Ciudad update(Ciudad ciudad, boolean merge)
		throws SystemException {
		return getPersistence().update(ciudad, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Ciudad update(Ciudad ciudad, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ciudad, merge, serviceContext);
	}

	/**
	* Caches the ciudad in the entity cache if it is enabled.
	*
	* @param ciudad the ciudad
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad) {
		getPersistence().cacheResult(ciudad);
	}

	/**
	* Caches the ciudads in the entity cache if it is enabled.
	*
	* @param ciudads the ciudads
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> ciudads) {
		getPersistence().cacheResult(ciudads);
	}

	/**
	* Creates a new ciudad with the primary key. Does not add the ciudad to the database.
	*
	* @param id_ciudad the primary key for the new ciudad
	* @return the new ciudad
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad create(
		int id_ciudad) {
		return getPersistence().create(id_ciudad);
	}

	/**
	* Removes the ciudad with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad remove(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException {
		return getPersistence().remove(id_ciudad);
	}

	public static la.netco.solicitudes_sdisc.model.model.Ciudad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ciudad, merge);
	}

	/**
	* Returns the ciudad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchCiudadException} if it could not be found.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad findByPrimaryKey(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException {
		return getPersistence().findByPrimaryKey(id_ciudad);
	}

	/**
	* Returns the ciudad with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad, or <code>null</code> if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad fetchByPrimaryKey(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_ciudad);
	}

	/**
	* Returns all the ciudads where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @return the matching ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydepartamento(id_departamento);
	}

	/**
	* Returns a range of all the ciudads where id_departamento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_departamento the id_departamento
	* @param start the lower bound of the range of ciudads
	* @param end the upper bound of the range of ciudads (not inclusive)
	* @return the range of matching ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydepartamento(id_departamento, start, end);
	}

	/**
	* Returns an ordered range of all the ciudads where id_departamento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id_departamento the id_departamento
	* @param start the lower bound of the range of ciudads
	* @param end the upper bound of the range of ciudads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydepartamento(id_departamento, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad findBydepartamento_First(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException {
		return getPersistence()
				   .findBydepartamento_First(id_departamento, orderByComparator);
	}

	/**
	* Returns the first ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ciudad, or <code>null</code> if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad fetchBydepartamento_First(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydepartamento_First(id_departamento, orderByComparator);
	}

	/**
	* Returns the last ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad findBydepartamento_Last(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException {
		return getPersistence()
				   .findBydepartamento_Last(id_departamento, orderByComparator);
	}

	/**
	* Returns the last ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ciudad, or <code>null</code> if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad fetchBydepartamento_Last(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydepartamento_Last(id_departamento, orderByComparator);
	}

	/**
	* Returns the ciudads before and after the current ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_ciudad the primary key of the current ciudad
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Ciudad[] findBydepartamento_PrevAndNext(
		int id_ciudad, int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException {
		return getPersistence()
				   .findBydepartamento_PrevAndNext(id_ciudad, id_departamento,
			orderByComparator);
	}

	/**
	* Returns all the ciudads.
	*
	* @return the ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ciudads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ciudads
	* @param end the upper bound of the range of ciudads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ciudads where id_departamento = &#63; from the database.
	*
	* @param id_departamento the id_departamento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydepartamento(int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBydepartamento(id_departamento);
	}

	/**
	* Removes all the ciudads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ciudads where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @return the number of matching ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydepartamento(int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBydepartamento(id_departamento);
	}

	/**
	* Returns the number of ciudads.
	*
	* @return the number of ciudads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CiudadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CiudadPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					CiudadPersistence.class.getName());

			ReferenceRegistry.registerReference(CiudadUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CiudadPersistence persistence) {
	}

	private static CiudadPersistence _persistence;
}