package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.ComunaVO;

public class ComunaNombreMapper implements RowMapper<String> {

	public String mapRow(ResultSet paramResultSet) throws SQLException {
		return paramResultSet.getString("comuna_nombre");
	}

}
