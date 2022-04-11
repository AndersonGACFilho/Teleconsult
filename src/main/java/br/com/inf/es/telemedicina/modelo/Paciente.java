package br.com.inf.es.telemedicina.modelo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(hidden = true)
@Entity
@DiscriminatorValue(value = "Pa")
public class Paciente extends Pessoa{
	@OneToOne
	private Endereco endereco;
	@OneToMany
	private List<Consulta> consultas;
	public Paciente() {}
	public Paciente(String primeiroNome, String sobrenome, String email, String senha,Endereco endereco, List<Consulta> consultas) {
		super(primeiroNome,sobrenome,email,senha);
		this.endereco = endereco;
		this.consultas = consultas;
	}
	@Override
	public String getSenha() {
		return super.getSenha();
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
}