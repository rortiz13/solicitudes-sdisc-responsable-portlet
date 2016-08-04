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

import la.netco.solicitudes_sdisc.model.model.Parametros;

/**
 * The persistence interface for the parametros service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ParametrosPersistenceImpl
 * @see ParametrosUtil
 * @generated
 */
public interface ParametrosPersistence extends BasePersistence<Parametros> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParametrosUtil} to access the parametros persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the parametros in the entity cache if it is enabled.
	*
	* @param parametros the parametros
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Parametros parametros);

	/**
	* Caches the parametroses in the entity cache if it is enabled.
	*
	* @param parametroses the parametroses
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Parametros> parametroses);

	/**
	* Creates a new parametros with the primary key. Does not add the parametros to the database.
	*
	* @param id the primary key for the new parametros
	* @return the new parametros
	*/
	public la.netco.solicitudes_sdisc.model.model.Parametros create(int id);

	/**
	* Removes the parametros with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the parametros
	* @return the parametros that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchParametrosException if a parametros with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Parametros remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchParametrosException;

	public la.netco.solicitudes_sdisc.model.model.Parametros updateImpl(
		la.netco.solicitudes_sdisc.model.model.Parametros parametros,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parametros with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchParametrosException} if it could not be found.
	*
	* @param id the primary key of the parametros
	* @return the parametros
	* @throws la.netco.solicitudes_sdisc.model.NoSuchParametrosException if a parametros with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Parametros findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchParametrosException;

	/**
	* Returns the parametros with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the parametros
	* @return the parametros, or <code>null</code> if a parametros with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Parametros fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the parametroses.
	*
	* @return the parametroses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Parametros> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parametroses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of parametroses
	* @param end the upper bound of the range of parametroses (not inclusive)
	* @return the range of parametroses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Parametros> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parametroses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of parametroses
	* @param end the upper bound of the range of parametroses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of parametroses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Parametros> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the parametroses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parametroses.
	*
	* @return the number of parametroses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}