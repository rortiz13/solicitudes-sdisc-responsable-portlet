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

package la.netco.solicitudes_sdisc.model.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import la.netco.solicitudes_sdisc.model.model.Entidad;
import la.netco.solicitudes_sdisc.model.service.CiudadLocalService;
import la.netco.solicitudes_sdisc.model.service.DelegadoLocalService;
import la.netco.solicitudes_sdisc.model.service.DepartamentoLocalService;
import la.netco.solicitudes_sdisc.model.service.EntidadLocalService;
import la.netco.solicitudes_sdisc.model.service.EspecialidadLocalService;
import la.netco.solicitudes_sdisc.model.service.EstadoLocalService;
import la.netco.solicitudes_sdisc.model.service.FechaNoHabilLocalService;
import la.netco.solicitudes_sdisc.model.service.ImplicadoLocalService;
import la.netco.solicitudes_sdisc.model.service.ParametrosLocalService;
import la.netco.solicitudes_sdisc.model.service.PerfilImplicadoLocalService;
import la.netco.solicitudes_sdisc.model.service.ResponsableRespuestaLocalService;
import la.netco.solicitudes_sdisc.model.service.SolicitanteLocalService;
import la.netco.solicitudes_sdisc.model.service.SolicitudLocalService;
import la.netco.solicitudes_sdisc.model.service.TipoDocumentoLocalService;
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
import la.netco.solicitudes_sdisc.model.service.persistence.SolicitudFinder;
import la.netco.solicitudes_sdisc.model.service.persistence.SolicitudPersistence;
import la.netco.solicitudes_sdisc.model.service.persistence.TipoDocumentoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the entidad local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link la.netco.solicitudes_sdisc.model.service.impl.EntidadLocalServiceImpl}.
 * </p>
 *
 * @author smontanez
 * @see la.netco.solicitudes_sdisc.model.service.impl.EntidadLocalServiceImpl
 * @see la.netco.solicitudes_sdisc.model.service.EntidadLocalServiceUtil
 * @generated
 */
