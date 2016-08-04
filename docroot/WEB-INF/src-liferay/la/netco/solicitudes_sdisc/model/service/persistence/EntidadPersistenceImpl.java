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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import la.netco.solicitudes_sdisc.model.NoSuchEntidadException;
import la.netco.solicitudes_sdisc.model.model.Entidad;
import la.netco.solicitudes_sdisc.model.model.impl.EntidadImpl;
import la.netco.solicitudes_sdisc.model.model.impl.EntidadModelImpl;
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
 * The persistence implementation for the entidad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see EntidadPersistence
 * @see EntidadUtil
 * @generated
 */
public class EntidadPersistenceImpl extends BasePersistenceImpl<Entidad>
	implements EntidadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EntidadUtil} to access the entidad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EntidadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntidadModelImpl.ENTITY_CACHE_ENABLED,
			EntidadModelImpl.FINDER_CACHE_ENABLED, EntidadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntidadModelImpl.ENTITY_CACHE_ENABLED,
			EntidadModelImpl.FINDER_CACHE_ENABLED, EntidadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntidadModelImpl.ENTITY_CACHE_ENABLED,
			EntidadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the entidad in the entity cache if it is enabled.
	 *
	 * @param entidad the entidad
	 */
	public void cacheResult(Entidad entidad) {
		EntityCacheUtil.putResult(EntidadModelImpl.ENTITY_CACHE_ENABLED,
			EntidadImpl.class, entidad.getPrimaryKey(), entidad);

		entidad.resetOriginalValues();
	}

	/**
	 * Caches the entidads in the entity cache if it is enabled.
	 *
	 * @param entidads the entidads
	 */
	public void cacheResult(List<Entidad> entidads) {
		for (Entidad entidad : entidads) {
			if (EntityCacheUtil.getResult(
						EntidadModelImpl.ENTITY_CACHE_ENABLED,
						EntidadImpl.class, entidad.getPrimaryKey()) == null) {
				cacheResult(entidad);
			}
			else {
				entidad.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all entidads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EntidadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EntidadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the entidad.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Entidad entidad) {
		EntityCacheUtil.removeResult(EntidadModelImpl.ENTITY_CACHE_ENABLED,
			EntidadImpl.class, entidad.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Entidad> entidads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Entidad entidad : entidads) {
			EntityCacheUtil.removeResult(EntidadModelImpl.ENTITY_CACHE_ENABLED,
				EntidadImpl.class, entidad.getPrimaryKey());
		}
	}

	/**
	 * Creates a new entidad with the primary key. Does not add the entidad to the database.
	 *
	 * @param codigo the primary key for the new entidad
	 * @return the new entidad
	 */
	public Entidad create(String codigo) {
		Entidad entidad = new EntidadImpl();

		entidad.setNew(true);
		entidad.setPrimaryKey(codigo);

		return entidad;
	}

	/**
	 * Removes the entidad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codigo the primary key of the entidad
	 * @return the entidad that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEntidadException if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entidad remove(String codigo)
		throws NoSuchEntidadException, SystemException {
		return remove((Serializable)codigo);
	}

	/**
	 * Removes the entidad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entidad
	 * @return the entidad that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEntidadException if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entidad remove(Serializable primaryKey)
		throws NoSuchEntidadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Entidad entidad = (Entidad)session.get(EntidadImpl.class, primaryKey);

			if (entidad == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntidadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(entidad);
		}
		catch (NoSuchEntidadException nsee) {
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
	protected Entidad removeImpl(Entidad entidad) throws SystemException {
		entidad = toUnwrappedModel(entidad);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, entidad);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(entidad);

		return entidad;
	}

	@Override
	public Entidad updateImpl(
		la.netco.solicitudes_sdisc.model.model.Entidad entidad, boolean merge)
		throws SystemException {
		entidad = toUnwrappedModel(entidad);

		boolean isNew = entidad.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, entidad, merge);

			entidad.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EntidadModelImpl.ENTITY_CACHE_ENABLED,
			EntidadImpl.class, entidad.getPrimaryKey(), entidad);

		return entidad;
	}

	protected Entidad toUnwrappedModel(Entidad entidad) {
		if (entidad instanceof EntidadImpl) {
			return entidad;
		}

		EntidadImpl entidadImpl = new EntidadImpl();

		entidadImpl.setNew(entidad.isNew());
		entidadImpl.setPrimaryKey(entidad.getPrimaryKey());

		entidadImpl.setCodigo(entidad.getCodigo());
		entidadImpl.setNombre(entidad.getNombre());

		return entidadImpl;
	}

	/**
	 * Returns the entidad with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the entidad
	 * @return the entidad
	 * @throws com.liferay.portal.NoSuchModelException if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entidad findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the entidad with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchEntidadException} if it could not be found.
	 *
	 * @param codigo the primary key of the entidad
	 * @return the entidad
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchEntidadException if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entidad findByPrimaryKey(String codigo)
		throws NoSuchEntidadException, SystemException {
		Entidad entidad = fetchByPrimaryKey(codigo);

		if (entidad == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + codigo);
			}

			throw new NoSuchEntidadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				codigo);
		}

		return entidad;
	}

	/**
	 * Returns the entidad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entidad
	 * @return the entidad, or <code>null</code> if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entidad fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the entidad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codigo the primary key of the entidad
	 * @return the entidad, or <code>null</code> if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entidad fetchByPrimaryKey(String codigo) throws SystemException {
		Entidad entidad = (Entidad)EntityCacheUtil.getResult(EntidadModelImpl.ENTITY_CACHE_ENABLED,
				EntidadImpl.class, codigo);

		if (entidad == _nullEntidad) {
			return null;
		}

		if (entidad == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				entidad = (Entidad)session.get(EntidadImpl.class, codigo);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (entidad != null) {
					cacheResult(entidad);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EntidadModelImpl.ENTITY_CACHE_ENABLED,
						EntidadImpl.class, codigo, _nullEntidad);
				}

				closeSession(session);
			}
		}

		return entidad;
	}

	/**
	 * Returns all the entidads.
	 *
	 * @return the entidads
	 * @throws SystemException if a system exception occurred
	 */
	public List<Entidad> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Entidad> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Entidad> findAll(int start, int end,
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

		List<Entidad> list = (List<Entidad>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENTIDAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTIDAD;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Entidad>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Entidad>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the entidads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Entidad entidad : findAll()) {
			remove(entidad);
		}
	}

	/**
	 * Returns the number of entidads.
	 *
	 * @return the number of entidads
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENTIDAD);

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
	 * Initializes the entidad persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Entidad")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Entidad>> listenersList = new ArrayList<ModelListener<Entidad>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Entidad>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EntidadImpl.class.getName());
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
	private static final String _SQL_SELECT_ENTIDAD = "SELECT entidad FROM Entidad entidad";
	private static final String _SQL_COUNT_ENTIDAD = "SELECT COUNT(entidad) FROM Entidad entidad";
	private static final String _ORDER_BY_ENTITY_ALIAS = "entidad.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Entidad exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EntidadPersistenceImpl.class);
	private static Entidad _nullEntidad = new EntidadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Entidad> toCacheModel() {
				return _nullEntidadCacheModel;
			}
		};

	private static CacheModel<Entidad> _nullEntidadCacheModel = new CacheModel<Entidad>() {
			public Entidad toEntityModel() {
				return _nullEntidad;
			}
		};
}