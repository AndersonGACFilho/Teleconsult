package br.com.inf.es.telemedicina.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Consulta {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@OneToOne
	private Paciente paciente;
	@OneToOne
	private Medico medico;
	private LocalDateTime data;
	private String motivo;
	@OneToOne
	private Diagnostico diagnostico;
	@OneToOne
	private Pagamento pagamento;
	private String linkSala;
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Long getId() {
		return Id;
	}
	public String getLinkSala() {
		return linkSala;
	}
	public void setLinkSala(String linkSala) {
		this.linkSala = linkSala;
	}
}
