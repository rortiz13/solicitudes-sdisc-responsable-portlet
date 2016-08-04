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

import la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException;
import la.netco.solicitudes_sdisc.model.model.Departamento;
import la.netco.solicitudes_sdisc.model.model.impl.DepartamentoImpl;
import la.netco.solicitudes_sdisc.model.model.impl.DepartamentoModelImpl;
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
 * The persistence implementation for the departamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see DepartamentoPersistence
 * @see DepartamentoUtil
 * @generated
 */
public class DepartamentoPersistenceImpl extends BasePersistenceImpl<Departamento>
	implements DepartamentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DepartamentoUtil} to access the departamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DepartamentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the departamento in the entity cache if it is enabled.
	 *
	 * @param departamento the departamento
	 */
	public void cacheResult(Departamento departamento) {
		EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey(), departamento);

		departamento.resetOriginalValues();
	}

	/**
	 * Caches the departamentos in the entity cache if it is enabled.
	 *
	 * @param departamentos the departamentos
	 */
	public void cacheResult(List<Departamento> departamentos) {
		for (Departamento departamento : departamentos) {
			if (EntityCacheUtil.getResult(
						DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
						DepartamentoImpl.class, departamento.getPrimaryKey()) == null) {
				cacheResult(departamento);
			}
			else {
				departamento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all departamentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DepartamentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DepartamentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the departamento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Departamento departamento) {
		EntityCacheUtil.removeResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Departamento> departamentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Departamento departamento : departamentos) {
			EntityCacheUtil.removeResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
				DepartamentoImpl.class, departamento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new departamento with the primary key. Does not add the departamento to the database.
	 *
	 * @param id_departamento the primary key for the new departamento
	 * @return the new departamento
	 */
	public Departamento create(int id_departamento) {
		Departamento departamento = new DepartamentoImpl();

		departamento.setNew(true);
		departamento.setPrimaryKey(id_departamento);

		return departamento;
	}

	/**
	 * Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_departamento the primary key of the departamento
	 * @return the departamento that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento remove(int id_departamento)
		throws NoSuchDepartamentoException, SystemException {
		return remove(Integer.valueOf(id_departamento));
	}

	/**
	 * Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the departamento
	 * @return the departamento that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Departamento remove(Serializable primaryKey)
		throws NoSuchDepartamentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Departamento departamento = (Departamento)session.get(DepartamentoImpl.class,
					primaryKey);

			if (departamento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartamentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(departamento);
		}
		catch (NoSuchDepartamentoException nsee) {
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
	protected Departamento removeImpl(Departamento departamento)
		throws SystemException {
		departamento = toUnwrappedModel(departamento);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, departamento);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(departamento);

		return departamento;
	}

	@Override
	public Departamento updateImpl(
		la.netco.solicitudes_sdisc.model.model.Departamento departamento,
		boolean merge) throws SystemException {
		departamento = toUnwrappedModel(departamento);

		boolean isNew = departamento.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, departamento, merge);

			departamento.setNew(false);
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

		EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey(), departamento);

		return departamento;
	}

	protected Departamento toUnwrappedModel(Departamento departamento) {
		if (departamento instanceof DepartamentoImpl) {
			return departamento;
		}

		DepartamentoImpl departamentoImpl = new DepartamentoImpl();

		departamentoImpl.setNew(departamento.isNew());
		departamentoImpl.setPrimaryKey(departamento.getPrimaryKey());

		departamentoImpl.setId_departamento(departamento.getId_departamento());
		departamentoImpl.setNombre(departamento.getNombre());

		return departamentoImpl;
	}

	/**
	 * Returns the departamento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the departamento
	 * @return the departamento
	 * @throws com.liferay.portal.NoSuchModelException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Departamento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the departamento with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException} if it could not be found.
	 *
	 * @param id_departamento the primary key of the departamento
	 * @return the departamento
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento findByPrimaryKey(int id_departamento)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = fetchByPrimaryKey(id_departamento);

		if (departamento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_departamento);
			}

			throw new NoSuchDepartamentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_departamento);
		}

		return departamento;
	}

	/**
	 * Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the departamento
	 * @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Departamento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_departamento the primary key of the departamento
	 * @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento fetchByPrimaryKey(int id_departamento)
		throws SystemException {
		Departamento departamento = (Departamento)EntityCacheUtil.getResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
				DepartamentoImpl.class, id_departamento);

		if (departamento == _nullDepartamento) {
			return null;
		}

		if (departamento == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				departamento = (Departamento)session.get(DepartamentoImpl.class,
						Integer.valueOf(id_departamento));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (departamento != null) {
					cacheResult(departamento);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
						DepartamentoImpl.class, id_departamento,
						_nullDepartamento);
				}

				closeSession(session);
			}
		}

		return departamento;
	}

	/**
	 * Returns all the departamentos.
	 *
	 * @return the departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Departamento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the departamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of departamentos
	 * @param end the upper bound of the range of departamentos (not inclusive)
	 * @return the range of departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Departamento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the departamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of departamentos
	 * @param end the upper bound of the range of departamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Departamento> findAll(int start, int end,
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

		List<Departamento> list = (List<Departamento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPARTAMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTAMENTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Departamento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Departamento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the departamentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Departamento departamento : findAll()) {
			remove(departamento);
		}
	}

	/**
	 * Returns the number of departamentos.
	 *
	 * @return the number of departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEPARTAMENTO);

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
	 * Initializes the departamento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Departamento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Departamento>> listenersList = new ArrayList<ModelListener<Departamento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Departamento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DepartamentoImpl.class.getName());
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
	private static final String _SQL_SELECT_DEPARTAMENTO = "SELECT departamento FROM Departamento departamento";
	private static final String _SQL_COUNT_DEPARTAMENTO = "SELECT COUNT(departamento) FROM Departamento departamento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "departamento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Departamento exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DepartamentoPersistenceImpl.class);
	private static Departamento _nullDepartamento = new DepartamentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Departamento> toCacheModel() {
				return _nullDepartamentoCacheModel;
			}
		};

	private static CacheModel<Departamento> _nullDepartamentoCacheModel = new CacheModel<Departamento>() {
			public Departamento toEntityModel() {
				return _nullDepartamento;
			}
		};
}