package controller;

import DAO.DAOListaReproduccion;

public class CtrlListaReproduccion {
	
	DAOListaReproduccion ListaReproduccionDAO;

	public CtrlListaReproduccion() {
		this.ListaReproduccionDAO = new DAOListaReproduccion();
	}

}
