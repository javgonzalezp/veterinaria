package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.bean.MascotaBean;

public interface MascotaDAO {
	public int agregarMascota(MascotaBean mascota);
	public int editarMascota(int id, MascotaBean mascota);
	public List<MascotaBean> listarMascotas();
	public int eliminarMascota(int id);
}
