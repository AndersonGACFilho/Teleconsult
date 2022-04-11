package br.com.inf.es.telemedicina.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.inf.es.telemedicina.dto.ConsultaDTO;
import br.com.inf.es.telemedicina.dto.DetalhesPacienteDto;
import br.com.inf.es.telemedicina.dto.PacienteDto;
import br.com.inf.es.telemedicina.exceptions.ConsultaNotFoundException;
import br.com.inf.es.telemedicina.exceptions.PacienteNotFoundException;
import br.com.inf.es.telemedicina.form.AtualizacaoConsultaForm;
import br.com.inf.es.telemedicina.form.AtualizacaoPacienteForm;
import br.com.inf.es.telemedicina.form.PacienteConsultaForm;
import br.com.inf.es.telemedicina.form.PacienteForm;
import br.com.inf.es.telemedicina.modelo.Consulta;
import br.com.inf.es.telemedicina.modelo.Paciente;
import br.com.inf.es.telemedicina.repository.ConsultaRepository;
import br.com.inf.es.telemedicina.repository.EnderecoRepository;
import br.com.inf.es.telemedicina.repository.MedicoRepository;
import br.com.inf.es.telemedicina.repository.PacienteRepository;
import br.com.inf.es.telemedicina.repository.PagamentoRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteRepository pacienteRepository;	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@SuppressWarnings("unused")
	@Autowired
	private PagamentoRepository pagamentoRepository;
	//Mostrar pacientes
	@GetMapping
	@Cacheable(value = "listaDePacientes")
	public Page<PacienteDto> listar(@PageableDefault(sort="primeiroNome",direction = Direction.ASC,page = 0,size = 10)
	Pageable paginacao){
		Page<Paciente> paciente = pacienteRepository.findAll(paginacao);
		return PacienteDto.converter(paciente);
	}
	@PostMapping@Transactional
	@CacheEvict(value = "listaDePacientes", allEntries=true)
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PacienteForm pacienteForm,UriComponentsBuilder uriBuilder){
		Paciente paciente = pacienteForm.coverter(enderecoRepository,pacienteRepository);
		if(paciente!=null) {
			pacienteRepository.save(paciente);
			URI uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
			return ResponseEntity.created(uri).body(new PacienteDto(paciente));
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{id}")@Transactional
	public ResponseEntity<DetalhesPacienteDto> detalhar(@PathVariable("id") Long id){
			Optional<Paciente> paciente = pacienteRepository.findById(id);
			if(paciente.isPresent())
			return ResponseEntity.ok(new DetalhesPacienteDto(paciente.get()));
			else
			return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")@Transactional
	@CacheEvict(value = "listaDePacientes", allEntries=true)
	public ResponseEntity<DetalhesPacienteDto> atualizar(@PathVariable("id") Long id,@RequestBody @Valid AtualizacaoPacienteForm form,UriComponentsBuilder uriBuilder) throws PacienteNotFoundException{
		Optional<Paciente> optional = pacienteRepository.findById(id);
		if(optional.isPresent()) {
			Paciente paciente = form.atualizar(id, pacienteRepository);
			return ResponseEntity.ok(new DetalhesPacienteDto(paciente));
		}
		else
			return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")@Transactional
	@CacheEvict(value = "listaDePacientes", allEntries=true)
	public ResponseEntity<?> deletar(@PathVariable("id") Long id){
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if(paciente.isPresent()) {
			pacienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
	//Mostrar as consultas do paciente
	@GetMapping("/{id}/consultas")@Transactional
	@Cacheable(value = "listaDeConsultas")
	public ResponseEntity<Page<ConsultaDTO>> listar_consultas(@PathVariable("id") Long id,@PageableDefault(sort="primeiroNome",direction = Direction.ASC,page = 0,size = 10)
	Pageable paginacao){
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if(paciente.isPresent()) {
			Page<Consulta> consultas = new PageImpl<Consulta>(paciente.get().getConsultas(),paginacao,paciente.get().getConsultas().size());
			return ResponseEntity.ok(ConsultaDTO.converter(consultas));
		}
		else
			return ResponseEntity.notFound().build();
	}
	@PostMapping("/{id}/consultas")@Transactional
	@CacheEvict(value = "listaDeConsultas", allEntries=true)
	public ResponseEntity<?> cadastrar_consultas(@PathVariable("id") Long id,@RequestBody @Valid PacienteConsultaForm form,UriComponentsBuilder uriBuilder){
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if(paciente.isPresent()) {
			Consulta consulta = form.coverter(paciente.get(),consultaRepository,pacienteRepository,medicoRepository);
			if(consulta!=null) {
				consultaRepository.save(consulta);
				URI uri = uriBuilder.path("/{id}/consultas/{id_consulta}").buildAndExpand(consulta.getPaciente().getId(),consulta.getId()).toUri();
				return ResponseEntity.created(uri).body(new ConsultaDTO(consulta));
			}
			else {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}/consultas/{id_consulta}")@Transactional
	@CacheEvict(value = "listaDeConsultas", allEntries=true)
	public ResponseEntity<ConsultaDTO> atualizar_consulta(@PathVariable("id") Long id,@PathVariable("id_consulta") Long id_consulta,@RequestBody @Valid AtualizacaoConsultaForm form,UriComponentsBuilder uriBuilder) throws ConsultaNotFoundException{
		Optional<Consulta> optional = pacienteRepository.findById_Consulta(id,id_consulta);
		if(optional.isPresent()) {
			Consulta consulta = form.atualizar(id_consulta, consultaRepository);
			return ResponseEntity.ok(new ConsultaDTO(consulta));
		}
		else
			return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}/consultas/{id_consulta}")@Transactional
	@CacheEvict(value = "listaDeConsultas", allEntries=true)
	public ResponseEntity<?> deletar_consulta(@PathVariable("id") Long id,@PathVariable("id_consulta") Long id_consulta){
		Optional<Consulta> consulta = pacienteRepository.findById_Consulta(id,id_consulta);
		if(consulta.isPresent()) {
			consultaRepository.deleteById(id_consulta);
			return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
}
