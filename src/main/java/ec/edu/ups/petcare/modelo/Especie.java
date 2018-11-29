package ec.edu.ups.petcare.modelo;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="especie")
public class Especie {
	@Id
	@NotNull
	@GeneratedValue
	private int espeId;
	
	private String espeNombre;

	

	public String getEspeNombre() {
		return espeNombre;
	}

	public void setEspeNombre(String espeNombre) {
		this.espeNombre = espeNombre;
	}

	public int getEspeId() {
		return espeId;
	}

	public void setEspeId(int espeId) {
		this.espeId = espeId;
	}
	
	

}
