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

package la.netco.solicitudes_sdisc.model.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import la.netco.solicitudes_sdisc.model.model.Solicitud;
import la.netco.solicitudes_sdisc.model.service.base.SolicitudLocalServiceBaseImpl;
import la.netco.solicitudes_sdisc.model.service.persistence.SolicitudFinderUtil;

/**
 * The implementation of the Solicitud local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link la.netco.solicitudes_sdisc.model.service.SolicitudLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author smontanez
 * @see la.netco.solicitudes_sdisc.model.service.base.SolicitudLocalServiceBaseImpl
 * @see la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil
 */
public class SolicitudLocalServiceImpl extends SolicitudLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil} to access the Solicitud local service.
	 */
	
	public List<Solicitud> findByFields(Date fechaIni, Date fechaFin, Integer id_ciudad_solicitante,Integer  id_perfil, Integer  id_estado, int begin, int end) throws SystemException {
		return SolicitudFinderUtil.findByFields(fechaIni, fechaFin, id_ciudad_solicitante, id_perfil, id_estado, begin, end);
	}
	
	public int countByFields(Date fechaIni, Date fechaFin, Integer id_ciudad_solicitante,Integer  id_perfil, Integer  id_estado) throws SystemException {
		return SolicitudFinderUtil.countByFields(fechaIni, fechaFin, id_ciudad_solicitante, id_perfil, id_estado);
	}
}