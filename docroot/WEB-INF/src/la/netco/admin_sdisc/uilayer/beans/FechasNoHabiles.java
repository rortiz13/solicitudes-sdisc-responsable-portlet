package la.netco.admin_sdisc.uilayer.beans;

import java.util.Calendar;
import java.util.Date;

import la.netco.solicitudes_sdisc.model.service.FechaNoHabilLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

public class FechasNoHabiles {
	
	
	
	public static long getFechasNoHabiles(Date fechaInicio , Date fechaFinal){
		long diasNoHabiles = 0;
		
		try {
			
			Calendar fechaIni = Calendar.getInstance();
			fechaIni.setTime(fechaInicio);
			fechaIni.set(Calendar.HOUR_OF_DAY, 0);
			fechaIni.set(Calendar.MINUTE, 0);
			fechaIni.set(Calendar.SECOND, 0);
			
			Calendar fechaFin = Calendar.getInstance();
			fechaFin.setTime(fechaFinal);
			fechaFin.set(Calendar.HOUR_OF_DAY, 23);	
			fechaFin.set(Calendar.MINUTE, 59);
			fechaFin.set(Calendar.SECOND, 59);
			
			
			DynamicQuery dynamicQuery =  FechaNoHabilLocalServiceUtil.dynamicQuery();	
			dynamicQuery.add(RestrictionsFactoryUtil.between("fecha",fechaIni.getTime(), fechaFin.getTime()));
			
			
			diasNoHabiles = 	FechaNoHabilLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			return diasNoHabiles;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return diasNoHabiles;
			
	}
	
	public static int getDiffDiasNoFinSemana(Date fechaInicio , Date fechaFinal){
		int dias = 0;
		
		try {
			
			Calendar fechaIni = Calendar.getInstance();
			fechaIni.setTime(fechaInicio);
			fechaIni.set(Calendar.HOUR_OF_DAY, 0);
			fechaIni.set(Calendar.MINUTE, 0);
			fechaIni.set(Calendar.SECOND, 0);
			
			Calendar fechaFin = Calendar.getInstance();
			fechaFin.setTime(fechaFinal);
			fechaFin.set(Calendar.HOUR_OF_DAY, 0);	
			fechaFin.set(Calendar.MINUTE, 0);
			fechaFin.set(Calendar.SECOND, 0);
			while (fechaIni.before(fechaFin)) {
				fechaIni.add(Calendar.DAY_OF_MONTH, 1);				
				
				if(fechaIni.get(Calendar.DAY_OF_WEEK)  != Calendar.SATURDAY && fechaIni.get(Calendar.DAY_OF_WEEK)  != Calendar.SUNDAY){
					dias++;	
				}			
				
			}
 
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return dias;
			
	}
	
	public static Integer getNumDiasLaborales(Date fechaInicio, Date fechaFinal){
		long diasNoHabiles = getFechasNoHabiles(fechaInicio , fechaFinal);
		int difDiasNoFinSemana = getDiffDiasNoFinSemana(fechaInicio, fechaFinal);
		int diasLaborales = (int) (difDiasNoFinSemana - diasNoHabiles);
		return diasLaborales;		
	}

}
