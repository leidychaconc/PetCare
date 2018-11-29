package ec.edu.ups.petcare.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.RazaDAO;
import ec.edu.ups.petcare.modelo.Raza;


@Stateless
public class RazaBussiness {
	@Inject
	private RazaDAO razadao;
	public void save(Raza raza) throws Exception{
		Raza aux=razadao.leer(raza.getRazaId());
		if(aux!=null)
			razadao.actualizar(raza);
		else
			razadao.insertar(raza);
	//	return true;
	}
	
	public List<Raza> getRaza(){
		return razadao.getListRaza();
	}
	
	public void delete (int id)throws 	Exception {
		Raza aux=razadao.leer(id);
		if(aux==null)
			throw new Exception("registro raza no exist");
		else
			razadao.borrar(id);
	}
	
	
	public void update(Raza especie)throws Exception{
		Raza aux=razadao.leer(especie.getRazaId());
		if(aux==null)
			throw new Exception("raza no existe");
		else
			razadao.actualizar(especie);
	}
	//editar
	public Raza getRaza(int id)throws Exception{ 
		Raza aux= razadao.leer(id);
		if(aux==null)
			throw new Exception("raza no exite");
		else
			return aux;
		
	}
}
