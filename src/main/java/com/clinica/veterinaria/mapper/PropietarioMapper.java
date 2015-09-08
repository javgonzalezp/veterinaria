package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.PropietarioVO;

public class PropietarioMapper implements RowMapper<PropietarioVO> {

	public PropietarioVO mapRow(ResultSet paramResultSet) throws SQLException {
		PropietarioVO propVO = new PropietarioVO();
		propVO.setId(paramResultSet.getInt(1));
		propVO.setNombres(paramResultSet.getString(2));
		propVO.setApellidoPat(paramResultSet.getString(3));
		propVO.setApellidoMat(paramResultSet.getString(4));
		propVO.setRut(paramResultSet.getString(5));
		propVO.setTelefono(paramResultSet.getString(6));
		propVO.setEmail(paramResultSet.getString(7));
		propVO.setDireccion(paramResultSet.getString(8));
		propVO.setComunaId(paramResultSet.getInt(9));
		propVO.setRegionId(paramResultSet.getInt(10));
		return propVO;
	}

}
