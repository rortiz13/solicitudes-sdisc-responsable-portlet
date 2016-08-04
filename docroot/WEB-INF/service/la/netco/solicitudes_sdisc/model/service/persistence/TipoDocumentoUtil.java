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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import la.netco.solicitudes_sdisc.model.model.TipoDocumento;

import java.util.List;

/**
 * The persistence utility for the tipo documento service. This utility wraps {@link TipoDocumentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see TipoDocumentoPersistence
 * @see TipoDocumentoPersistenceImpl
 * @generated
 */
public class TipoDocumentoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TipoDocumento tipoDocumento) {
		getPersistence().clearCache(tipoDocumento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TipoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TipoDocumento update(TipoDocumento tipoDocumento,
		boolean merge) throws SystemException {
		return getPersistence().update(tipoDocumento, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TipoDocumento update(TipoDocumento tipoDocumento,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tipoDocumento, merge, serviceContext);
	}

	/**
	* Caches the tipo documento in the entity cache if it is enabled.
	*
	* @param tipoDocumento the tipo documento
	*/
	public static void cacheResult(
		la.netco.solicitudes_sdisc.model.model.TipoDocumento tipoDocumento) {
		getPersistence().cacheResult(tipoDocumento);
	}

	/**
	* Caches the tipo documentos in the entity cache if it is enabled.
	*
	* @param tipoDocumentos the tipo documentos
	*/
	public static void cacheResult(
		java.util.List<la.netco.solicitudes_sdisc.model.model.TipoDocumento> tipoDocumentos) {
		getPersistence().cacheResult(tipoDocumentos);
	}

	/**
	* Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	*
	* @param id_tipo_doc the primary key for the new tipo documento
	* @return the new tipo documento
	*/
	public static la.netco.solicitudes_sdisc.model.model.TipoDocumento create(
		int id_tipo_doc) {
		return getPersistence().create(id_tipo_doc);
	}

	/**
	* Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipo_doc the primary key of the tipo documento
	* @return the tipo documento that was removed
	* @throws la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.TipoDocumento remove(
		int id_tipo_doc)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException {
		return getPersistence().remove(id_tipo_doc);
	}

	public static la.netco.solicitudes_sdisc.model.model.TipoDocumento updateImpl(
		la.netco.solicitudes_sdisc.model.model.TipoDocumento tipoDocumento,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tipoDocumento, merge);
	}

	/**
	* Returns the tipo documento with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException} if it could not be found.
	*
	* @param id_tipo_doc the primary key of the tipo documento
	* @return the tipo documento
	* @throws la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.TipoDocumento findByPrimaryKey(
		int id_tipo_doc)
		throws com.liferay.portal.kernel.exception.SystemException,
			la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException {
		return getPersistence().findByPrimaryKey(id_tipo_doc);
	}

	/**
	* Returns the tipo documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipo_doc the primary key of the tipo documento
	* @return the tipo documento, or <code>null</code> if a tipo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static la.netco.solicitudes_sdisc.model.model.TipoDocumento fetchByPrimaryKey(
		int id_tipo_doc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_tipo_doc);
	}

	/**
	* Returns all the tipo documentos.
	*
	* @return the tipo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.TipoDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipo documentos
	* @param end the upper bound of the range of tipo documentos (not inclusive)
	* @return the range of tipo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.TipoDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipo documentos
	* @param end the upper bound of the range of tipo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.TipoDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tipo documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipo documentos.
	*
	* @return the number of tipo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TipoDocumentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TipoDocumentoPersistence)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					TipoDocumentoPersistence.class.getName());

			ReferenceRegistry.registerReference(TipoDocumentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TipoDocumentoPersistence persistence) {
	}

	private static TipoDocumentoPersistence _persistence;
}