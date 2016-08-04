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

/**
 * @author smontanez
 */
public interface SolicitudFinder {
	public java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findByFields(
		java.util.Date fechaIni, java.util.Date fechaFin,
		java.lang.Integer id_ciudad_solicitante, java.lang.Integer id_perfil,
		java.lang.Integer id_estado, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByFields(java.util.Date fechaIni, java.util.Date fechaFin,
		java.lang.Integer id_ciudad_solicitante, java.lang.Integer id_perfil,
		java.lang.Integer id_estado)
		throws com.liferay.portal.kernel.exception.SystemException;
}