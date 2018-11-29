package ec.edu.ups.petcare.dao;

import java.util.List;  

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import ec.edu.ups.petcare.modelo.Raza;
@Stateless
public class RazaDAO {
	@Inject
	private EntityManager em;
	
	public void insertar(Raza raza) {
		em.persist(raza);
	}
	
	public void actualizar(Raza raza) {
		em.merge(raza);
	}
	
	public Raza leer(int id) {
		Raza raza=em.find(Raza.class, id);
		return raza;
	}
	public void borrar(int id) {
		em.remove(this.leer(id));
	}
	
	public List<Raza> getListRaza(){
		String jpql="SELECT p FROM Raza p";
		Query query=em.createQuery(jpql, Raza.class);
		List <Raza> listado=query.getResultList();
		return listado;
	}
	
}
