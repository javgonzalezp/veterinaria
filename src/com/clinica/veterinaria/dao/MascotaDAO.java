package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.bean.MascotaBean;
import com.clinica.veterinaria.vo.PropietarioVO;

public interface MascotaDAO {
	public int agregarMascota(MascotaBean mascota);
	public int editarMascota(int id, MascotaBean mascota);
	public List<MascotaBean> listarMascotas(String propietarioId);
	public int eliminarMascota(int id);
	public String obtenerNombrePropietario(int propId);
	public List<PropietarioVO> obtenerPropietarios();
}
