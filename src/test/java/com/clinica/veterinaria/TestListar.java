package com.clinica.veterinaria;

import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;

public class TestListar {

	public static void main(String[] args) {
		PropietarioJDBCDAO prop = new PropietarioJDBCDAO();
		PropietarioBean lista = prop.obtenerPropietario("16858475k");
		System.out.println(lista.toString());
	}

}
