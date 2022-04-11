package br.com.inf.es.telemedicina.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.inf.es.telemedicina.modelo.Consulta;
import br.com.inf.es.telemedicina.modelo.Diagnostico;
import br.com.inf.es.telemedicina.modelo.Pagamento;

public class ConsultaDTO {
	private PacienteDto paciente;
	private MedicoConsultaDto medico;
	private LocalDateTime data;
	private String motivo;
	private Diagnostico diagnostico;
	private PagamentoDto pagamento;
	private String linkSala;
	
	public ConsultaDTO(Consulta consulta) {
		paciente = new PacienteDto(consulta.getPaciente());
		medico = new MedicoConsultaDto(consulta.getMedico());
		data = consulta.getData();
		motivo = consulta.getMotivo();
		diagnostico = consulta.getDiagnostico();
		pagamento = new PagamentoDto(consulta.getPagamento());
		linkSala = consulta.getLinkSala();
	}
	public String getLinkSala() {
		return linkSala;
	}
	public void setLinkSala(String linkSala) {
		this.linkSala = linkSala;
	}
	public PacienteDto getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDto paciente) {
		this.paciente = paciente;
	}

	public MedicoConsultaDto getMedico() {
		return medico;
	}

	public void setMedicoDto(MedicoConsultaDto medico) {
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

	public PagamentoDto getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoDto pagamento) {
		this.pagamento = pagamento;
	}

	public static Page<ConsultaDTO> converter(Page<Consulta> consultas) {
		return consultas.map(ConsultaDTO::new);
	}

}
