package ec.edu.ups.petcare.modelo;

import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="mascota")
public class Mascota 
{
	
	@Id
	@NotNull

	@GeneratedValue
	private int mascoId;
	
	@NotNull
//	@Size(min = 3, max = 20)
	private String mascoNombre;
	
	@NotNull
	private int mascoEdad;
	
	@NotNull
	private String mascoSexo;
	
	@NotNull
	private String mascoEsterizado;
	
	private String mascoColor;
	
	@NotNull
	private String mascoAlergias;

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="persona")
	private Persona persona;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="raza")
	private Raza raza;
	

	public int getMascoEdad() {
		return mascoEdad;
	}

	public void setMascoEdad(int mascoEdad) {
		this.mascoEdad = mascoEdad;
	}

	public String getMascoSexo() {
		return mascoSexo;
	}

	public void setMascoSexo(String mascoSexo) {
		this.mascoSexo = mascoSexo;
	}

	

	public String getMascoColor() {
		return mascoColor;
	}

	public void setMascoColor(String mascoColor) {
		this.mascoColor = mascoColor;
	}

	public String getMascoAlergias() {
		return mascoAlergias;
	}

	public void setMascoAlergias(String mascoAlergias) {
		this.mascoAlergias = mascoAlergias;
	}

	public String getMascoEsterizado() {
		return mascoEsterizado;
	}

	public void setMascoEsterizado(String mascoEsterizado) {
		this.mascoEsterizado = mascoEsterizado;
	}

	public int getMascoId() {
		return mascoId;
	}

	public void setMascoId(int mascoId) {
		this.mascoId = mascoId;
	}

	public String getMascoNombre() {
		return mascoNombre;
	}

	public void setMascoNombre(String mascoNombre) {
		this.mascoNombre = mascoNombre;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	
	
}
