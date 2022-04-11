package br.com.inf.es.telemedicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inf.es.telemedicina.modelo.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}

