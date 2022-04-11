package br.com.inf.es.telemedicina.dto;

import br.com.inf.es.telemedicina.modelo.Endereco;

public class EnderecoDto {
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private Integer numero;
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
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
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
	public EnderecoDto(Endereco end) {

		cep = end.getCep();
		estado = end.getEstado();
		cidade = end.getCidade();
		logradouro = end.getLogradouro();
		numero = end.getNumero();
		bairro = end.getBairro();
		complemento = end.getComplemento();
	}
}
