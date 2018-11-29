package ec.edu.ups.petcare.modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="vacuna")
public class Vacuna 
{
	@Id
	@NotNull
	@GeneratedValue
	@Column(name = "vac_id")
	private int id;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[^0-9]*", message = "No puede contener numeros")
	@Column(name = "vac_nombre")
	private String nombre;
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
