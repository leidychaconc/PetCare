package ec.edu.ups.petcare.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import ec.edu.ups.petcare.bussines.HistorialVacunasBussiness;
import ec.edu.ups.petcare.bussines.VacunaBussiness;
import ec.edu.ups.petcare.modelo.HistorialVacunas;
import ec.edu.ups.petcare.modelo.Vacuna;


@ManagedBean(name="historialVacunasBean")
@ViewScoped
public class HistorialVacunasBean 
{
	@Inject
	private HistorialVacunasBussiness hisVacBussiness;
	
	@Inject
	private VacunaBussiness vacBussiness;
	
	private HistorialVacunas newHistorialVacunas;
	
	private List<HistorialVacunas> hisVacunas;
	
	private List<Vacuna> listVacunas;
	
	private Vacuna newVacuna;
	
	private boolean editing;
	
	private int id;
	
	@Inject
	private FacesContext facesContext;
	
	@PostConstruct
	public void init()
	{
		newHistorialVacunas = new HistorialVacunas();
		hisVacunas = hisVacBussiness.getHistorialVacunass();
		listVacunas = vacBussiness.getVacunas();
		newVacuna = new Vacuna();
		setEditing(false);
	}
	
	
	public HistorialVacunas getNewHistorialVacunas() {
		return newHistorialVacunas;
	}

	public void setNewHistorialVacunas(HistorialVacunas newHistorialVacunas) {
		this.newHistorialVacunas = newHistorialVacunas;
	}

	public List<HistorialVacunas> getHisVacunas() {
		return hisVacunas;
	}

	public void setHisVacunas(List<HistorialVacunas> hisVacunas) {
		this.hisVacunas = hisVacunas;
	}
	
		
	public List<Vacuna> getListVacunas() 
	{
		return listVacunas;
	}

	public void setListVacunas(List<Vacuna> listVacunas) 
	{
		this.listVacunas = listVacunas;
	}

	
	public Vacuna getNewVacuna() {
		return newVacuna;
	}

	public void setNewVacuna(Vacuna newVacuna)
	{
		this.newVacuna = newVacuna;
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
		System.out.println("Set ID Historial Vacuna bean   "+id);
		this.id = id;
	}


	public String guardar()
	{
		System.out.println("Metodo guardar en el bean       "+this.newHistorialVacunas.getVacuna().getNombre());
		System.out.println("editando    "+editing);
		try
		{
			if (editing)
			{
				System.out.println(newHistorialVacunas.getVacuna().getNombre());
				hisVacBussiness.actualizar(newHistorialVacunas);
				hisVacunas = hisVacBussiness.getHistorialVacunass();
				return "mantenimiento_historial_vacunas?faces-redirect=true";
			}
			else
			{
				hisVacBussiness.save(newHistorialVacunas);
				System.out.println("Registro Guardado");
				System.out.println("CLASE HISTORIAL VACUNAS BEAN..... METODO GUARDAR HISTORIAL DE VACUNAS GUARDADADA");
				return "mantenimiento_historial_vacunas?faces-redirect=true";
			}
		}
		catch(Exception e)
		{
			System.out.println("Catch del guardar del BEAN HISTORIAL VACUNAS");
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}
	
	public String editar(HistorialVacunas hisvac)
	{
		editing = true;
		System.out.println(hisvac);
		return "mantenimiento_historial_vacunas?faces-redirect=true&id="+hisvac.getId();
	}
	
	public void loadData()
	{
		System.out.println("Load Data HistorialVacunasBean     "+id);
		if(id==0)
			return;
		else
		{
			try
			{
				System.out.println("Print del try del LOAD DATA DE HISTORIALVACUNASBEAN");
				newHistorialVacunas = hisVacBussiness.getHistorialVacunas(id);
				System.out.println(newHistorialVacunas.getId()+"     "+newHistorialVacunas.getFecha_aplicacion()+"     "+newHistorialVacunas.getFecha_proxima_aplicacion()+"     "+newHistorialVacunas.getDescripcion()+"     "+newHistorialVacunas.getPeso()+"     "+newHistorialVacunas.getVacuna().getId()+"     "+newHistorialVacunas.getVacuna().getNombre());
				newVacuna = newHistorialVacunas.getVacuna();
				List<Vacuna> aux = listVacunas;
				listVacunas = new ArrayList<>();
				listVacunas.add(newVacuna);
				int i=0;
				while (i<aux.size())
				{
					if(aux.get(i).getId()==newVacuna.getId())
					{
						System.out.println("IF   "+aux.get(i).getId()+"    "+aux.get(i).getNombre());
					}
					else
					{
						System.out.println("ELSE    "+aux.get(i));
						listVacunas.add(aux.get(i));
					}
					i++;
				}
				editing = true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"Error");
				facesContext.addMessage(null, m);
				
			}
		}
		
	}
	
	
	
	public String eliminar(int id_historial_vacunas)
	{
		System.out.println("ID Historial Vacunas    :        metodo eliminar"+ id_historial_vacunas);
		try
		{
			hisVacBussiness.eliminarHistorialVacuna(id_historial_vacunas);
			return "mantenimiento_historial_vacunas?faces-redirect=true";
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
