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

import java.util.List;

import la.netco.solicitudes_sdisc.model.NoSuchCiudadException;
import la.netco.solicitudes_sdisc.model.model.Ciudad;
import la.netco.solicitudes_sdisc.model.service.base.CiudadLocalServiceBaseImpl;
import la.netco.solicitudes_sdisc.model.service.persistence.CiudadUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the ciudad local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link la.netco.solicitudes_sdisc.model.service.CiudadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author smontanez
 * @see la.netco.solicitudes_sdisc.model.service.base.CiudadLocalServiceBaseImpl
 * @see la.netco.solicitudes_sdisc.model.service.CiudadLocalServiceUtil
 */
public class CiudadLocalServiceImpl extends CiudadLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link la.netco.solicitudes_sdisc.model.service.CiudadLocalServiceUtil} to access the ciudad local service.
	 */
	
	public List<Ciudad> findBydepartamento(int id_departamento)
			throws NoSuchCiudadException, SystemException {
			return CiudadUtil.findBydepartamento(id_departamento);
	}

}