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

import la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException;
import la.netco.solicitudes_sdisc.model.model.TipoDocumento;
import la.netco.solicitudes_sdisc.model.model.impl.TipoDocumentoImpl;
import la.netco.solicitudes_sdisc.model.model.impl.TipoDocumentoModelImpl;
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
 * The persistence implementation for the tipo documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see TipoDocumentoPersistence
 * @see TipoDocumentoUtil
 * @generated
 */
public class TipoDocumentoPersistenceImpl extends BasePersistenceImpl<TipoDocumento>
	implements TipoDocumentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipoDocumentoUtil} to access the tipo documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipoDocumentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TipoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TipoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TipoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TipoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TipoDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tipo documento in the entity cache if it is enabled.
	 *
	 * @param tipoDocumento the tipo documento
	 */
	public void cacheResult(TipoDocumento tipoDocumento) {
		EntityCacheUtil.putResult(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey(),
			tipoDocumento);

		tipoDocumento.resetOriginalValues();
	}

	/**
	 * Caches the tipo documentos in the entity cache if it is enabled.
	 *
	 * @param tipoDocumentos the tipo documentos
	 */
	public void cacheResult(List<TipoDocumento> tipoDocumentos) {
		for (TipoDocumento tipoDocumento : tipoDocumentos) {
			if (EntityCacheUtil.getResult(
						TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey()) == null) {
				cacheResult(tipoDocumento);
			}
			else {
				tipoDocumento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipo documentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TipoDocumentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TipoDocumentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo documento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoDocumento tipoDocumento) {
		EntityCacheUtil.removeResult(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipoDocumento> tipoDocumentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipoDocumento tipoDocumento : tipoDocumentos) {
			EntityCacheUtil.removeResult(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	 *
	 * @param id_tipo_doc the primary key for the new tipo documento
	 * @return the new tipo documento
	 */
	public TipoDocumento create(int id_tipo_doc) {
		TipoDocumento tipoDocumento = new TipoDocumentoImpl();

		tipoDocumento.setNew(true);
		tipoDocumento.setPrimaryKey(id_tipo_doc);

		return tipoDocumento;
	}

	/**
	 * Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_tipo_doc the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TipoDocumento remove(int id_tipo_doc)
		throws NoSuchTipoDocumentoException, SystemException {
		return remove(Integer.valueOf(id_tipo_doc));
	}

	/**
	 * Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipoDocumento remove(Serializable primaryKey)
		throws NoSuchTipoDocumentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TipoDocumento tipoDocumento = (TipoDocumento)session.get(TipoDocumentoImpl.class,
					primaryKey);

			if (tipoDocumento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipoDocumento);
		}
		catch (NoSuchTipoDocumentoException nsee) {
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
	protected TipoDocumento removeImpl(TipoDocumento tipoDocumento)
		throws SystemException {
		tipoDocumento = toUnwrappedModel(tipoDocumento);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tipoDocumento);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tipoDocumento);

		return tipoDocumento;
	}

	@Override
	public TipoDocumento updateImpl(
		la.netco.solicitudes_sdisc.model.model.TipoDocumento tipoDocumento,
		boolean merge) throws SystemException {
		tipoDocumento = toUnwrappedModel(tipoDocumento);

		boolean isNew = tipoDocumento.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tipoDocumento, merge);

			tipoDocumento.setNew(false);
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

		EntityCacheUtil.putResult(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey(),
			tipoDocumento);

		return tipoDocumento;
	}

	protected TipoDocumento toUnwrappedModel(TipoDocumento tipoDocumento) {
		if (tipoDocumento instanceof TipoDocumentoImpl) {
			return tipoDocumento;
		}

		TipoDocumentoImpl tipoDocumentoImpl = new TipoDocumentoImpl();

		tipoDocumentoImpl.setNew(tipoDocumento.isNew());
		tipoDocumentoImpl.setPrimaryKey(tipoDocumento.getPrimaryKey());

		tipoDocumentoImpl.setId_tipo_doc(tipoDocumento.getId_tipo_doc());
		tipoDocumentoImpl.setNombre(tipoDocumento.getNombre());

		return tipoDocumentoImpl;
	}

	/**
	 * Returns the tipo documento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws com.liferay.portal.NoSuchModelException if a tipo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipoDocumento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the tipo documento with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException} if it could not be found.
	 *
	 * @param id_tipo_doc the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TipoDocumento findByPrimaryKey(int id_tipo_doc)
		throws NoSuchTipoDocumentoException, SystemException {
		TipoDocumento tipoDocumento = fetchByPrimaryKey(id_tipo_doc);

		if (tipoDocumento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_tipo_doc);
			}

			throw new NoSuchTipoDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_tipo_doc);
		}

		return tipoDocumento;
	}

	/**
	 * Returns the tipo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo documento
	 * @return the tipo documento, or <code>null</code> if a tipo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipoDocumento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the tipo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_tipo_doc the primary key of the tipo documento
	 * @return the tipo documento, or <code>null</code> if a tipo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TipoDocumento fetchByPrimaryKey(int id_tipo_doc)
		throws SystemException {
		TipoDocumento tipoDocumento = (TipoDocumento)EntityCacheUtil.getResult(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				TipoDocumentoImpl.class, id_tipo_doc);

		if (tipoDocumento == _nullTipoDocumento) {
			return null;
		}

		if (tipoDocumento == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tipoDocumento = (TipoDocumento)session.get(TipoDocumentoImpl.class,
						Integer.valueOf(id_tipo_doc));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tipoDocumento != null) {
					cacheResult(tipoDocumento);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TipoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						TipoDocumentoImpl.class, id_tipo_doc, _nullTipoDocumento);
				}

				closeSession(session);
			}
		}

		return tipoDocumento;
	}

	/**
	 * Returns all the tipo documentos.
	 *
	 * @return the tipo documentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TipoDocumento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TipoDocumento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<TipoDocumento> findAll(int start, int end,
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

		List<TipoDocumento> list = (List<TipoDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIPODOCUMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPODOCUMENTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TipoDocumento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TipoDocumento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tipo documentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TipoDocumento tipoDocumento : findAll()) {
			remove(tipoDocumento);
		}
	}

	/**
	 * Returns the number of tipo documentos.
	 *
	 * @return the number of tipo documentos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPODOCUMENTO);

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
	 * Initializes the tipo documento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.TipoDocumento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TipoDocumento>> listenersList = new ArrayList<ModelListener<TipoDocumento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TipoDocumento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TipoDocumentoImpl.class.getName());
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
	private static final String _SQL_SELECT_TIPODOCUMENTO = "SELECT tipoDocumento FROM TipoDocumento tipoDocumento";
	private static final String _SQL_COUNT_TIPODOCUMENTO = "SELECT COUNT(tipoDocumento) FROM TipoDocumento tipoDocumento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoDocumento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipoDocumento exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TipoDocumentoPersistenceImpl.class);
	private static TipoDocumento _nullTipoDocumento = new TipoDocumentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TipoDocumento> toCacheModel() {
				return _nullTipoDocumentoCacheModel;
			}
		};

	private static CacheModel<TipoDocumento> _nullTipoDocumentoCacheModel = new CacheModel<TipoDocumento>() {
			public TipoDocumento toEntityModel() {
				return _nullTipoDocumento;
			}
		};
}