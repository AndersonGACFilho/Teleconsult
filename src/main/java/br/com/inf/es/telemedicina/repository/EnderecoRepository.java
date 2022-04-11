package br.com.inf.es.telemedicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inf.es.telemedicina.modelo.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}

