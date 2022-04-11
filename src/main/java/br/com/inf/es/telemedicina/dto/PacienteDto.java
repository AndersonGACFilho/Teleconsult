package br.com.inf.es.telemedicina.dto;

import org.springframework.data.domain.Page;

import br.com.inf.es.telemedicina.modelo.Paciente;

public class PacienteDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	
	public PacienteDto(Paciente paciente) {
		id = paciente.getId();
		nome = paciente.getPrimeiroNome();
		sobrenome = paciente.getSobrenome();
		email = paciente.getEmail();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static Page<PacienteDto> converter(Page<Paciente> paciente){
		return paciente.map(PacienteDto::new);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
