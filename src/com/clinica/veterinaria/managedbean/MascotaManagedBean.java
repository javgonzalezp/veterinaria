package com.clinica.veterinaria.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.clinica.veterinaria.bean.MascotaBean;
import com.clinica.veterinaria.delegate.MascotaDelegate;
import com.clinica.veterinaria.vo.PropietarioVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MascotaManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5708438790668633227L;
	private List<MascotaBean> mascotas = null;
	private List<MascotaBean> filteredMascotas = null;
	private MascotaBean mascotaBean = null;
	private MascotaDelegate mascotaDelegate = null;
	private MascotaBean selectedMascota = null;
	private MascotaBean editedMascota = null;
	private String nombrePropietario = null;
	private List<PropietarioVO> propietarios = null;
	private String valorSelectOne = null;

	public String getValorSelectOne() {
		return valorSelectOne;
	}

	public void setValorSelectOne(String valorSelectOne) {
		this.valorSelectOne = valorSelectOne;
	}

	public List<PropietarioVO> getPropietarios() {
		if(propietarios == null){
			propietarios = obtenerPropietarios();
		}
		return propietarios;
	}

	public void setPropietarios(List<PropietarioVO> propietarios) {
		this.propietarios = propietarios;
	}

	public String getNombrePropietario() {
		if((Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("propId")!=null){
			if(nombrePropietario == null){
				int propId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("propId");
				nombrePropietario = "Mascotas de "+mascotaDelegate.obtenerNombrePropietario(propId);
			}
		}
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public List<MascotaBean> getFilteredMascotas() {
		return filteredMascotas;
	}

	public void setFilteredMascotas(List<MascotaBean> filterMascotas) {
		this.filteredMascotas = filterMascotas;
	}

	public MascotaBean getEditedMascota() {
		if(editedMascota == null){
			editedMascota = new MascotaBean();
		}
		return editedMascota;
	}

	public void setEditedMascota(MascotaBean editedMascota) {
		this.editedMascota = editedMascota;
	}

	public MascotaBean getSelectedMascota() {
		return selectedMascota;
	}

	public void setSelectedMascota(MascotaBean selectedMascota) {
		this.selectedMascota = selectedMascota;
	}

	public List<MascotaBean> getMascotas() {
//		if(mascotas == null){
			mascotas = obtenerMascotas();
//		}
		return mascotas;
	}

	public void setMascotas(List<MascotaBean> mascotas) {
		this.mascotas = mascotas;
	}

	public MascotaBean getMascotaBean() {
		if(mascotaBean == null){
			mascotaBean = new MascotaBean();
		}
		if((Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("propId")!=null){
			int propId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("propId");
			setValorSelectOne(String.valueOf(propId));
		}
		return mascotaBean;
	}

	public void setMascotaBean(MascotaBean mascotaBean) {
		this.mascotaBean = mascotaBean;
	}

	public String agregarMascota(){
		mascotaDelegate = new MascotaDelegate();
		mascotaBean.setPropietarioId(Integer.valueOf(getValorSelectOne()));
		String response = mascotaDelegate.agregarMascota(mascotaBean);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public List<MascotaBean> obtenerMascotas(){
		int propId = 0;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("propId")!=null){
			propId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("propId");
		} 
		mascotaDelegate = new MascotaDelegate();
		return mascotaDelegate.obtenerMascotas(String.valueOf(propId));
	}
	
	public void obtenerTodasMascotas(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("propId");
		mascotaDelegate = new MascotaDelegate();
		setMascotas(mascotaDelegate.obtenerMascotas("0"));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/veterinaria/mascotas/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String eliminarMascota(Integer id){
		mascotaDelegate = new MascotaDelegate();
		String response = mascotaDelegate.eliminarMascota(id);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public String editarMascota(Integer id){
		mascotaDelegate = new MascotaDelegate();
		String response = mascotaDelegate.editarMascota(editedMascota);
		if(response.equalsIgnoreCase("success")){
			return "index";
		} else {
			return "failure";
		}
	}
	
	public void listarHistorialMascota(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mascotaId", getSelectedMascota().getId());
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/veterinaria/historiales/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<PropietarioVO> obtenerPropietarios() {
		mascotaDelegate = new MascotaDelegate();
		List<PropietarioVO> propietariosSQL = mascotaDelegate.obtenerPropietarios();
		return propietariosSQL;
	}

}
