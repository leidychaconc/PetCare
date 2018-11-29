package ec.edu.ups.petcare.bussines;

import java.util.List; 

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.MascotaDAO;
import ec.edu.ups.petcare.modelo.Mascota;
@Stateless
public class MascotaBussiness {
	
	@Inject
	private MascotaDAO masdao;
	
	public void save(Mascota mascota) throws Exception{
		System.out.println(mascota.getMascoNombre());
		Mascota aux=masdao.leer(mascota.getMascoId());
		if(aux!=null)
			masdao.actualizar(mascota);
		else
			masdao.insertar(mascota);
		//return true;
	}
	public List<Mascota> getMascota(){
		return masdao.getListMascota();
	}
	public void delete (int id) throws Exception{
		Mascota aux=masdao.leer(id);
		if(aux==null)
			throw new Exception("registro mascotaBussines no existe");
		else
			masdao.borrar(id);
	}
	
	public void update(Mascota mascota) throws Exception{
		Mascota aux=masdao.leer(mascota.getMascoId());
		Mascota aux2=masdao.leer(mascota.getMascoId());
		if (aux==null ||aux2==null)
			throw new Exception("mascota no existe");
		else
			masdao.actualizar(mascota);
	}
	//editar
	public Mascota getMascota(int id) throws Exception{
		Mascota aux=masdao.leer(id);
		if(aux==null)
			throw new Exception("mascota a editar no existe");
		else
			return aux;
	}
	

}
