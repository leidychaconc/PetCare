package ec.edu.ups.petcare.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.petcare.modelo.HistorialVacunas;

@Stateless
public class HistorialVacunasDAO 
{
	@Inject
	private EntityManager em;
	
	public void insert(HistorialVacunas vacunacion)
	{
		em.persist(vacunacion);
	}
	
	
	public void update(HistorialVacunas vacunacion)
	{
		em.merge(vacunacion);
	}
	
	
	public HistorialVacunas read(int id)
	{
		HistorialVacunas hisva = em.find(HistorialVacunas.class, id);
		return hisva;
	}
	
	public void remove (int id)
	{
		em.remove(this.read(id));
	}
	
	
	/**
	 * Este metodo lista todas las personas registradas en la base de datos
	 * */
	@SuppressWarnings("unchecked")
	public List<HistorialVacunas> getHistorialVacunas()
	{
		//En jpql no existe el producto cartesiano
		//jpql respeta el uso de mayusculas y minusculas
		String jpql = "SELECT hist FROM HistorialVacunas hist";
		//String jpql = "SELECT p FROM Persona ORDER BY p.nombre";
		
		Query query = em.createQuery(jpql, HistorialVacunas.class);
		
		List <HistorialVacunas> listado = query.getResultList();

		return listado;
	}
	
	
	
	
}
