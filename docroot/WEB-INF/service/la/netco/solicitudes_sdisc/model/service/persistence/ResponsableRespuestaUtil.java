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

import la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta;

import java.util.List;

/**
 * The persistence utility for the responsable respuesta service. This utility wraps {@link ResponsableRespuestaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ResponsableRespuestaPersistence
 * @see ResponsableRespuestaPersistenceImpl
 * @generated
 */
public class ResponsableRespuestaUtil {
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
	public static void clearCache(ResponsableRespuesta responsableRespuesta) {
		getPersistence().clearCache(responsableRespuesta);
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
	public static List<ResponsableRespuesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResponsableRespuesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResponsableRespuesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ResponsableRespuesta update(
		ResponsableRespuesta responsableRespuesta, boolean merge)
		throws SystemException {
		return getPersistence().update(responsableRespuesta, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ResponsableRespuesta update(
		ResponsableRespuesta responsableRespuesta, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(responsableRespuesta, merge, serviceContext);
	}

	/**
	* Caches the responsable respuesta in the entity cache if it is enabled.
	*
	* @param responsableRespuesta the responsable respuesta
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta) {
		getPersistence().cacheResult(responsableRespuesta);
	}

	/**
	* Caches the responsable respuestas in the entity cache if it is enabled.
	*
	* @param responsableRespuestas the responsable respuestas
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> responsableRespuestas) {
		getPersistence().cacheResult(responsableRespuestas);
	}

	/**
	* Creates a new responsable respuesta with the primary key. Does not add the responsable respuesta to the database.
	*
	* @param id_responsable the primary key for the new responsable respuesta
	* @return the new responsable respuesta
	*/
	public static la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta create(
		int id_responsable) {
		return getPersistence().create(id_responsable);
	}

	/**
	* Removes the responsable respuesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta remove(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException {
		return getPersistence().remove(id_responsable);
	}

	public static la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta updateImpl(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(responsableRespuesta, merge);
	}

	/**
	* Returns the responsable respuesta with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException} if it could not be found.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta
	* @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta findByPrimaryKey(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException {
		return getPersistence().findByPrimaryKey(id_responsable);
	}

	/**
	* Returns the responsable respuesta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta, or <code>null</code> if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta fetchByPrimaryKey(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_responsable);
	}

	/**
	* Returns all the responsable respuestas.
	*
	* @return the responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the responsable respuestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of responsable respuestas
	* @param end the upper bound of the range of responsable respuestas (not inclusive)
	* @return the range of responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the responsable respuestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of responsable respuestas
	* @param end the upper bound of the range of responsable respuestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the responsable respuestas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of responsable respuestas.
	*
	* @return the number of responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ResponsableRespuestaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ResponsableRespuestaPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					ResponsableRespuestaPersistence.class.getName());

			ReferenceRegistry.registerReference(ResponsableRespuestaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ResponsableRespuestaPersistence persistence) {
	}

	private static ResponsableRespuestaPersistence _persistence;
}