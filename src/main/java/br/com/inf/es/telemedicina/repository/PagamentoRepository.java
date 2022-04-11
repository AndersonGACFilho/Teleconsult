package br.com.inf.es.telemedicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inf.es.telemedicina.modelo.Paciente;
@Repository
public interface PagamentoRepository extends JpaRepository<Paciente, Long> {

	Paciente findByEmail(String email);

}
