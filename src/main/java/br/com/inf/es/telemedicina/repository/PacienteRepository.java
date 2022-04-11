package br.com.inf.es.telemedicina.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.inf.es.telemedicina.modelo.Consulta;
import br.com.inf.es.telemedicina.modelo.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Paciente findByEmail(String email);
	
	@Query(value="SELECT c FROM Paciente p INNER JOIN Consulta c ON p.id = c.paciente_id WHERE p.id= :id AND c.id=:id2",nativeQuery = true)
	Optional<Consulta> findById_Consulta(@Param("id") Long id, @Param("id2") Long id2);

}
