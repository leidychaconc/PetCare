package ec.edu.ups.petcare.dao;

import java.util.List; 

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.petcare.modelo.Persona;

@Stateless //liberar recurso cuando ya no se necesita y ayuda transaccionalidad commit
//EJB sin estado
public class PersonaDAO {
	
	@Inject
	private EntityManager em; //conexion jpa
	
	public void insertar (Persona persona) {
		em.persist(persona);
		
		}
	public void actualizar (Persona persona) {
		em.merge(persona);
			
		}
	public void borrar (String cedula) {
		em.remove(this.leer(cedula));
	}
	public Persona leer (String cedula) {
		Persona persona =em.find(Persona.class , cedula);
		return persona;
	}
	
	//Mantenimiento Listar
	public List<Persona> getListPersona(){
		String jpql="SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);
		
		List<Persona> listado= query.getResultList();
		return listado;
	}

}
