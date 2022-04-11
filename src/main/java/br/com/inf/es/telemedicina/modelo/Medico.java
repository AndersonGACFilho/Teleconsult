package br.com.inf.es.telemedicina.modelo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(hidden = true)
@Entity
@DiscriminatorValue(value = "Me")
public class Medico extends Pessoa{
	private String crm;
	@ManyToMany
	private List<Especialidade> especialidades;
	@OneToOne
	private Conta conta;
	@OneToOne
	private Agenda agenda;
	
	public Medico(String primeiroNome, String sobrenome, String email, String senha,String crm, List<Especialidade> especialidades, Conta conta, Agenda agenda) {
		super(primeiroNome,sobrenome,email,senha);
		this.crm = crm;
		this.especialidades = especialidades;
		this.conta = conta;
		this.agenda = agenda;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidade> especialidade) {
		this.especialidades = especialidade;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
}
