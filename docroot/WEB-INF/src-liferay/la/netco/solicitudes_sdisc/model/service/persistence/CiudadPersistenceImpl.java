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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import la.netco.solicitudes_sdisc.model.NoSuchCiudadException;
import la.netco.solicitudes_sdisc.model.model.Ciudad;
import la.netco.solicitudes_sdisc.model.model.impl.CiudadImpl;
import la.netco.solicitudes_sdisc.model.model.impl.CiudadModelImpl;
import la.netco.solicitudes_sdisc.model.service.persistence.CiudadPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.DelegadoPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.DepartamentoPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.EntidadPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.EspecialidadPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.EstadoPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.FechaNoHabilPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.ImplicadoPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.ParametrosPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.PerfilImplicadoPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.ResponsableRespuestaPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.SolicitantePersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.SolicitudPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.TipoDocumentoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ciudad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see CiudadPersistence
 * @see CiudadUtil
 * @generated
 */
public class CiudadPersistenceImpl extends BasePersistenceImpl<Ciudad>
	implements CiudadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CiudadUtil} to access the ciudad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CiudadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTAMENTO =
		new FinderPath(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadModelImpl.FINDER_CACHE_ENABLED, CiudadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydepartamento",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTAMENTO =
		new FinderPath(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadModelImpl.FINDER_CACHE_ENABLED, CiudadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydepartamento",
			new String[] { Integer.class.getName() },
			CiudadModelImpl.ID_DEPARTAMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTAMENTO = new FinderPath(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydepartamento",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadModelImpl.FINDER_CACHE_ENABLED, CiudadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadModelImpl.FINDER_CACHE_ENABLED, CiudadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ciudad in the entity cache if it is enabled.
	 *
	 * @param ciudad the ciudad
	 */
	public void cacheResult(Ciudad ciudad) {
		EntityCacheUtil.putResult(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadImpl.class, ciudad.getPrimaryKey(), ciudad);

		ciudad.resetOriginalValues();
	}

	/**
	 * Caches the ciudads in the entity cache if it is enabled.
	 *
	 * @param ciudads the ciudads
	 */
	public void cacheResult(List<Ciudad> ciudads) {
		for (Ciudad ciudad : ciudads) {
			if (EntityCacheUtil.getResult(
						CiudadModelImpl.ENTITY_CACHE_ENABLED, CiudadImpl.class,
						ciudad.getPrimaryKey()) == null) {
				cacheResult(ciudad);
			}
			else {
				ciudad.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ciudads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CiudadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CiudadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ciudad.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ciudad ciudad) {
		EntityCacheUtil.removeResult(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadImpl.class, ciudad.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Ciudad> ciudads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ciudad ciudad : ciudads) {
			EntityCacheUtil.removeResult(CiudadModelImpl.ENTITY_CACHE_ENABLED,
				CiudadImpl.class, ciudad.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ciudad with the primary key. Does not add the ciudad to the database.
	 *
	 * @param id_ciudad the primary key for the new ciudad
	 * @return the new ciudad
	 */
	public Ciudad create(int id_ciudad) {
		Ciudad ciudad = new CiudadImpl();

		ciudad.setNew(true);
		ciudad.setPrimaryKey(id_ciudad);

		return ciudad;
	}

	/**
	 * Removes the ciudad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ciudad the primary key of the ciudad
	 * @return the ciudad that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad remove(int id_ciudad)
		throws NoSuchCiudadException, SystemException {
		return remove(Integer.valueOf(id_ciudad));
	}

	/**
	 * Removes the ciudad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ciudad
	 * @return the ciudad that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ciudad remove(Serializable primaryKey)
		throws NoSuchCiudadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Ciudad ciudad = (Ciudad)session.get(CiudadImpl.class, primaryKey);

			if (ciudad == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCiudadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ciudad);
		}
		catch (NoSuchCiudadException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Ciudad removeImpl(Ciudad ciudad) throws SystemException {
		ciudad = toUnwrappedModel(ciudad);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ciudad);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ciudad);

		return ciudad;
	}

	@Override
	public Ciudad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Ciudad ciudad, boolean merge)
		throws SystemException {
		ciudad = toUnwrappedModel(ciudad);

		boolean isNew = ciudad.isNew();

		CiudadModelImpl ciudadModelImpl = (CiudadModelImpl)ciudad;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ciudad, merge);

			ciudad.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CiudadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ciudadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTAMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(ciudadModelImpl.getOriginalId_departamento())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTAMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTAMENTO,
					args);

				args = new Object[] {
						Integer.valueOf(ciudadModelImpl.getId_departamento())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTAMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTAMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(CiudadModelImpl.ENTITY_CACHE_ENABLED,
			CiudadImpl.class, ciudad.getPrimaryKey(), ciudad);

		return ciudad;
	}

	protected Ciudad toUnwrappedModel(Ciudad ciudad) {
		if (ciudad instanceof CiudadImpl) {
			return ciudad;
		}

		CiudadImpl ciudadImpl = new CiudadImpl();

		ciudadImpl.setNew(ciudad.isNew());
		ciudadImpl.setPrimaryKey(ciudad.getPrimaryKey());

		ciudadImpl.setId_ciudad(ciudad.getId_ciudad());
		ciudadImpl.setNombre(ciudad.getNombre());
		ciudadImpl.setId_departamento(ciudad.getId_departamento());

		return ciudadImpl;
	}

	/**
	 * Returns the ciudad with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ciudad
	 * @return the ciudad
	 * @throws com.liferay.portal.NoSuchModelException if a ciudad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ciudad findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the ciudad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchCiudadException} if it could not be found.
	 *
	 * @param id_ciudad the primary key of the ciudad
	 * @return the ciudad
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a ciudad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad findByPrimaryKey(int id_ciudad)
		throws NoSuchCiudadException, SystemException {
		Ciudad ciudad = fetchByPrimaryKey(id_ciudad);

		if (ciudad == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_ciudad);
			}

			throw new NoSuchCiudadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_ciudad);
		}

		return ciudad;
	}

	/**
	 * Returns the ciudad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ciudad
	 * @return the ciudad, or <code>null</code> if a ciudad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ciudad fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the ciudad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ciudad the primary key of the ciudad
	 * @return the ciudad, or <code>null</code> if a ciudad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad fetchByPrimaryKey(int id_ciudad) throws SystemException {
		Ciudad ciudad = (Ciudad)EntityCacheUtil.getResult(CiudadModelImpl.ENTITY_CACHE_ENABLED,
				CiudadImpl.class, id_ciudad);

		if (ciudad == _nullCiudad) {
			return null;
		}

		if (ciudad == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ciudad = (Ciudad)session.get(CiudadImpl.class,
						Integer.valueOf(id_ciudad));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ciudad != null) {
					cacheResult(ciudad);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CiudadModelImpl.ENTITY_CACHE_ENABLED,
						CiudadImpl.class, id_ciudad, _nullCiudad);
				}

				closeSession(session);
			}
		}

		return ciudad;
	}

	/**
	 * Returns all the ciudads where id_departamento = &#63;.
	 *
	 * @param id_departamento the id_departamento
	 * @return the matching ciudads
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ciudad> findBydepartamento(int id_departamento)
		throws SystemException {
		return findBydepartamento(id_departamento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Ciudad> findBydepartamento(int id_departamento, int start,
		int end) throws SystemException {
		return findBydepartamento(id_departamento, start, end, null);
	}

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
	public List<Ciudad> findBydepartamento(int id_departamento, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTAMENTO;
			finderArgs = new Object[] { id_departamento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTAMENTO;
			finderArgs = new Object[] {
					id_departamento,
					
					start, end, orderByComparator
				};
		}

		List<Ciudad> list = (List<Ciudad>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ciudad ciudad : list) {
				if ((id_departamento != ciudad.getId_departamento())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CIUDAD_WHERE);

			query.append(_FINDER_COLUMN_DEPARTAMENTO_ID_DEPARTAMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CiudadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_departamento);

				list = (List<Ciudad>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ciudad in the ordered set where id_departamento = &#63;.
	 *
	 * @param id_departamento the id_departamento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudad
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a matching ciudad could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad findBydepartamento_First(int id_departamento,
		OrderByComparator orderByComparator)
		throws NoSuchCiudadException, SystemException {
		Ciudad ciudad = fetchBydepartamento_First(id_departamento,
				orderByComparator);

		if (ciudad != null) {
			return ciudad;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_departamento=");
		msg.append(id_departamento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCiudadException(msg.toString());
	}

	/**
	 * Returns the first ciudad in the ordered set where id_departamento = &#63;.
	 *
	 * @param id_departamento the id_departamento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudad, or <code>null</code> if a matching ciudad could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad fetchBydepartamento_First(int id_departamento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Ciudad> list = findBydepartamento(id_departamento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ciudad in the ordered set where id_departamento = &#63;.
	 *
	 * @param id_departamento the id_departamento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudad
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchCiudadException if a matching ciudad could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad findBydepartamento_Last(int id_departamento,
		OrderByComparator orderByComparator)
		throws NoSuchCiudadException, SystemException {
		Ciudad ciudad = fetchBydepartamento_Last(id_departamento,
				orderByComparator);

		if (ciudad != null) {
			return ciudad;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_departamento=");
		msg.append(id_departamento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCiudadException(msg.toString());
	}

	/**
	 * Returns the last ciudad in the ordered set where id_departamento = &#63;.
	 *
	 * @param id_departamento the id_departamento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudad, or <code>null</code> if a matching ciudad could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ciudad fetchBydepartamento_Last(int id_departamento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBydepartamento(id_departamento);

		List<Ciudad> list = findBydepartamento(id_departamento, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Ciudad[] findBydepartamento_PrevAndNext(int id_ciudad,
		int id_departamento, OrderByComparator orderByComparator)
		throws NoSuchCiudadException, SystemException {
		Ciudad ciudad = findByPrimaryKey(id_ciudad);

		Session session = null;

		try {
			session = openSession();

			Ciudad[] array = new CiudadImpl[3];

			array[0] = getBydepartamento_PrevAndNext(session, ciudad,
					id_departamento, orderByComparator, true);

			array[1] = ciudad;

			array[2] = getBydepartamento_PrevAndNext(session, ciudad,
					id_departamento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ciudad getBydepartamento_PrevAndNext(Session session,
		Ciudad ciudad, int id_departamento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIUDAD_WHERE);

		query.append(_FINDER_COLUMN_DEPARTAMENTO_ID_DEPARTAMENTO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CiudadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_departamento);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ciudad);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ciudad> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ciudads.
	 *
	 * @return the ciudads
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ciudad> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Ciudad> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Ciudad> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Ciudad> list = (List<Ciudad>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CIUDAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CIUDAD.concat(CiudadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Ciudad>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Ciudad>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ciudads where id_departamento = &#63; from the database.
	 *
	 * @param id_departamento the id_departamento
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBydepartamento(int id_departamento)
		throws SystemException {
		for (Ciudad ciudad : findBydepartamento(id_departamento)) {
			remove(ciudad);
		}
	}

	/**
	 * Removes all the ciudads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Ciudad ciudad : findAll()) {
			remove(ciudad);
		}
	}

	/**
	 * Returns the number of ciudads where id_departamento = &#63;.
	 *
	 * @param id_departamento the id_departamento
	 * @return the number of matching ciudads
	 * @throws SystemException if a system exception occurred
	 */
	public int countBydepartamento(int id_departamento)
		throws SystemException {
		Object[] finderArgs = new Object[] { id_departamento };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTAMENTO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CIUDAD_WHERE);

			query.append(_FINDER_COLUMN_DEPARTAMENTO_ID_DEPARTAMENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_departamento);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTAMENTO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ciudads.
	 *
	 * @return the number of ciudads
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CIUDAD);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the ciudad persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Ciudad")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Ciudad>> listenersList = new ArrayList<ModelListener<Ciudad>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Ciudad>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CiudadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CiudadPersistence.class)
	protected CiudadPersistence ciudadPersistence;
	@BeanReference(type = DelegadoPersistence.class)
	protected DelegadoPersistence delegadoPersistence;
	@BeanReference(type = DepartamentoPersistence.class)
	protected DepartamentoPersistence departamentoPersistence;
	@BeanReference(type = EntidadPersistence.class)
	protected EntidadPersistence entidadPersistence;
	@BeanReference(type = EspecialidadPersistence.class)
	protected EspecialidadPersistence especialidadPersistence;
	@BeanReference(type = EstadoPersistence.class)
	protected EstadoPersistence estadoPersistence;
	@BeanReference(type = FechaNoHabilPersistence.class)
	protected FechaNoHabilPersistence fechaNoHabilPersistence;
	@BeanReference(type = ImplicadoPersistence.class)
	protected ImplicadoPersistence implicadoPersistence;
	@BeanReference(type = ParametrosPersistence.class)
	protected ParametrosPersistence parametrosPersistence;
	@BeanReference(type = PerfilImplicadoPersistence.class)
	protected PerfilImplicadoPersistence perfilImplicadoPersistence;
	@BeanReference(type = ResponsableRespuestaPersistence.class)
	protected ResponsableRespuestaPersistence responsableRespuestaPersistence;
	@BeanReference(type = SolicitantePersistence.class)
	protected SolicitantePersistence solicitantePersistence;
	@BeanReference(type = SolicitudPersistence.class)
	protected SolicitudPersistence solicitudPersistence;
	@BeanReference(type = TipoDocumentoPersistence.class)
	protected TipoDocumentoPersistence tipoDocumentoPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CIUDAD = "SELECT ciudad FROM Ciudad ciudad";
	private static final String _SQL_SELECT_CIUDAD_WHERE = "SELECT ciudad FROM Ciudad ciudad WHERE ";
	private static final String _SQL_COUNT_CIUDAD = "SELECT COUNT(ciudad) FROM Ciudad ciudad";
	private static final String _SQL_COUNT_CIUDAD_WHERE = "SELECT COUNT(ciudad) FROM Ciudad ciudad WHERE ";
	private static final String _FINDER_COLUMN_DEPARTAMENTO_ID_DEPARTAMENTO_2 = "ciudad.id_departamento = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ciudad.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Ciudad exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Ciudad exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CiudadPersistenceImpl.class);
	private static Ciudad _nullCiudad = new CiudadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Ciudad> toCacheModel() {
				return _nullCiudadCacheModel;
			}
		};

	private static CacheModel<Ciudad> _nullCiudadCacheModel = new CacheModel<Ciudad>() {
			public Ciudad toEntityModel() {
				return _nullCiudad;
			}
		};
}