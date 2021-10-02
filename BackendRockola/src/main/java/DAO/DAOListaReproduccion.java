package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TO.TOListaReproduccion;
import db.ConexionDB;

public class DAOListaReproduccion{
	
	private final ConexionDB con = new ConexionDB();
	private final String nombreTabla = "ListaReproducción";
	private final String[] columnas = { "nombreLista", "fechaCreacion"};
	
	public DAOListaReproduccion() {
		super();
	}
	
	public ArrayList<TOListaReproduccion> consultarUsuarios() {
		ArrayList<TOListaReproduccion> listaReproduccion = new ArrayList<>();
		TOListaReproduccion TOListasReproduccion;
		try {
			ResultSet rs = con.consultar(nombreTabla);
			while (rs.next()) {
				TOListasReproduccion = new TOListaReproduccion();
				TOListasReproduccion.setApellidos(rs.getString("apellidos"));
				TOListasReproduccion.setClave(rs.getString("clave"));
				TOListasReproduccion.setDireccion(rs.getString("direccion"));
				TOListasReproduccion.setFecha(rs.getDate("fechaNacimiento"));
				TOListasReproduccion.setGenero(rs.getString("genero"));
				TOListasReproduccion.setCorreo(rs.getString("correo"));
				TOListasReproduccion.setIdUsuarios(rs.getInt("idusuarios"));
				TOListasReproduccion.setIdentificacion(rs.getString("identificacion"));
				TOListasReproduccion.setNombres(rs.getString("nombres"));
				TOListasReproduccion.setTelefono(rs.getString("telefono"));
				TOListasReproduccion.setTipoUsuario(rs.getString("tipoUsuario"));
				TOListasReproduccion.setUsuario(rs.getString("usuario"));
				TOListasReproduccion.setNombreLista(rs.getString("nombreLista"));
				TOListasReproduccion.setFechaCreacion(rs.getDate("fechaCreacion"));

				listaReproduccion.add(TOListasReproduccion);
			}
			return listaReproduccion;

		} catch (SQLException ex) {
			System.out.println("Error en DAOListaReproduccion.consultarListaReproduccion: " + ex.getMessage());
			return null;
		}

	}
	
	public void insertarListaReproduccion(TOListaReproduccion x) {
		
	}
}