public abstract class EntidadLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements EntidadLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link la.netco.solicitudes_sdisc.model.service.EntidadLocalServiceUtil} to access the entidad local service.
	 */

	/**
	 * Adds the entidad to the database. Also notifies the appropriate model listeners.
	 *
	 * @param entidad the entidad
	 * @return the entidad that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Entidad addEntidad(Entidad entidad) throws SystemException {
		entidad.setNew(true);

		return entidadPersistence.update(entidad, false);
	}

	/**
	 * Creates a new entidad with the primary key. Does not add the entidad to the database.
	 *
	 * @param codigo the primary key for the new entidad
	 * @return the new entidad
	 */
	public Entidad createEntidad(String codigo) {
		return entidadPersistence.create(codigo);
	}

	/**
	 * Deletes the entidad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codigo the primary key of the entidad
	 * @return the entidad that was removed
	 * @throws PortalException if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Entidad deleteEntidad(String codigo)
		throws PortalException, SystemException {
		return entidadPersistence.remove(codigo);
	}

	/**
	 * Deletes the entidad from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entidad the entidad
	 * @return the entidad that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Entidad deleteEntidad(Entidad entidad) throws SystemException {
		return entidadPersistence.remove(entidad);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Entidad.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return entidadPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return entidadPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return entidadPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return entidadPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Entidad fetchEntidad(String codigo) throws SystemException {
		return entidadPersistence.fetchByPrimaryKey(codigo);
	}

	/**
	 * Returns the entidad with the primary key.
	 *
	 * @param codigo the primary key of the entidad
	 * @return the entidad
	 * @throws PortalException if a entidad with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entidad getEntidad(String codigo)
		throws PortalException, SystemException {
		return entidadPersistence.findByPrimaryKey(codigo);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return entidadPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Entidad> getEntidads(int start, int end)
		throws SystemException {
		return entidadPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of entidads.
	 *
	 * @return the number of entidads
	 * @throws SystemException if a system exception occurred
	 */
	public int getEntidadsCount() throws SystemException {
		return entidadPersistence.countAll();
	}

	/**
	 * Updates the entidad in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param entidad the entidad
	 * @return the entidad that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Entidad updateEntidad(Entidad entidad) throws SystemException {
		return updateEntidad(entidad, true);
	}

	/**
	 * Updates the entidad in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param entidad the entidad
	 * @param merge whether to merge the entidad with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the entidad that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Entidad updateEntidad(Entidad entidad, boolean merge)
		throws SystemException {
		entidad.setNew(false);

		return entidadPersistence.update(entidad, merge);
	}

	/**
	 * Returns the ciudad local service.
	 *
	 * @return the ciudad local service
	 */
	public CiudadLocalService getCiudadLocalService() {
		return ciudadLocalService;
	}

	/**
	 * Sets the ciudad local service.
	 *
	 * @param ciudadLocalService the ciudad local service
	 */
	public void setCiudadLocalService(CiudadLocalService ciudadLocalService) {
		this.ciudadLocalService = ciudadLocalService;
	}

	/**
	 * Returns the ciudad persistence.
	 *
	 * @return the ciudad persistence
	 */
	public CiudadPersistence getCiudadPersistence() {
		return ciudadPersistence;
	}

	/**
	 * Sets the ciudad persistence.
	 *
	 * @param ciudadPersistence the ciudad persistence
	 */
	public void setCiudadPersistence(CiudadPersistence ciudadPersistence) {
		this.ciudadPersistence = ciudadPersistence;
	}

	/**
	 * Returns the delegado local service.
	 *
	 * @return the delegado local service
	 */
	public DelegadoLocalService getDelegadoLocalService() {
		return delegadoLocalService;
	}

	/**
	 * Sets the delegado local service.
	 *
	 * @param delegadoLocalService the delegado local service
	 */
	public void setDelegadoLocalService(
		DelegadoLocalService delegadoLocalService) {
		this.delegadoLocalService = delegadoLocalService;
	}

	/**
	 * Returns the delegado persistence.
	 *
	 * @return the delegado persistence
	 */
	public DelegadoPersistence getDelegadoPersistence() {
		return delegadoPersistence;
	}

	/**
	 * Sets the delegado persistence.
	 *
	 * @param delegadoPersistence the delegado persistence
	 */
	public void setDelegadoPersistence(DelegadoPersistence delegadoPersistence) {
		this.delegadoPersistence = delegadoPersistence;
	}

	/**
	 * Returns the departamento local service.
	 *
	 * @return the departamento local service
	 */
	public DepartamentoLocalService getDepartamentoLocalService() {
		return departamentoLocalService;
	}

	/**
	 * Sets the departamento local service.
	 *
	 * @param departamentoLocalService the departamento local service
	 */
	public void setDepartamentoLocalService(
		DepartamentoLocalService departamentoLocalService) {
		this.departamentoLocalService = departamentoLocalService;
	}

	/**
	 * Returns the departamento persistence.
	 *
	 * @return the departamento persistence
	 */
	public DepartamentoPersistence getDepartamentoPersistence() {
		return departamentoPersistence;
	}

	/**
	 * Sets the departamento persistence.
	 *
	 * @param departamentoPersistence the departamento persistence
	 */
	public void setDepartamentoPersistence(
		DepartamentoPersistence departamentoPersistence) {
		this.departamentoPersistence = departamentoPersistence;
	}

	/**
	 * Returns the entidad local service.
	 *
	 * @return the entidad local service
	 */
	public EntidadLocalService getEntidadLocalService() {
		return entidadLocalService;
	}

	/**
	 * Sets the entidad local service.
	 *
	 * @param entidadLocalService the entidad local service
	 */
	public void setEntidadLocalService(EntidadLocalService entidadLocalService) {
		this.entidadLocalService = entidadLocalService;
	}

	/**
	 * Returns the entidad persistence.
	 *
	 * @return the entidad persistence
	 */
	public EntidadPersistence getEntidadPersistence() {
		return entidadPersistence;
	}

	/**
	 * Sets the entidad persistence.
	 *
	 * @param entidadPersistence the entidad persistence
	 */
	public void setEntidadPersistence(EntidadPersistence entidadPersistence) {
		this.entidadPersistence = entidadPersistence;
	}

	/**
	 * Returns the especialidad local service.
	 *
	 * @return the especialidad local service
	 */
	public EspecialidadLocalService getEspecialidadLocalService() {
		return especialidadLocalService;
	}

	/**
	 * Sets the especialidad local service.
	 *
	 * @param especialidadLocalService the especialidad local service
	 */
	public void setEspecialidadLocalService(
		EspecialidadLocalService especialidadLocalService) {
		this.especialidadLocalService = especialidadLocalService;
	}

	/**
	 * Returns the especialidad persistence.
	 *
	 * @return the especialidad persistence
	 */
	public EspecialidadPersistence getEspecialidadPersistence() {
		return especialidadPersistence;
	}

	/**
	 * Sets the especialidad persistence.
	 *
	 * @param especialidadPersistence the especialidad persistence
	 */
	public void setEspecialidadPersistence(
		EspecialidadPersistence especialidadPersistence) {
		this.especialidadPersistence = especialidadPersistence;
	}

	/**
	 * Returns the estado local service.
	 *
	 * @return the estado local service
	 */
	public EstadoLocalService getEstadoLocalService() {
		return estadoLocalService;
	}

	/**
	 * Sets the estado local service.
	 *
	 * @param estadoLocalService the estado local service
	 */
	public void setEstadoLocalService(EstadoLocalService estadoLocalService) {
		this.estadoLocalService = estadoLocalService;
	}

	/**
	 * Returns the estado persistence.
	 *
	 * @return the estado persistence
	 */
	public EstadoPersistence getEstadoPersistence() {
		return estadoPersistence;
	}

	/**
	 * Sets the estado persistence.
	 *
	 * @param estadoPersistence the estado persistence
	 */
	public void setEstadoPersistence(EstadoPersistence estadoPersistence) {
		this.estadoPersistence = estadoPersistence;
	}

	/**
	 * Returns the fecha no habil local service.
	 *
	 * @return the fecha no habil local service
	 */
	public FechaNoHabilLocalService getFechaNoHabilLocalService() {
		return fechaNoHabilLocalService;
	}

	/**
	 * Sets the fecha no habil local service.
	 *
	 * @param fechaNoHabilLocalService the fecha no habil local service
	 */
	public void setFechaNoHabilLocalService(
		FechaNoHabilLocalService fechaNoHabilLocalService) {
		this.fechaNoHabilLocalService = fechaNoHabilLocalService;
	}

	/**
	 * Returns the fecha no habil persistence.
	 *
	 * @return the fecha no habil persistence
	 */
	public FechaNoHabilPersistence getFechaNoHabilPersistence() {
		return fechaNoHabilPersistence;
	}

	/**
	 * Sets the fecha no habil persistence.
	 *
	 * @param fechaNoHabilPersistence the fecha no habil persistence
	 */
	public void setFechaNoHabilPersistence(
		FechaNoHabilPersistence fechaNoHabilPersistence) {
		this.fechaNoHabilPersistence = fechaNoHabilPersistence;
	}

	/**
	 * Returns the implicado local service.
	 *
	 * @return the implicado local service
	 */
	public ImplicadoLocalService getImplicadoLocalService() {
		return implicadoLocalService;
	}

	/**
	 * Sets the implicado local service.
	 *
	 * @param implicadoLocalService the implicado local service
	 */
	public void setImplicadoLocalService(
		ImplicadoLocalService implicadoLocalService) {
		this.implicadoLocalService = implicadoLocalService;
	}

	/**
	 * Returns the implicado persistence.
	 *
	 * @return the implicado persistence
	 */
	public ImplicadoPersistence getImplicadoPersistence() {
		return implicadoPersistence;
	}

	/**
	 * Sets the implicado persistence.
	 *
	 * @param implicadoPersistence the implicado persistence
	 */
	public void setImplicadoPersistence(
		ImplicadoPersistence implicadoPersistence) {
		this.implicadoPersistence = implicadoPersistence;
	}

	/**
	 * Returns the parametros local service.
	 *
	 * @return the parametros local service
	 */
	public ParametrosLocalService getParametrosLocalService() {
		return parametrosLocalService;
	}

	/**
	 * Sets the parametros local service.
	 *
	 * @param parametrosLocalService the parametros local service
	 */
	public void setParametrosLocalService(
		ParametrosLocalService parametrosLocalService) {
		this.parametrosLocalService = parametrosLocalService;
	}

	/**
	 * Returns the parametros persistence.
	 *
	 * @return the parametros persistence
	 */
	public ParametrosPersistence getParametrosPersistence() {
		return parametrosPersistence;
	}

	/**
	 * Sets the parametros persistence.
	 *
	 * @param parametrosPersistence the parametros persistence
	 */
	public void setParametrosPersistence(
		ParametrosPersistence parametrosPersistence) {
		this.parametrosPersistence = parametrosPersistence;
	}

	/**
	 * Returns the perfil implicado local service.
	 *
	 * @return the perfil implicado local service
	 */
	public PerfilImplicadoLocalService getPerfilImplicadoLocalService() {
		return perfilImplicadoLocalService;
	}

	/**
	 * Sets the perfil implicado local service.
	 *
	 * @param perfilImplicadoLocalService the perfil implicado local service
	 */
	public void setPerfilImplicadoLocalService(
		PerfilImplicadoLocalService perfilImplicadoLocalService) {
		this.perfilImplicadoLocalService = perfilImplicadoLocalService;
	}

	/**
	 * Returns the perfil implicado persistence.
	 *
	 * @return the perfil implicado persistence
	 */
	public PerfilImplicadoPersistence getPerfilImplicadoPersistence() {
		return perfilImplicadoPersistence;
	}

	/**
	 * Sets the perfil implicado persistence.
	 *
	 * @param perfilImplicadoPersistence the perfil implicado persistence
	 */
	public void setPerfilImplicadoPersistence(
		PerfilImplicadoPersistence perfilImplicadoPersistence) {
		this.perfilImplicadoPersistence = perfilImplicadoPersistence;
	}

	/**
	 * Returns the responsable respuesta local service.
	 *
	 * @return the responsable respuesta local service
	 */
	public ResponsableRespuestaLocalService getResponsableRespuestaLocalService() {
		return responsableRespuestaLocalService;
	}

	/**
	 * Sets the responsable respuesta local service.
	 *
	 * @param responsableRespuestaLocalService the responsable respuesta local service
	 */
	public void setResponsableRespuestaLocalService(
		ResponsableRespuestaLocalService responsableRespuestaLocalService) {
		this.responsableRespuestaLocalService = responsableRespuestaLocalService;
	}

	/**
	 * Returns the responsable respuesta persistence.
	 *
	 * @return the responsable respuesta persistence
	 */
	public ResponsableRespuestaPersistence getResponsableRespuestaPersistence() {
		return responsableRespuestaPersistence;
	}

	/**
	 * Sets the responsable respuesta persistence.
	 *
	 * @param responsableRespuestaPersistence the responsable respuesta persistence
	 */
	public void setResponsableRespuestaPersistence(
		ResponsableRespuestaPersistence responsableRespuestaPersistence) {
		this.responsableRespuestaPersistence = responsableRespuestaPersistence;
	}

	/**
	 * Returns the solicitante local service.
	 *
	 * @return the solicitante local service
	 */
	public SolicitanteLocalService getSolicitanteLocalService() {
		return solicitanteLocalService;
	}

	/**
	 * Sets the solicitante local service.
	 *
	 * @param solicitanteLocalService the solicitante local service
	 */
	public void setSolicitanteLocalService(
		SolicitanteLocalService solicitanteLocalService) {
		this.solicitanteLocalService = solicitanteLocalService;
	}

	/**
	 * Returns the solicitante persistence.
	 *
	 * @return the solicitante persistence
	 */
	public SolicitantePersistence getSolicitantePersistence() {
		return solicitantePersistence;
	}

	/**
	 * Sets the solicitante persistence.
	 *
	 * @param solicitantePersistence the solicitante persistence
	 */
	public void setSolicitantePersistence(
		SolicitantePersistence solicitantePersistence) {
		this.solicitantePersistence = solicitantePersistence;
	}

	/**
	 * Returns the Solicitud local service.
	 *
	 * @return the Solicitud local service
	 */
	public SolicitudLocalService getSolicitudLocalService() {
		return solicitudLocalService;
	}

	/**
	 * Sets the Solicitud local service.
	 *
	 * @param solicitudLocalService the Solicitud local service
	 */
	public void setSolicitudLocalService(
		SolicitudLocalService solicitudLocalService) {
		this.solicitudLocalService = solicitudLocalService;
	}

	/**
	 * Returns the Solicitud persistence.
	 *
	 * @return the Solicitud persistence
	 */
	public SolicitudPersistence getSolicitudPersistence() {
		return solicitudPersistence;
	}

	/**
	 * Sets the Solicitud persistence.
	 *
	 * @param solicitudPersistence the Solicitud persistence
	 */
	public void setSolicitudPersistence(
		SolicitudPersistence solicitudPersistence) {
		this.solicitudPersistence = solicitudPersistence;
	}

	/**
	 * Returns the Solicitud finder.
	 *
	 * @return the Solicitud finder
	 */
	public SolicitudFinder getSolicitudFinder() {
		return solicitudFinder;
	}

	/**
	 * Sets the Solicitud finder.
	 *
	 * @param solicitudFinder the Solicitud finder
	 */
	public void setSolicitudFinder(SolicitudFinder solicitudFinder) {
		this.solicitudFinder = solicitudFinder;
	}

	/**
	 * Returns the tipo documento local service.
	 *
	 * @return the tipo documento local service
	 */
	public TipoDocumentoLocalService getTipoDocumentoLocalService() {
		return tipoDocumentoLocalService;
	}

	/**
	 * Sets the tipo documento local service.
	 *
	 * @param tipoDocumentoLocalService the tipo documento local service
	 */
	public void setTipoDocumentoLocalService(
		TipoDocumentoLocalService tipoDocumentoLocalService) {
		this.tipoDocumentoLocalService = tipoDocumentoLocalService;
	}

	/**
	 * Returns the tipo documento persistence.
	 *
	 * @return the tipo documento persistence
	 */
	public TipoDocumentoPersistence getTipoDocumentoPersistence() {
		return tipoDocumentoPersistence;
	}

	/**
	 * Sets the tipo documento persistence.
	 *
	 * @param tipoDocumentoPersistence the tipo documento persistence
	 */
	public void setTipoDocumentoPersistence(
		TipoDocumentoPersistence tipoDocumentoPersistence) {
		this.tipoDocumentoPersistence = tipoDocumentoPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("la.netco.solicitudes_sdisc.model.model.Entidad",
			entidadLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"la.netco.solicitudes_sdisc.model.model.Entidad");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Entidad.class;
	}

	protected String getModelClassName() {
		return Entidad.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = entidadPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CiudadLocalService.class)
	protected CiudadLocalService ciudadLocalService;
	@BeanReference(type = CiudadPersistence.class)
	protected CiudadPersistence ciudadPersistence;
	@BeanReference(type = DelegadoLocalService.class)
	protected DelegadoLocalService delegadoLocalService;
	@BeanReference(type = DelegadoPersistence.class)
	protected DelegadoPersistence delegadoPersistence;
	@BeanReference(type = DepartamentoLocalService.class)
	protected DepartamentoLocalService departamentoLocalService;
	@BeanReference(type = DepartamentoPersistence.class)
	protected DepartamentoPersistence departamentoPersistence;
	@BeanReference(type = EntidadLocalService.class)
	protected EntidadLocalService entidadLocalService;
	@BeanReference(type = EntidadPersistence.class)
	protected EntidadPersistence entidadPersistence;
	@BeanReference(type = EspecialidadLocalService.class)
	protected EspecialidadLocalService especialidadLocalService;
	@BeanReference(type = EspecialidadPersistence.class)
	protected EspecialidadPersistence especialidadPersistence;
	@BeanReference(type = EstadoLocalService.class)
	protected EstadoLocalService estadoLocalService;
	@BeanReference(type = EstadoPersistence.class)
	protected EstadoPersistence estadoPersistence;
	@BeanReference(type = FechaNoHabilLocalService.class)
	protected FechaNoHabilLocalService fechaNoHabilLocalService;
	@BeanReference(type = FechaNoHabilPersistence.class)
	protected FechaNoHabilPersistence fechaNoHabilPersistence;
	@BeanReference(type = ImplicadoLocalService.class)
	protected ImplicadoLocalService implicadoLocalService;
	@BeanReference(type = ImplicadoPersistence.class)
	protected ImplicadoPersistence implicadoPersistence;
	@BeanReference(type = ParametrosLocalService.class)
	protected ParametrosLocalService parametrosLocalService;
	@BeanReference(type = ParametrosPersistence.class)
	protected ParametrosPersistence parametrosPersistence;
	@BeanReference(type = PerfilImplicadoLocalService.class)
	protected PerfilImplicadoLocalService perfilImplicadoLocalService;
	@BeanReference(type = PerfilImplicadoPersistence.class)
	protected PerfilImplicadoPersistence perfilImplicadoPersistence;
	@BeanReference(type = ResponsableRespuestaLocalService.class)
	protected ResponsableRespuestaLocalService responsableRespuestaLocalService;
	@BeanReference(type = ResponsableRespuestaPersistence.class)
	protected ResponsableRespuestaPersistence responsableRespuestaPersistence;
	@BeanReference(type = SolicitanteLocalService.class)
	protected SolicitanteLocalService solicitanteLocalService;
	@BeanReference(type = SolicitantePersistence.class)
	protected SolicitantePersistence solicitantePersistence;
	@BeanReference(type = SolicitudLocalService.class)
	protected SolicitudLocalService solicitudLocalService;
	@BeanReference(type = SolicitudPersistence.class)
	protected SolicitudPersistence solicitudPersistence;
	@BeanReference(type = SolicitudFinder.class)
	protected SolicitudFinder solicitudFinder;
	@BeanReference(type = TipoDocumentoLocalService.class)
	protected TipoDocumentoLocalService tipoDocumentoLocalService;
	@BeanReference(type = TipoDocumentoPersistence.class)
	protected TipoDocumentoPersistence tipoDocumentoPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private EntidadLocalServiceClpInvoker _clpInvoker = new EntidadLocalServiceClpInvoker();
}