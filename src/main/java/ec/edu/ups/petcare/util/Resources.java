package ec.edu.ups.petcare.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	//conexion persistencia dataSource
	@Produces
	@PersistenceContext
	private EntityManager em;
	
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) 
	{
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	/**
	 * Es parte de la vista
	 * */
	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() 
	{
		return FacesContext.getCurrentInstance();
	}

	
	

}
