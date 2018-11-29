package ec.edu.ups.petcare.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import ec.edu.ups.petcare.modelo.Vacuna;


//Para lo que son DAO estos deben ser de tipo Stateles, son objetos que internamente tienen la transaccionalidad
//Un metodo de stateless si usa jpa ya tiene atomicidad.
@Stateless
public class VacunaDAO 
{
	@Inject
	private EntityManager em;
	
	
	public void insert(Vacuna v)
	{
		em.persist(v);
	}
	
	public void update(Vacuna v)
	{
		em.merge(v);
	}
	
	public void remove(int id)
	{
		System.out.println("REMOVE DAO           ID VACUNA                 "+id);
		em.remove(this.read(id));
	}
	
	public Vacuna read(int id)
	{
		Vacuna vac=em.find(Vacuna.class, id);
		System.out.println("READ DAO          ID ENCONTRADO     "+vac.getNombre());
		return vac;
	}
	
	
	public Vacuna readPorNombre(String nombrev)
	{
		//En jpql no existe el producto cartesiano
		//jpql respeta el uso de mayusculas y minusculas
		String jpql = "SELECT v FROM Vacuna v WHERE v.nombre like :param";
		Query query = em.createQuery(jpql, Vacuna.class);
		query.setParameter("param", "%"+nombrev+"%");
		Vacuna vac=null;
		try
		{
			vac=(Vacuna) query.getSingleResult();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return vac;
	}
	
	
	/**
	 * Este metodo lista todas las personas registradas en la base de datos
	 * */
	public List<Vacuna> getVacunas()
	{
		//En jpql no existe el producto cartesiano
		//jpql respeta el uso de mayusculas y minusculas
		String jpql = "SELECT v FROM Vacuna v";
		//String jpql = "SELECT p FROM Persona ORDER BY p.nombre";
		
		Query query = em.createQuery(jpql, Vacuna.class);
		@SuppressWarnings("unchecked")
		List <Vacuna> listado = query.getResultList();


		return listado;
	}
	

}