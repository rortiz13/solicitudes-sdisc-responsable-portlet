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

import la.netco.solicitudes_sdisc.model.NoSuchParametrosException;
import la.netco.solicitudes_sdisc.model.model.Parametros;
import la.netco.solicitudes_sdisc.model.model.impl.ParametrosImpl;
import la.netco.solicitudes_sdisc.model.model.impl.ParametrosModelImpl;
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
 * The persistence implementation for the parametros service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ParametrosPersistence
 * @see ParametrosUtil
 * @generated
 */
public class ParametrosPersistenceImpl extends BasePersistenceImpl<Parametros>
	implements ParametrosPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ParametrosUtil} to access the parametros persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ParametrosImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
			ParametrosModelImpl.FINDER_CACHE_ENABLED, ParametrosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
			ParametrosModelImpl.FINDER_CACHE_ENABLED, ParametrosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
			ParametrosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	public void cacheResult(Parametros parametros) {
		EntityCacheUtil.putResult(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
			ParametrosImpl.class, parametros.getPrimaryKey(), parametros);

		parametros.resetOriginalValues();
	}

	/**
	 * Caches the parametroses in the entity cache if it is enabled.
	 *
	 * @param parametroses the parametroses
	 */
	public void cacheResult(List<Parametros> parametroses) {
		for (Parametros parametros : parametroses) {
			if (EntityCacheUtil.getResult(
						ParametrosModelImpl.ENTITY_CACHE_ENABLED,
						ParametrosImpl.class, parametros.getPrimaryKey()) == null) {
				cacheResult(parametros);
			}
			else {
				parametros.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all parametroses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ParametrosImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ParametrosImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the parametros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametros parametros) {
		EntityCacheUtil.removeResult(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
			ParametrosImpl.class, parametros.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Parametros> parametroses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Parametros parametros : parametroses) {
			EntityCacheUtil.removeResult(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
				ParametrosImpl.class, parametros.getPrimaryKey());
		}
	}

	/**
	 * Creates a new parametros with the primary key. Does not add the parametros to the database.
	 *
	 * @param id the primary key for the new parametros
	 * @return the new parametros
	 */
	public Parametros create(int id) {
		Parametros parametros = new ParametrosImpl();

		parametros.setNew(true);
		parametros.setPrimaryKey(id);

		return parametros;
	}

	/**
	 * Removes the parametros with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the parametros
	 * @return the parametros that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchParametrosException if a parametros with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parametros remove(int id)
		throws NoSuchParametrosException, SystemException {
		return remove(Integer.valueOf(id));
	}

	/**
	 * Removes the parametros with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametros
	 * @return the parametros that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchParametrosException if a parametros with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parametros remove(Serializable primaryKey)
		throws NoSuchParametrosException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Parametros parametros = (Parametros)session.get(ParametrosImpl.class,
					primaryKey);

			if (parametros == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametrosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(parametros);
		}
		catch (NoSuchParametrosException nsee) {
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
	protected Parametros removeImpl(Parametros parametros)
		throws SystemException {
		parametros = toUnwrappedModel(parametros);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, parametros);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(parametros);

		return parametros;
	}

	@Override
	public Parametros updateImpl(
		la.netco.solicitudes_sdisc.model.model.Parametros parametros,
		boolean merge) throws SystemException {
		parametros = toUnwrappedModel(parametros);

		boolean isNew = parametros.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, parametros, merge);

			parametros.setNew(false);
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

		EntityCacheUtil.putResult(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
			ParametrosImpl.class, parametros.getPrimaryKey(), parametros);

		return parametros;
	}

	protected Parametros toUnwrappedModel(Parametros parametros) {
		if (parametros instanceof ParametrosImpl) {
			return parametros;
		}

		ParametrosImpl parametrosImpl = new ParametrosImpl();

		parametrosImpl.setNew(parametros.isNew());
		parametrosImpl.setPrimaryKey(parametros.getPrimaryKey());

		parametrosImpl.setTiempo_proximo_caducar(parametros.getTiempo_proximo_caducar());
		parametrosImpl.setTiempo_caducidad(parametros.getTiempo_caducidad());
		parametrosImpl.setEmail_resposable(parametros.getEmail_resposable());
		parametrosImpl.setMensaje_email(parametros.getMensaje_email());
		parametrosImpl.setAsunto_email(parametros.getAsunto_email());
		parametrosImpl.setId(parametros.getId());
		parametrosImpl.setRepositoryId(parametros.getRepositoryId());
		parametrosImpl.setFolderId(parametros.getFolderId());
		parametrosImpl.setUserRepositoryId(parametros.getUserRepositoryId());

		return parametrosImpl;
	}

	/**
	 * Returns the parametros with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametros
	 * @return the parametros
	 * @throws com.liferay.portal.NoSuchModelException if a parametros with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parametros findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the parametros with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchParametrosException} if it could not be found.
	 *
	 * @param id the primary key of the parametros
	 * @return the parametros
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchParametrosException if a parametros with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parametros findByPrimaryKey(int id)
		throws NoSuchParametrosException, SystemException {
		Parametros parametros = fetchByPrimaryKey(id);

		if (parametros == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchParametrosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return parametros;
	}

	/**
	 * Returns the parametros with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametros
	 * @return the parametros, or <code>null</code> if a parametros with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parametros fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the parametros with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the parametros
	 * @return the parametros, or <code>null</code> if a parametros with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parametros fetchByPrimaryKey(int id) throws SystemException {
		Parametros parametros = (Parametros)EntityCacheUtil.getResult(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
				ParametrosImpl.class, id);

		if (parametros == _nullParametros) {
			return null;
		}

		if (parametros == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				parametros = (Parametros)session.get(ParametrosImpl.class,
						Integer.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (parametros != null) {
					cacheResult(parametros);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ParametrosModelImpl.ENTITY_CACHE_ENABLED,
						ParametrosImpl.class, id, _nullParametros);
				}

				closeSession(session);
			}
		}

		return parametros;
	}

	/**
	 * Returns all the parametroses.
	 *
	 * @return the parametroses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parametros> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametroses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametroses
	 * @param end the upper bound of the range of parametroses (not inclusive)
	 * @return the range of parametroses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parametros> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametroses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametroses
	 * @param end the upper bound of the range of parametroses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametroses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parametros> findAll(int start, int end,
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

		List<Parametros> list = (List<Parametros>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PARAMETROS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETROS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Parametros>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Parametros>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the parametroses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Parametros parametros : findAll()) {
			remove(parametros);
		}
	}

	/**
	 * Returns the number of parametroses.
	 *
	 * @return the number of parametroses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PARAMETROS);

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
	 * Initializes the parametros persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Parametros")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Parametros>> listenersList = new ArrayList<ModelListener<Parametros>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Parametros>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ParametrosImpl.class.getName());
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
	private static final String _SQL_SELECT_PARAMETROS = "SELECT parametros FROM Parametros parametros";
	private static final String _SQL_COUNT_PARAMETROS = "SELECT COUNT(parametros) FROM Parametros parametros";
	private static final String _ORDER_BY_ENTITY_ALIAS = "parametros.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Parametros exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ParametrosPersistenceImpl.class);
	private static Parametros _nullParametros = new ParametrosImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Parametros> toCacheModel() {
				return _nullParametrosCacheModel;
			}
		};

	private static CacheModel<Parametros> _nullParametrosCacheModel = new CacheModel<Parametros>() {
			public Parametros toEntityModel() {
				return _nullParametros;
			}
		};
}