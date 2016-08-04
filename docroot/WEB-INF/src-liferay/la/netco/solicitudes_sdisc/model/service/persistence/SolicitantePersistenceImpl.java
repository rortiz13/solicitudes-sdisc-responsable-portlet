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

import la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException;
import la.netco.solicitudes_sdisc.model.model.Solicitante;
import la.netco.solicitudes_sdisc.model.model.impl.SolicitanteImpl;
import la.netco.solicitudes_sdisc.model.model.impl.SolicitanteModelImpl;
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
 * The persistence implementation for the solicitante service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see SolicitantePersistence
 * @see SolicitanteUtil
 * @generated
 */
public class SolicitantePersistenceImpl extends BasePersistenceImpl<Solicitante>
	implements SolicitantePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SolicitanteUtil} to access the solicitante persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SolicitanteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
			SolicitanteModelImpl.FINDER_CACHE_ENABLED, SolicitanteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
			SolicitanteModelImpl.FINDER_CACHE_ENABLED, SolicitanteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
			SolicitanteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the solicitante in the entity cache if it is enabled.
	 *
	 * @param solicitante the solicitante
	 */
	public void cacheResult(Solicitante solicitante) {
		EntityCacheUtil.putResult(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
			SolicitanteImpl.class, solicitante.getPrimaryKey(), solicitante);

		solicitante.resetOriginalValues();
	}

	/**
	 * Caches the solicitantes in the entity cache if it is enabled.
	 *
	 * @param solicitantes the solicitantes
	 */
	public void cacheResult(List<Solicitante> solicitantes) {
		for (Solicitante solicitante : solicitantes) {
			if (EntityCacheUtil.getResult(
						SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
						SolicitanteImpl.class, solicitante.getPrimaryKey()) == null) {
				cacheResult(solicitante);
			}
			else {
				solicitante.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all solicitantes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SolicitanteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SolicitanteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the solicitante.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Solicitante solicitante) {
		EntityCacheUtil.removeResult(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
			SolicitanteImpl.class, solicitante.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Solicitante> solicitantes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Solicitante solicitante : solicitantes) {
			EntityCacheUtil.removeResult(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
				SolicitanteImpl.class, solicitante.getPrimaryKey());
		}
	}

	/**
	 * Creates a new solicitante with the primary key. Does not add the solicitante to the database.
	 *
	 * @param id_solicitante the primary key for the new solicitante
	 * @return the new solicitante
	 */
	public Solicitante create(int id_solicitante) {
		Solicitante solicitante = new SolicitanteImpl();

		solicitante.setNew(true);
		solicitante.setPrimaryKey(id_solicitante);

		return solicitante;
	}

	/**
	 * Removes the solicitante with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_solicitante the primary key of the solicitante
	 * @return the solicitante that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException if a solicitante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Solicitante remove(int id_solicitante)
		throws NoSuchSolicitanteException, SystemException {
		return remove(Integer.valueOf(id_solicitante));
	}

	/**
	 * Removes the solicitante with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the solicitante
	 * @return the solicitante that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException if a solicitante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Solicitante remove(Serializable primaryKey)
		throws NoSuchSolicitanteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Solicitante solicitante = (Solicitante)session.get(SolicitanteImpl.class,
					primaryKey);

			if (solicitante == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSolicitanteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(solicitante);
		}
		catch (NoSuchSolicitanteException nsee) {
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
	protected Solicitante removeImpl(Solicitante solicitante)
		throws SystemException {
		solicitante = toUnwrappedModel(solicitante);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, solicitante);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(solicitante);

		return solicitante;
	}

	@Override
	public Solicitante updateImpl(
		la.netco.solicitudes_sdisc.model.model.Solicitante solicitante,
		boolean merge) throws SystemException {
		solicitante = toUnwrappedModel(solicitante);

		boolean isNew = solicitante.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, solicitante, merge);

			solicitante.setNew(false);
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

		EntityCacheUtil.putResult(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
			SolicitanteImpl.class, solicitante.getPrimaryKey(), solicitante);

		return solicitante;
	}

	protected Solicitante toUnwrappedModel(Solicitante solicitante) {
		if (solicitante instanceof SolicitanteImpl) {
			return solicitante;
		}

		SolicitanteImpl solicitanteImpl = new SolicitanteImpl();

		solicitanteImpl.setNew(solicitante.isNew());
		solicitanteImpl.setPrimaryKey(solicitante.getPrimaryKey());

		solicitanteImpl.setId_solicitante(solicitante.getId_solicitante());
		solicitanteImpl.setNombres(solicitante.getNombres());
		solicitanteImpl.setApellidos(solicitante.getApellidos());
		solicitanteImpl.setNum_documento(solicitante.getNum_documento());
		solicitanteImpl.setTelefono(solicitante.getTelefono());
		solicitanteImpl.setEmail(solicitante.getEmail());
		solicitanteImpl.setDireccion(solicitante.getDireccion());
		solicitanteImpl.setId_tipo_doc(solicitante.getId_tipo_doc());
		solicitanteImpl.setId_ciudad(solicitante.getId_ciudad());

		return solicitanteImpl;
	}

	/**
	 * Returns the solicitante with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitante
	 * @return the solicitante
	 * @throws com.liferay.portal.NoSuchModelException if a solicitante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Solicitante findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the solicitante with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException} if it could not be found.
	 *
	 * @param id_solicitante the primary key of the solicitante
	 * @return the solicitante
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException if a solicitante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Solicitante findByPrimaryKey(int id_solicitante)
		throws NoSuchSolicitanteException, SystemException {
		Solicitante solicitante = fetchByPrimaryKey(id_solicitante);

		if (solicitante == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_solicitante);
			}

			throw new NoSuchSolicitanteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_solicitante);
		}

		return solicitante;
	}

	/**
	 * Returns the solicitante with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitante
	 * @return the solicitante, or <code>null</code> if a solicitante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Solicitante fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the solicitante with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_solicitante the primary key of the solicitante
	 * @return the solicitante, or <code>null</code> if a solicitante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Solicitante fetchByPrimaryKey(int id_solicitante)
		throws SystemException {
		Solicitante solicitante = (Solicitante)EntityCacheUtil.getResult(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
				SolicitanteImpl.class, id_solicitante);

		if (solicitante == _nullSolicitante) {
			return null;
		}

		if (solicitante == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				solicitante = (Solicitante)session.get(SolicitanteImpl.class,
						Integer.valueOf(id_solicitante));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (solicitante != null) {
					cacheResult(solicitante);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SolicitanteModelImpl.ENTITY_CACHE_ENABLED,
						SolicitanteImpl.class, id_solicitante, _nullSolicitante);
				}

				closeSession(session);
			}
		}

		return solicitante;
	}

	/**
	 * Returns all the solicitantes.
	 *
	 * @return the solicitantes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Solicitante> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the solicitantes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitantes
	 * @param end the upper bound of the range of solicitantes (not inclusive)
	 * @return the range of solicitantes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Solicitante> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the solicitantes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitantes
	 * @param end the upper bound of the range of solicitantes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of solicitantes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Solicitante> findAll(int start, int end,
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

		List<Solicitante> list = (List<Solicitante>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOLICITANTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOLICITANTE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Solicitante>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Solicitante>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the solicitantes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Solicitante solicitante : findAll()) {
			remove(solicitante);
		}
	}

	/**
	 * Returns the number of solicitantes.
	 *
	 * @return the number of solicitantes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOLICITANTE);

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
	 * Initializes the solicitante persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Solicitante")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Solicitante>> listenersList = new ArrayList<ModelListener<Solicitante>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Solicitante>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SolicitanteImpl.class.getName());
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
	private static final String _SQL_SELECT_SOLICITANTE = "SELECT solicitante FROM Solicitante solicitante";
	private static final String _SQL_COUNT_SOLICITANTE = "SELECT COUNT(solicitante) FROM Solicitante solicitante";
	private static final String _ORDER_BY_ENTITY_ALIAS = "solicitante.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Solicitante exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SolicitantePersistenceImpl.class);
	private static Solicitante _nullSolicitante = new SolicitanteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Solicitante> toCacheModel() {
				return _nullSolicitanteCacheModel;
			}
		};

	private static CacheModel<Solicitante> _nullSolicitanteCacheModel = new CacheModel<Solicitante>() {
			public Solicitante toEntityModel() {
				return _nullSolicitante;
			}
		};
}