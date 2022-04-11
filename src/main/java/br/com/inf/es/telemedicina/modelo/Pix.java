package br.com.inf.es.telemedicina.modelo;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Pi")
public class Pix extends Pagamento{
	private String CodigoPix;
	private LocalDateTime dataEmissao;
	private LocalDateTime dataVencimento;
	public String getCodigoPix() {
		return CodigoPix;
	}
	public void setCodigoPix(String codigoPix) {
		CodigoPix = codigoPix;
	}
	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
