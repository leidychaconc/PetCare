package ec.edu.ups.petcare.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="histo_med")
public class HistorialMedico {
	
	@Id
	@NotNull
	@Column(name = "hismed_id")
	private int hismed_id;
	private Date hismed_fecha;
	
	@Column(name = "hismed_prorea")
	@NotNull
	@Size(min = 3, max = 20)
	private String hismed_proced_realizado;
	
	@Column(name = "hismed_diag")
	@NotNull
	@Size(min = 3, max = 20)
	private String hismed_diagnostico;
	
	@NotNull
	private double hismed_peso_mas;
	private String hismed_tratamiento;
	private String hismed_medicamentos;
	public int getHismed_id() {
		return hismed_id;
	}
	public void setHismed_id(int hismed_id) {
		this.hismed_id = hismed_id;
	}
	public Date getHismed_fecha() {
		return hismed_fecha;
	}
	public void setHismed_fecha(Date hismed_fecha) {
		this.hismed_fecha = hismed_fecha;
	}
	public String getHismed_proced_realizado() {
		return hismed_proced_realizado;
	}
	public void setHismed_proced_realizado(String hismed_proced_realizado) {
		this.hismed_proced_realizado = hismed_proced_realizado;
	}
	public String getHismed_diagnostico() {
		return hismed_diagnostico;
	}
	public void setHismed_diagnostico(String hismed_diagnostico) {
		this.hismed_diagnostico = hismed_diagnostico;
	}
	public double getHismed_peso_mas() {
		return hismed_peso_mas;
	}
	public void setHismed_peso_mas(double hismed_peso_mas) {
		this.hismed_peso_mas = hismed_peso_mas;
	}
	public String getHismed_tratamiento() {
		return hismed_tratamiento;
	}
	public void setHismed_tratamiento(String hismed_tratamiento) {
		this.hismed_tratamiento = hismed_tratamiento;
	}
	public String getHismed_medicamentos() {
		return hismed_medicamentos;
	}
	public void setHismed_medicamentos(String hismed_medicamentos) {
		this.hismed_medicamentos = hismed_medicamentos;
	}
	
	

}
