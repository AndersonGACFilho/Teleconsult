package br.com.inf.es.telemedicina.modelo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(hidden = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Pes")
@DiscriminatorColumn(name="tipo",length=3,discriminatorType = DiscriminatorType.STRING)
public class Pessoa {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String primeiroNome;
	private String sobrenome;
	private String email;
	@Parameter(hidden = true)
	private String senha;
	public Long getId() {
		return id;
	}
	public Pessoa() {
	}
	public Pessoa(String primeiroNome, String sobrenome, String email, String senha) {
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
}
