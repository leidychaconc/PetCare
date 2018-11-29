package ec.edu.ups.petcare.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
	
	@Id
	private String cliCedula;
	private String cliNombre;
	private String cliApellido;
	//@Email
	private String cliEmail;
	
	//@Column(name="cliTelf")
	
	private int cliTelefono;
	private int cliCelular;
	
	
	private String cliDireccion;
	
	
	public String getCliCedula() {
		return cliCedula;
	}
	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}
	public String getCliNombre() {
		return cliNombre;
	}
	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}
	public String getCliApellido() {
		return cliApellido;
	}
	public void setCliApellido(String cliApellido) {
		this.cliApellido = cliApellido;
	}
	public String getCliEmail() {
		return cliEmail;
	}
	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}
	public int getCliTelefono() {
		return cliTelefono;
	}
	public void setCliTelefono(int cliTelefono) {
		this.cliTelefono = cliTelefono;
	}
	public int getCliCelular() {
		return cliCelular;
	}
	public void setCliCelular(int cliCelular) {
		this.cliCelular = cliCelular;
	}
	public String getCliDireccion() {
		return cliDireccion;
	}
	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}
	
	
	
}