package la.netco.admin_sdisc.uilayer.beans;

import java.io.Serializable;

public class ArchivoSolicitud implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String nombre;

	private String url;

	public String getNombre() {
		return nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
