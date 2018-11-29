package ec.edu.ups.petcare.controlador;

import java.util.List;  

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.petcare.bussines.PersonaBussiness;
import ec.edu.ups.petcare.modelo.Persona;

@ManagedBean
@ViewScoped
public class PersonaBean {
	@Inject
	private PersonaBussiness perBussines;
	private Persona newPersona;
	private List<Persona> personas;
	private String id;
	private boolean edit=false;
	
	@PostConstruct
	public void init() {
		newPersona=new Persona();
		personas=perBussines.getPersonas();
	}
	
	public String guardar() {
		try{
		if(edit==true)
			perBussines.update(newPersona);
		else
		
			perBussines.save(newPersona);
			System.out.println("registro guardado");
			return "Mantenimiento_Persona?faces-redirect=true";
		}catch(Exception e) {

			System.out.println("ERROR AL GUARDA");
			e.printStackTrace();
		}
		//pdao.insertar(persona);
		return null;
		
	}
	public String eliminar(String cedula) {
		System.out.println("ID cedula   :"+ cedula);
		try
		{
			perBussines.eliminarPersona(cedula);
			System.out.println("registro eliminado");
			return "Mantenimiento_Persona?faces-redirect=true";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	
	}
	//editar
	public void loadData() {
		
		System.out.println("load data" + id);
		if(id==null)
			return;
		
			try {
				newPersona=perBussines.getEditPersona(id);
				edit=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public String editar (Persona per) {
		edit=true;
		System.out.println(per);
		return "Mantenimiento_Persona?faces-redirect=true&id="+per.getCliCedula();
	}

	public PersonaBussiness getPerBussines() {
		return perBussines;
	}

	public void setPerBussines(PersonaBussiness perBussines) {
		this.perBussines = perBussines;
	}

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
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
