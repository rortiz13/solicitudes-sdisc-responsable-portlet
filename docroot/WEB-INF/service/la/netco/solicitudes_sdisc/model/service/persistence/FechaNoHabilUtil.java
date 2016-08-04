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

import la.netco.solicitudes_sdisc.model.model.FechaNoHabil;

import java.util.List;

/**
 * The persistence utility for the fecha no habil service. This utility wraps {@link FechaNoHabilPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see FechaNoHabilPersistence
 * @see FechaNoHabilPersistenceImpl
 * @generated
 */
public class FechaNoHabilUtil {
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
	public static void clearCache(FechaNoHabil fechaNoHabil) {
		getPersistence().clearCache(fechaNoHabil);
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
	public static List<FechaNoHabil> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FechaNoHabil> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FechaNoHabil> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static FechaNoHabil update(FechaNoHabil fechaNoHabil, boolean merge)
		throws SystemException {
		return getPersistence().update(fechaNoHabil, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static FechaNoHabil update(FechaNoHabil fechaNoHabil, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(fechaNoHabil, merge, serviceContext);
	}

	/**
	* Caches the fecha no habil in the entity cache if it is enabled.
	*
	* @param fechaNoHabil the fecha no habil
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.FechaNoHabil fechaNoHabil) {
		getPersistence().cacheResult(fechaNoHabil);
	}

	/**
	* Caches the fecha no habils in the entity cache if it is enabled.
	*
	* @param fechaNoHabils the fecha no habils
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> fechaNoHabils) {
		getPersistence().cacheResult(fechaNoHabils);
	}

	/**
	* Creates a new fecha no habil with the primary key. Does not add the fecha no habil to the database.
	*
	* @param id the primary key for the new fecha no habil
	* @return the new fecha no habil
	*/
	public static la.netco.solicitudes_sdisc.model.model.FechaNoHabil create(
		int id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the fecha no habil with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the fecha no habil
	* @return the fecha no habil that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.FechaNoHabil remove(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException {
		return getPersistence().remove(id);
	}

	public static la.netco.solicitudes_sdisc.model.model.FechaNoHabil updateImpl(
		la.netco.solicitudes_sdisc.model.model.FechaNoHabil fechaNoHabil,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(fechaNoHabil, merge);
	}

	/**
	* Returns the fecha no habil with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException} if it could not be found.
	*
	* @param id the primary key of the fecha no habil
	* @return the fecha no habil
	* @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.FechaNoHabil findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the fecha no habil with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the fecha no habil
	* @return the fecha no habil, or <code>null</code> if a fecha no habil with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.FechaNoHabil fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the fecha no habils.
	*
	* @return the fecha no habils
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fecha no habils.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fecha no habils
	* @param end the upper bound of the range of fecha no habils (not inclusive)
	* @return the range of fecha no habils
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fecha no habils.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fecha no habils
	* @param end the upper bound of the range of fecha no habils (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fecha no habils
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fecha no habils from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fecha no habils.
	*
	* @return the number of fecha no habils
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FechaNoHabilPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FechaNoHabilPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					FechaNoHabilPersistence.class.getName());

			ReferenceRegistry.registerReference(FechaNoHabilUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(FechaNoHabilPersistence persistence) {
	}

	private static FechaNoHabilPersistence _persistence;
}