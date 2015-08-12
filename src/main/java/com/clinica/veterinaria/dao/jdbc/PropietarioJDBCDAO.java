package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.dao.PropietarioDAO;
import com.clinica.veterinaria.mapper.PropietarioMapper;
import com.clinica.veterinaria.vo.PropietarioVO;

public class PropietarioJDBCDAO extends BaseJDBCDAO implements PropietarioDAO{

	public PropietarioJDBCDAO() {
		super();
	}

	public int agregarPropietario(PropietarioVO propietario) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.propietario (nombres, apellido_pat, "
				+ "apellido_mat, rut, telefono, email, direccion, comuna, provincia, region) VALUES ("
				+ ":nombres, :apellido_pat, :apellido_mat, :telefono, :email, "
				+ ":direccion, :comuna, :provincia, :region)";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("nombres", propietario.getNombres());
		parameterMap.put("apellido_pat", propietario.getApellido_pat());
		parameterMap.put("apellido_mat", propietario.getApellido_mat());
		parameterMap.put("rut", propietario.getRut());
		parameterMap.put("telefono", propietario.getTelefono());
		parameterMap.put("email", propietario.getEmail());
		parameterMap.put("direccion", propietario.getDireccion());
		parameterMap.put("comuna", propietario.getComuna());
		parameterMap.put("provincia", propietario.getProvincia());
		parameterMap.put("region", propietario.getRegion());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

	public int editarPropietario(int id, PropietarioVO propietario) {
		int response = 0;
		String sql = "UPDATE veterinaria.propietario SET id_propietario = :id_propietario, "
				+ "nombres = :nombres, apellido_pat = :apellido_pat, apellido_mat = :apellido_mat, "
				+ "rut = :rut, telefono = :telefono, email = :email, direccion = :direccion, comuna = :comuna, "
				+ "provincia = :provincia, region = :region WHERE id_propietario = :id_propietario";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_propietario", id);
		parameterMap.put("nombres", propietario.getNombres());
		parameterMap.put("apellido_pat", propietario.getApellido_pat());
		parameterMap.put("apellido_mat", propietario.getApellido_mat());
		parameterMap.put("rut", propietario.getRut());
		parameterMap.put("telefono", propietario.getTelefono());
		parameterMap.put("email", propietario.getEmail());
		parameterMap.put("direccion", propietario.getDireccion());
		parameterMap.put("comuna", propietario.getComuna());
		parameterMap.put("provincia", propietario.getProvincia());
		parameterMap.put("region", propietario.getRegion());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}

	public List<PropietarioVO> listarPropietarios() {
		String sql = "select * from veterinaria.propietario";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<PropietarioVO> list = null;
		try {
			list = queryForModelList(sql, new PropietarioMapper(), parameterMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public PropietarioVO obtenerPropietario(int id) {
		String sql = "select * from veterinaria.propietario where id_propietario=:id_propietario";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_propietario", id);
		List<PropietarioVO> list = null;
		try {
			list = queryForModelList(sql, new PropietarioMapper(), parameterMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	public int eliminarPropietario(int id) {
		int response = 0;
		String sql = "DELETE FROM `veterinaria`.`propietario` WHERE id_propietario=:id_propietario";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_propietario", id);
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}


}
