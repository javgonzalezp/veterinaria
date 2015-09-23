package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;

public interface PropietarioDAO {
	public int agregarPropietario(PropietarioBean propietario);
	public int editarPropietario(int id, PropietarioBean propietario);
	public List<PropietarioBean> listarPropietarios();
	public PropietarioBean obtenerPropietario(String rut);
	public int eliminarPropietario(int id);
}
