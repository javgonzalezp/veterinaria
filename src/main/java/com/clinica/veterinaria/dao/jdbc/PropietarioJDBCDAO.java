package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.PropietarioDAO;
import com.clinica.veterinaria.mapper.PropietarioMapper;

public class PropietarioJDBCDAO extends BaseJDBCDAO implements PropietarioDAO{

	public PropietarioJDBCDAO() {
		super();
	}

	public int agregarPropietario(PropietarioBean propietario) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.propietario (nombres, apellido_pat, "
				+ "apellido_mat, rut, telefono, email, direccion, comuna_id, region_id) VALUES ("
				+ ":nombres, :apellido_pat, :apellido_mat, :rut, :telefono, :email, "
				+ ":direccion, :comuna_id, :region_id)";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("nombres", propietario.getNombres());
		parameterMap.put("apellido_pat", propietario.getApellidoPat());
		parameterMap.put("apellido_mat", propietario.getApellidoMat());
		parameterMap.put("rut", propietario.getRut());
		parameterMap.put("telefono", propietario.getTelefono());
		parameterMap.put("email", propietario.getEmail());
		parameterMap.put("direccion", propietario.getDireccion());
		parameterMap.put("comuna_id", propietario.getComunaId());
		parameterMap.put("region_id", propietario.getRegionId());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

	public int editarPropietario(int id, PropietarioBean propietario) {
		int response = 0;
		String sql = "UPDATE veterinaria.propietario SET "
				+ "nombres = :nombres, apellido_pat = :apellido_pat, apellido_mat = :apellido_mat, "
				+ "rut = :rut, telefono = :telefono, email = :email, direccion = :direccion, comuna_id = :comuna, "
				+ "region_id = :region WHERE id_propietario = :id_propietario";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_propietario", id);
		parameterMap.put("nombres", propietario.getNombres());
		parameterMap.put("apellido_pat", propietario.getApellidoPat());
		parameterMap.put("apellido_mat", propietario.getApellidoMat());
		parameterMap.put("rut", propietario.getRut());
		parameterMap.put("telefono", propietario.getTelefono());
		parameterMap.put("email", propietario.getEmail());
		parameterMap.put("direccion", propietario.getDireccion());
		parameterMap.put("comuna", propietario.getComunaId());
		parameterMap.put("region", propietario.getRegionId());
		
		try {
			response = update(sql, parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}

	public List<PropietarioBean> listarPropietarios() {
		String sql = "select * from veterinaria.propietario";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<PropietarioBean> list = null;
		try {
			list = queryForModelList(sql, new PropietarioMapper(), parameterMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public PropietarioBean obtenerPropietario(String rut) {
		String sql = "select * from veterinaria.propietario where rut=:rut";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("rut", rut);
		List<PropietarioBean> list = null;
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
