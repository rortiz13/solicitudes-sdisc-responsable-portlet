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

import la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException;
import la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta;
import la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaImpl;
import la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaModelImpl;
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
 * The persistence implementation for the responsable respuesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ResponsableRespuestaPersistence
 * @see ResponsableRespuestaUtil
 * @generated
 */
public class ResponsableRespuestaPersistenceImpl extends BasePersistenceImpl<ResponsableRespuesta>
	implements ResponsableRespuestaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResponsableRespuestaUtil} to access the responsable respuesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResponsableRespuestaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
			ResponsableRespuestaModelImpl.FINDER_CACHE_ENABLED,
			ResponsableRespuestaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
			ResponsableRespuestaModelImpl.FINDER_CACHE_ENABLED,
			ResponsableRespuestaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
			ResponsableRespuestaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the responsable respuesta in the entity cache if it is enabled.
	 *
	 * @param responsableRespuesta the responsable respuesta
	 */
	public void cacheResult(ResponsableRespuesta responsableRespuesta) {
		EntityCacheUtil.putResult(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
			ResponsableRespuestaImpl.class,
			responsableRespuesta.getPrimaryKey(), responsableRespuesta);

		responsableRespuesta.resetOriginalValues();
	}

	/**
	 * Caches the responsable respuestas in the entity cache if it is enabled.
	 *
	 * @param responsableRespuestas the responsable respuestas
	 */
	public void cacheResult(List<ResponsableRespuesta> responsableRespuestas) {
		for (ResponsableRespuesta responsableRespuesta : responsableRespuestas) {
			if (EntityCacheUtil.getResult(
						ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
						ResponsableRespuestaImpl.class,
						responsableRespuesta.getPrimaryKey()) == null) {
				cacheResult(responsableRespuesta);
			}
			else {
				responsableRespuesta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all responsable respuestas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResponsableRespuestaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResponsableRespuestaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the responsable respuesta.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResponsableRespuesta responsableRespuesta) {
		EntityCacheUtil.removeResult(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
			ResponsableRespuestaImpl.class, responsableRespuesta.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ResponsableRespuesta> responsableRespuestas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResponsableRespuesta responsableRespuesta : responsableRespuestas) {
			EntityCacheUtil.removeResult(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
				ResponsableRespuestaImpl.class,
				responsableRespuesta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new responsable respuesta with the primary key. Does not add the responsable respuesta to the database.
	 *
	 * @param id_responsable the primary key for the new responsable respuesta
	 * @return the new responsable respuesta
	 */
	public ResponsableRespuesta create(int id_responsable) {
		ResponsableRespuesta responsableRespuesta = new ResponsableRespuestaImpl();

		responsableRespuesta.setNew(true);
		responsableRespuesta.setPrimaryKey(id_responsable);

		return responsableRespuesta;
	}

	/**
	 * Removes the responsable respuesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_responsable the primary key of the responsable respuesta
	 * @return the responsable respuesta that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResponsableRespuesta remove(int id_responsable)
		throws NoSuchResponsableRespuestaException, SystemException {
		return remove(Integer.valueOf(id_responsable));
	}

	/**
	 * Removes the responsable respuesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the responsable respuesta
	 * @return the responsable respuesta that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResponsableRespuesta remove(Serializable primaryKey)
		throws NoSuchResponsableRespuestaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResponsableRespuesta responsableRespuesta = (ResponsableRespuesta)session.get(ResponsableRespuestaImpl.class,
					primaryKey);

			if (responsableRespuesta == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResponsableRespuestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(responsableRespuesta);
		}
		catch (NoSuchResponsableRespuestaException nsee) {
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
	protected ResponsableRespuesta removeImpl(
		ResponsableRespuesta responsableRespuesta) throws SystemException {
		responsableRespuesta = toUnwrappedModel(responsableRespuesta);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, responsableRespuesta);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(responsableRespuesta);

		return responsableRespuesta;
	}

	@Override
	public ResponsableRespuesta updateImpl(
		la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta responsableRespuesta,
		boolean merge) throws SystemException {
		responsableRespuesta = toUnwrappedModel(responsableRespuesta);

		boolean isNew = responsableRespuesta.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, responsableRespuesta, merge);

			responsableRespuesta.setNew(false);
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

		EntityCacheUtil.putResult(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
			ResponsableRespuestaImpl.class,
			responsableRespuesta.getPrimaryKey(), responsableRespuesta);

		return responsableRespuesta;
	}

	protected ResponsableRespuesta toUnwrappedModel(
		ResponsableRespuesta responsableRespuesta) {
		if (responsableRespuesta instanceof ResponsableRespuestaImpl) {
			return responsableRespuesta;
		}

		ResponsableRespuestaImpl responsableRespuestaImpl = new ResponsableRespuestaImpl();

		responsableRespuestaImpl.setNew(responsableRespuesta.isNew());
		responsableRespuestaImpl.setPrimaryKey(responsableRespuesta.getPrimaryKey());

		responsableRespuestaImpl.setId_responsable(responsableRespuesta.getId_responsable());
		responsableRespuestaImpl.setRespuesta(responsableRespuesta.getRespuesta());
		responsableRespuestaImpl.setFecha_respuesta(responsableRespuesta.getFecha_respuesta());
		responsableRespuestaImpl.setNombre_usuario(responsableRespuesta.getNombre_usuario());
		responsableRespuestaImpl.setId_solicitud(responsableRespuesta.getId_solicitud());

		return responsableRespuestaImpl;
	}

	/**
	 * Returns the responsable respuesta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the responsable respuesta
	 * @return the responsable respuesta
	 * @throws com.liferay.portal.NoSuchModelException if a responsable respuesta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResponsableRespuesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the responsable respuesta with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException} if it could not be found.
	 *
	 * @param id_responsable the primary key of the responsable respuesta
	 * @return the responsable respuesta
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException if a responsable respuesta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResponsableRespuesta findByPrimaryKey(int id_responsable)
		throws NoSuchResponsableRespuestaException, SystemException {
		ResponsableRespuesta responsableRespuesta = fetchByPrimaryKey(id_responsable);

		if (responsableRespuesta == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_responsable);
			}

			throw new NoSuchResponsableRespuestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_responsable);
		}

		return responsableRespuesta;
	}

	/**
	 * Returns the responsable respuesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the responsable respuesta
	 * @return the responsable respuesta, or <code>null</code> if a responsable respuesta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResponsableRespuesta fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the responsable respuesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_responsable the primary key of the responsable respuesta
	 * @return the responsable respuesta, or <code>null</code> if a responsable respuesta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResponsableRespuesta fetchByPrimaryKey(int id_responsable)
		throws SystemException {
		ResponsableRespuesta responsableRespuesta = (ResponsableRespuesta)EntityCacheUtil.getResult(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
				ResponsableRespuestaImpl.class, id_responsable);

		if (responsableRespuesta == _nullResponsableRespuesta) {
			return null;
		}

		if (responsableRespuesta == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				responsableRespuesta = (ResponsableRespuesta)session.get(ResponsableRespuestaImpl.class,
						Integer.valueOf(id_responsable));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (responsableRespuesta != null) {
					cacheResult(responsableRespuesta);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ResponsableRespuestaModelImpl.ENTITY_CACHE_ENABLED,
						ResponsableRespuestaImpl.class, id_responsable,
						_nullResponsableRespuesta);
				}

				closeSession(session);
			}
		}

		return responsableRespuesta;
	}

	/**
	 * Returns all the responsable respuestas.
	 *
	 * @return the responsable respuestas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResponsableRespuesta> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the responsable respuestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsable respuestas
	 * @param end the upper bound of the range of responsable respuestas (not inclusive)
	 * @return the range of responsable respuestas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResponsableRespuesta> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the responsable respuestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of responsable respuestas
	 * @param end the upper bound of the range of responsable respuestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of responsable respuestas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResponsableRespuesta> findAll(int start, int end,
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

		List<ResponsableRespuesta> list = (List<ResponsableRespuesta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESPONSABLERESPUESTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESPONSABLERESPUESTA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ResponsableRespuesta>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ResponsableRespuesta>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the responsable respuestas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ResponsableRespuesta responsableRespuesta : findAll()) {
			remove(responsableRespuesta);
		}
	}

	/**
	 * Returns the number of responsable respuestas.
	 *
	 * @return the number of responsable respuestas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESPONSABLERESPUESTA);

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
	 * Initializes the responsable respuesta persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.ResponsableRespuesta")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResponsableRespuesta>> listenersList = new ArrayList<ModelListener<ResponsableRespuesta>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResponsableRespuesta>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ResponsableRespuestaImpl.class.getName());
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
	private static final String _SQL_SELECT_RESPONSABLERESPUESTA = "SELECT responsableRespuesta FROM ResponsableRespuesta responsableRespuesta";
	private static final String _SQL_COUNT_RESPONSABLERESPUESTA = "SELECT COUNT(responsableRespuesta) FROM ResponsableRespuesta responsableRespuesta";
	private static final String _ORDER_BY_ENTITY_ALIAS = "responsableRespuesta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResponsableRespuesta exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResponsableRespuestaPersistenceImpl.class);
	private static ResponsableRespuesta _nullResponsableRespuesta = new ResponsableRespuestaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResponsableRespuesta> toCacheModel() {
				return _nullResponsableRespuestaCacheModel;
			}
		};

	private static CacheModel<ResponsableRespuesta> _nullResponsableRespuestaCacheModel =
		new CacheModel<ResponsableRespuesta>() {
			public ResponsableRespuesta toEntityModel() {
				return _nullResponsableRespuesta;
			}
		};
}