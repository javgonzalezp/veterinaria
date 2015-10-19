package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;

public class NombrePropietarioMapper implements RowMapper<String> {

	public String mapRow(ResultSet paramResultSet) throws SQLException {
		StringBuilder nombre = new StringBuilder();
		nombre.append(paramResultSet.getString("nombres"));
		nombre.append(" ");
		nombre.append(paramResultSet.getString("apellido_pat"));
		nombre.append(" ");
		nombre.append(paramResultSet.getString("apellido_mat"));
		return nombre.toString();
	}

}
