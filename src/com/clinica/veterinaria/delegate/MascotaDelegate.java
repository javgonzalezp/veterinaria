package com.clinica.veterinaria.delegate;

import java.util.List;

import com.clinica.veterinaria.bean.MascotaBean;
import com.clinica.veterinaria.dao.MascotaDAO;
import com.clinica.veterinaria.dao.jdbc.MascotaJDBCDAO;
import com.clinica.veterinaria.vo.PropietarioVO;

public class MascotaDelegate {

	public String agregarMascota(MascotaBean mascotaBean) {
		MascotaDAO mascotaDAO = new MascotaJDBCDAO();
		int response = mascotaDAO.agregarMascota(mascotaBean);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public List<MascotaBean> obtenerMascotas(String propietarioId) {
		MascotaDAO mascotaDAO = new MascotaJDBCDAO();
		return mascotaDAO.listarMascotas(propietarioId);
	}

	public String eliminarMascota(Integer id) {
		MascotaDAO mascotaDAO = new MascotaJDBCDAO();
		int response = mascotaDAO.eliminarMascota(id);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public String editarMascota(MascotaBean editedMascota) {
		MascotaDAO mascotaDAO = new MascotaJDBCDAO();
		int response = mascotaDAO.editarMascota(editedMascota.getId(), editedMascota);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public String obtenerNombrePropietario(int propId) {
		MascotaDAO mascotaDAO = new MascotaJDBCDAO();
		return mascotaDAO.obtenerNombrePropietario(propId);
	}

	public List<PropietarioVO> obtenerPropietarios() {
		MascotaDAO mascotaDAO = new MascotaJDBCDAO();
		return mascotaDAO.obtenerPropietarios();
	}

}
