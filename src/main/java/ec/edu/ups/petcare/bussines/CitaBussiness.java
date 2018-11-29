package ec.edu.ups.petcare.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.CitaMedicaDAO;
import ec.edu.ups.petcare.modelo.Cita_Medica;

@Stateless
public class CitaBussiness 
{
	@Inject
	private CitaMedicaDAO dao;
	
	
	/**
	 * Método que guarda las citas medicas
	 * Verifica si la cita medica existe o no
	 * Muestra un mensaje en caso de que la cita medica exista
	 * */
	public void save(Cita_Medica cita) throws Exception
	{
		Cita_Medica aux = dao.read(cita.getId());
		if (aux!=null)
		{
			System.out.println("Metodo save    CLASE CITABUSSINESS  ID CITA MEDICA:"+aux.getId());
			throw new Exception("La cita ya existe");
		}
		else
		{
			System.out.println("METODO SAVE ELSE.... VA A INSERTAR LA CITA MEDICA");
			dao.insert(cita);
		}
	}
	
	
	
	
	public List<Cita_Medica> getCitas()
	{
		return dao.getCitasMedicas();
	}
	
	public void eliminar_cita(int id)
	{
		dao.remove(id);
	}
	
	
	
}
