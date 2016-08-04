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

import la.netco.solicitudes_sdisc.model.model.Delegado;

import java.util.List;

/**
 * The persistence utility for the delegado service. This utility wraps {@link DelegadoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see DelegadoPersistence
 * @see DelegadoPersistenceImpl
 * @generated
 */
public class DelegadoUtil {
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
	public static void clearCache(Delegado delegado) {
		getPersistence().clearCache(delegado);
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
	public static List<Delegado> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Delegado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Delegado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Delegado update(Delegado delegado, boolean merge)
		throws SystemException {
		return getPersistence().update(delegado, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Delegado update(Delegado delegado, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(delegado, merge, serviceContext);
	}

	/**
	* Caches the delegado in the entity cache if it is enabled.
	*
	* @param delegado the delegado
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado) {
		getPersistence().cacheResult(delegado);
	}

	/**
	* Caches the delegados in the entity cache if it is enabled.
	*
	* @param delegados the delegados
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> delegados) {
		getPersistence().cacheResult(delegados);
	}

	/**
	* Creates a new delegado with the primary key. Does not add the delegado to the database.
	*
	* @param id_delegado the primary key for the new delegado
	* @return the new delegado
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado create(
		int id_delegado) {
		return getPersistence().create(id_delegado);
	}

	/**
	* Removes the delegado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado remove(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchDelegadoException {
		return getPersistence().remove(id_delegado);
	}

	public static la.netco.solicitudes_sdisc.model.model.Delegado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(delegado, merge);
	}

	/**
	* Returns the delegado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchDelegadoException} if it could not be found.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado findByPrimaryKey(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchDelegadoException {
		return getPersistence().findByPrimaryKey(id_delegado);
	}

	/**
	* Returns the delegado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado, or <code>null</code> if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Delegado fetchByPrimaryKey(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_delegado);
	}

	/**
	* Returns all the delegados.
	*
	* @return the delegados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the delegados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of delegados
	* @param end the upper bound of the range of delegados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of delegados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the delegados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of delegados.
	*
	* @return the number of delegados
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DelegadoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DelegadoPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					DelegadoPersistence.class.getName());

			ReferenceRegistry.registerReference(DelegadoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DelegadoPersistence persistence) {
	}

	private static DelegadoPersistence _persistence;
}