package ec.edu.ups.petcare.converter;

import java.util.List;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.petcare.modelo.Especie;
@FacesConverter("ec.edu.ups.petcare.converter.EspecieConverter")
public class EspecieConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		System.out.println("Método getAsObject de Especie Converter     " + value);
		List<Especie> especies = this.getDAO();
		for(Especie v : especies)
		{
			System.out.println("bucle for de getAsObject   ");
			if (v.getEspeNombre().equals(value))
			{
				System.out.println("v.getEspeNombre    "+v.getEspeId()+"      "+v.getEspeNombre()+"             "+value);
				return v;
			}
				
		}
		return null;		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) 
	{
		System.out.println("getAsString " + value);		
		return ((Especie) value).getEspeNombre();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Especie> getDAO()
	{				
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext ec = ctx.getELContext();
		System.out.println("Metodo getDAO del especieconverter   "+ec);
		Application app = ctx.getApplication();
		
		int i=0;
		
		
		return (List<Especie>) app.evaluateExpressionGet(ctx,"#{razaBean.listEspecies}", List.class);		
	}
	

}
