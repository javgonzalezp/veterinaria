package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.bean.HistorialBean;
import com.clinica.veterinaria.dao.HistorialDAO;
import com.clinica.veterinaria.mapper.HistorialMapper;
import com.clinica.veterinaria.mapper.MascotaMapper;

public class HistorialJDBCDAO extends BaseJDBCDAO implements HistorialDAO {
	
	public HistorialJDBCDAO() {
		super();
	}

	public int agregarHistorial(HistorialBean historial) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.historial (fecha, observaciones, "
				+ "tratamiento, mascota_id) VALUES "
				+ "(:fecha, :observaciones, :tratamiento, :mascota_id)";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("fecha", historial.getFecha());
		parameterMap.put("observaciones", historial.getObservaciones());
		parameterMap.put("tratamiento", historial.getTratamiento());
		parameterMap.put("mascota_id", historial.getMascotaId());
		
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
				+ "tratamiento = :tratamiento, mascota_id = :mascota_id WHERE id_historial = :id";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_historial", id);
		parameterMap.put("fecha", historial.getFecha());
		parameterMap.put("observaciones", historial.getObservaciones());
		parameterMap.put("tratamiento", historial.getTratamiento());
		parameterMap.put("mascota_id", historial.getMascotaId());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public List<HistorialBean> listarHistoriales() {
		String sql = "select * from veterinaria.historial";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
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

}