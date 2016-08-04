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

package la.netco.solicitudes_sdisc.model.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import la.netco.solicitudes_sdisc.model.service.CiudadLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ClpSerializer;
import la.netco.solicitudes_sdisc.model.service.DelegadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.DepartamentoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.EntidadLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.EspecialidadLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.EstadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.FechaNoHabilLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ImplicadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ParametrosLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.PerfilImplicadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ResponsableRespuestaLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitanteLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.TipoDocumentoLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CiudadLocalServiceUtil.clearService();

			DelegadoLocalServiceUtil.clearService();

			DepartamentoLocalServiceUtil.clearService();

			EntidadLocalServiceUtil.clearService();

			EspecialidadLocalServiceUtil.clearService();

			EstadoLocalServiceUtil.clearService();

			FechaNoHabilLocalServiceUtil.clearService();

			ImplicadoLocalServiceUtil.clearService();

			ParametrosLocalServiceUtil.clearService();

			PerfilImplicadoLocalServiceUtil.clearService();

			ResponsableRespuestaLocalServiceUtil.clearService();

			SolicitanteLocalServiceUtil.clearService();

			SolicitudLocalServiceUtil.clearService();

			TipoDocumentoLocalServiceUtil.clearService();
		}
	}
}