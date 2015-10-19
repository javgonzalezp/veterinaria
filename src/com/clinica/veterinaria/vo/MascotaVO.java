package com.clinica.veterinaria.vo;

import com.clinica.veterinaria.base.vo.BaseVO;

public class MascotaVO  extends BaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7898457366515414377L;
	private int id;
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
