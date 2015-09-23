package com.clinica.veterinaria.managedbean;

import java.io.Serializable;
import java.util.List;

import com.clinica.veterinaria.bean.PropietarioBean;
import com.clinica.veterinaria.delegate.PropietarioDelegate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PropietarioManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5708438790668633227L;
	private List<PropietarioBean> propietarios = null;
	private List<PropietarioBean> filteredPropietarios = null;
	private PropietarioBean propietarioBean = null;
	private PropietarioDelegate propietarioDelegate = null;
	private PropietarioBean selectedPropietario = null;
	private PropietarioBean editedPropietario = null;
	
	public List<PropietarioBean> getFilteredPropietarios() {
		return filteredPropietarios;
	}

	public void setFilteredPropietarios(List<PropietarioBean> filterPropietarios) {
		this.filteredPropietarios = filterPropietarios;
	}

	public PropietarioBean getEditedPropietario() {
		if(editedPropietario == null){
			editedPropietario = new PropietarioBean();
		}
		return editedPropietario;
	}

	public void setEditedPropietario(PropietarioBean editedPropietario) {
		this.editedPropietario = editedPropietario;
	}

	public PropietarioBean getSelectedPropietario() {
		return selectedPropietario;
	}

	public void setSelectedPropietario(PropietarioBean selectedPropietario) {
		this.selectedPropietario = selectedPropietario;
	}

	public List<PropietarioBean> getPropietarios() {
		setPropietarios(obtenerPropietarios());
		return propietarios;
	}

	public void setPropietarios(List<PropietarioBean> propietarios) {
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
	
	public List<PropietarioBean> obtenerPropietarios(){
		propietarioDelegate = new PropietarioDelegate();
		return propietarioDelegate.obtenerPropietarios();
	}
	
	public String eliminarPropietario(String id){
		propietarioDelegate = new PropietarioDelegate();
		String response = propietarioDelegate.eliminarPropietario(id);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public String editarPropietario(String id){
		propietarioDelegate = new PropietarioDelegate();
		String response = propietarioDelegate.editarPropietario(editedPropietario);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}

}
