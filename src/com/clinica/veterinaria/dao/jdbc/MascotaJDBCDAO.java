package com.clinica.veterinaria.dao.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinica.veterinaria.base.dao.BaseJDBCDAO;
import com.clinica.veterinaria.bean.MascotaBean;
import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.dao.MascotaDAO;
import com.clinica.veterinaria.mapper.MascotaMapper;
import com.clinica.veterinaria.mapper.NombrePropietarioMapper;
import com.clinica.veterinaria.mapper.PropietarioMapper;
import com.clinica.veterinaria.mapper.PropietarioSelectMapper;
import com.clinica.veterinaria.mapper.UsuarioMapper;
import com.clinica.veterinaria.vo.PropietarioVO;
import com.clinica.veterinaria.vo.UsuarioVO;

public class MascotaJDBCDAO extends BaseJDBCDAO implements MascotaDAO {

	public MascotaJDBCDAO() {
		super();
	}

	public int agregarMascota(MascotaBean mascota) {
		int response = 0;
		String sql = "INSERT INTO veterinaria.mascota (nombre, especie, "
				+ "raza, sexo, inscripcion, color, propietario_id) VALUES "
				+ "(:nombre, :especie, :raza, :sexo, :inscripcion, :color, "
				+ ":propietario_id)";
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

	public List<MascotaBean> listarMascotas(String propietarioId) {
		String sql = "SELECT mascota.id_mascota, mascota.nombre, mascota.especie, mascota.raza, "
				+ "mascota.sexo, mascota.inscripcion, mascota.color, mascota.propietario_id, "
				+ "propietario.nombres, propietario.apellido_pat, propietario.apellido_mat "
				+ "FROM veterinaria.mascota INNER JOIN veterinaria.propietario "
				+ "ON propietario.id_propietario = mascota.propietario_id";

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		if (!propietarioId.equalsIgnoreCase("0")) {
			sql = sql + " where propietario_id=:propietario_id";
			parameterMap.put("propietario_id", propietarioId);
		}
		sql = sql + " order by veterinaria.mascota.id_mascota asc";
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

	@Override
	public String obtenerNombrePropietario(int propId) {
		String sql = "select nombres, apellido_pat, apellido_mat from veterinaria.propietario where id_propietario=:id_propietario";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("id_propietario", propId);
		List<String> list = null;
		try {
			list = queryForModelList(sql, new NombrePropietarioMapper(),
					parameterMap);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	@Override
	public List<PropietarioVO> obtenerPropietarios() {
		String sql = "SELECT id_propietario, nombres, apellido_pat, apellido_mat FROM veterinaria.propietario";
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<PropietarioVO> list = null;
		try {
			list = queryForModelList(sql, new PropietarioSelectMapper(), parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
