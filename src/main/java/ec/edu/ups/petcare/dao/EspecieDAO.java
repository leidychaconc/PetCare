package ec.edu.ups.petcare.dao;

import java.util.List; 

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.petcare.modelo.Especie;

@Stateless
public class EspecieDAO {
	@Inject
	private EntityManager em;
	
	public void insertar(Especie especie) {
		em.persist(especie);
		
	}
	public void actualizar(Especie especie) {
		em.merge(especie);
		
	}
	public void borrar(int id) {
		em.remove(this.leer(id));
	}
	

	public Especie leer(int id) {
		Especie especie = em.find(Especie.class, id);
		return especie;
	}
	
	public List<Especie> getListEspecie(){
		String jpql="SELECT p FROM Especie p";
		Query query=em.createQuery(jpql, Especie.class);
		List <Especie> listado=query.getResultList();
		return listado;
		
	
	
	}

}
