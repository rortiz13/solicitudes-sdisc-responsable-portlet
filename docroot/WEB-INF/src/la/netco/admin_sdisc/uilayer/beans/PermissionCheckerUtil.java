package la.netco.admin_sdisc.uilayer.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;

public class PermissionCheckerUtil {

	public static Boolean  getPermittedToUpdate(String resource, String action) {

		try {
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			PermissionChecker permissionChecker = LiferayFacesContext.getInstance().getPermissionChecker();
			return permissionChecker.hasPermission(liferayFacesContext.getScopeGroupId(), resource,liferayFacesContext.getScopeGroupId(), action);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Long getCurrentUserId() {
		Long id = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext externalContext = fc.getExternalContext();
		if (externalContext.getUserPrincipal() != null) {
			 id = Long.parseLong(externalContext.getUserPrincipal().getName());
			
		}
		return id;
	}
	
	
	public static User getCurrentUser() throws PortalException, SystemException {
		User user = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext externalContext = fc.getExternalContext();
		if (externalContext.getUserPrincipal() != null) {
			Long id = Long.parseLong(externalContext.getUserPrincipal().getName());
			user = UserLocalServiceUtil.getUser(id);
		}
		return user;
	}

}
