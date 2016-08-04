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

import la.netco.solicitudes_sdisc.model.model.Implicado;

import java.util.List;

/**
 * The persistence utility for the implicado service. This utility wraps {@link ImplicadoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ImplicadoPersistence
 * @see ImplicadoPersistenceImpl
 * @generated
 */
public class ImplicadoUtil {
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
	public static void clearCache(Implicado implicado) {
		getPersistence().clearCache(implicado);
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
	public static List<Implicado> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Implicado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Implicado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Implicado update(Implicado implicado, boolean merge)
		throws SystemException {
		return getPersistence().update(implicado, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Implicado update(Implicado implicado, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(implicado, merge, serviceContext);
	}

	/**
	* Caches the implicado in the entity cache if it is enabled.
	*
	* @param implicado the implicado
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado) {
		getPersistence().cacheResult(implicado);
	}

	/**
	* Caches the implicados in the entity cache if it is enabled.
	*
	* @param implicados the implicados
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> implicados) {
		getPersistence().cacheResult(implicados);
	}

	/**
	* Creates a new implicado with the primary key. Does not add the implicado to the database.
	*
	* @param id_implicado the primary key for the new implicado
	* @return the new implicado
	*/
	public static la.netco.solicitudes_sdisc.model.model.Implicado create(
		int id_implicado) {
		return getPersistence().create(id_implicado);
	}

	/**
	* Removes the implicado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Implicado remove(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchImplicadoException {
		return getPersistence().remove(id_implicado);
	}

	public static la.netco.solicitudes_sdisc.model.model.Implicado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(implicado, merge);
	}

	/**
	* Returns the implicado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchImplicadoException} if it could not be found.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Implicado findByPrimaryKey(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchImplicadoException {
		return getPersistence().findByPrimaryKey(id_implicado);
	}

	/**
	* Returns the implicado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado, or <code>null</code> if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.Implicado fetchByPrimaryKey(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_implicado);
	}

	/**
	* Returns all the implicados.
	*
	* @return the implicados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the implicados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of implicados
	* @param end the upper bound of the range of implicados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of implicados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the implicados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of implicados.
	*
	* @return the number of implicados
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ImplicadoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ImplicadoPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					ImplicadoPersistence.class.getName());

			ReferenceRegistry.registerReference(ImplicadoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ImplicadoPersistence persistence) {
	}

	private static ImplicadoPersistence _persistence;
}