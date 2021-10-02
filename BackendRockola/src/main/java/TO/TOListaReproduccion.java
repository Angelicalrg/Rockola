package TO;

import java.sql.Date;

public class TOListaReproduccion extends TOusuario{
	
	private String nombreLista;
	private Date FechaCreacion;
	private String genero;
	
	//Constructores
	
	public TOListaReproduccion(String nombreLista, Date FechaCreacion, String genero) {
		super();
		this.nombreLista = nombreLista;
		this.FechaCreacion = FechaCreacion;
		this.genero = genero;
	}

	public TOListaReproduccion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	//Getters y Setters

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

	public Date getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
