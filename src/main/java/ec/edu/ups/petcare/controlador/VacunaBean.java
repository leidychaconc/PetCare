package ec.edu.ups.petcare.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.petcare.bussines.VacunaBussiness;
import ec.edu.ups.petcare.modelo.Vacuna;


/**
 * Aqui se puede poner los bean propiertes que son los que tienen relacion con 
 * los campos de entrada o los action controller de los botones
 * */
@ManagedBean
@ViewScoped
public class VacunaBean 
{
	@Inject
	private VacunaBussiness vacBussiness;
	
	private Vacuna newVacuna;
	
	private List<Vacuna> vacunas;
	
	private boolean editing;
	
	/**
	 * Variable que almacena el id de la vacuna cuando se va a editar
	 * */
	private int id;
	
	@Inject
	private FacesContext facesContext;
	
	@PostConstruct
	public void init()
	{
		newVacuna = new Vacuna();
		vacunas = vacBussiness.getVacunas();
		setEditing(false);
	}

		
	public Vacuna getNewVacuna() {
		return newVacuna;
	}

	public void setNewVacuna(Vacuna newVacuna) {
		this.newVacuna = newVacuna;
	}

	public List<Vacuna> getVacunas() {
		return vacunas;
	}

	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) 
	{
		System.out.println("id param ---- vacuna bean" + id);
		this.id = id;
	}


	public String guardar()
	{
		System.out.println("editando " + editing);
		try
		{
			if(editing)
				vacBussiness.actualizar(newVacuna);
			else
				vacBussiness.save(newVacuna);
			System.out.println("Registro Guardado");
			return "Mantenimiento_Vacunas?faces-redirect=true";
		} 
		catch (Exception e) 
		{
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public String eliminar(int id)
	{
		System.out.println("ID Vacuna  eliminar en vacuna bean  :"+ id);
		try
		{
			vacBussiness.eliminarVacuna(id);
			return "Mantenimiento_Vacunas?faces-redirect=true";
		}
		catch (Exception e)
		{
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Vacuna vacu) 
	{
		editing = true;
		System.out.println(vacu);
		return "Mantenimiento_Vacunas?faces-redirect=true&id="+vacu.getId();
	}
	
	
	public void loadData() 
	{
		
		System.out.println("load data " + id);
		if(id==0)
			return;
		try 
		{
			System.out.println("Print del try del load DATA");
			newVacuna = vacBussiness.getVacuna(id);
			editing = true;
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
	}
	
}
