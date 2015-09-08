package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.vo.PropietarioVO;

public interface PropietarioDAO {
	public int agregarPropietario(PropietarioVO propietario);
	public int editarPropietario(int id, PropietarioVO propietario);
	public List<PropietarioVO> listarPropietarios();
	public PropietarioVO obtenerPropietario(String rut);
	public int eliminarPropietario(int id);
}
