package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.vo.ComunaVO;
import com.clinica.veterinaria.vo.RegionVO;

public interface PropietarioDAO {
	public int agregarPropietario(PropietarioBean propietario);
	public int editarPropietario(int id, PropietarioBean propietario);
	public List<PropietarioBean> listarPropietarios();
	public PropietarioBean obtenerPropietario(String rut);
	public int eliminarPropietario(int id);
	public List<RegionVO> obtenerRegiones();
	public List<ComunaVO> obtenerComunas();
}
