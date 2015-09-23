package com.clinica.veterinaria.delegate;

import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.PropietarioDAO;
import com.clinica.veterinaria.dao.jdbc.PropietarioJDBCDAO;

public class PropietarioDelegate {

	public String agregarPropietario(PropietarioBean propietarioBean) {
		PropietarioDAO propietarioDAO = new PropietarioJDBCDAO();
		int response = propietarioDAO.agregarPropietario(propietarioBean);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public List<PropietarioBean> obtenerPropietarios() {
		PropietarioDAO propietarioDAO = new PropietarioJDBCDAO();
		return propietarioDAO.listarPropietarios();
	}

	public String eliminarPropietario(String id) {
		PropietarioDAO propietarioDAO = new PropietarioJDBCDAO();
		int response = propietarioDAO.eliminarPropietario(Integer.parseInt(id));
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public String editarPropietario(PropietarioBean editedPropietario) {
		PropietarioDAO propietarioDAO = new PropietarioJDBCDAO();
		int response = propietarioDAO.editarPropietario(editedPropietario.getId(), editedPropietario);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

}
