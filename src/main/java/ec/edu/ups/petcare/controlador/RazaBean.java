package ec.edu.ups.petcare.controlador;

import java.util.ArrayList; 
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.petcare.bussines.EspecieBussines;
import ec.edu.ups.petcare.bussines.RazaBussiness;
import ec.edu.ups.petcare.modelo.Especie;
import ec.edu.ups.petcare.modelo.Raza;


@ManagedBean
@ViewScoped
public class RazaBean {
	
	@Inject
	private RazaBussiness razaBussiness;
	private Raza newRaza;
	private int id; 
	private boolean edit;
	private List<Raza> razas;
	
	//////box/////
	@Inject
	private EspecieBussines espeBussines;
	private Especie newEspecie;
	private List<Especie> listEspecies;
	
	@PostConstruct
	public void init() {
		newRaza=new Raza();
		razas=razaBussiness.getRaza();
		////////box////
		listEspecies = espeBussines.getEspecie();
		newEspecie = new Especie();
		
	}
	
	public String guardar() {
		try 
		{
			if(edit) 
			{
				razaBussiness.update(newRaza);
				razas= razaBussiness.getRaza();
				return "Mantenimiento_Raza?faces-redirect=true";
			}
			else 
			{
				razaBussiness.save(newRaza);
				System.out.println("registro guardado");
				return "Mantenimiento_Raza?faces-redirect=true";
			}
	} 
	catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("ERROR AL GUARDA");
			e.printStackTrace();
		}
		return null;
	}
	
	public 	String borrar(int id) {

		try {
			razaBussiness.delete(id);
			System.out.println("registro eliminado");
			return "Mantenimiento_Raza?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
		public void loadData() {
			System.out.println("load data RazaBean"+ id);
			
			if(id==0)
				return;
			try {
				newRaza=razaBussiness.getRaza(id);
				/////////
				newEspecie = newRaza.getEspecie();
				List<Especie> aux = listEspecies;
				listEspecies = new ArrayList<>();
				listEspecies.add(newEspecie);
				int i=0;
				
				while (i<aux.size()) {
					if (aux.get(i).getEspeId()==newEspecie.getEspeId()) {
						System.out.println(" ---if-- "+aux.get(i).getEspeId()+ "  "+aux.get(i).getEspeNombre());
						
					}else {
						System.out.println("--Caso-- "+aux.get(i));
						listEspecies.add(aux.get(i));
					}
					i++;
				}
				edit=true;
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}
		
		public String editar(Raza raza) {
			edit=true;
			System.out.println(raza);
			return"Mantenimiento_Raza?faces-redirect=true&id="+raza.getRazaId();
		}

		
		public RazaBussiness getRazaBussiness() {
			return razaBussiness;
		}

		public void setRazaBussiness(RazaBussiness razaBussiness) {
			this.razaBussiness = razaBussiness;
		}

		public Raza getNewRaza() {
			return newRaza;
		}

		public void setNewRaza(Raza newRaza) {
			this.newRaza = newRaza;
		}

		

		public boolean isEdit() {
			return edit;
		}

		public void setEdit(boolean edit) {
			this.edit = edit;
		}

		public List<Raza> getRazas() {
			return razas;
		}

		public void setRazas(List<Raza> razas) {
			this.razas = razas;
		}

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

		public List<Especie> getListEspecies() {
			return listEspecies;
		}

		public void setListEspecies(List<Especie> listEspecies) {
			this.listEspecies = listEspecies;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
	
	
}
