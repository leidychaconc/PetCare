package ec.edu.ups.petcare.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.petcare.modelo.Cita_Medica;




//Para lo que son DAO estos deben ser de tipo Stateles, son objetos que internamente tienen la transaccionalidad
//Un metodo de stateless si usa jpa ya tiene atomicidad.
@Stateless
public class CitaMedicaDAO 
{
	
	@Inject
	private EntityManager em;
	
	
	public void insert(Cita_Medica cita)
	{
		em.persist(cita);
	}
	
	public void update(Cita_Medica cita)
	{
		em.merge(cita);
	}
	
	public void remove(int id)
	{
		
		em.remove(this.read(id));
	}
	
	public Cita_Medica read(int i)
	{
		Cita_Medica cit=em.find(Cita_Medica.class, i);
		return cit;
	}
	
	
	/**
	 * Este metodo lista todas las personas registradas en la base de datos
	 * */
	@SuppressWarnings("unchecked")
	public List<Cita_Medica> getCitasMedicas()
	{
		//En jpql no existe el producto cartesiano
		//jpql respeta el uso de mayusculas y minusculas
		String jpql = "SELECT cit FROM Cita_Medica cit";
		//String jpql = "SELECT p FROM Persona ORDER BY p.nombre";
		
		Query query = em.createQuery(jpql, Cita_Medica.class);
		List <Cita_Medica> listado = query.getResultList();


		return listado;
	}
	

}
