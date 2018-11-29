package ec.edu.ups.petcare.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.EspecieDAO;
import ec.edu.ups.petcare.modelo.Especie;
@Stateless
public class EspecieBussines {
	@Inject
	private EspecieDAO espedao;
	public boolean save(Especie especie) throws Exception{
		Especie aux=espedao.leer(especie.getEspeId());
		if(aux!=null)
			espedao.actualizar(especie);
		else
			espedao.insertar(especie);
		return true;
	}
	
	public List<Especie> getEspecie(){
		return espedao.getListEspecie();
	}
	
	public void delete (int id)throws 	Exception {
		Especie aux=espedao.leer(id);
		if(aux==null)
			throw new Exception("registro no exist");
		else
			espedao.borrar(id);
	}
	
	
	public void update(Especie especie)throws Exception{
		Especie aux=espedao.leer(especie.getEspeId());
		if(aux==null)
			throw new Exception("especie no existe");
		else
			espedao.actualizar(especie);
	}
	//editar
	public Especie getEspecie(int id)throws Exception{ 
		Especie aux= espedao.leer(id);
		if(aux==null)
			throw new Exception("especie no exite");
		else
			return aux;
		
	}
	

}
