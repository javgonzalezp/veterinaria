package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.bean.HistorialBean;
import com.clinica.veterinaria.dao.HistorialDAO;
import com.clinica.veterinaria.mapper.HistorialMapper;
import com.clinica.veterinaria.mapper.UsuarioMapper;
import com.clinica.veterinaria.vo.MascotaVO;
import com.clinica.veterinaria.vo.UsuarioVO;

public class HistorialJDBCDAO extends BaseJDBCDAO implements HistorialDAO {
	
	public HistorialJDBCDAO() {
		super();
	}

	public int agregarHistorial(HistorialBean historial) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.historial (fecha, observaciones, "
				+ "tratamiento, mascota_id, usuario_id) VALUES "
				+ "(:fecha, :observaciones, :tratamiento, :mascota_id, :usuario_id)";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("fecha", historial.getFecha());
		parameterMap.put("observaciones", historial.getObservaciones());
		parameterMap.put("tratamiento", historial.getTratamiento());
		parameterMap.put("mascota_id", historial.getMascotaId());
		parameterMap.put("usuario_id", historial.getUsuarioId());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public int editarHistorial(int id, HistorialBean historial) {
		int response = 0;
		String sql = "UPDATE veterinaria.historial SET fecha = :fecha, observaciones = :observaciones, "
				+ "tratamiento = :tratamiento, mascota_id = :mascota_id, usuario_id = :usuario_id WHERE id_historial = :id_historial";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_historial", id);
		parameterMap.put("fecha", historial.getFecha());
		parameterMap.put("observaciones", historial.getObservaciones());
		parameterMap.put("tratamiento", historial.getTratamiento());
		parameterMap.put("mascota_id", historial.getMascotaId());
		parameterMap.put("usuario_id", historial.getUsuarioId());
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public List<HistorialBean> listarHistoriales(String mascotaId) {
		String sql = "select historial.id_historial, historial.fecha, historial.observaciones, "
				+ "historial.tratamiento, historial.mascota_id, historial.usuario_id, "
				+ "usuario.nombre, mascota.nombre from veterinaria.historial "
				+ "INNER JOIN veterinaria.mascota ON historial.mascota_id=mascota.id_mascota "
				+ "INNER JOIN veterinaria.usuario ON historial.usuario_id=usuario.id_usuario ";
				
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		if(!mascotaId.equalsIgnoreCase("0")){
			sql = sql+" where mascota_id=:mascota_id";
			parameterMap.put("mascota_id", mascotaId);
		}
		sql = sql+ " order by veterinaria.mascota.id_mascota asc";
		List<HistorialBean> list = null;
		try {
			list = queryForModelList(sql, new HistorialMapper(), parameterMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int eliminarHistorial(int id) {
		int response = 0;
		String sql = "DELETE FROM `veterinaria`.`historial` WHERE id_historial=:id_historial";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_historial", id);
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public List<UsuarioVO> obtenerUsuarios() {
		String sql = "SELECT id_usuario, nombre FROM veterinaria.usuario";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<UsuarioVO> list = null;
		try {
			list = queryForModelList(sql, new UsuarioMapper(), parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MascotaVO> obtenerMascotas() {
		String sql = "SELECT id_mascota, nombre FROM veterinaria.mascota";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<MascotaVO> list = null;
		try {
			list = queryForModelList(sql, new UsuarioMapper(), parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}