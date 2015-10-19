package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.RegionVO;

public class RegionMapper implements RowMapper<RegionVO> {

	public RegionVO mapRow(ResultSet paramResultSet) throws SQLException {
		RegionVO regionVO = new RegionVO();
		regionVO.setId(paramResultSet.getInt(1));
		regionVO.setNombre(paramResultSet.getString(2));
		return regionVO;
	}

}
