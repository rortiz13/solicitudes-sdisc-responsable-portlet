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

import la.netco.solicitudes_sdisc.model.model.FechaNoHabil;

/**
 * The persistence interface for the fecha no habil service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see FechaNoHabilPersistenceImpl
 * @see FechaNoHabilUtil
 * @generated
 */
public interface FechaNoHabilPersistence extends BasePersistence<FechaNoHabil> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FechaNoHabilUtil} to access the fecha no habil persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fecha no habil in the entity cache if it is enabled.
	*
	* @param fechaNoHabil the fecha no habil
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.FechaNoHabil fechaNoHabil);

	/**
	* Caches the fecha no habils in the entity cache if it is enabled.
	*
	* @param fechaNoHabils the fecha no habils
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> fechaNoHabils);

	/**
	* Creates a new fecha no habil with the primary key. Does not add the fecha no habil to the database.
	*
	* @param id the primary key for the new fecha no habil
	* @return the new fecha no habil
	*/
	public la.netco.solicitudes_sdisc.model.model.FechaNoHabil create(int id);

	/**
	* Removes the fecha no habil with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the fecha no habil
	* @return the fecha no habil that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.FechaNoHabil remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException;

	public la.netco.solicitudes_sdisc.model.model.FechaNoHabil updateImpl(
		la.netco.solicitudes_sdisc.model.model.FechaNoHabil fechaNoHabil,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fecha no habil with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException} if it could not be found.
	*
	* @param id the primary key of the fecha no habil
	* @return the fecha no habil
	* @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.FechaNoHabil findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException;

	/**
	* Returns the fecha no habil with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the fecha no habil
	* @return the fecha no habil, or <code>null</code> if a fecha no habil with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.FechaNoHabil fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fecha no habils.
	*
	* @return the fecha no habils
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.FechaNoHabil> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fecha no habils from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fecha no habils.
	*
	* @return the number of fecha no habils
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}