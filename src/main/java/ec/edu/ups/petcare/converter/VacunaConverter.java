package ec.edu.ups.petcare.converter;

import java.util.List;  

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.petcare.modelo.Vacuna;


@FacesConverter("ec.edu.ups.petcare.converter.VacunaConverter")
public class VacunaConverter implements Converter 
{
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		System.out.println("Método getAsObject de Vacuna Converter     " + value);
		List<Vacuna> vacunas = this.getDAO();
		for(Vacuna v : vacunas)
		{
			System.out.println("bucle for de getAsObject   ");
			if (v.getNombre().equals(value))
			{
				System.out.println("v.getNombre    "+v.getId()+"      "+v.getNombre()+"             "+value);
				return v;
			}
				
		}
		return null;		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) 
	{
		System.out.println("getAsString " + value);		
		return ((Vacuna) value).getNombre();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Vacuna> getDAO()
	{				
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext ec = ctx.getELContext();
		System.out.println("Metodo getDAO del vacunaconverter   "+ec);
		Application app = ctx.getApplication();
		//System.out.println(ctx.getApplication());
		//System.out.println(app.evaluateExpressionGet(ctx,"#{vacunaBean.vacunas}", List.class));
		int i=0;
		/*while(i<app.evaluateExpressionGet(ctx,"#{vacunaBean.vacunas}", List.class).size())
		{
			Vacuna va=((Vacuna)app.evaluateExpressionGet(ctx,"#{vacunaBean.vacunas}", List.class).get(i));
			va.getNombre();
			System.out.println(va.getId()+"        "+va.getNombre());
			i++;
		}*/
		
		return (List<Vacuna>) app.evaluateExpressionGet(ctx,"#{historialVacunasBean.listVacunas}", List.class);		
	}
	
	
}
