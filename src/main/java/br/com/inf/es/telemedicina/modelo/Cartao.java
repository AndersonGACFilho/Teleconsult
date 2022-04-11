package br.com.inf.es.telemedicina.modelo;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "Ca")
public class Cartao extends Pagamento{
	@Enumerated(EnumType.STRING)
	private FormaDePagamento tipo;
	private String numero;
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
	private LocalDate vencimento;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Bandeira getBandeira() {
		return bandeira;
	}
	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
	public FormaDePagamento getTipo() {
		return tipo;
	}
	public void setTipo(FormaDePagamento tipo) {
		this.tipo = tipo;
	}
}
