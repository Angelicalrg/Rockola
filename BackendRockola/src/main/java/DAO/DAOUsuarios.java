package DAO;

import java.util.ArrayList;
import TO.TOusuario;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarios {

	private final ConexionDB con = new ConexionDB();
	private final String nombreTabla = "usuarios";
	private final String[] columnas = { "usuario", "clave", "tipoUsuario", "nombres", "apellidos", "indentificacion",
			"direccion", "telefono", "correo", "genero" };

	public DAOUsuarios() {
	}

	public ArrayList<TOusuario> consultarUsuarios() {
		ArrayList<TOusuario> usuario = new ArrayList<>();
		TOusuario tousuarios;
		try {
			ResultSet rs = con.consultar(nombreTabla);
			while (rs.next()) {
				tousuarios = new TOusuario();
				tousuarios.setApellidos(rs.getString("apellidos"));
				tousuarios.setClave(rs.getString("clave"));
				tousuarios.setDireccion(rs.getString("direccion"));
				tousuarios.setFecha(rs.getDate("fechaNacimiento"));
				tousuarios.setGenero(rs.getString("genero"));
				tousuarios.setCorreo(rs.getString("correo"));
				tousuarios.setIdUsuarios(rs.getInt("idusuarios"));
				tousuarios.setIdentificacion(rs.getString("identificacion"));
				tousuarios.setNombres(rs.getString("nombres"));
				tousuarios.setTelefono(rs.getString("telefono"));
				tousuarios.setTipoUsuario(rs.getString("tipoUsuario"));
				tousuarios.setUsuario(rs.getString("usuario"));

				usuario.add(tousuarios);
			}
			return usuario;

		} catch (SQLException ex) {
			System.out.println("Error en DAOusuarios.consultarUsuarios: " + ex.getMessage());
			return null;
		}

	}

	public int insertarUsuarios(TOusuario tousuarios) {
		String[] valores = { tousuarios.getUsuario(), tousuarios.getClave(), tousuarios.getTipoUsuario(),
				tousuarios.getNombres(), tousuarios.getApellidos(), tousuarios.getIdentificacion(),
				tousuarios.getDireccion(), tousuarios.getTelefono(), tousuarios.getCorreo(), tousuarios.getGenero() };

		try {
			return con.insertar(nombreTabla, columnas, valores);

		} catch (Exception ex) {
			System.out.println("Error en DAOusuarios.insertarUsuarios: " + ex.getMessage());
			return 0;

		}
	}

	public boolean actualizarUsuarios(TOusuario tousuarios) {
		String[] valores = { tousuarios.getUsuario(), tousuarios.getClave(), tousuarios.getTipoUsuario(),
				tousuarios.getNombres(), tousuarios.getApellidos(), tousuarios.getIdentificacion(),
				tousuarios.getDireccion(), tousuarios.getTelefono(), tousuarios.getCorreo(), tousuarios.getGenero() };

		try {
			return con.actualizar(nombreTabla, columnas, valores, tousuarios.getIdUsuarios());

		} catch (Exception ex) {
			System.out.println("Error en DAOusuarios.actualizarUsuarios: " + ex.getMessage());
			return false;

		}
	}

	public boolean eliminarUsuarios(int idusuarios) {

		try {
			return con.eliminar(nombreTabla, idusuarios);

		} catch (Exception ex) {
			System.out.println("Error en DAOusuarios.eliminarUsuarios: " + ex.getMessage());
			return false;
		}

	}

}
