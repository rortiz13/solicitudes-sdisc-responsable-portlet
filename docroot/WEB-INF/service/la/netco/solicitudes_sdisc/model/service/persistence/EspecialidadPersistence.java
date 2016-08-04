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

import la.netco.solicitudes_sdisc.model.model.Especialidad;

/**
 * The persistence interface for the especialidad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see EspecialidadPersistenceImpl
 * @see EspecialidadUtil
 * @generated
 */
public interface EspecialidadPersistence extends BasePersistence<Especialidad> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EspecialidadUtil} to access the especialidad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the especialidad in the entity cache if it is enabled.
	*
	* @param especialidad the especialidad
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Especialidad especialidad);

	/**
	* Caches the especialidads in the entity cache if it is enabled.
	*
	* @param especialidads the especialidads
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> especialidads);

	/**
	* Creates a new especialidad with the primary key. Does not add the especialidad to the database.
	*
	* @param codigo the primary key for the new especialidad
	* @return the new especialidad
	*/
	public la.netco.solicitudes_sdisc.model.model.Especialidad create(
		java.lang.String codigo);

	/**
	* Removes the especialidad with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codigo the primary key of the especialidad
	* @return the especialidad that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException if a especialidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Especialidad remove(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException;

	public la.netco.solicitudes_sdisc.model.model.Especialidad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Especialidad especialidad,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the especialidad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException} if it could not be found.
	*
	* @param codigo the primary key of the especialidad
	* @return the especialidad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException if a especialidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Especialidad findByPrimaryKey(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException;

	/**
	* Returns the especialidad with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codigo the primary key of the especialidad
	* @return the especialidad, or <code>null</code> if a especialidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Especialidad fetchByPrimaryKey(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the especialidads.
	*
	* @return the especialidads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Especialidad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the especialidads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of especialidads.
	*
	* @return the number of especialidads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}