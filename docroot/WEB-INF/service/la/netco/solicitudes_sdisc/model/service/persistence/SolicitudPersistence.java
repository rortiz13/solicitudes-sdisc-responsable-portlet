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

import com.liferay.portal.service.persistence.BasePersistence;

import la.netco.solicitudes_sdisc.model.model.Solicitud;

/**
 * The persistence interface for the Solicitud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see SolicitudPersistenceImpl
 * @see SolicitudUtil
 * @generated
 */
public interface SolicitudPersistence extends BasePersistence<Solicitud> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SolicitudUtil} to access the Solicitud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Solicitud in the entity cache if it is enabled.
	*
	* @param solicitud the Solicitud
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud);

	/**
	* Caches the Solicituds in the entity cache if it is enabled.
	*
	* @param solicituds the Solicituds
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> solicituds);

	/**
	* Creates a new Solicitud with the primary key. Does not add the Solicitud to the database.
	*
	* @param id_solicitud the primary key for the new Solicitud
	* @return the new Solicitud
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud create(
		int id_solicitud);

	/**
	* Removes the Solicitud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud remove(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchSolicitudException;

	public la.netco.solicitudes_sdisc.model.model.Solicitud updateImpl(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Solicitud with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchSolicitudException} if it could not be found.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud
	* @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud findByPrimaryKey(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchSolicitudException;

	/**
	* Returns the Solicitud with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_solicitud the primary key of the Solicitud
	* @return the Solicitud, or <code>null</code> if a Solicitud with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Solicitud fetchByPrimaryKey(
		int id_solicitud)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Solicituds.
	*
	* @return the Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Solicituds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Solicituds.
	*
	* @return the number of Solicituds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}