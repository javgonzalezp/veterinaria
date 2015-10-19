package com.clinica.veterinaria.bean;

import java.util.Date;

import com.clinica.veterinaria.base.vo.BaseVO;

public class HistorialBean extends BaseVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8200407470140393590L;
	private int id;
	private Date fecha;
	private String observaciones;
	private String tratamiento;
	private String nombreUsuario;
	private String nombreMascota;
	private int usuarioId;
	private int mascotaId;
	
	
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public int getMascotaId() {
		return mascotaId;
	}
	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
	}
	
	

}
