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

import la.netco.solicitudes_sdisc.model.NoSuchDelegadoException;
import la.netco.solicitudes_sdisc.model.model.Delegado;
import la.netco.solicitudes_sdisc.model.model.impl.DelegadoImpl;
import la.netco.solicitudes_sdisc.model.model.impl.DelegadoModelImpl;
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
 * The persistence implementation for the delegado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see DelegadoPersistence
 * @see DelegadoUtil
 * @generated
 */
public class DelegadoPersistenceImpl extends BasePersistenceImpl<Delegado>
	implements DelegadoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DelegadoUtil} to access the delegado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DelegadoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
			DelegadoModelImpl.FINDER_CACHE_ENABLED, DelegadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
			DelegadoModelImpl.FINDER_CACHE_ENABLED, DelegadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
			DelegadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the delegado in the entity cache if it is enabled.
	 *
	 * @param delegado the delegado
	 */
	public void cacheResult(Delegado delegado) {
		EntityCacheUtil.putResult(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
			DelegadoImpl.class, delegado.getPrimaryKey(), delegado);

		delegado.resetOriginalValues();
	}

	/**
	 * Caches the delegados in the entity cache if it is enabled.
	 *
	 * @param delegados the delegados
	 */
	public void cacheResult(List<Delegado> delegados) {
		for (Delegado delegado : delegados) {
			if (EntityCacheUtil.getResult(
						DelegadoModelImpl.ENTITY_CACHE_ENABLED,
						DelegadoImpl.class, delegado.getPrimaryKey()) == null) {
				cacheResult(delegado);
			}
			else {
				delegado.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all delegados.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DelegadoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DelegadoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the delegado.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Delegado delegado) {
		EntityCacheUtil.removeResult(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
			DelegadoImpl.class, delegado.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Delegado> delegados) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Delegado delegado : delegados) {
			EntityCacheUtil.removeResult(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
				DelegadoImpl.class, delegado.getPrimaryKey());
		}
	}

	/**
	 * Creates a new delegado with the primary key. Does not add the delegado to the database.
	 *
	 * @param id_delegado the primary key for the new delegado
	 * @return the new delegado
	 */
	public Delegado create(int id_delegado) {
		Delegado delegado = new DelegadoImpl();

		delegado.setNew(true);
		delegado.setPrimaryKey(id_delegado);

		return delegado;
	}

	/**
	 * Removes the delegado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_delegado the primary key of the delegado
	 * @return the delegado that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Delegado remove(int id_delegado)
		throws NoSuchDelegadoException, SystemException {
		return remove(Integer.valueOf(id_delegado));
	}

	/**
	 * Removes the delegado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the delegado
	 * @return the delegado that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Delegado remove(Serializable primaryKey)
		throws NoSuchDelegadoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Delegado delegado = (Delegado)session.get(DelegadoImpl.class,
					primaryKey);

			if (delegado == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDelegadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(delegado);
		}
		catch (NoSuchDelegadoException nsee) {
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
	protected Delegado removeImpl(Delegado delegado) throws SystemException {
		delegado = toUnwrappedModel(delegado);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, delegado);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(delegado);

		return delegado;
	}

	@Override
	public Delegado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Delegado delegado, boolean merge)
		throws SystemException {
		delegado = toUnwrappedModel(delegado);

		boolean isNew = delegado.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, delegado, merge);

			delegado.setNew(false);
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

		EntityCacheUtil.putResult(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
			DelegadoImpl.class, delegado.getPrimaryKey(), delegado);

		return delegado;
	}

	protected Delegado toUnwrappedModel(Delegado delegado) {
		if (delegado instanceof DelegadoImpl) {
			return delegado;
		}

		DelegadoImpl delegadoImpl = new DelegadoImpl();

		delegadoImpl.setNew(delegado.isNew());
		delegadoImpl.setPrimaryKey(delegado.getPrimaryKey());

		delegadoImpl.setId_delegado(delegado.getId_delegado());
		delegadoImpl.setNombre(delegado.getNombre());

		return delegadoImpl;
	}

	/**
	 * Returns the delegado with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the delegado
	 * @return the delegado
	 * @throws com.liferay.portal.NoSuchModelException if a delegado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Delegado findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the delegado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchDelegadoException} if it could not be found.
	 *
	 * @param id_delegado the primary key of the delegado
	 * @return the delegado
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchDelegadoException if a delegado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Delegado findByPrimaryKey(int id_delegado)
		throws NoSuchDelegadoException, SystemException {
		Delegado delegado = fetchByPrimaryKey(id_delegado);

		if (delegado == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_delegado);
			}

			throw new NoSuchDelegadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_delegado);
		}

		return delegado;
	}

	/**
	 * Returns the delegado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the delegado
	 * @return the delegado, or <code>null</code> if a delegado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Delegado fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the delegado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_delegado the primary key of the delegado
	 * @return the delegado, or <code>null</code> if a delegado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Delegado fetchByPrimaryKey(int id_delegado)
		throws SystemException {
		Delegado delegado = (Delegado)EntityCacheUtil.getResult(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
				DelegadoImpl.class, id_delegado);

		if (delegado == _nullDelegado) {
			return null;
		}

		if (delegado == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				delegado = (Delegado)session.get(DelegadoImpl.class,
						Integer.valueOf(id_delegado));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (delegado != null) {
					cacheResult(delegado);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DelegadoModelImpl.ENTITY_CACHE_ENABLED,
						DelegadoImpl.class, id_delegado, _nullDelegado);
				}

				closeSession(session);
			}
		}

		return delegado;
	}

	/**
	 * Returns all the delegados.
	 *
	 * @return the delegados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Delegado> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the delegados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegados
	 * @param end the upper bound of the range of delegados (not inclusive)
	 * @return the range of delegados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Delegado> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the delegados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of delegados
	 * @param end the upper bound of the range of delegados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of delegados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Delegado> findAll(int start, int end,
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

		List<Delegado> list = (List<Delegado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DELEGADO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DELEGADO.concat(DelegadoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Delegado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Delegado>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the delegados from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Delegado delegado : findAll()) {
			remove(delegado);
		}
	}

	/**
	 * Returns the number of delegados.
	 *
	 * @return the number of delegados
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DELEGADO);

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
	 * Initializes the delegado persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Delegado")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Delegado>> listenersList = new ArrayList<ModelListener<Delegado>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Delegado>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DelegadoImpl.class.getName());
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
	private static final String _SQL_SELECT_DELEGADO = "SELECT delegado FROM Delegado delegado";
	private static final String _SQL_COUNT_DELEGADO = "SELECT COUNT(delegado) FROM Delegado delegado";
	private static final String _ORDER_BY_ENTITY_ALIAS = "delegado.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Delegado exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DelegadoPersistenceImpl.class);
	private static Delegado _nullDelegado = new DelegadoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Delegado> toCacheModel() {
				return _nullDelegadoCacheModel;
			}
		};

	private static CacheModel<Delegado> _nullDelegadoCacheModel = new CacheModel<Delegado>() {
			public Delegado toEntityModel() {
				return _nullDelegado;
			}
		};
}