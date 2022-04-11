package br.com.inf.es.telemedicina.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Banco {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String apiLink;
	private Integer numero;
	public String getApiLink() {
		return apiLink;
	}
	public void setApiLink(String apiLink) {
		this.apiLink = apiLink;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;
}
