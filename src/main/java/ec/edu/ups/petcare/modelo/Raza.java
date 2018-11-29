package ec.edu.ups.petcare.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Entity
public class Raza {
	
	@Id
	@NotNull
	@GeneratedValue
	private int razaId;
	
	@NotNull
	//@Size(min = 4, max = 20)
	private String razaNombre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="especie")
	private Especie especie;

	public int getRazaId() {
		return razaId;
	}

	public void setRazaId(int razaId) {
		this.razaId = razaId;
	}

	public String getRazaNombre() {
		return razaNombre;
	}

	public void setRazaNombre(String razaNombre) {
		this.razaNombre = razaNombre;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	
}
