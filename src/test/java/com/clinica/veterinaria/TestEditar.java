package com.clinica.veterinaria;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;

public class TestEditar {

	public static void main(String[] args) {
		PropietarioJDBCDAO prop = new PropietarioJDBCDAO();
		PropietarioBean propVO = new PropietarioBean();
		propVO.setApellidoMat("Pichuante");
		propVO.setApellidoPat("Gonzalez");
		propVO.setComunaId(13101);
		propVO.setDireccion("Carmen 319, depto 2009");
		propVO.setEmail("jgonzalezp@gmail.com");
		propVO.setNombres("Javier Ignacio");
		propVO.setRegionId(13);
		propVO.setTelefono("91251888");
		propVO.setRut("16858475k");
		System.out.println(prop.editarPropietario(1, propVO));
	}

}
