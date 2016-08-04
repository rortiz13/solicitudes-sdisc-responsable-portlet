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

import la.netco.solicitudes_sdisc.model.model.Especialidad;

import java.util.List;

/**
 * The persistence utility for the especialidad service. This utility wraps {@link EspecialidadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see EspecialidadPersistence
 * @see EspecialidadPersistenceImpl
 * @generated
 */
public class EspecialidadUtil {
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
	public static void clearCache(Especialidad especialidad) {
		getPersistence().clearCache(especialidad);
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
	public static List<Especialidad> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Especialidad> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Especialidad> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Especialidad update(Especialidad especialidad, boolean merge)
		throws SystemException {
		return getPersistence().update(especialidad, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Especialidad update(Especialidad especialidad, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(especialidad, merge, serviceContext);
	}

	/**
	* Caches the especialidad in the entity cache if it is enabled.
	*
	* @param especialidad the especialidad
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Especialidad especialidad) {
		getPersistence().cacheResult(especialidad);
	}

	/**
	* Caches the especialidads in the entity cache if it is enabled.
	*
	* @param especialidads the especialidads
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> especialidads) {
		getPersistence().cacheResult(especialidads);
	}

	/**
	* Creates a new especialidad with the primary key. Does not add the especialidad to the database.
	*
	* @param codigo the primary key for the new especialidad
	* @return the new especialidad
	*/
	public static la.netco.solicitudes_sdisc.model.model.Especialidad create(
		java.lang.String codigo) {
		return getPersistence().create(codigo);
	}

	/**
	* Removes the especialidad with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codigo the primary key of the especialidad
	* @return the especialidad that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException if a especialidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Especialidad remove(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException {
		return getPersistence().remove(codigo);
	}

	public static la.netco.solicitudes_sdisc.model.model.Especialidad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Especialidad especialidad,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(especialidad, merge);
	}

	/**
	* Returns the especialidad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException} if it could not be found.
	*
	* @param codigo the primary key of the especialidad
	* @return the especialidad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException if a especialidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Especialidad findByPrimaryKey(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException {
		return getPersistence().findByPrimaryKey(codigo);
	}

	/**
	* Returns the especialidad with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codigo the primary key of the especialidad
	* @return the especialidad, or <code>null</code> if a especialidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Especialidad fetchByPrimaryKey(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codigo);
	}

	/**
	* Returns all the especialidads.
	*
	* @return the especialidads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the especialidads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of especialidads
	* @param end the upper bound of the range of especialidads (not inclusive)
	* @return the range of especialidads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the especialidads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of especialidads
	* @param end the upper bound of the range of especialidads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of especialidads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the especialidads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of especialidads.
	*
	* @return the number of especialidads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EspecialidadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EspecialidadPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					EspecialidadPersistence.class.getName());

			ReferenceRegistry.registerReference(EspecialidadUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EspecialidadPersistence persistence) {
	}

	private static EspecialidadPersistence _persistence;
}