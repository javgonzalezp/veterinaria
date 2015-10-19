package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.vo.UsuarioVO;

public class UsuarioMapper implements RowMapper<UsuarioVO> {

	public UsuarioVO mapRow(ResultSet paramResultSet) throws SQLException {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setId(paramResultSet.getInt(1));
		usuarioVO.setNombre(paramResultSet.getString(2));
		return usuarioVO;
	}

}
