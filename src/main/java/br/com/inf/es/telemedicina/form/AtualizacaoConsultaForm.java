package br.com.inf.es.telemedicina.form;

import java.time.LocalDateTime;
import java.util.Optional;

import br.com.inf.es.telemedicina.exceptions.ConsultaNotFoundException;
import br.com.inf.es.telemedicina.modelo.Consulta;
import br.com.inf.es.telemedicina.modelo.Diagnostico;
import br.com.inf.es.telemedicina.modelo.Medico;
import br.com.inf.es.telemedicina.modelo.Paciente;
import br.com.inf.es.telemedicina.modelo.Pagamento;
import br.com.inf.es.telemedicina.repository.ConsultaRepository;

public class AtualizacaoConsultaForm {
	private Paciente paciente;
	private Medico medico;
	private LocalDateTime data;
	private String motivo;
	private Diagnostico diagnostico;
	private Pagamento pagamento;
	private String linkSala;
	
	public String getLinkSala() {
		return linkSala;
	}
	public void setLinkSala(String linkSala) {
		this.linkSala = linkSala;
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Consulta atualizar(Long id, ConsultaRepository consultaRepository) throws ConsultaNotFoundException {
		Optional<Consulta> consulta = consultaRepository.findById(id);
		if (consulta.isPresent()) {
			if(paciente!=null)
				consulta.get().setPaciente(paciente);
			if(medico!=null)
				consulta.get().setMedico(medico);
			if(data!=null)
				consulta.get().setData(data);
			if(motivo!=null)
				consulta.get().setMotivo(motivo);
			if(diagnostico!=null)
				consulta.get().setDiagnostico(diagnostico);
			if(pagamento!=null)
				consulta.get().setPagamento(pagamento);
			if(linkSala!=null)
				consulta.get().setLinkSala(linkSala);
			return consulta.get();
		}
		throw new ConsultaNotFoundException();
		}
		
	
	}

