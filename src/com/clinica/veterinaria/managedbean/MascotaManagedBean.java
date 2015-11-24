package com.clinica.veterinaria.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
	private Date currentDate = new Date();
	private String edad = null;

	public String getEdad() {
		this.edad = calcularEdad(selectedMascota.getFechaNacimiento());
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

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
		mascotaBean = null;
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
	
	private static String calcularEdad(Date birthDate)
	   {
	      int years = 0;
	      int months = 0;
	      int days = 0;
	      //create calendar object for birth day
	      Calendar birthDay = Calendar.getInstance();
	      birthDay.setTimeInMillis(birthDate.getTime());
	      //create calendar object for current day
	      long currentTime = System.currentTimeMillis();
	      Calendar now = Calendar.getInstance();
	      now.setTimeInMillis(currentTime);
	      //Get difference between years
	      years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	      int currMonth = now.get(Calendar.MONTH) + 1;
	      int birthMonth = birthDay.get(Calendar.MONTH) + 1;
	      //Get difference between months
	      months = currMonth - birthMonth;
	      //if month difference is in negative then reduce years by one and calculate the number of months.
	      if (months < 0)
	      {
	         years--;
	         months = 12 - birthMonth + currMonth;
	         if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	            months--;
	      } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         years--;
	         months = 11;
	      }
	      //Calculate the days
	      if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
	         days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
	      else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         int today = now.get(Calendar.DAY_OF_MONTH);
	         now.add(Calendar.MONTH, -1);
	         days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
	      } else
	      {
	         days = 0;
	         if (months == 12)
	         {
	            years++;
	            months = 0;
	         }
	      }
	      //Create new Age object
	      StringBuilder edad = new StringBuilder();
	      if(years != 0){
	    	  edad.append(years + " años ");
	      }
	      if(months != 0){
	    	  edad.append(months +" meses ");
	      }
	      if(days != 0){
	    	  edad.append(days + " días");
	      }
	      return edad.toString();
	   }
}
