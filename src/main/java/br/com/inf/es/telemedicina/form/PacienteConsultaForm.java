package br.com.inf.es.telemedicina.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.inf.es.telemedicina.modelo.Bandeira;
import br.com.inf.es.telemedicina.modelo.Boleto;
import br.com.inf.es.telemedicina.modelo.Cartao;
import br.com.inf.es.telemedicina.modelo.Consulta;
import br.com.inf.es.telemedicina.modelo.FormaDePagamento;
import br.com.inf.es.telemedicina.modelo.Paciente;
import br.com.inf.es.telemedicina.modelo.Pagamento;
import br.com.inf.es.telemedicina.modelo.Pix;
import br.com.inf.es.telemedicina.modelo.Situacao;
import br.com.inf.es.telemedicina.repository.ConsultaRepository;
import br.com.inf.es.telemedicina.repository.MedicoRepository;
import br.com.inf.es.telemedicina.repository.PacienteRepository;

public class PacienteConsultaForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String crm;
	@NotNull @NotEmpty
	private LocalDateTime data;
	@NotNull @NotEmpty @Length(min = 3)
	private String motivo;
	@NotNull @NotEmpty
	private String formaPagamento;
	@NotNull @NotEmpty
	private Integer situacao;
	@NotNull @NotEmpty
	private float valor;
	private String bandeira;
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Integer getSituacao() {
		return situacao;
	}
	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Consulta coverter(Paciente paciente, ConsultaRepository consultaRepository,
			PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
		Consulta consulta = new Consulta();
		Pagamento pagamento = new Pagamento();
		consulta.setData(data);
		consulta.setPaciente(paciente);
		consulta.setMedico(medicoRepository.getByCrm(crm));
		consulta.setMotivo(motivo);
		pagamento.setValor(valor);		
		if (formaPagamento.equals(FormaDePagamento.PIX.name()) ) {
			Pix pix= (Pix)pagamento;
			pix.setDataEmissao(LocalDateTime.now());
			pix.setCodigoPix("Código Pix");
			pix.setDataVencimento(data.plusHours(2));
		}
		else if (formaPagamento.equals(FormaDePagamento.BOLETO.name())) {
			Boleto boleto= (Boleto)pagamento;
			boleto.setCodigo("Código Boleto");
			boleto.setDataEmissao(LocalDateTime.now());
			boleto.setDataVencimento(data.plusDays(3));
		}
		else {
			Cartao cartao= (Cartao)pagamento;
			if(bandeira.equals(Bandeira.MASTERCARD.name())){
				cartao.setBandeira(Bandeira.MASTERCARD);
			}
			else if(bandeira.equals(Bandeira.VISA.name())){
				cartao.setBandeira(Bandeira.VISA);
			} 
			else if(bandeira.equals(Bandeira.HIPERCARD.name())){
				cartao.setBandeira(Bandeira.HIPERCARD);
			}
			else if(bandeira.equals(Bandeira.AMERICAN_EXPRESS.name())){
				cartao.setBandeira(Bandeira.AMERICAN_EXPRESS);
			}
			else{
				cartao.setBandeira(Bandeira.ELO);
			}
			cartao.setNumero(crm);
			
			if (formaPagamento.equals(FormaDePagamento.DEBITO.name())) {
				cartao.setTipo(FormaDePagamento.DEBITO);
			}
			else if (formaPagamento.equals(FormaDePagamento.CREDITO.name())) {
				cartao.setTipo(FormaDePagamento.CREDITO);
			}
		}
		pagamento.setValor(valor);
		pagamento.setSituacao(Situacao.NAO_PAGO);
		//Consumir API
		return consulta;
	}

}
