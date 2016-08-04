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

import la.netco.solicitudes_sdisc.model.model.Delegado;

/**
 * The persistence interface for the delegado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see DelegadoPersistenceImpl
 * @see DelegadoUtil
 * @generated
 */
public interface DelegadoPersistence extends BasePersistence<Delegado> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DelegadoUtil} to access the delegado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the delegado in the entity cache if it is enabled.
	*
	* @param delegado the delegado
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado);

	/**
	* Caches the delegados in the entity cache if it is enabled.
	*
	* @param delegados the delegados
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> delegados);

	/**
	* Creates a new delegado with the primary key. Does not add the delegado to the database.
	*
	* @param id_delegado the primary key for the new delegado
	* @return the new delegado
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado create(
		int id_delegado);

	/**
	* Removes the delegado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado remove(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchDelegadoException;

	public la.netco.solicitudes_sdisc.model.model.Delegado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the delegado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchDelegadoException} if it could not be found.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado findByPrimaryKey(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchDelegadoException;

	/**
	* Returns the delegado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_delegado the primary key of the delegado
	* @return the delegado, or <code>null</code> if a delegado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Delegado fetchByPrimaryKey(
		int id_delegado)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the delegados.
	*
	* @return the delegados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Delegado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the delegados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of delegados.
	*
	* @return the number of delegados
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}