package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.vo.HistorialVO;

public interface HistorialDAO {
	public int agregarHistorial(HistorialVO historial);
	public int editarHistorial(int id, HistorialVO historial);
	public List<HistorialVO> listarHistoriales();
	public int eliminarHistorial(int id);
}
