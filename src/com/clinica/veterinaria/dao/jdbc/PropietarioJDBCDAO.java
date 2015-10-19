package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.PropietarioDAO;
import com.clinica.veterinaria.mapper.ComunaMapper;
import com.clinica.veterinaria.mapper.ComunaNombreMapper;
import com.clinica.veterinaria.mapper.PropietarioMapper;
import com.clinica.veterinaria.mapper.RegionMapper;
import com.clinica.veterinaria.mapper.RegionNombreMapper;
import com.clinica.veterinaria.vo.ComunaVO;
import com.clinica.veterinaria.vo.RegionVO;

public class PropietarioJDBCDAO extends BaseJDBCDAO implements PropietarioDAO{

	public PropietarioJDBCDAO() {
		super();
	}

	public int agregarPropietario(PropietarioBean propietario) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.propietario (nombres, apellido_pat, "
				+ "apellido_mat, rut, telefono, email, direccion, comuna, region) VALUES ("
				+ ":nombres, :apellido_pat, :apellido_mat, :rut, :telefono, :email, "
				+ ":direccion, :comuna, :region)";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("nombres", propietario.getNombres());
		parameterMap.put("apellido_pat", propietario.getApellidoPat());
		parameterMap.put("apellido_mat", propietario.getApellidoMat());
		parameterMap.put("rut", propietario.getRut());
		parameterMap.put("telefono", propietario.getTelefono());
		parameterMap.put("email", propietario.getEmail());
		parameterMap.put("direccion", propietario.getDireccion());
		parameterMap.put("comuna", propietario.getComuna());
		parameterMap.put("region", propietario.getRegion());
		
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
				+ "rut = :rut, telefono = :telefono, email = :email, direccion = :direccion, comuna = :comuna, "
				+ "region = :region WHERE id_propietario = :id_propietario";
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_propietario", id);
		parameterMap.put("nombres", propietario.getNombres());
		parameterMap.put("apellido_pat", propietario.getApellidoPat());
		parameterMap.put("apellido_mat", propietario.getApellidoMat());
		parameterMap.put("rut", propietario.getRut());
		parameterMap.put("telefono", propietario.getTelefono());
		parameterMap.put("email", propietario.getEmail());
		parameterMap.put("direccion", propietario.getDireccion());
		parameterMap.put("comuna", propietario.getComuna());
		parameterMap.put("region", propietario.getRegion());
		
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

	@Override
	public List<RegionVO> obtenerRegiones() {
		String sql = "SELECT region_id, region_nombre FROM veterinaria.region";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<RegionVO> list = null;
		try {
			list = queryForModelList(sql, new RegionMapper(), parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ComunaVO> obtenerComunas() {
		String sql = "SELECT comuna_id, comuna_nombre, region_id FROM veterinaria.comuna ORDER BY comuna_nombre ASC";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<ComunaVO> list = null;
		try {
			list = queryForModelList(sql, new ComunaMapper(), parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


}
