package ec.edu.ups.petcare.modelo;

import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class HistorialVacunas 
{
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@NotEmpty
	private String fecha_aplicacion;

	@NotNull
	@NotEmpty
	private String fecha_proxima_aplicacion;
	
	
	private double peso;
	
	
	@NotNull
	@NotEmpty
	private String descripcion;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="vacuna")
	private Vacuna vacuna;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha_aplicacion() {
		return fecha_aplicacion;
	}

	public void setFecha_aplicacion(String fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}

	public String getFecha_proxima_aplicacion() {
		return fecha_proxima_aplicacion;
	}

	public void setFecha_proxima_aplicacion(String fecha_proxima_aplicacion) {
		this.fecha_proxima_aplicacion = fecha_proxima_aplicacion;
	}

	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

		
	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) 
	{
		System.out.println("Set vacuna en Historial Vacunas paquete modelo      "+vacuna.getId()+"       "+vacuna.getNombre());
		this.vacuna = vacuna;
	}


	
	
}
