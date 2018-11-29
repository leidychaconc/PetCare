package ec.edu.ups.petcare.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cita_medica")
public class Cita_Medica 
{
	@Id
	@NotNull
	@GeneratedValue(generator="seq_cita_medica", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_cita_medica", sequenceName = "seq_cita_medica", initialValue = 1, allocationSize = 10)
	@Column(name = "citam_id")
	private int id;
	
	@NotNull
	@NotEmpty
	@Column(name = "citam_fecha")
	private String fecha;
	
	@NotNull
	@NotEmpty
	@Column(name = "citam_hora")
	private String hora;
	
	
	@NotNull
	@NotEmpty
	@Column(name = "citam_motivo")
	private String motivo;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) 
	{
		this.hora = hora;
	}
	
	
}
