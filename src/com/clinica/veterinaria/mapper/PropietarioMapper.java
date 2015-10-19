package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.bean.PropietarioBean;

public class PropietarioMapper implements RowMapper<PropietarioBean> {

	public PropietarioBean mapRow(ResultSet paramResultSet) throws SQLException {
		PropietarioBean propVO = new PropietarioBean();
		propVO.setId(paramResultSet.getInt(1));
		propVO.setNombres(paramResultSet.getString(2));
		propVO.setApellidoPat(paramResultSet.getString(3));
		propVO.setApellidoMat(paramResultSet.getString(4));
		propVO.setRut(paramResultSet.getString(5));
		propVO.setTelefono(paramResultSet.getString(6));
		propVO.setEmail(paramResultSet.getString(7));
		propVO.setDireccion(paramResultSet.getString(8));
		propVO.setComuna(paramResultSet.getString(9));
		propVO.setRegion(paramResultSet.getString(10));
		return propVO;
	}

}
