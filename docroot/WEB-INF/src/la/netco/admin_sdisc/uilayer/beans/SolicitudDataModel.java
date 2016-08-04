package la.netco.admin_sdisc.uilayer.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import la.netco.admin_sdisc.uilayer.list.SolicitudWrapper;
import la.netco.solicitudes_sdisc.model.model.Estado;
import la.netco.solicitudes_sdisc.model.model.Implicado;
import la.netco.solicitudes_sdisc.model.model.PerfilImplicado;
import la.netco.solicitudes_sdisc.model.model.Solicitante;
import la.netco.solicitudes_sdisc.model.model.Solicitud;
import la.netco.solicitudes_sdisc.model.service.EstadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.ImplicadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.PerfilImplicadoLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitanteLocalServiceUtil;
import la.netco.solicitudes_sdisc.model.service.SolicitudLocalServiceUtil;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public  class SolicitudDataModel extends LazyDataModel<SolicitudWrapper> implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private Class<SolicitudWrapper> entityClass;
	private List<SolicitudWrapper> data;
	
	
	private Order orderBy;
	
	private Map<String, Object> filtros;
	
	public SolicitudDataModel() {
		super();
	}
	
	@Override
	public List<SolicitudWrapper> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {		
		try {
			
			
			rowCount = 	SolicitudLocalServiceUtil.countByFields((Date)filtros.get("fechaIni"), (Date)filtros.get("fechaFin"),(Integer) filtros.get("id_ciudad_solicitante"), (Integer)filtros.get("id_perfil"), (Integer)filtros.get("id_estado"));
			
			List<Solicitud> solicitudes =  (List<Solicitud>)   SolicitudLocalServiceUtil.findByFields((Date)filtros.get("fechaIni"), (Date)filtros.get("fechaFin"),(Integer) filtros.get("id_ciudad_solicitante"), (Integer)filtros.get("id_perfil"), (Integer)filtros.get("id_estado"), first, first + pageSize);
			data = new ArrayList<SolicitudWrapper>(solicitudes.size());
			
			
			for (Solicitud solicitud : solicitudes) {
				 Estado estado = EstadoLocalServiceUtil.getEstado(solicitud.getId_estado());
				 Solicitante solicitante = SolicitanteLocalServiceUtil.getSolicitante(solicitud.getId_solicitante());
				 Implicado implicado =ImplicadoLocalServiceUtil.getImplicado(solicitud.getId_implicado());	
				 PerfilImplicado perfil =PerfilImplicadoLocalServiceUtil.getPerfilImplicado(implicado.getId_perfil());	
				 SolicitudWrapper solWrapper = new SolicitudWrapper(solicitud, estado, solicitante,implicado,perfil);
				 solWrapper.setAntiguedad(getAntiguedadSolicitud(solicitud.getFechaRegistro()));
				 data.add(solWrapper);
			}
			
		} catch (Exception e) {
			_log.error("Error leyendo SolicitudLocalServiceUtil ", e);
		}
		
		setPageSize(pageSize);
		return data;
	}
	
	private Integer rowCount = null; 

	@Override
	public int getRowCount() {		
		int count = 0;		
		try {
			if(rowCount == null){				
				rowCount = 	SolicitudLocalServiceUtil.countByFields((Date)filtros.get("fechaIni"), (Date)filtros.get("fechaFin"),(Integer) filtros.get("id_ciudad_solicitante"), (Integer)filtros.get("id_perfil"), (Integer)filtros.get("id_estado"));
				count = rowCount.intValue();
			}else{				
				count=  rowCount.intValue();
			}
		} catch (Exception e) {
			_log.error("Error leyendo SolicitudLocalServiceUtil ", e);
		}
		return count;
	}
	
	
	@Override
	public Object getRowKey(SolicitudWrapper object) {
		return  getId(object);
	}

	@Override
	public SolicitudWrapper  getRowData(String rowKey) {
		for (SolicitudWrapper  object : data) {
			if (getId(object).equals(rowKey))
				return object;
		}

		return null;
	}

	

	public Class<SolicitudWrapper> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<SolicitudWrapper> entityClass) {
		this.entityClass = entityClass;
	}

	private Object getId(SolicitudWrapper t) {
		return t.getId_solicitante();
	}


	public Order getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Order orderBy) {
		this.orderBy = orderBy;
	}

	public Map<String, Object> getFiltros() {
		return filtros;
	}

	public void setFiltros(Map<String, Object> filtros) {
		this.filtros = filtros;
	}
	private static Log _log = LogFactoryUtil.getLog(SolicitudDataModel.class);
	   
	private int getAntiguedadSolicitud(Date fechaSolcitud){			
			Date fechaActual = new Date(System.currentTimeMillis());
			return  FechasNoHabiles.getNumDiasLaborales(fechaSolcitud, fechaActual);
}
	   

}
