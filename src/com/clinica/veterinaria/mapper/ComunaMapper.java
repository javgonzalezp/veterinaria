package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.ComunaVO;

public class ComunaMapper implements RowMapper<ComunaVO> {

	public ComunaVO mapRow(ResultSet paramResultSet) throws SQLException {
		ComunaVO comunaVO = new ComunaVO();
		comunaVO.setId(paramResultSet.getInt(1));
		comunaVO.setNombre(paramResultSet.getString(2));
		comunaVO.setRegionId(paramResultSet.getInt(3));
		return comunaVO;
	}

}
