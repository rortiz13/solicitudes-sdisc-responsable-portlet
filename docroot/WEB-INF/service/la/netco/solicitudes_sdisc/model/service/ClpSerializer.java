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

package la.netco.solicitudes_sdisc.model.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import la.netco.solicitudes_sdisc.model.model.CiudadClp;
import la.netco.solicitudes_sdisc.model.model.DelegadoClp;
import la.netco.solicitudes_sdisc.model.model.DepartamentoClp;
import la.netco.solicitudes_sdisc.model.model.EntidadClp;
import la.netco.solicitudes_sdisc.model.model.EspecialidadClp;
import la.netco.solicitudes_sdisc.model.model.EstadoClp;
import la.netco.solicitudes_sdisc.model.model.FechaNoHabilClp;
import la.netco.solicitudes_sdisc.model.model.ImplicadoClp;
import la.netco.solicitudes_sdisc.model.model.ParametrosClp;
import la.netco.solicitudes_sdisc.model.model.PerfilImplicadoClp;
import la.netco.solicitudes_sdisc.model.model.ResponsableRespuestaClp;
import la.netco.solicitudes_sdisc.model.model.SolicitanteClp;
import la.netco.solicitudes_sdisc.model.model.SolicitudClp;
import la.netco.solicitudes_sdisc.model.model.TipoDocumentoClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"solicitudes-sdisc-responsable-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"solicitudes-sdisc-responsable-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "solicitudes-sdisc-responsable-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CiudadClp.class.getName())) {
			return translateInputCiudad(oldModel);
		}

		if (oldModelClassName.equals(DelegadoClp.class.getName())) {
			return translateInputDelegado(oldModel);
		}

		if (oldModelClassName.equals(DepartamentoClp.class.getName())) {
			return translateInputDepartamento(oldModel);
		}

		if (oldModelClassName.equals(EntidadClp.class.getName())) {
			return translateInputEntidad(oldModel);
		}

		if (oldModelClassName.equals(EspecialidadClp.class.getName())) {
			return translateInputEspecialidad(oldModel);
		}

		if (oldModelClassName.equals(EstadoClp.class.getName())) {
			return translateInputEstado(oldModel);
		}

		if (oldModelClassName.equals(FechaNoHabilClp.class.getName())) {
			return translateInputFechaNoHabil(oldModel);
		}

		if (oldModelClassName.equals(ImplicadoClp.class.getName())) {
			return translateInputImplicado(oldModel);
		}

		if (oldModelClassName.equals(ParametrosClp.class.getName())) {
			return translateInputParametros(oldModel);
		}

		if (oldModelClassName.equals(PerfilImplicadoClp.class.getName())) {
			return translateInputPerfilImplicado(oldModel);
		}

		if (oldModelClassName.equals(ResponsableRespuestaClp.class.getName())) {
			return translateInputResponsableRespuesta(oldModel);
		}

		if (oldModelClassName.equals(SolicitanteClp.class.getName())) {
			return translateInputSolicitante(oldModel);
		}

		if (oldModelClassName.equals(SolicitudClp.class.getName())) {
			return translateInputSolicitud(oldModel);
		}

		if (oldModelClassName.equals(TipoDocumentoClp.class.getName())) {
			return translateInputTipoDocumento(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCiudad(BaseModel<?> oldModel) {
		CiudadClp oldClpModel = (CiudadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCiudadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDelegado(BaseModel<?> oldModel) {
		DelegadoClp oldClpModel = (DelegadoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDelegadoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDepartamento(BaseModel<?> oldModel) {
		DepartamentoClp oldClpModel = (DepartamentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDepartamentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEntidad(BaseModel<?> oldModel) {
		EntidadClp oldClpModel = (EntidadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEntidadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEspecialidad(BaseModel<?> oldModel) {
		EspecialidadClp oldClpModel = (EspecialidadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEspecialidadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEstado(BaseModel<?> oldModel) {
		EstadoClp oldClpModel = (EstadoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEstadoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFechaNoHabil(BaseModel<?> oldModel) {
		FechaNoHabilClp oldClpModel = (FechaNoHabilClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFechaNoHabilRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputImplicado(BaseModel<?> oldModel) {
		ImplicadoClp oldClpModel = (ImplicadoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getImplicadoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputParametros(BaseModel<?> oldModel) {
		ParametrosClp oldClpModel = (ParametrosClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getParametrosRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPerfilImplicado(BaseModel<?> oldModel) {
		PerfilImplicadoClp oldClpModel = (PerfilImplicadoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPerfilImplicadoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResponsableRespuesta(
		BaseModel<?> oldModel) {
		ResponsableRespuestaClp oldClpModel = (ResponsableRespuestaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getResponsableRespuestaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSolicitante(BaseModel<?> oldModel) {
		SolicitanteClp oldClpModel = (SolicitanteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSolicitanteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSolicitud(BaseModel<?> oldModel) {
		SolicitudClp oldClpModel = (SolicitudClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSolicitudRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTipoDocumento(BaseModel<?> oldModel) {
		TipoDocumentoClp oldClpModel = (TipoDocumentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTipoDocumentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.CiudadImpl")) {
			return translateOutputCiudad(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.DelegadoImpl")) {
			return translateOutputDelegado(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.DepartamentoImpl")) {
			return translateOutputDepartamento(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.EntidadImpl")) {
			return translateOutputEntidad(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.EspecialidadImpl")) {
			return translateOutputEspecialidad(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.EstadoImpl")) {
			return translateOutputEstado(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.FechaNoHabilImpl")) {
			return translateOutputFechaNoHabil(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.ImplicadoImpl")) {
			return translateOutputImplicado(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.ParametrosImpl")) {
			return translateOutputParametros(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.PerfilImplicadoImpl")) {
			return translateOutputPerfilImplicado(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.ResponsableRespuestaImpl")) {
			return translateOutputResponsableRespuesta(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.SolicitanteImpl")) {
			return translateOutputSolicitante(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.SolicitudImpl")) {
			return translateOutputSolicitud(oldModel);
		}

		if (oldModelClassName.equals(
					"la.netco.solicitudes_sdisc.model.model.impl.TipoDocumentoImpl")) {
			return translateOutputTipoDocumento(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchCiudadException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchCiudadException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchDelegadoException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchDelegadoException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchDepartamentoException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchEntidadException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchEntidadException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchEspecialidadException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchEstadoException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchEstadoException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchFechaNoHabilException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchImplicadoException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchImplicadoException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchParametrosException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchParametrosException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchPerfilImplicadoException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchResponsableRespuestaException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchSolicitanteException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchSolicitudException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchSolicitudException();
		}

		if (className.equals(
					"la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException")) {
			return new la.netco.solicitudes_sdisc.model.NoSuchTipoDocumentoException();
		}

		return throwable;
	}

	public static Object translateOutputCiudad(BaseModel<?> oldModel) {
		CiudadClp newModel = new CiudadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCiudadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDelegado(BaseModel<?> oldModel) {
		DelegadoClp newModel = new DelegadoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDelegadoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDepartamento(BaseModel<?> oldModel) {
		DepartamentoClp newModel = new DepartamentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDepartamentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEntidad(BaseModel<?> oldModel) {
		EntidadClp newModel = new EntidadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEntidadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEspecialidad(BaseModel<?> oldModel) {
		EspecialidadClp newModel = new EspecialidadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEspecialidadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEstado(BaseModel<?> oldModel) {
		EstadoClp newModel = new EstadoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEstadoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFechaNoHabil(BaseModel<?> oldModel) {
		FechaNoHabilClp newModel = new FechaNoHabilClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFechaNoHabilRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputImplicado(BaseModel<?> oldModel) {
		ImplicadoClp newModel = new ImplicadoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setImplicadoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputParametros(BaseModel<?> oldModel) {
		ParametrosClp newModel = new ParametrosClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setParametrosRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPerfilImplicado(BaseModel<?> oldModel) {
		PerfilImplicadoClp newModel = new PerfilImplicadoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPerfilImplicadoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResponsableRespuesta(
		BaseModel<?> oldModel) {
		ResponsableRespuestaClp newModel = new ResponsableRespuestaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setResponsableRespuestaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSolicitante(BaseModel<?> oldModel) {
		SolicitanteClp newModel = new SolicitanteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSolicitanteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSolicitud(BaseModel<?> oldModel) {
		SolicitudClp newModel = new SolicitudClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSolicitudRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTipoDocumento(BaseModel<?> oldModel) {
		TipoDocumentoClp newModel = new TipoDocumentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTipoDocumentoRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}