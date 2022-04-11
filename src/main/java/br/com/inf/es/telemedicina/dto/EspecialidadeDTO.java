package br.com.inf.es.telemedicina.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.inf.es.telemedicina.modelo.Especialidade;

public class EspecialidadeDTO {
	private String nome;
	private String descricao;
	public EspecialidadeDTO(Especialidade especialidade) {
		nome = especialidade.getNome();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static List<EspecialidadeDTO> converter(List<Especialidade> especialidades) {
		return especialidades.stream().map(EspecialidadeDTO::new).collect(Collectors.toList());
	}
	
}
