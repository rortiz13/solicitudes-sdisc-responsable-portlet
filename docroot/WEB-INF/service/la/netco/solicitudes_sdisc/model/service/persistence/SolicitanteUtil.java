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

import la.netco.solicitudes_sdisc.model.model.Solicitante;

import java.util.List;

/**
 * The persistence utility for the solicitante service. This utility wraps {@link SolicitantePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see SolicitantePersistence
 * @see SolicitantePersistenceImpl
 * @generated
 */
public class SolicitanteUtil {
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
	public static void clearCache(Solicitante solicitante) {
		getPersistence().clearCache(solicitante);
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
	public static List<Solicitante> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Solicitante> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Solicitante> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Solicitante update(Solicitante solicitante, boolean merge)
		throws SystemException {
		return getPersistence().update(solicitante, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Solicitante update(Solicitante solicitante, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(solicitante, merge, serviceContext);
	}

	/**
	* Caches the solicitante in the entity cache if it is enabled.
	*
	* @param solicitante the solicitante
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Solicitante solicitante) {
		getPersistence().cacheResult(solicitante);
	}

	/**
	* Caches the solicitantes in the entity cache if it is enabled.
	*
	* @param solicitantes the solicitantes
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitante> solicitantes) {
		getPersistence().cacheResult(solicitantes);
	}

	/**
	* Creates a new solicitante with the primary key. Does not add the solicitante to the database.
	*
	* @param id_solicitante the primary key for the new solicitante
	* @return the new solicitante
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitante create(
		int id_solicitante) {
		return getPersistence().create(id_solicitante);
	}

	/**
	* Removes the solicitante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_solicitante the primary key of the solicitante
	* @return the solicitante that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException if a solicitante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitante remove(
		int id_solicitante)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException {
		return getPersistence().remove(id_solicitante);
	}

	public static la.netco.solicitudes_sdisc.model.model.Solicitante updateImpl(
		la.netco.solicitudes_sdisc.model.model.Solicitante solicitante,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(solicitante, merge);
	}

	/**
	* Returns the solicitante with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException} if it could not be found.
	*
	* @param id_solicitante the primary key of the solicitante
	* @return the solicitante
	* @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException if a solicitante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitante findByPrimaryKey(
		int id_solicitante)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException {
		return getPersistence().findByPrimaryKey(id_solicitante);
	}

	/**
	* Returns the solicitante with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_solicitante the primary key of the solicitante
	* @return the solicitante, or <code>null</code> if a solicitante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Solicitante fetchByPrimaryKey(
		int id_solicitante)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_solicitante);
	}

	/**
	* Returns all the solicitantes.
	*
	* @return the solicitantes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitante> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the solicitantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitantes
	* @param end the upper bound of the range of solicitantes (not inclusive)
	* @return the range of solicitantes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitante> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the solicitantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitantes
	* @param end the upper bound of the range of solicitantes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of solicitantes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitante> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the solicitantes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of solicitantes.
	*
	* @return the number of solicitantes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SolicitantePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SolicitantePersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					SolicitantePersistence.class.getName());

			ReferenceRegistry.registerReference(SolicitanteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SolicitantePersistence persistence) {
	}

	private static SolicitantePersistence _persistence;
}