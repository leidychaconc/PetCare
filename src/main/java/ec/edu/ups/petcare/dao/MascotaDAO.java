package ec.edu.ups.petcare.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.petcare.modelo.Mascota;

@Stateless
public class MascotaDAO {
	@Inject
	private EntityManager em;
	
	public void insertar (Mascota mascota) {
		em.persist(mascota);
	}
	public void actualizar(Mascota mascota) {
		em.merge(mascota);
	}
	public Mascota leer(int id ) {
		Mascota mascota = em.find(Mascota.class, id);
		return mascota;
	}
	public void borrar (int id) {
		em.remove(this.leer(id));
		
	}
	
	//LISTAR
	public List<Mascota> getListMascota(){
		String jpql="SELECT p FROM Mascota p";
		Query query=em.createQuery(jpql, Mascota.class);
		
		List<Mascota> listado=query.getResultList();
		return listado;
	}

}
