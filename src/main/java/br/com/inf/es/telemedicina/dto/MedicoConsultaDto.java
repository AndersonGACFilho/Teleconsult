package br.com.inf.es.telemedicina.dto;

import java.util.List;

import br.com.inf.es.telemedicina.modelo.Medico;

public class MedicoConsultaDto {
	

	private String primeiroNome;
	private String sobrenome;
	private String crm;
	private String email;
	private List<EspecialidadeDTO> especialidades;
	
	public MedicoConsultaDto(Medico medico) {
		primeiroNome=medico.getPrimeiroNome();
		sobrenome=medico.getSobrenome();
		crm=medico.getCrm();
		email=medico.getEmail();
		especialidades=EspecialidadeDTO.converter(medico.getEspecialidades());
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<EspecialidadeDTO> getEspecialidadeDTO() {
		return especialidades;
	}

	public void setEspecialidades(List<EspecialidadeDTO> especialidades) {
		this.especialidades = especialidades;
	}
}
