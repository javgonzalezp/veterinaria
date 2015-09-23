package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.bean.MascotaBean;
import com.clinica.veterinaria.dao.MascotaDAO;
import com.clinica.veterinaria.mapper.MascotaMapper;

public class MascotaJDBCDAO extends BaseJDBCDAO implements MascotaDAO{

	public MascotaJDBCDAO() {
		super();
	}

	public int agregarMascota(MascotaBean mascota) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.mascota (nombre, especie, "
				+ "raza, sexo, inscripcion, color, propietario_id) VALUES "
				+ "(:nombre, :especie, :raza, :sexo, :inscripcion, :color, "
				+ "propietario_id)";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("nombre", mascota.getNombre());
		parameterMap.put("especie", mascota.getEspecie());
		parameterMap.put("raza", mascota.getRaza());
		parameterMap.put("sexo", mascota.getSexo());
		parameterMap.put("inscripcion", mascota.getInscripcion());
		parameterMap.put("color", mascota.getColor());
		parameterMap.put("propietario_id", mascota.getPropietarioId());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public int editarMascota(int id, MascotaBean mascota) {
		int response = 0;
		String sql = "UPDATE veterinaria.mascota SET nombre = :nombre, especie = :especie, "
				+ "raza = :raza, sexo = :sexo, inscripcion = :inscripcion, color = :color, "
				+ "propietario_id = :propietario_id WHERE id_mascota = :id_mascota";  
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_mascota", id);
		parameterMap.put("nombre", mascota.getNombre());
		parameterMap.put("especie", mascota.getEspecie());
		parameterMap.put("raza", mascota.getRaza());
		parameterMap.put("sexo", mascota.getSexo());
		parameterMap.put("inscripcion", mascota.getInscripcion());
		parameterMap.put("color", mascota.getColor());
		parameterMap.put("propietario_id", mascota.getPropietarioId());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public List<MascotaBean> listarMascotas() {
		String sql = "select * from veterinaria.mascota";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<MascotaBean> list = null;
		try {
			list = queryForModelList(sql, new MascotaMapper(), parameterMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int eliminarMascota(int id) {
		int response = 0;
		String sql = "DELETE FROM `veterinaria`.`mascota` WHERE id_mascota=:id_mascota";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_mascota", id);
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
