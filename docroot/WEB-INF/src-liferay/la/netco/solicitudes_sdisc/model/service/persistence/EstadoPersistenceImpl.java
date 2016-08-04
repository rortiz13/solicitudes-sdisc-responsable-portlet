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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import la.netco.solicitudes_sdisc.model.NoSuchEstadoException;
import la.netco.solicitudes_sdisc.model.model.Estado;
import la.netco.solicitudes_sdisc.model.model.impl.EstadoImpl;
import la.netco.solicitudes_sdisc.model.model.impl.EstadoModelImpl;
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
 * The persistence implementation for the estado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see EstadoPersistence
 * @see EstadoUtil
 * @generated
 */
public class EstadoPersistenceImpl extends BasePersistenceImpl<Estado>
	implements EstadoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EstadoUtil} to access the estado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EstadoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_NOMBRE = new FinderPath(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoModelImpl.FINDER_CACHE_ENABLED, EstadoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNombre",
			new String[] { String.class.getName() },
			EstadoModelImpl.NOMBRE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOMBRE = new FinderPath(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNombre",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoModelImpl.FINDER_CACHE_ENABLED, EstadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoModelImpl.FINDER_CACHE_ENABLED, EstadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the estado in the entity cache if it is enabled.
	 *
	 * @param estado the estado
	 */
	public void cacheResult(Estado estado) {
		EntityCacheUtil.putResult(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoImpl.class, estado.getPrimaryKey(), estado);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOMBRE,
			new Object[] { estado.getNombre() }, estado);

		estado.resetOriginalValues();
	}

	/**
	 * Caches the estados in the entity cache if it is enabled.
	 *
	 * @param estados the estados
	 */
	public void cacheResult(List<Estado> estados) {
		for (Estado estado : estados) {
			if (EntityCacheUtil.getResult(
						EstadoModelImpl.ENTITY_CACHE_ENABLED, EstadoImpl.class,
						estado.getPrimaryKey()) == null) {
				cacheResult(estado);
			}
			else {
				estado.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all estados.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EstadoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EstadoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the estado.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Estado estado) {
		EntityCacheUtil.removeResult(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoImpl.class, estado.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(estado);
	}

	@Override
	public void clearCache(List<Estado> estados) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Estado estado : estados) {
			EntityCacheUtil.removeResult(EstadoModelImpl.ENTITY_CACHE_ENABLED,
				EstadoImpl.class, estado.getPrimaryKey());

			clearUniqueFindersCache(estado);
		}
	}

	protected void clearUniqueFindersCache(Estado estado) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOMBRE,
			new Object[] { estado.getNombre() });
	}

	/**
	 * Creates a new estado with the primary key. Does not add the estado to the database.
	 *
	 * @param id_estado the primary key for the new estado
	 * @return the new estado
	 */
	public Estado create(int id_estado) {
		Estado estado = new EstadoImpl();

		estado.setNew(true);
		estado.setPrimaryKey(id_estado);

		return estado;
	}

	/**
	 * Removes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_estado the primary key of the estado
	 * @return the estado that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a estado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Estado remove(int id_estado)
		throws NoSuchEstadoException, SystemException {
		return remove(Integer.valueOf(id_estado));
	}

	/**
	 * Removes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the estado
	 * @return the estado that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a estado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Estado remove(Serializable primaryKey)
		throws NoSuchEstadoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Estado estado = (Estado)session.get(EstadoImpl.class, primaryKey);

			if (estado == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEstadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(estado);
		}
		catch (NoSuchEstadoException nsee) {
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
	protected Estado removeImpl(Estado estado) throws SystemException {
		estado = toUnwrappedModel(estado);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, estado);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(estado);

		return estado;
	}

	@Override
	public Estado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Estado estado, boolean merge)
		throws SystemException {
		estado = toUnwrappedModel(estado);

		boolean isNew = estado.isNew();

		EstadoModelImpl estadoModelImpl = (EstadoModelImpl)estado;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, estado, merge);

			estado.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EstadoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EstadoModelImpl.ENTITY_CACHE_ENABLED,
			EstadoImpl.class, estado.getPrimaryKey(), estado);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOMBRE,
				new Object[] { estado.getNombre() }, estado);
		}
		else {
			if ((estadoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NOMBRE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { estadoModelImpl.getOriginalNombre() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOMBRE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOMBRE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOMBRE,
					new Object[] { estado.getNombre() }, estado);
			}
		}

		return estado;
	}

	protected Estado toUnwrappedModel(Estado estado) {
		if (estado instanceof EstadoImpl) {
			return estado;
		}

		EstadoImpl estadoImpl = new EstadoImpl();

		estadoImpl.setNew(estado.isNew());
		estadoImpl.setPrimaryKey(estado.getPrimaryKey());

		estadoImpl.setId_estado(estado.getId_estado());
		estadoImpl.setNombre(estado.getNombre());

		return estadoImpl;
	}

	/**
	 * Returns the estado with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the estado
	 * @return the estado
	 * @throws com.liferay.portal.NoSuchModelException if a estado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Estado findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the estado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEstadoException} if it could not be found.
	 *
	 * @param id_estado the primary key of the estado
	 * @return the estado
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a estado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Estado findByPrimaryKey(int id_estado)
		throws NoSuchEstadoException, SystemException {
		Estado estado = fetchByPrimaryKey(id_estado);

		if (estado == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_estado);
			}

			throw new NoSuchEstadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_estado);
		}

		return estado;
	}

	/**
	 * Returns the estado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the estado
	 * @return the estado, or <code>null</code> if a estado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Estado fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the estado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_estado the primary key of the estado
	 * @return the estado, or <code>null</code> if a estado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Estado fetchByPrimaryKey(int id_estado) throws SystemException {
		Estado estado = (Estado)EntityCacheUtil.getResult(EstadoModelImpl.ENTITY_CACHE_ENABLED,
				EstadoImpl.class, id_estado);

		if (estado == _nullEstado) {
			return null;
		}

		if (estado == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				estado = (Estado)session.get(EstadoImpl.class,
						Integer.valueOf(id_estado));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (estado != null) {
					cacheResult(estado);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EstadoModelImpl.ENTITY_CACHE_ENABLED,
						EstadoImpl.class, id_estado, _nullEstado);
				}

				closeSession(session);
			}
		}

		return estado;
	}

	/**
	 * Returns the estado where nombre = &#63; or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEstadoException} if it could not be found.
	 *
	 * @param nombre the nombre
	 * @return the matching estado
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEstadoException if a matching estado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Estado findByNombre(String nombre)
		throws NoSuchEstadoException, SystemException {
		Estado estado = fetchByNombre(nombre);

		if (estado == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nombre=");
			msg.append(nombre);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEstadoException(msg.toString());
		}

		return estado;
	}

	/**
	 * Returns the estado where nombre = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nombre the nombre
	 * @return the matching estado, or <code>null</code> if a matching estado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Estado fetchByNombre(String nombre) throws SystemException {
		return fetchByNombre(nombre, true);
	}

	/**
	 * Returns the estado where nombre = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nombre the nombre
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching estado, or <code>null</code> if a matching estado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Estado fetchByNombre(String nombre, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { nombre };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NOMBRE,
					finderArgs, this);
		}

		if (result instanceof Estado) {
			Estado estado = (Estado)result;

			if (!Validator.equals(nombre, estado.getNombre())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESTADO_WHERE);

			if (nombre == null) {
				query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_1);
			}
			else {
				if (nombre.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
				}
				else {
					query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
				}
			}

			query.append(EstadoModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (nombre != null) {
					qPos.add(nombre);
				}

				List<Estado> list = q.list();

				result = list;

				Estado estado = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOMBRE,
						finderArgs, list);
				}
				else {
					estado = list.get(0);

					cacheResult(estado);

					if ((estado.getNombre() == null) ||
							!estado.getNombre().equals(nombre)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOMBRE,
							finderArgs, estado);
					}
				}

				return estado;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOMBRE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Estado)result;
			}
		}
	}

	/**
	 * Returns all the estados.
	 *
	 * @return the estados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Estado> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the estados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of estados
	 * @param end the upper bound of the range of estados (not inclusive)
	 * @return the range of estados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Estado> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the estados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of estados
	 * @param end the upper bound of the range of estados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of estados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Estado> findAll(int start, int end,
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

		List<Estado> list = (List<Estado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESTADO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESTADO.concat(EstadoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Estado>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Estado>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes the estado where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 * @return the estado that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Estado removeByNombre(String nombre)
		throws NoSuchEstadoException, SystemException {
		Estado estado = findByNombre(nombre);

		return remove(estado);
	}

	/**
	 * Removes all the estados from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Estado estado : findAll()) {
			remove(estado);
		}
	}

	/**
	 * Returns the number of estados where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching estados
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNombre(String nombre) throws SystemException {
		Object[] finderArgs = new Object[] { nombre };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOMBRE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESTADO_WHERE);

			if (nombre == null) {
				query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_1);
			}
			else {
				if (nombre.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
				}
				else {
					query.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (nombre != null) {
					qPos.add(nombre);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOMBRE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of estados.
	 *
	 * @return the number of estados
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ESTADO);

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
	 * Initializes the estado persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Estado")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Estado>> listenersList = new ArrayList<ModelListener<Estado>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Estado>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EstadoImpl.class.getName());
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
	private static final String _SQL_SELECT_ESTADO = "SELECT estado FROM Estado estado";
	private static final String _SQL_SELECT_ESTADO_WHERE = "SELECT estado FROM Estado estado WHERE ";
	private static final String _SQL_COUNT_ESTADO = "SELECT COUNT(estado) FROM Estado estado";
	private static final String _SQL_COUNT_ESTADO_WHERE = "SELECT COUNT(estado) FROM Estado estado WHERE ";
	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_1 = "estado.nombre IS NULL";
	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_2 = "estado.nombre = ?";
	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 = "(estado.nombre IS NULL OR estado.nombre = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "estado.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Estado exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Estado exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EstadoPersistenceImpl.class);
	private static Estado _nullEstado = new EstadoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Estado> toCacheModel() {
				return _nullEstadoCacheModel;
			}
		};

	private static CacheModel<Estado> _nullEstadoCacheModel = new CacheModel<Estado>() {
			public Estado toEntityModel() {
				return _nullEstado;
			}
		};
}