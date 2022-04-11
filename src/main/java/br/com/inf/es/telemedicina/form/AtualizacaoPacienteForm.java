package br.com.inf.es.telemedicina.form;

import java.util.Optional;

import br.com.inf.es.telemedicina.exceptions.PacienteNotFoundException;
import br.com.inf.es.telemedicina.modelo.Endereco;
import br.com.inf.es.telemedicina.modelo.Paciente;
import br.com.inf.es.telemedicina.repository.PacienteRepository;

public class AtualizacaoPacienteForm {
	private String primeiroNome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cep;
	private String estado;
	private String cidade;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String complemento;
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primerioNome) {
		this.primeiroNome = primerioNome;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Paciente atualizar(Long id, PacienteRepository pacienteRepository) throws PacienteNotFoundException {
		
		Optional<Paciente> optional = pacienteRepository.findById(id);
		if(optional.isPresent()) {
			Paciente paciente = optional.get();
			Endereco endereco = paciente.getEndereco();
			if(primeiroNome!=null)
			paciente.setPrimeiroNome(primeiroNome);
			if(senha!=null)
			paciente.setSenha(senha);
			if(sobrenome!=null)
			paciente.setSobrenome(sobrenome);
			if(email!=null)
			paciente.setEmail(email);
			if(bairro!=null)
			endereco.setBairro(bairro);
			if(cep!=null)
			endereco.setCep(cep);
			if(cidade!=null)
			endereco.setCidade(cidade);
			if(estado!=null)
			endereco.setEstado(estado);
			if(logradouro!=null)
			endereco.setLogradouro(logradouro);
			if(numero!=null)
			endereco.setNumero(numero);
			if(complemento!=null)
			endereco.setComplemento(complemento);
			return paciente;
		}
		throw new PacienteNotFoundException();
	}

}
