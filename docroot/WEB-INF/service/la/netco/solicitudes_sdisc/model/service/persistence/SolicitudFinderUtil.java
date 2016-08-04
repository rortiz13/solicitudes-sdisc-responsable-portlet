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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author smontanez
 */
public class SolicitudFinderUtil {
	public static java.util.List<la.netco.solicitudes_sdisc.model.model.Solicitud> findByFields(
		java.util.Date fechaIni, java.util.Date fechaFin,
		java.lang.Integer id_ciudad_solicitante, java.lang.Integer id_perfil,
		java.lang.Integer id_estado, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByFields(fechaIni, fechaFin, id_ciudad_solicitante,
			id_perfil, id_estado, begin, end);
	}

	public static int countByFields(java.util.Date fechaIni,
		java.util.Date fechaFin, java.lang.Integer id_ciudad_solicitante,
		java.lang.Integer id_perfil, java.lang.Integer id_estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByFields(fechaIni, fechaFin, id_ciudad_solicitante,
			id_perfil, id_estado);
	}

	public static SolicitudFinder getFinder() {
		if (_finder == null) {
			_finder = (SolicitudFinder)PortletBeanLocatorUtil.locate(la.netco.solicitudes_sdisc.model.service.ClpSerializer.getServletContextName(),
					SolicitudFinder.class.getName());

			ReferenceRegistry.registerReference(SolicitudFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SolicitudFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SolicitudFinderUtil.class, "_finder");
	}

	private static SolicitudFinder _finder;
}