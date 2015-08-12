package com.clinica.veterinaria;

import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;
import com.clinica.veterinaria.vo.PropietarioVO;

public class TestEditar {

	public static void main(String[] args) {
		PropietarioJDBCDAO prop = new PropietarioJDBCDAO();
		PropietarioVO propVO = new PropietarioVO();
		propVO.setApellido_mat("Pichuante");
		propVO.setApellido_pat("Gonzalez");
		propVO.setComuna("Santiago");
		propVO.setDireccion("Carmen 319, depto 2009");
		propVO.setEmail("jgonzalezp@gmail.com");
		propVO.setNombres("Javier Ignacio");
		propVO.setProvincia("Santiago");
		propVO.setRegion("Region Metropolitana");
		propVO.setTelefono("91251888");
		System.out.println(prop.editarPropietario(1, propVO));
	}

}