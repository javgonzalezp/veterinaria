package com.clinica.veterinaria.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.clinica.veterinaria.bean.HistorialBean;
import com.clinica.veterinaria.delegate.HistorialDelegate;
import com.clinica.veterinaria.vo.MascotaVO;
import com.clinica.veterinaria.vo.UsuarioVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class HistorialManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5708438790668633227L;
	private List<HistorialBean> historiales = null;
	private List<HistorialBean> filteredHistoriales = null;
	private HistorialBean historialBean = null;
	private HistorialDelegate historialDelegate = null;
	private HistorialBean selectedHistorial = null;
	private HistorialBean editedHistorial = null;
	private List<UsuarioVO> usuarios = null;
	private List<MascotaVO> mascotas = null;
	private String valorSelectOne = null;
	private String valorSelectOneMascota = null;
	private Date currentDate = new Date();
	
	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public List<MascotaVO> getMascotas() {
		if(mascotas == null){
			mascotas = obtenerMascotas();
		}
		return mascotas;
	}

	public void setMascotas(List<MascotaVO> mascotas) {
		this.mascotas = mascotas;
	}

	public String getValorSelectOneMascota() {
		return valorSelectOneMascota;
	}

	public void setValorSelectOneMascota(String valorSelectOneMascota) {
		this.valorSelectOneMascota = valorSelectOneMascota;
	}

	public String getValorSelectOne() {
		return valorSelectOne;
	}

	public void setValorSelectOne(String valorSelectOne) {
		this.valorSelectOne = valorSelectOne;
	}

	public List<UsuarioVO> getUsuarios() {
		if(usuarios == null){
			usuarios = obtenerUsuarios();
		}
		return usuarios;
	}

	private List<UsuarioVO> obtenerUsuarios() {
		historialDelegate = new HistorialDelegate();
		List<UsuarioVO> usuariosSQL = historialDelegate.obtenerUsuarios();
		return usuariosSQL;
	}
	
	private List<MascotaVO> obtenerMascotas() {
		historialDelegate = new HistorialDelegate();
		List<MascotaVO> mascotasSQL = historialDelegate.obtenerMascotas();
		return mascotasSQL;
	}

	public void setUsuarios(List<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}

	public List<HistorialBean> getFilteredHistoriales() {
		return filteredHistoriales;
	}

	public void setFilteredHistoriales(List<HistorialBean> filterHistoriales) {
		this.filteredHistoriales = filterHistoriales;
	}

	public HistorialBean getEditedHistorial() {
		if(editedHistorial == null){
			editedHistorial = new HistorialBean();
		}
		return editedHistorial;
	}

	public void setEditedHistorial(HistorialBean editedHistorial) {
		this.editedHistorial = editedHistorial;
	}

	public HistorialBean getSelectedHistorial() {
		return selectedHistorial;
	}

	public void setSelectedHistorial(HistorialBean selectedHistorial) {
		this.selectedHistorial = selectedHistorial;
	}

	public List<HistorialBean> getHistoriales() {
		setHistoriales(obtenerHistoriales());
		return historiales;
	}

	public void setHistoriales(List<HistorialBean> historiales) {
		this.historiales = historiales;
	}

	public HistorialBean getHistorialBean() {
		if(historialBean == null){
			historialBean = new HistorialBean();
		}
		if((Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mascotaId")!=null){
			int mascotaId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mascotaId");
			setValorSelectOneMascota(String.valueOf(mascotaId));
		}
		return historialBean;
	}

	public void setHistorialBean(HistorialBean historialBean) {
		this.historialBean = historialBean;
	}

	public String agregarHistorial(){
		historialDelegate = new HistorialDelegate();
		historialBean.setUsuarioId(Integer.valueOf(getValorSelectOne()));
		historialBean.setMascotaId(Integer.valueOf(getValorSelectOneMascota()));
		String response = historialDelegate.agregarHistorial(historialBean);
		historialBean = null;
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public List<HistorialBean> obtenerHistoriales(){
		int mascotaId = 0;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mascotaId")!=null){
			mascotaId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mascotaId");
		}
		historialDelegate = new HistorialDelegate();
		return historialDelegate.obtenerHistoriales(String.valueOf(mascotaId));
	}
	
	public String eliminarHistorial(Integer id){
		historialDelegate = new HistorialDelegate();
		String response = historialDelegate.eliminarHistorial(id);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public String editarHistorial(Integer id){
		historialDelegate = new HistorialDelegate();
		String response = historialDelegate.editarHistorial(editedHistorial);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public void obtenerTodosHistoriales(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("mascotaId");
		historialDelegate = new HistorialDelegate();
		setHistoriales(historialDelegate.obtenerHistoriales("0"));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/veterinaria/historiales/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
