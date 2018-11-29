package ec.edu.ups.petcare.converter;

import java.util.List; 

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.petcare.modelo.Persona;

@FacesConverter("ec.edu.ups.petcare.converter.PersonaConverter")
public class PersonaConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		System.out.println("Método getAsObject de Persona Converter     " + value);
		List<Persona> personas = this.getDAO();
		for(Persona v : personas)
		{
			System.out.println("bucle for de getAsObject   ");
			if (v.getCliNombre().equals(value))
			{
				System.out.println("v.getCliNombre   "+v.getCliCedula()+"      "+v.getCliNombre()+"             "+value);
				return v;
			}
				
		}
		return null;		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) 
	{
		System.out.println("getAsString " + value);		
		return ((Persona) value).getCliNombre();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Persona> getDAO()
	{				
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext ec = ctx.getELContext();
		System.out.println("Metodo getDAO del Personaconverter   "+ec);
		Application app = ctx.getApplication();
		int i=0;
	
		return (List<Persona>) app.evaluateExpressionGet(ctx,"#{mascotaBean.listPersonas}", List.class);		
	}

}
