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

import la.netco.solicitudes_sdisc.model.model.PerfilImplicado;

/**
 * The persistence interface for the perfil implicado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see PerfilImplicadoPersistenceImpl
 * @see PerfilImplicadoUtil
 * @generated
 */
public interface PerfilImplicadoPersistence extends BasePersistence<PerfilImplicado> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PerfilImplicadoUtil} to access the perfil implicado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the perfil implicado in the entity cache if it is enabled.
	*
	* @param perfilImplicado the perfil implicado
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.PerfilImplicado perfilImplicado);

	/**
	* Caches the perfil implicados in the entity cache if it is enabled.
	*
	* @param perfilImplicados the perfil implicados
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.PerfilImplicado> perfilImplicados);

	/**
	* Creates a new perfil implicado with the primary key. Does not add the perfil implicado to the database.
	*
	* @param id_perfil the primary key for the new perfil implicado
	* @return the new perfil implicado
	*/
	public la.netco.solicitudes_sdisc.model.model.PerfilImplicado create(
		int id_perfil);

	/**
	* Removes the perfil implicado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_perfil the primary key of the perfil implicado
	* @return the perfil implicado that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException if a perfil implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.PerfilImplicado remove(
		int id_perfil)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException;

	public la.netco.solicitudes_sdisc.model.model.PerfilImplicado updateImpl(
		la.netco.solicitudes_sdisc.model.model.PerfilImplicado perfilImplicado,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the perfil implicado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException} if it could not be found.
	*
	* @param id_perfil the primary key of the perfil implicado
	* @return the perfil implicado
	* @throws la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException if a perfil implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.PerfilImplicado findByPrimaryKey(
		int id_perfil)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException;

	/**
	* Returns the perfil implicado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_perfil the primary key of the perfil implicado
	* @return the perfil implicado, or <code>null</code> if a perfil implicado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.PerfilImplicado fetchByPrimaryKey(
		int id_perfil)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the perfil implicados.
	*
	* @return the perfil implicados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.PerfilImplicado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the perfil implicados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of perfil implicados
	* @param end the upper bound of the range of perfil implicados (not inclusive)
	* @return the range of perfil implicados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.PerfilImplicado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the perfil implicados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of perfil implicados
	* @param end the upper bound of the range of perfil implicados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of perfil implicados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.PerfilImplicado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the perfil implicados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of perfil implicados.
	*
	* @return the number of perfil implicados
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}