package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.MascotaVO;

public class MascotaSelectMapper implements RowMapper<MascotaVO>{

	public MascotaVO mapRow(ResultSet paramResultSet) throws SQLException {
		MascotaVO mascotaVO = new MascotaVO();
		mascotaVO.setId(paramResultSet.getInt(1));
		mascotaVO.setNombre(paramResultSet.getString(2));
		return mascotaVO;
	}

}
