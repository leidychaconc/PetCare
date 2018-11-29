package ec.edu.ups.petcare.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.PersonaDAO;
import ec.edu.ups.petcare.modelo.Especie;
import ec.edu.ups.petcare.modelo.Persona;
@Stateless
public class PersonaBussiness {
	
	@Inject
	private PersonaDAO dao;
	
	public boolean save(Persona persona) throws Exception{
		Persona aux=dao.leer(persona.getCliCedula());
		if(aux!=null)
			dao.actualizar(persona);
		else
			dao.insertar(persona);
		return true;
	}
	
	public List<Persona> getPersonas(){
		return dao.getListPersona();
		
	}
	
	public void eliminarPersona(String cedula) throws Exception {
		Persona aux=dao.leer(cedula);
		if(aux==null)
			throw  new Exception("registro no existe");
		else
			dao.borrar(cedula);
	}
//EDITAR
	
	public void update(Persona persona)throws Exception{
		Persona aux=dao.leer(persona.getCliCedula());
		if(aux==null)
			throw new Exception("persona no existe");
		else
			dao.actualizar(persona);
	}
	
	public Persona getEditPersona(String cedula) throws Exception{
		Persona aux=dao.leer(cedula);
		if(aux==null)
			throw new Exception("persona no exite");
		else
			return aux;
	}

}
