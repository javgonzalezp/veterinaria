package com.clinica.veterinaria.delegate;

import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.PropietarioDAO;
import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;
import com.clinica.veterinaria.vo.PropietarioVO;

public class PropietarioDelegate {

	public String agregarPropietario(PropietarioBean propietarioBean) {
		PropietarioDAO propietarioDAO = new PropietarioJDBCDAO();
		int response = propietarioDAO.agregarPropietario(copiarPropietario(propietarioBean));
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	private PropietarioVO copiarPropietario(PropietarioBean propietarioBean) {
		PropietarioVO propietario = new PropietarioVO();
		propietario.setApellidoMat(propietarioBean.getApellidoMat());
		propietario.setApellidoPat(propietarioBean.getApellidoPat());
		propietario.setComunaId(propietarioBean.getComunaId());
		propietario.setDireccion(propietarioBean.getDireccion());
		propietario.setEmail(propietarioBean.getEmail());
		propietario.setNombres(propietarioBean.getNombres());
		propietario.setRegionId(propietarioBean.getRegionId());
		propietario.setRut(propietarioBean.getRut());
		propietario.setTelefono(propietarioBean.getTelefono());
		return propietario;
	}

	public List<PropietarioVO> obtenerPropietarios() {
		PropietarioDAO propietarioDAO = new PropietarioJDBCDAO();
		return propietarioDAO.listarPropietarios();
	}

}
