package br.com.inf.es.telemedicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inf.es.telemedicina.modelo.Medico;

public interface MedicoRepository  extends JpaRepository<Medico, Long>{

	Medico getByCrm(String crm);

}
