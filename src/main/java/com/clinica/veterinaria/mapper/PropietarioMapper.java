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
		propVO.setApellido_pat(paramResultSet.getString(3));
		propVO.setApellido_mat(paramResultSet.getString(4));
		propVO.setRut(paramResultSet.getString(5));
		propVO.setTelefono(paramResultSet.getString(6));
		propVO.setEmail(paramResultSet.getString(7));
		propVO.setDireccion(paramResultSet.getString(8));
		propVO.setComuna(paramResultSet.getString(9));
		propVO.setProvincia(paramResultSet.getString(10));
		propVO.setRegion(paramResultSet.getString(11));
		return propVO;
	}

}
