package br.com.inf.es.telemedicina.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.inf.es.telemedicina.modelo.Paciente;

public class DetalhesPacienteDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private EnderecoDto endereco;
	
	
	public DetalhesPacienteDto(Paciente paciente) {
		id = paciente.getId();
		nome = paciente.getPrimeiroNome();
		sobrenome = paciente.getSobrenome();
		email = paciente.getEmail();
		endereco = new EnderecoDto(paciente.getEndereco());
	}
	public Long getId() {
		return id;
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
	public EnderecoDto getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}
	public static List<PacienteDto> converter(List<Paciente> paciente){
		return paciente.stream().map(PacienteDto::new).collect(Collectors.toList());
	}
}
