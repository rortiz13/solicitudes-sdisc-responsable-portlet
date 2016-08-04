package la.netco.solicitudes_sdisc.model.service.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import la.netco.solicitudes_sdisc.model.model.Solicitud;
import la.netco.solicitudes_sdisc.model.model.impl.SolicitudImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SolicitudFinderImpl extends BasePersistenceImpl<Solicitud> implements SolicitudFinder{
	

	public static final String FINDBYFIELDS =SolicitudFinder.class.getName() +	".findByFields";
	public static final String COUNTBYFIELDS =SolicitudFinder.class.getName() +	".countByFields";
	
	@SuppressWarnings("unchecked")
	public List<Solicitud> findByFields(Date fechaIni, Date fechaFin, Integer id_ciudad_solicitante,Integer  id_perfil, Integer  id_estado, int begin, int end) throws SystemException {

        Session session = null;
        
        Timestamp fechaInicial = CalendarUtil.getTimestamp(fechaIni);        
        Timestamp fechaFinal = CalendarUtil.getTimestamp(fechaFin);
        
        try {
            
        	if (fechaIni == null) {
    			throw new IllegalArgumentException();
    		}
            
        	if (fechaFin == null) {
    			throw new IllegalArgumentException();
    		}
        	
            String sql = CustomSQLUtil.get(FINDBYFIELDS);
            if (Validator.isNull(id_ciudad_solicitante)) {
            	sql = StringUtil.replace(sql, " AND  municipio.id_mcpio = ? ", "");
            }
            
            if (Validator.isNull(id_estado)) {
            	sql = StringUtil.replace(sql, " AND  SOLISALAD_SOLICITUD.id_estado = ? ", "");
            }
            
            if (Validator.isNull(id_perfil)) {
            	sql = StringUtil.replace(sql, "  AND  implicado.id_perfil = ? ", "");
            }
            
            session = openSession();
            
            SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("SOLISALAD_SOLICITUD", SolicitudImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			
			qPos.add(fechaInicial);
			qPos.add(fechaFinal);
			
			
			if (Validator.isNotNull(id_ciudad_solicitante)) {
			     qPos.add(id_ciudad_solicitante);
			}
			
			if (Validator.isNotNull(id_estado)) {
			     qPos.add(id_estado);
			}
			
			if (Validator.isNotNull(id_perfil)) {
			     qPos.add(id_perfil);
			}
			
			
			return (List<Solicitud>) QueryUtil.list(q, getDialect(), begin, end);
			
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }
    }
	
	
	@SuppressWarnings("unchecked")
	public int countByFields(Date fechaIni, Date fechaFin, Integer id_ciudad_solicitante,Integer  id_perfil, Integer  id_estado) throws SystemException {

        Session session = null;
        
        Timestamp fechaInicial = CalendarUtil.getTimestamp(fechaIni);        
        Timestamp fechaFinal = CalendarUtil.getTimestamp(fechaFin);
        
        try {
            
        	if (fechaIni == null) {
    			throw new IllegalArgumentException();
    		}
            
        	if (fechaFin == null) {
    			throw new IllegalArgumentException();
    		}
        	
            String sql = CustomSQLUtil.get(COUNTBYFIELDS);
            if (Validator.isNull(id_ciudad_solicitante)) {
            	sql = StringUtil.replace(sql, " AND  municipio.id_mcpio = ? ", "");
            }
            
            if (Validator.isNull(id_estado)) {
            	sql = StringUtil.replace(sql, " AND  SOLISALAD_SOLICITUD.id_estado = ? ", "");
            }
            
            if (Validator.isNull(id_perfil)) {
            	sql = StringUtil.replace(sql, "  AND  implicado.id_perfil = ? ", "");
            }
            
            
            session = openSession();
            
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(fechaInicial);		
			qPos.add(fechaFinal);
			
			
			if (Validator.isNotNull(id_ciudad_solicitante)) {
			     qPos.add(id_ciudad_solicitante);
			}
			
			if (Validator.isNotNull(id_estado)) {
			     qPos.add(id_estado);
			}
			
			if (Validator.isNotNull(id_perfil)) {
			     qPos.add(id_perfil);
			}
			
			
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {		
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
			
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }
    }
	
}