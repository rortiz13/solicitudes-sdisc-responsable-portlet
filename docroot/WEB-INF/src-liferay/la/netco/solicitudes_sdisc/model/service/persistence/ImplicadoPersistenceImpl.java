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

import la.netco.solicitudes_sdisc.model.NoSuchImplicadoException;
import la.netco.solicitudes_sdisc.model.model.Implicado;
import la.netco.solicitudes_sdisc.model.model.impl.ImplicadoImpl;
import la.netco.solicitudes_sdisc.model.model.impl.ImplicadoModelImpl;
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
 * The persistence implementation for the implicado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author smontanez
 * @see ImplicadoPersistence
 * @see ImplicadoUtil
 * @generated
 */
public class ImplicadoPersistenceImpl extends BasePersistenceImpl<Implicado>
	implements ImplicadoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImplicadoUtil} to access the implicado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImplicadoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
			ImplicadoModelImpl.FINDER_CACHE_ENABLED, ImplicadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
			ImplicadoModelImpl.FINDER_CACHE_ENABLED, ImplicadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
			ImplicadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the implicado in the entity cache if it is enabled.
	 *
	 * @param implicado the implicado
	 */
	public void cacheResult(Implicado implicado) {
		EntityCacheUtil.putResult(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
			ImplicadoImpl.class, implicado.getPrimaryKey(), implicado);

		implicado.resetOriginalValues();
	}

	/**
	 * Caches the implicados in the entity cache if it is enabled.
	 *
	 * @param implicados the implicados
	 */
	public void cacheResult(List<Implicado> implicados) {
		for (Implicado implicado : implicados) {
			if (EntityCacheUtil.getResult(
						ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
						ImplicadoImpl.class, implicado.getPrimaryKey()) == null) {
				cacheResult(implicado);
			}
			else {
				implicado.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all implicados.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImplicadoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImplicadoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the implicado.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Implicado implicado) {
		EntityCacheUtil.removeResult(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
			ImplicadoImpl.class, implicado.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Implicado> implicados) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Implicado implicado : implicados) {
			EntityCacheUtil.removeResult(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
				ImplicadoImpl.class, implicado.getPrimaryKey());
		}
	}

	/**
	 * Creates a new implicado with the primary key. Does not add the implicado to the database.
	 *
	 * @param id_implicado the primary key for the new implicado
	 * @return the new implicado
	 */
	public Implicado create(int id_implicado) {
		Implicado implicado = new ImplicadoImpl();

		implicado.setNew(true);
		implicado.setPrimaryKey(id_implicado);

		return implicado;
	}

	/**
	 * Removes the implicado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_implicado the primary key of the implicado
	 * @return the implicado that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Implicado remove(int id_implicado)
		throws NoSuchImplicadoException, SystemException {
		return remove(Integer.valueOf(id_implicado));
	}

	/**
	 * Removes the implicado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the implicado
	 * @return the implicado that was removed
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Implicado remove(Serializable primaryKey)
		throws NoSuchImplicadoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Implicado implicado = (Implicado)session.get(ImplicadoImpl.class,
					primaryKey);

			if (implicado == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImplicadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(implicado);
		}
		catch (NoSuchImplicadoException nsee) {
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
	protected Implicado removeImpl(Implicado implicado)
		throws SystemException {
		implicado = toUnwrappedModel(implicado);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, implicado);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(implicado);

		return implicado;
	}

	@Override
	public Implicado updateImpl(
		la.netco.solicitudes_sdisc.model.model.Implicado implicado,
		boolean merge) throws SystemException {
		implicado = toUnwrappedModel(implicado);

		boolean isNew = implicado.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, implicado, merge);

			implicado.setNew(false);
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

		EntityCacheUtil.putResult(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
			ImplicadoImpl.class, implicado.getPrimaryKey(), implicado);

		return implicado;
	}

	protected Implicado toUnwrappedModel(Implicado implicado) {
		if (implicado instanceof ImplicadoImpl) {
			return implicado;
		}

		ImplicadoImpl implicadoImpl = new ImplicadoImpl();

		implicadoImpl.setNew(implicado.isNew());
		implicadoImpl.setPrimaryKey(implicado.getPrimaryKey());

		implicadoImpl.setId_implicado(implicado.getId_implicado());
		implicadoImpl.setNombre(implicado.getNombre());
		implicadoImpl.setDespacho_entidad(implicado.getDespacho_entidad());
		implicadoImpl.setId_perfil(implicado.getId_perfil());
		implicadoImpl.setId_ciudad(implicado.getId_ciudad());
		implicadoImpl.setCod_entidad(implicado.getCod_entidad());
		implicadoImpl.setCod_especialidad(implicado.getCod_especialidad());
		implicadoImpl.setId_delegado(implicado.getId_delegado());

		return implicadoImpl;
	}

	/**
	 * Returns the implicado with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the implicado
	 * @return the implicado
	 * @throws com.liferay.portal.NoSuchModelException if a implicado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Implicado findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the implicado with the primary key or throws a {@link la.netco.solicitudes_sdisc.model.NoSuchImplicadoException} if it could not be found.
	 *
	 * @param id_implicado the primary key of the implicado
	 * @return the implicado
	 * @throws la.netco.solicitudes_sdisc.model.NoSuchImplicadoException if a implicado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Implicado findByPrimaryKey(int id_implicado)
		throws NoSuchImplicadoException, SystemException {
		Implicado implicado = fetchByPrimaryKey(id_implicado);

		if (implicado == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id_implicado);
			}

			throw new NoSuchImplicadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id_implicado);
		}

		return implicado;
	}

	/**
	 * Returns the implicado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the implicado
	 * @return the implicado, or <code>null</code> if a implicado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Implicado fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the implicado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_implicado the primary key of the implicado
	 * @return the implicado, or <code>null</code> if a implicado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Implicado fetchByPrimaryKey(int id_implicado)
		throws SystemException {
		Implicado implicado = (Implicado)EntityCacheUtil.getResult(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
				ImplicadoImpl.class, id_implicado);

		if (implicado == _nullImplicado) {
			return null;
		}

		if (implicado == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				implicado = (Implicado)session.get(ImplicadoImpl.class,
						Integer.valueOf(id_implicado));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (implicado != null) {
					cacheResult(implicado);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ImplicadoModelImpl.ENTITY_CACHE_ENABLED,
						ImplicadoImpl.class, id_implicado, _nullImplicado);
				}

				closeSession(session);
			}
		}

		return implicado;
	}

	/**
	 * Returns all the implicados.
	 *
	 * @return the implicados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Implicado> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the implicados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of implicados
	 * @param end the upper bound of the range of implicados (not inclusive)
	 * @return the range of implicados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Implicado> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the implicados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of implicados
	 * @param end the upper bound of the range of implicados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of implicados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Implicado> findAll(int start, int end,
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

		List<Implicado> list = (List<Implicado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMPLICADO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPLICADO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Implicado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Implicado>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the implicados from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Implicado implicado : findAll()) {
			remove(implicado);
		}
	}

	/**
	 * Returns the number of implicados.
	 *
	 * @return the number of implicados
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMPLICADO);

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
	 * Initializes the implicado persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.la.netco.solicitudes_sdisc.model.model.Implicado")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Implicado>> listenersList = new ArrayList<ModelListener<Implicado>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Implicado>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImplicadoImpl.class.getName());
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
	private static final String _SQL_SELECT_IMPLICADO = "SELECT implicado FROM Implicado implicado";
	private static final String _SQL_COUNT_IMPLICADO = "SELECT COUNT(implicado) FROM Implicado implicado";
	private static final String _ORDER_BY_ENTITY_ALIAS = "implicado.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Implicado exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImplicadoPersistenceImpl.class);
	private static Implicado _nullImplicado = new ImplicadoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Implicado> toCacheModel() {
				return _nullImplicadoCacheModel;
			}
		};

	private static CacheModel<Implicado> _nullImplicadoCacheModel = new CacheModel<Implicado>() {
			public Implicado toEntityModel() {
				return _nullImplicado;
			}
		};
}