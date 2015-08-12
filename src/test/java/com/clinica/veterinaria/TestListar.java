package com.clinica.veterinaria;

import java.util.List;

import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;
import com.clinica.veterinaria.vo.PropietarioVO;

public class TestListar {

	public static void main(String[] args) {
		PropietarioJDBCDAO prop = new PropietarioJDBCDAO();
		PropietarioVO lista = prop.obtenerPropietario(1);
		System.out.println(lista.toString());
	}

}
