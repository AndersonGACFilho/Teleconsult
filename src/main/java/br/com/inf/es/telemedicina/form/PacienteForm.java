package br.com.inf.es.telemedicina.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.inf.es.telemedicina.modelo.Endereco;
import br.com.inf.es.telemedicina.modelo.Paciente;
import br.com.inf.es.telemedicina.repository.EnderecoRepository;
import br.com.inf.es.telemedicina.repository.PacienteRepository;

public class PacienteForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String primeiroNome;
	@NotNull @NotEmpty @Length(min = 3)
	private String sobrenome;
	@NotNull @NotEmpty @Length(min = 9)
	private String email;
	@NotNull @NotEmpty @Length(min = 8)
	private String senha;
	@NotNull @NotEmpty @Length(min = 8, max = 8)
	private String cep;
	@NotNull @NotEmpty @Length(min = 4, max = 15)
	private String estado;
	@NotNull @NotEmpty @Length(min = 5)
	private String cidade;
	@NotNull @NotEmpty @Length(min = 5)
	private String logradouro;
	@PositiveOrZero
	private Integer numero;
	@NotNull @NotEmpty @Length(min = 5)
	private String bairro;
	@NotNull @NotEmpty @Length(min = 5)
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
	public Paciente coverter(EnderecoRepository enderecoRepository,PacienteRepository pacienteRepository) {
		Paciente paciente;
		Endereco endereco = new Endereco();
		paciente = pacienteRepository.findByEmail(email);
		if(paciente==null) {
			paciente = new Paciente();
			paciente.setPrimeiroNome(primeiroNome);
			paciente.setSenha(senha);
			paciente.setSobrenome(sobrenome);
			paciente.setEmail(email);
			endereco.setBairro(bairro);
			endereco.setCep(cep);
			endereco.setCidade(cidade);
			endereco.setEstado(estado);
			endereco.setLogradouro(logradouro);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			enderecoRepository.save(endereco);
			paciente.setEndereco(endereco);
		}else {
			paciente = null;
		}
		return paciente;
	}

}
