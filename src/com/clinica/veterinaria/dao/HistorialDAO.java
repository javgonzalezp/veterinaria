package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.bean.HistorialBean;
import com.clinica.veterinaria.vo.MascotaVO;
import com.clinica.veterinaria.vo.UsuarioVO;

public interface HistorialDAO {
	public int agregarHistorial(HistorialBean historial);
	public int editarHistorial(int id, HistorialBean historial);
	public List<HistorialBean> listarHistoriales(String mascotaId);
	public int eliminarHistorial(int id);
	public List<UsuarioVO> obtenerUsuarios();
	public List<MascotaVO> obtenerMascotas();
}
