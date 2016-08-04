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

import la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta;

/**
 * The persistence interface for the responsable respuesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ResponsableRespuestaPersistenceImpl
 * @see ResponsableRespuestaUtil
 * @generated
 */
public interface ResponsableRespuestaPersistence extends BasePersistence<ResponsableRespuesta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResponsableRespuestaUtil} to access the responsable respuesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the responsable respuesta in the entity cache if it is enabled.
	*
	* @param responsableRespuesta the responsable respuesta
	*/
	public void cacheResult(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta);

	/**
	* Caches the responsable respuestas in the entity cache if it is enabled.
	*
	* @param responsableRespuestas the responsable respuestas
	*/
	public void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> responsableRespuestas);

	/**
	* Creates a new responsable respuesta with the primary key. Does not add the responsable respuesta to the database.
	*
	* @param id_responsable the primary key for the new responsable respuesta
	* @return the new responsable respuesta
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta create(
		int id_responsable);

	/**
	* Removes the responsable respuesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta remove(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException;

	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta updateImpl(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the responsable respuesta with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException} if it could not be found.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta
	* @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta findByPrimaryKey(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException;

	/**
	* Returns the responsable respuesta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_responsable the primary key of the responsable respuesta
	* @return the responsable respuesta, or <code>null</code> if a responsable respuesta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta fetchByPrimaryKey(
		int id_responsable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the responsable respuestas.
	*
	* @return the responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the responsable respuestas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of responsable respuestas.
	*
	* @return the number of responsable respuestas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}