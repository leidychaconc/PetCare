package ec.edu.ups.petcare.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.petcare.bussines.CitaBussiness;
import ec.edu.ups.petcare.modelo.Cita_Medica;

/**
 * Aqui se puede poner los bean propiertes que son los que tienen relacion con 
 * los campos de entrada o los action controller de los botones
 * */
@ManagedBean
public class CitaBean 
{
	@Inject
	private CitaBussiness citaBussiness;

	private Cita_Medica newCitaMedica;
	
	private List<Cita_Medica> citas;
	
	private FacesContext facesContext;
	
	@PostConstruct
	public void init()
	{
		newCitaMedica = new Cita_Medica();
		citas = citaBussiness.getCitas();
	}

	public Cita_Medica getNewCitaMedica() {
		return newCitaMedica;
	}

	public void setNewCitaMedica(Cita_Medica newCitaMedica) {
		this.newCitaMedica = newCitaMedica;
	}

	public List<Cita_Medica> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita_Medica> citas) {
		this.citas = citas;
	}
	
	public String guardar()
	{
		try
		{
			citaBussiness.save(newCitaMedica);
			System.out.println("CLASE CITA BEAN........ METODO GUARDDAR Cita Medica Guardada......");
			return "mantenimiento_citas_medicas?faces-redirect=true";
		}
		catch (Exception e)
		{
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void loadDatosEditar(String id)
	{
		
	}
	
	
	public String eliminar(int id)
	{
		System.out.println("METODO ELIMINAR CLASE CITA BEAN");
		try
		{
			citaBussiness.eliminar_cita(id);
			return "mantenimiento_citas_medicas?faces-redirect=true";
		}
		catch (Exception e)
		{
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}
	
	
}
