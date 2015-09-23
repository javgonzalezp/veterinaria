package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.bean.HistorialBean;

public interface HistorialDAO {
	public int agregarHistorial(HistorialBean historial);
	public int editarHistorial(int id, HistorialBean historial);
	public List<HistorialBean> listarHistoriales();
	public int eliminarHistorial(int id);
}
