package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.HistorialVO;

public class HistorialMapper implements RowMapper<HistorialVO>{

	public HistorialVO mapRow(ResultSet paramResultSet) throws SQLException {
		HistorialVO historialVO = new HistorialVO();
		historialVO.setId(paramResultSet.getInt(1));
		historialVO.setFecha(paramResultSet.getDate(2));
		historialVO.setObservaciones(paramResultSet.getString(3));
		historialVO.setTratamiento(paramResultSet.getString(4));
		historialVO.setMascotaId(paramResultSet.getInt(5));
		return historialVO;
	}

}
