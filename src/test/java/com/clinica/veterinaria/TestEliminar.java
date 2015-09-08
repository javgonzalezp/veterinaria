package com.clinica.veterinaria;

import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;

public class TestEliminar {

	public static void main(String[] args) {
		PropietarioJDBCDAO prop = new PropietarioJDBCDAO();
		System.out.println(prop.eliminarPropietario(1));
	}
}
