package ec.edu.ups.petcare.controlador;

import java.util.ArrayList;  
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.petcare.bussines.MascotaBussiness;
import ec.edu.ups.petcare.bussines.PersonaBussiness;
import ec.edu.ups.petcare.bussines.RazaBussiness;
import ec.edu.ups.petcare.modelo.Mascota;
import ec.edu.ups.petcare.modelo.Persona;
import ec.edu.ups.petcare.modelo.Raza;

@ManagedBean
@ViewScoped
public class MascotaBean {
	@Inject
	private MascotaBussiness mascoBussiness;
	private Mascota newMascota;
	private int id;
	private int id2;
	private boolean edit;
	private List<Mascota>mascotas;
	/////
	
	
	@Inject
	private PersonaBussiness perBussiness;
	private Persona newPersona;
	private List<Persona> listPersonas;
	
	///////
	@Inject
	private RazaBussiness razaBussines;
	private Raza newRaza;
	private List<Raza> listRazas;
	
	@PostConstruct
	public void init() {
		newMascota=new Mascota();
		mascotas=mascoBussiness.getMascota();
		////box//
		listPersonas = perBussiness.getPersonas();
		newPersona = new Persona();
		////box//
		listRazas = razaBussines.getRaza();
		newRaza = new Raza();
		
		
		
	}
	
	public String guardar() 
	{
		System.out.println("Guardar  "+newMascota.getMascoNombre()+"    "+newMascota.getPersona().getCliCedula());
		try {
			if(edit) 
			{
				mascoBussiness.update(newMascota);
				//////
				
				razaBussines.update(newRaza);
			    //////
				mascotas=mascoBussiness.getMascota();
				return "Mantenimiento_Mascota?faces-redirect=true";
			}
			else
			{
				mascoBussiness.save(newMascota);
				//////
				razaBussines.save(newRaza);
				//////
				System.out.println("registro guardado");
				return "Mantenimiento_Mascota?faces-redirect=true";			
			}
	}
			catch (Exception e) {
			System.out.println("ERROR AL GUARDAR");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public String borrar(int id) {
		try {
			mascoBussiness.delete(id);
			System.out.println("registro eliminado");
			return "Mantenimiento_Mascota?faces-redirect=true";
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//editar
	public void loadData() {
		System.out.println("LOAD DATA MascotaBean " +id +"         "+id2);
		if(id==0 & id2==0 )
			return;
		try {
			newMascota=mascoBussiness.getMascota(id);
			newMascota=mascoBussiness.getMascota(id2);
			////////
			newPersona = newMascota.getPersona();
			List<Persona> aux= listPersonas;
			listPersonas = new ArrayList<>();
			listPersonas.add(newPersona);
			///////
			newRaza = newMascota.getRaza();
			List<Raza> aux2 = listRazas;
			listRazas= new ArrayList<>();
			listRazas.add(newRaza);
			
			int i=0;
			
			while (i<aux.size()) {
				if(aux.get(i).getCliCedula()==newPersona.getCliCedula() &
						aux2.get(i).getRazaId()==newRaza.getRazaId()) {
					System.out.println("----IF----"+ aux.get(i).getCliCedula() );
					
				}else  {
					System.out.println("----CASO--- +"+aux.get(i));
					listPersonas.add(aux.get(i));
					//////
					System.out.println("--Caso-- "+aux2.get(i));
					listRazas.add(aux2.get(i));
				}
				i++;	
			}
			edit=true;
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String editar(Mascota masco) {
		edit=true;
		System.out.println(masco);
		return "Mantenimiento_Mascota?faces-redirect=true&id="+masco.getMascoId();
	}

	public MascotaBussiness getMascoBussiness() {
		return mascoBussiness;
	}

	public void setMascoBussiness(MascotaBussiness mascoBussiness) {
		this.mascoBussiness = mascoBussiness;
	}

	public Mascota getNewMascota() {
		return newMascota;
	}

	public void setNewMascota(Mascota newMascota) {
		this.newMascota = newMascota;
	}

	

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	

	public List<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(List<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public PersonaBussiness getPerBussiness() {
		return perBussiness;
	}

	public void setPerBussiness(PersonaBussiness perBussiness) {
		this.perBussiness = perBussiness;
	}

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RazaBussiness getRazaBussines() {
		return razaBussines;
	}

	public void setRazaBussines(RazaBussiness razaBussines) {
		this.razaBussines = razaBussines;
	}

	public Raza getNewRaza() {
		return newRaza;
	}

	public void setNewRaza(Raza newRaza) {
		this.newRaza = newRaza;
	}

	public List<Raza> getListRazas() {
		return listRazas;
	}

	public void setListRazas(List<Raza> listRazas) {
		this.listRazas = listRazas;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	
	
	
}
