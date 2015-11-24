package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.bean.MascotaBean;

public class MascotaMapper implements RowMapper<MascotaBean>{

	public MascotaBean mapRow(ResultSet paramResultSet) throws SQLException {
		MascotaBean mascotaVO = new MascotaBean();
		mascotaVO.setId(paramResultSet.getInt("mascota.id_mascota"));
		mascotaVO.setNombre(paramResultSet.getString("mascota.nombre"));
		mascotaVO.setEspecie(paramResultSet.getString("mascota.especie"));
		mascotaVO.setRaza(paramResultSet.getString("mascota.raza"));
		mascotaVO.setSexo(paramResultSet.getString("mascota.sexo"));
		mascotaVO.setInscripcion(paramResultSet.getString("mascota.inscripcion"));
		mascotaVO.setColor(paramResultSet.getString("mascota.color"));
		mascotaVO.setFechaNacimiento(paramResultSet.getDate("mascota.fecha_nacimiento"));
		mascotaVO.setPropietarioId(paramResultSet.getInt("mascota.propietario_id"));
		mascotaVO.setPropietarioNombre(paramResultSet.getString("propietario.nombres")+" "+
				paramResultSet.getString("propietario.apellido_pat")+" "+
				paramResultSet.getString("propietario.apellido_mat"));
		return mascotaVO;
	}

}
