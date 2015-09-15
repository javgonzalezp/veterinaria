package com.clinica.veterinaria.managedbean;

import java.io.Serializable;
import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.delegate.PropietarioDelegate;
import com.clinica.veterinaria.vo.PropietarioVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PropietarioManagedBean implements Serializable{

	private List<PropietarioVO> propietarios = null;
	private PropietarioBean propietarioBean = null;
	private PropietarioDelegate propietarioDelegate = null;
	
	public List<PropietarioVO> getPropietarios() {
		setPropietarios(obtenerPropietarios());
		return propietarios;
	}

	public void setPropietarios(List<PropietarioVO> propietarios) {
		this.propietarios = propietarios;
	}

	public PropietarioBean getPropietarioBean() {
		if(propietarioBean == null){
			propietarioBean = new PropietarioBean();
		}
		return propietarioBean;
	}

	public void setPropietarioBean(PropietarioBean propietarioBean) {
		this.propietarioBean = propietarioBean;
	}

	public String agregarPropietario(){
		propietarioDelegate = new PropietarioDelegate();
		String response = propietarioDelegate.agregarPropietario(propietarioBean);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public List<PropietarioVO> obtenerPropietarios(){
		propietarioDelegate = new PropietarioDelegate();
		return propietarioDelegate.obtenerPropietarios();
	}

}
