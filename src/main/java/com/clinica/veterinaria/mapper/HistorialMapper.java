package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.bean.HistorialBean;

public class HistorialMapper implements RowMapper<HistorialBean>{

	public HistorialBean mapRow(ResultSet paramResultSet) throws SQLException {
		HistorialBean historialVO = new HistorialBean();
		historialVO.setId(paramResultSet.getInt(1));
		historialVO.setFecha(paramResultSet.getDate(2));
		historialVO.setObservaciones(paramResultSet.getString(3));
		historialVO.setTratamiento(paramResultSet.getString(4));
		historialVO.setMascotaId(paramResultSet.getInt(5));
		return historialVO;
	}

}
