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

import la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException;
import la.netco.solicitudes_sdisc.model.model.FechaNoHabil;
import la.netco.solicitudes_sdisc.model.model.impl.FechaNoHabilImpl;
import la.netco.solicitudes_sdisc.model.model.impl.FechaNoHabilModelImpl;
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
 * The persistence implementation for the fecha no habil service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see FechaNoHabilPersistence
 * @see FechaNoHabilUtil
 * @generated
 */
public class FechaNoHabilPersistenceImpl extends BasePersistenceImpl<FechaNoHabil>
	implements FechaNoHabilPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FechaNoHabilUtil} to access the fecha no habil persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FechaNoHabilImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
			FechaNoHabilModelImpl.FINDER_CACHE_ENABLED, FechaNoHabilImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
			FechaNoHabilModelImpl.FINDER_CACHE_ENABLED, FechaNoHabilImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
			FechaNoHabilModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the fecha no habil in the entity cache if it is enabled.
	 *
	 * @param fechaNoHabil the fecha no habil
	 */
	public void cacheResult(FechaNoHabil fechaNoHabil) {
		EntityCacheUtil.putResult(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
			FechaNoHabilImpl.class, fechaNoHabil.getPrimaryKey(), fechaNoHabil);

		fechaNoHabil.resetOriginalValues();
	}

	/**
	 * Caches the fecha no habils in the entity cache if it is enabled.
	 *
	 * @param fechaNoHabils the fecha no habils
	 */
	public void cacheResult(List<FechaNoHabil> fechaNoHabils) {
		for (FechaNoHabil fechaNoHabil : fechaNoHabils) {
			if (EntityCacheUtil.getResult(
						FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
						FechaNoHabilImpl.class, fechaNoHabil.getPrimaryKey()) == null) {
				cacheResult(fechaNoHabil);
			}
			else {
				fechaNoHabil.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fecha no habils.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FechaNoHabilImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FechaNoHabilImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fecha no habil.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FechaNoHabil fechaNoHabil) {
		EntityCacheUtil.removeResult(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
			FechaNoHabilImpl.class, fechaNoHabil.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FechaNoHabil> fechaNoHabils) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FechaNoHabil fechaNoHabil : fechaNoHabils) {
			EntityCacheUtil.removeResult(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
				FechaNoHabilImpl.class, fechaNoHabil.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fecha no habil with the primary key. Does not add the fecha no habil to the database.
	 *
	 * @param id the primary key for the new fecha no habil
	 * @return the new fecha no habil
	 */
	public FechaNoHabil create(int id) {
		FechaNoHabil fechaNoHabil = new FechaNoHabilImpl();

		fechaNoHabil.setNew(true);
		fechaNoHabil.setPrimaryKey(id);

		return fechaNoHabil;
	}

	/**
	 * Removes the fecha no habil with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the fecha no habil
	 * @return the fecha no habil that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FechaNoHabil remove(int id)
		throws NoSuchFechaNoHabilException, SystemException {
		return remove(Integer.valueOf(id));
	}

	/**
	 * Removes the fecha no habil with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fecha no habil
	 * @return the fecha no habil that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FechaNoHabil remove(Serializable primaryKey)
		throws NoSuchFechaNoHabilException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FechaNoHabil fechaNoHabil = (FechaNoHabil)session.get(FechaNoHabilImpl.class,
					primaryKey);

			if (fechaNoHabil == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFechaNoHabilException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fechaNoHabil);
		}
		catch (NoSuchFechaNoHabilException nsee) {
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
	protected FechaNoHabil removeImpl(FechaNoHabil fechaNoHabil)
		throws SystemException {
		fechaNoHabil = toUnwrappedModel(fechaNoHabil);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, fechaNoHabil);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(fechaNoHabil);

		return fechaNoHabil;
	}

	@Override
	public FechaNoHabil updateImpl(
		la.netco.solicitudes_sdisc.model.model.FechaNoHabil fechaNoHabil,
		boolean merge) throws SystemException {
		fechaNoHabil = toUnwrappedModel(fechaNoHabil);

		boolean isNew = fechaNoHabil.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, fechaNoHabil, merge);

			fechaNoHabil.setNew(false);
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

		EntityCacheUtil.putResult(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
			FechaNoHabilImpl.class, fechaNoHabil.getPrimaryKey(), fechaNoHabil);

		return fechaNoHabil;
	}

	protected FechaNoHabil toUnwrappedModel(FechaNoHabil fechaNoHabil) {
		if (fechaNoHabil instanceof FechaNoHabilImpl) {
			return fechaNoHabil;
		}

		FechaNoHabilImpl fechaNoHabilImpl = new FechaNoHabilImpl();

		fechaNoHabilImpl.setNew(fechaNoHabil.isNew());
		fechaNoHabilImpl.setPrimaryKey(fechaNoHabil.getPrimaryKey());

		fechaNoHabilImpl.setId(fechaNoHabil.getId());
		fechaNoHabilImpl.setFecha(fechaNoHabil.getFecha());
		fechaNoHabilImpl.setNombre(fechaNoHabil.getNombre());

		return fechaNoHabilImpl;
	}

	/**
	 * Returns the fecha no habil with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fecha no habil
	 * @return the fecha no habil
	 * @throws com.liferay.portal.NoSuchModelException if a fecha no habil with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FechaNoHabil findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the fecha no habil with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException} if it could not be found.
	 *
	 * @param id the primary key of the fecha no habil
	 * @return the fecha no habil
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException if a fecha no habil with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FechaNoHabil findByPrimaryKey(int id)
		throws NoSuchFechaNoHabilException, SystemException {
		FechaNoHabil fechaNoHabil = fetchByPrimaryKey(id);

		if (fechaNoHabil == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchFechaNoHabilException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return fechaNoHabil;
	}

	/**
	 * Returns the fecha no habil with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fecha no habil
	 * @return the fecha no habil, or <code>null</code> if a fecha no habil with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FechaNoHabil fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the fecha no habil with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the fecha no habil
	 * @return the fecha no habil, or <code>null</code> if a fecha no habil with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FechaNoHabil fetchByPrimaryKey(int id) throws SystemException {
		FechaNoHabil fechaNoHabil = (FechaNoHabil)EntityCacheUtil.getResult(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
				FechaNoHabilImpl.class, id);

		if (fechaNoHabil == _nullFechaNoHabil) {
			return null;
		}

		if (fechaNoHabil == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				fechaNoHabil = (FechaNoHabil)session.get(FechaNoHabilImpl.class,
						Integer.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (fechaNoHabil != null) {
					cacheResult(fechaNoHabil);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FechaNoHabilModelImpl.ENTITY_CACHE_ENABLED,
						FechaNoHabilImpl.class, id, _nullFechaNoHabil);
				}

				closeSession(session);
			}
		}

		return fechaNoHabil;
	}

	/**
	 * Returns all the fecha no habils.
	 *
	 * @return the fecha no habils
	 * @throws SystemException if a system exception occurred
	 */
	public List<FechaNoHabil> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fecha no habils.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha no habils
	 * @param end the upper bound of the range of fecha no habils (not inclusive)
	 * @return the range of fecha no habils
	 * @throws SystemException if a system exception occurred
	 */
	public List<FechaNoHabil> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fecha no habils.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha no habils
	 * @param end the upper bound of the range of fecha no habils (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fecha no habils
	 * @throws SystemException if a system exception occurred
	 */
	public List<FechaNoHabil> findAll(int start, int end,
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

		List<FechaNoHabil> list = (List<FechaNoHabil>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FECHANOHABIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FECHANOHABIL;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FechaNoHabil>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FechaNoHabil>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fecha no habils from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FechaNoHabil fechaNoHabil : findAll()) {
			remove(fechaNoHabil);
		}
	}

	/**
	 * Returns the number of fecha no habils.
	 *
	 * @return the number of fecha no habils
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FECHANOHABIL);

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
	 * Initializes the fecha no habil persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.FechaNoHabil")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FechaNoHabil>> listenersList = new ArrayList<ModelListener<FechaNoHabil>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FechaNoHabil>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FechaNoHabilImpl.class.getName());
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
	private static final String _SQL_SELECT_FECHANOHABIL = "SELECT fechaNoHabil FROM FechaNoHabil fechaNoHabil";
	private static final String _SQL_COUNT_FECHANOHABIL = "SELECT COUNT(fechaNoHabil) FROM FechaNoHabil fechaNoHabil";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fechaNoHabil.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FechaNoHabil exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FechaNoHabilPersistenceImpl.class);
	private static FechaNoHabil _nullFechaNoHabil = new FechaNoHabilImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FechaNoHabil> toCacheModel() {
				return _nullFechaNoHabilCacheModel;
			}
		};

	private static CacheModel<FechaNoHabil> _nullFechaNoHabilCacheModel = new CacheModel<FechaNoHabil>() {
			public FechaNoHabil toEntityModel() {
				return _nullFechaNoHabil;
			}
		};
}