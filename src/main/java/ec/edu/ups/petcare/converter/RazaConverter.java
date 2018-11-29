package ec.edu.ups.petcare.converter;



import java.util.List;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.petcare.modelo.Especie;
import ec.edu.ups.petcare.modelo.Raza;

@FacesConverter("ec.edu.ups.petcare.converter.RazaConverter")
public class RazaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		System.out.println("Método getAsObject de Especie Converter     " + value);
		List<Raza> razas = this.getDAO();
		for(Raza v : razas)
		{
			System.out.println("bucle for de getAsObject   ");
			if (v.getRazaNombre().equals(value))
			{
				System.out.println("v.getRazaeNombre    "+v.getRazaId()+"      "+v.getRazaNombre()+"             "+value);
				return v;
			}
				
		}
		return null;		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) 
	{
		System.out.println("getAsString " + value);		
		return ((Raza) value).getRazaNombre();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Raza> getDAO()
	{				
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext ec = ctx.getELContext();
		System.out.println("Metodo getDAO del Razaconverter   "+ec);
		Application app = ctx.getApplication();
		
		int i=0;
		
		
		return (List<Raza>) app.evaluateExpressionGet(ctx,"#{mascotaBean.listRazas}", List.class);		
	}
	

}
