package br.com.inf.es.telemedicina.exceptions;

public class ConsultaNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensagem =  "Essa consulta não existe";
	@Override
	public String getMessage() {
	return mensagem;
	}
}
