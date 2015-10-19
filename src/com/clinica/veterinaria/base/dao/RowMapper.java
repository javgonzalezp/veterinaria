package com.clinica.veterinaria.base.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	public abstract T mapRow(ResultSet paramResultSet) throws SQLException;	
}
