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

import la.netco.solicitudes_sdisc.model.model.Ciudad;

/**
 * The persistence interface for the ciudad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see CiudadPersistenceImpl
 * @see CiudadUtil
 * @generated
 */
public interface CiudadPersistence extends BasePersistence<Ciudad> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CiudadUtil} to access the ciudad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ciudad in the entity cache if it is enabled.
	*
	* @param ciudad the ciudad
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad);

	/**
	* Caches the ciudads in the entity cache if it is enabled.
	*
	* @param ciudads the ciudads
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> ciudads);

	/**
	* Creates a new ciudad with the primary key. Does not add the ciudad to the database.
	*
	* @param id_ciudad the primary key for the new ciudad
	* @return the new ciudad
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad create(int id_ciudad);

	/**
	* Removes the ciudad with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad remove(int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException;

	public la.netco.solicitudes_sdisc.model.model.Ciudad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ciudad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchCiudadException} if it could not be found.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad findByPrimaryKey(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException;

	/**
	* Returns the ciudad with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ciudad the primary key of the ciudad
	* @return the ciudad, or <code>null</code> if a ciudad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad fetchByPrimaryKey(
		int id_ciudad)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ciudads where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @return the matching ciudads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findBydepartamento(
		int id_departamento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad findBydepartamento_First(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException;

	/**
	* Returns the first ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ciudad, or <code>null</code> if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad fetchBydepartamento_First(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ciudad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad findBydepartamento_Last(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException;

	/**
	* Returns the last ciudad in the ordered set where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ciudad, or <code>null</code> if a matching ciudad could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Ciudad fetchBydepartamento_Last(
		int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public la.netco.solicitudes_sdisc.model.model.Ciudad[] findBydepartamento_PrevAndNext(
		int id_ciudad, int id_departamento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchCiudadException;

	/**
	* Returns all the ciudads.
	*
	* @return the ciudads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Ciudad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ciudads where id_departamento = &#63; from the database.
	*
	* @param id_departamento the id_departamento
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydepartamento(int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ciudads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ciudads where id_departamento = &#63;.
	*
	* @param id_departamento the id_departamento
	* @return the number of matching ciudads
	* @throws SystemException if a system exception occurred
	*/
	public int countBydepartamento(int id_departamento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ciudads.
	*
	* @return the number of ciudads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}