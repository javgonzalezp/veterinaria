package com.clinica.veterinaria.dao;

import java.util.List;

import com.clinica.veterinaria.vo.MascotaVO;

public interface MascotaDAO {
	public int agregarMascota(MascotaVO mascota);
	public int editarMascota(int id, MascotaVO mascota);
	public List<MascotaVO> listarMascotas();
	public int eliminarMascota(int id);
}
