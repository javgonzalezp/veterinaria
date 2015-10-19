package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.MascotaVO;
import com.clinica.veterinaria.vo.PropietarioVO;

public class PropietarioSelectMapper implements RowMapper<PropietarioVO>{

	public PropietarioVO mapRow(ResultSet paramResultSet) throws SQLException {
		PropietarioVO propietarioVO = new PropietarioVO();
		propietarioVO.setId(paramResultSet.getInt(1));
		propietarioVO.setNombre(paramResultSet.getString(2) + " " + paramResultSet.getString(2) + " " + paramResultSet.getString(3));
		return propietarioVO;
	}

}
