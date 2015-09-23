package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.bean.MascotaBean;

public class MascotaMapper implements RowMapper<MascotaBean>{

	public MascotaBean mapRow(ResultSet paramResultSet) throws SQLException {
		MascotaBean mascotaVO = new MascotaBean();
		mascotaVO.setId(paramResultSet.getInt(1));
		mascotaVO.setNombre(paramResultSet.getString(2));
		mascotaVO.setEspecie(paramResultSet.getString(3));
		mascotaVO.setRaza(paramResultSet.getString(4));
		mascotaVO.setSexo(paramResultSet.getString(5));
		mascotaVO.setInscripcion(paramResultSet.getString(6));
		mascotaVO.setColor(paramResultSet.getString(7));
		mascotaVO.setPropietarioId(paramResultSet.getInt(8));
		return mascotaVO;
	}

}
