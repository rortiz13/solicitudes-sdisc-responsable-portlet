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

import la.netco.solicitudes_sdisc.model.NoSuchEstadoException;
import la.netco.solicitudes_sdisc.model.model.Estado;
import la.netco.solicitudes_sdisc.model.service.base.EstadoLocalServiceBaseImpl;
import la.netco.solicitudes_sdisc.model.service.persistence.EstadoUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the estado local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link la.netco.solicitudes_sdisc.model.service.EstadoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author smontanez
 * @see la.netco.solicitudes_sdisc.model.service.base.EstadoLocalServiceBaseImpl
 * @see la.netco.solicitudes_sdisc.model.service.EstadoLocalServiceUtil
 */
public class EstadoLocalServiceImpl extends EstadoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link la.netco.solicitudes_sdisc.model.service.EstadoLocalServiceUtil} to access the estado local service.
	 */
	
	public Estado findByNombre(String nombre) throws NoSuchEstadoException, SystemException{
			return EstadoUtil.findByNombre(nombre);
	}
}