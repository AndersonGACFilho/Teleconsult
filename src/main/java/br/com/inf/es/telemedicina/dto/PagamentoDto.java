package br.com.inf.es.telemedicina.dto;

import br.com.inf.es.telemedicina.modelo.FormaDePagamento;
import br.com.inf.es.telemedicina.modelo.Pagamento;
import br.com.inf.es.telemedicina.modelo.Situacao;

public class PagamentoDto {
	private FormaDePagamento formaPagamento;
	private Situacao situacao;
	private float valor;
	private String descricao;

	public PagamentoDto(Pagamento pagamento) {
		this.formaPagamento = pagamento.getFormaPagamento();
		this.situacao = pagamento.getSituacao();
		this.valor = pagamento.getValor();
		this.descricao = pagamento.getDescricao();
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public FormaDePagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaDePagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}
