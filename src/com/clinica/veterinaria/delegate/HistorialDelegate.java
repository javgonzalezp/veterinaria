package com.clinica.veterinaria.delegate;

import java.util.List;

import com.clinica.veterinaria.bean.HistorialBean;
import com.clinica.veterinaria.dao.HistorialDAO;
import com.clinica.veterinaria.dao.jdbc.HistorialJDBCDAO;
import com.clinica.veterinaria.vo.MascotaVO;
import com.clinica.veterinaria.vo.UsuarioVO;

public class HistorialDelegate {

	public String agregarHistorial(HistorialBean historialBean) {
		HistorialDAO historialDAO = new HistorialJDBCDAO();
		int response = historialDAO.agregarHistorial(historialBean);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public List<HistorialBean> obtenerHistoriales(String mascotaId) {
		HistorialDAO historialDAO = new HistorialJDBCDAO();
		return historialDAO.listarHistoriales(mascotaId);
	}

	public String eliminarHistorial(Integer id) {
		HistorialDAO historialDAO = new HistorialJDBCDAO();
		int response = historialDAO.eliminarHistorial(id);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public String editarHistorial(HistorialBean editedHistorial) {
		HistorialDAO historialDAO = new HistorialJDBCDAO();
		int response = historialDAO.editarHistorial(editedHistorial.getId(), editedHistorial);
		if(response == 1){
			return "success";
		} else {
			return "failure";
		}
	}

	public List<UsuarioVO> obtenerUsuarios() {
		HistorialDAO historialDAO = new HistorialJDBCDAO();
		List<UsuarioVO> usuariosSQL = historialDAO.obtenerUsuarios();
		return usuariosSQL;
	}
	
	public List<MascotaVO> obtenerMascotas() {
		HistorialDAO historialDAO = new HistorialJDBCDAO();
		List<MascotaVO> mascotasSQL = historialDAO.obtenerMascotas();
		return mascotasSQL;
	}

}
