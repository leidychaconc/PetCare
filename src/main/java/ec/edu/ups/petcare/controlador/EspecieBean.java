package ec.edu.ups.petcare.controlador;

import java.util.List;  

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.petcare.bussines.EspecieBussines;
import ec.edu.ups.petcare.modelo.Especie;

@ManagedBean
@ViewScoped
public class EspecieBean {
	@Inject
	private EspecieBussines espeBussines;
	private Especie newEspecie;
	private String id; 
	private boolean edit=false;
	private List<Especie> especies;
	
	@PostConstruct
	public void init() {
		newEspecie=new Especie();
		especies=espeBussines.getEspecie();
	}
	
	public String guardar() {
		try {
			if(edit==true)
				espeBussines.update(newEspecie);
			else
			espeBussines.save(newEspecie);
			System.out.println("registro guardado");

			return "Mantenimiento_Especie?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL GUARDA");
			e.printStackTrace();
		}
		return null;
	}
	
	public 	String borrar(int id) {

		try {
			espeBussines.delete(id);
			System.out.println("registro eliminado");
			return "Mantenimiento_Especie?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//EDITAR
		public void loadData() {
			System.out.println("load data"+ id);
			if(id==null)
				return;
			try {
				newEspecie=espeBussines.getEspecie(Integer.parseInt(id));
				edit=true;
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}
		
		public String editar(Especie espe) {
			edit=true;
			System.out.println(espe);
			return "Mantenimiento_Especie?faces-redirect=true&id="+espe.getEspeId();
		}

	///GETTER & SETTER
	
	public EspecieBussines getEspeBussines() {
		return espeBussines;
	}


	public void setEspeBussines(EspecieBussines espeBussines) {
		this.espeBussines = espeBussines;
	}


	public Especie getNewEspecie() {
		return newEspecie;
	}


	public void setNewEspecie(Especie newEspecie) {
		this.newEspecie = newEspecie;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	} 
	

	
}
