package com.clinica.veterinaria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinica.veterinaria.base.dao.RowMapper;
import com.clinica.veterinaria.bean.HistorialBean;

public class HistorialMapper implements RowMapper<HistorialBean>{

	public HistorialBean mapRow(ResultSet paramResultSet) throws SQLException {
		HistorialBean historialVO = new HistorialBean();
		historialVO.setId(paramResultSet.getInt("historial.id_historial"));
		historialVO.setFecha(paramResultSet.getDate("historial.fecha"));
		historialVO.setObservaciones(paramResultSet.getString("historial.observaciones"));
		historialVO.setTratamiento(paramResultSet.getString("historial.tratamiento"));
		historialVO.setFechaProxControl(paramResultSet.getDate("historial.fecha_prox_control"));
		historialVO.setMascotaId(paramResultSet.getInt("historial.mascota_id"));
		historialVO.setUsuarioId(paramResultSet.getInt("historial.usuario_id"));
		historialVO.setNombreUsuario(paramResultSet.getString("usuario.nombre"));
		historialVO.setNombreMascota(paramResultSet.getString("mascota.nombre"));
		return historialVO;
	}

}
