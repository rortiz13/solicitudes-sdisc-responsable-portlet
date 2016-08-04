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

import la.netco.solicitudes_sdisc.model.model.Implicado;

/**
 * The persistence interface for the implicado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ImplicadoPersistenceImpl
 * @see ImplicadoUtil
 * @generated
 */
public interface ImplicadoPersistence extends BasePersistence<Implicado> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImplicadoUtil} to access the implicado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the implicado in the entity cache if it is enabled.
	*
	* @param implicado the implicado
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado);

	/**
	* Caches the implicados in the entity cache if it is enabled.
	*
	* @param implicados the implicados
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> implicados);

	/**
	* Creates a new implicado with the primary key. Does not add the implicado to the database.
	*
	* @param id_implicado the primary key for the new implicado
	* @return the new implicado
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado create(
		int id_implicado);

	/**
	* Removes the implicado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado remove(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchImplicadoException;

	public la.netco.solicitudes_sdisc.model.model.Implicado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the implicado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchImplicadoException} if it could not be found.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado findByPrimaryKey(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchImplicadoException;

	/**
	* Returns the implicado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_implicado the primary key of the implicado
	* @return the implicado, or <code>null</code> if a implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.Implicado fetchByPrimaryKey(
		int id_implicado)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the implicados.
	*
	* @return the implicados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Implicado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the implicados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of implicados.
	*
	* @return the number of implicados
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}