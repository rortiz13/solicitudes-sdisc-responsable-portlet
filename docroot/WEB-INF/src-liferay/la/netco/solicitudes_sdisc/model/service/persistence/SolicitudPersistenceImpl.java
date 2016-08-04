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

import la.netco.solicitudes_sdisc.model.NoSuchSolicitudException;
import la.netco.solicitudes_sdisc.model.model.Solicitud;
import la.netco.solicitudes_sdisc.model.model.impl.SolicitudImpl;
import la.netco.solicitudes_sdisc.model.model.impl.SolicitudModelImpl;
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
 * The persistence implementation for the Solicitud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see SolicitudPersistence
 * @see SolicitudUtil
 * @generated
 */
public class SolicitudPersistenceImpl extends BasePersistenceImpl<Solicitud>
	implements SolicitudPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SolicitudUtil} to access the Solicitud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SolicitudImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudModelImpl.FINDER_CACHE_ENABLED, SolicitudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudModelImpl.FINDER_CACHE_ENABLED, SolicitudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Solicitud in the entity cache if it is enabled.
	 *
	 * @param solicitud the Solicitud
	 */
	public void cacheResult(Solicitud solicitud) {
		EntityCacheUtil.putResult(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudImpl.class, solicitud.getPrimaryKey(), solicitud);

		solicitud.resetOriginalValues();
	}

	/**
	 * Caches the Solicituds in the entity cache if it is enabled.
	 *
	 * @param solicituds the Solicituds
	 */
	public void cacheResult(List<Solicitud> solicituds) {
		for (Solicitud solicitud : solicituds) {
			if (EntityCacheUtil.getResult(
						SolicitudModelImpl.ENTITY_CACHE_ENABLED,
						SolicitudImpl.class, solicitud.getPrimaryKey()) == null) {
				cacheResult(solicitud);
			}
			else {
				solicitud.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Solicituds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SolicitudImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SolicitudImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Solicitud.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Solicitud solicitud) {
		EntityCacheUtil.removeResult(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudImpl.class, solicitud.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Solicitud> solicituds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Solicitud solicitud : solicituds) {
			EntityCacheUtil.removeResult(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
				SolicitudImpl.class, solicitud.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Solicitud with the primary key. Does not add the Solicitud to the database.
	 *
	 * @param id_solicitud the primary key for the new Solicitud
	 * @return the new Solicitud
	 */
	public Solicitud create(int id_solicitud) {
		Solicitud solicitud = new SolicitudImpl();

		solicitud.setNew(true);
		solicitud.setPrimaryKey(id_solicitud);

		return solicitud;
	}

	/**
	 * Removes the Solicitud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_solicitud the primary key of the Solicitud
	 * @return the Solicitud that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Solicitud remove(int id_solicitud)
		throws NoSuchSolicitudException, SystemException {
		return remove(Integer.valueOf(id_solicitud));
	}

	/**
	 * Removes the Solicitud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Solicitud
	 * @return the Solicitud that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Solicitud remove(Serializable primaryKey)
		throws NoSuchSolicitudException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Solicitud solicitud = (Solicitud)session.get(SolicitudImpl.class,
					primaryKey);

			if (solicitud == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSolicitudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(solicitud);
		}
		catch (NoSuchSolicitudException nsee) {
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
	protected Solicitud removeImpl(Solicitud solicitud)
		throws SystemException {
		solicitud = toUnwrappedModel(solicitud);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, solicitud);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(solicitud);

		return solicitud;
	}

	@Override
	public Solicitud updateImpl(
		la.netco.solicitudes_sdisc.model.model.Solicitud solicitud,
		boolean merge) throws SystemException {
		solicitud = toUnwrappedModel(solicitud);

		boolean isNew = solicitud.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, solicitud, merge);

			solicitud.setNew(false);
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

		EntityCacheUtil.putResult(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudImpl.class, solicitud.getPrimaryKey(), solicitud);

		return solicitud;
	}

	protected Solicitud toUnwrappedModel(Solicitud solicitud) {
		if (solicitud instanceof SolicitudImpl) {
			return solicitud;
		}

		SolicitudImpl solicitudImpl = new SolicitudImpl();

		solicitudImpl.setNew(solicitud.isNew());
		solicitudImpl.setPrimaryKey(solicitud.getPrimaryKey());

		solicitudImpl.setId_solicitud(solicitud.getId_solicitud());
		solicitudImpl.setHechos(solicitud.getHechos());
		solicitudImpl.setPruebas(solicitud.getPruebas());
		solicitudImpl.setId_estado(solicitud.getId_estado());
		solicitudImpl.setId_implicado(solicitud.getId_implicado());
		solicitudImpl.setId_solicitante(solicitud.getId_solicitante());
		solicitudImpl.setFechaRegistro(solicitud.getFechaRegistro());

		return solicitudImpl;
	}

	/**
	 * Returns the Solicitud with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Solicitud
	 * @return the Solicitud
	 * @throws com.liferay.portal.NoSuchModelException if a Solicitud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Solicitud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the Solicitud with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchSolicitudException} if it could not be found.
	 *
	 * @param id_solicitud the primary key of the Solicitud
	 * @return the Solicitud
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitudException if a Solicitud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Solicitud findByPrimaryKey(int id_solicitud)
		throws NoSuchSolicitudException, SystemException {
		Solicitud solicitud = fetchByPrimaryKey(id_solicitud);

		if (solicitud == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_solicitud);
			}

			throw new NoSuchSolicitudException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_solicitud);
		}

		return solicitud;
	}

	/**
	 * Returns the Solicitud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Solicitud
	 * @return the Solicitud, or <code>null</code> if a Solicitud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Solicitud fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the Solicitud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_solicitud the primary key of the Solicitud
	 * @return the Solicitud, or <code>null</code> if a Solicitud with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Solicitud fetchByPrimaryKey(int id_solicitud)
		throws SystemException {
		Solicitud solicitud = (Solicitud)EntityCacheUtil.getResult(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
				SolicitudImpl.class, id_solicitud);

		if (solicitud == _nullSolicitud) {
			return null;
		}

		if (solicitud == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				solicitud = (Solicitud)session.get(SolicitudImpl.class,
						Integer.valueOf(id_solicitud));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (solicitud != null) {
					cacheResult(solicitud);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SolicitudModelImpl.ENTITY_CACHE_ENABLED,
						SolicitudImpl.class, id_solicitud, _nullSolicitud);
				}

				closeSession(session);
			}
		}

		return solicitud;
	}

	/**
	 * Returns all the Solicituds.
	 *
	 * @return the Solicituds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Solicitud> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Solicituds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Solicituds
	 * @param end the upper bound of the range of Solicituds (not inclusive)
	 * @return the range of Solicituds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Solicitud> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Solicituds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Solicituds
	 * @param end the upper bound of the range of Solicituds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Solicituds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Solicitud> findAll(int start, int end,
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

		List<Solicitud> list = (List<Solicitud>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOLICITUD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOLICITUD;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Solicitud>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Solicitud>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Solicituds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Solicitud solicitud : findAll()) {
			remove(solicitud);
		}
	}

	/**
	 * Returns the number of Solicituds.
	 *
	 * @return the number of Solicituds
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOLICITUD);

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
	 * Initializes the Solicitud persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Solicitud")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Solicitud>> listenersList = new ArrayList<ModelListener<Solicitud>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Solicitud>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SolicitudImpl.class.getName());
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
	private static final String _SQL_SELECT_SOLICITUD = "SELECT solicitud FROM Solicitud solicitud";
	private static final String _SQL_COUNT_SOLICITUD = "SELECT COUNT(solicitud) FROM Solicitud solicitud";
	private static final String _ORDER_BY_ENTITY_ALIAS = "solicitud.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Solicitud exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SolicitudPersistenceImpl.class);
	private static Solicitud _nullSolicitud = new SolicitudImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Solicitud> toCacheModel() {
				return _nullSolicitudCacheModel;
			}
		};

	private static CacheModel<Solicitud> _nullSolicitudCacheModel = new CacheModel<Solicitud>() {
			public Solicitud toEntityModel() {
				return _nullSolicitud;
			}
		};
}