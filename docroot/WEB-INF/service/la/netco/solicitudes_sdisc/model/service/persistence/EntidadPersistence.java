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

import la.netco.solicitudes_sdisc.model.model.Entidad;

/**
 * The persistence interface for the entidad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see EntidadPersistenceImpl
 * @see EntidadUtil
 * @generated
 */
public interface EntidadPersistence extends BasePersistence<Entidad> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntidadUtil} to access the entidad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the entidad in the entity cache if it is enabled.
	*
	* @param entidad the entidad
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Entidad entidad);

	/**
	* Caches the entidads in the entity cache if it is enabled.
	*
	* @param entidads the entidads
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Entidad> entidads);

	/**
	* Creates a new entidad with the primary key. Does not add the entidad to the database.
	*
	* @param codigo the primary key for the new entidad
	* @return the new entidad
	*/
	public la.netco.solicitudes_sdisc.model.model.Entidad create(
		java.lang.String codigo);

	/**
	* Removes the entidad with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codigo the primary key of the entidad
	* @return the entidad that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEntidadException if a entidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Entidad remove(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEntidadException;

	public la.netco.solicitudes_sdisc.model.model.Entidad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Entidad entidad, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the entidad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEntidadException} if it could not be found.
	*
	* @param codigo the primary key of the entidad
	* @return the entidad
	* @throws la.netco.solicitudes_sdisc.model.NoSuchEntidadException if a entidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Entidad findByPrimaryKey(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchEntidadException;

	/**
	* Returns the entidad with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codigo the primary key of the entidad
	* @return the entidad, or <code>null</code> if a entidad with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Entidad fetchByPrimaryKey(
		java.lang.String codigo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entidads.
	*
	* @return the entidads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Entidad> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the entidads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of entidads
	* @param end the upper bound of the range of entidads (not inclusive)
	* @return the range of entidads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Entidad> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the entidads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of entidads
	* @param end the upper bound of the range of entidads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of entidads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Entidad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entidads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entidads.
	*
	* @return the number of entidads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}