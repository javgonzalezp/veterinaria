package com.clinica.veterinaria.bean;

import java.util.Date;

public class MascotaBean {
	private int id;
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private String inscripcion;
	private String color;
	private Date fechaNacimiento;
	private int propietarioId;
	private String propietarioNombre;
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPropietarioNombre() {
		return propietarioNombre;
	}
	public void setPropietarioNombre(String propietarioNombre) {
		this.propietarioNombre = propietarioNombre;
	}
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(String inscripcion) {
		this.inscripcion = inscripcion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPropietarioId() {
		return propietarioId;
	}
	public void setPropietarioId(int propietarioId) {
		this.propietarioId = propietarioId;
	}
	
	
}
