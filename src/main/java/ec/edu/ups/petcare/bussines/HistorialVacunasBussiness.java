package ec.edu.ups.petcare.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.petcare.dao.HistorialVacunasDAO;
import ec.edu.ups.petcare.modelo.HistorialVacunas;
import ec.edu.ups.petcare.modelo.Vacuna;


@Stateless
public class HistorialVacunasBussiness 
{
	@Inject
	private HistorialVacunasDAO dao;
	
	/**
	 * Método guardar Historial Vacunas
	 * @param hisva - objeto historial vacunas, incluye la vacuna que se aplicó
	 * 
	 * */
	public void save (HistorialVacunas hisva) throws Exception
	{
		System.out.println("*****   *******    Metodo save    :        "+hisva.getVacuna().getId()+"        "+hisva.getVacuna().getNombre());
		HistorialVacunas aux = dao.read(hisva.getId());
		if (aux!=null)
		{
			System.out.println("Metodo SAVE CLASE HISTORIALVACUNASBUSSINESS ID HISTORIAL VACUNAS : "+aux.getId());
			throw new Exception("El historial de vacunas ya existe");
		}
		else
		{
			System.out.println("METODO SAVE ELSE CLASE HISTORIALVACUNASBUSSINESS");
			dao.insert(hisva);
		}
	}
	
	/**
	 * Método para listar TODOS LOS HISTORIALES de vacunas
	 * @param - No recibe ningún parametro
	 * 
	 * */
	public List<HistorialVacunas> getHistorialVacunass()
	{
		return dao.getHistorialVacunas();
	}
	
	/**
	 * @param id - int
	 * */
	public HistorialVacunas buscar(int id)
	{
		HistorialVacunas hisvacu = dao.read(id);
		return hisvacu;
	}
	
	
	/**
	 * @param id_historial_vacunas int
	 * 
	 * */
	public void eliminarHistorialVacuna(int id_historial_vacunas)
	{
		dao.remove(id_historial_vacunas);
	}
	
	
	
	public void actualizar (HistorialVacunas hisvac) throws Exception 
	{
		/* *
		 * Buscar el historial de vacunas que quiero editar por el id del historial
		 * */
		HistorialVacunas aux = dao.read(hisvac.getId());
		if(aux==null)
			throw new Exception("El Historial de Vacunas no existe");
		else
			dao.update(hisvac);
		
	}
	
	/**
	 * Este método devuelve el HistorialVacunas que busca mendiante el id
	 * Ayuda para poder editar los datos
	 * @param id -Es el id del Historial Vacunas
	 * @return aux que es el objetoHistorialVacunas
	 *  
	 * */
	public HistorialVacunas getHistorialVacunas(int id) throws Exception
	{
		HistorialVacunas aux = dao.read(id);
		if (aux==null)
		{
			throw new Exception("No existe el Historial de Vacunas metodo get HistorialVacunas clase HistorialVacunasBussiness");
		}
		else
		{
			return aux;
		}
	}
	
	
}
