package controller;

import DAO.DAOUsuarios;
//import TO.TOusuario;
import java.util.ArrayList;

public class CtrlUsuarios {

    DAOUsuarios usuariosDAO;

    public CtrlUsuarios() {
        this.usuariosDAO = new DAOUsuarios();
    }

    public ArrayList<TO.TOusuario> consultarUsuarios() {
        return usuariosDAO.consultarUsuarios();
    }

    public int insertarUsuarios(TO.TOusuario tOUsuarios) {
        return usuariosDAO.insertarUsuarios(tOUsuarios);
    }

    public boolean actualizarUsuarios(TO.TOusuario tOUsuarios) {
        return usuariosDAO.actualizarUsuarios(tOUsuarios);
    }

    public boolean eliminarUsuarios(int idUsuarios) {
        return usuariosDAO.eliminarUsuarios(idUsuarios);
    }

}
