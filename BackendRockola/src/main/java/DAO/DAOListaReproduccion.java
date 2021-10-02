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
				TOListasReproduccion.setIdUsuarios(rs.getInt("idusuarios"));
				TOListasReproduccion.setIdListaReproduccion(rs.getInt("idListaReproduccion"));
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
