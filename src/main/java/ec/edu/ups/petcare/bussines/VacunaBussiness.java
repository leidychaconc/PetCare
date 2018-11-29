package ec.edu.ups.petcare.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.VacunaDAO;
import ec.edu.ups.petcare.modelo.Vacuna;

@Stateless
public class VacunaBussiness 
{
	
	@Inject
	private VacunaDAO dao;
	
	public void save(Vacuna vacuna) throws Exception
	{
		
		Vacuna aux=dao.readPorNombre(vacuna.getNombre());
		
		if(aux!=null)
			throw new Exception("Vacuna ya registrada");
		else
			dao.insert(vacuna);
	}
	
	
	
	public List<Vacuna> getVacunas()
	{
		return dao.getVacunas();
	}
	
	
	public Vacuna buscar(int id)
	{
		Vacuna vacb = dao.read(id);
		return vacb;
	}
	
	public void eliminarVacuna(int id)
	{
		dao.remove(id);
	}
	
	
	public Vacuna getVacuna(int id) throws Exception {
		Vacuna aux = dao.read(id);
		if(aux==null)
			throw new Exception("Vacuna no existe  -------- VacunaBussiness metodo getVacuna");
		else
			return aux;
	}
	
	public void actualizar(Vacuna vacu) throws Exception {
		Vacuna aux = dao.read(vacu.getId());
		if(aux==null)
			throw new Exception("Persona no existe");
		else
			dao.update(vacu);
	}
	
}
