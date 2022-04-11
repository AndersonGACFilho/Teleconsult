package br.com.inf.es.telemedicina.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PacienteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void PacienteNaoExiste() throws Exception {
		Long id = 100L;
		URI uri = new URI("/pacientes/"+id.intValue());
		mockMvc.perform( get(uri))
				.andExpect(MockMvcResultMatchers
						.status()
						.isNotFound());
	}
	@Test
	void SavePaciente() throws Exception {
		String json = "{\r\n"
				+ "    \"primeiroNome\" : \"Illian\",\r\n"
				+ "    \"sobrenome\" : \"Yamandú\",\r\n"
				+ "    \"email\" : \"illianyamandú@discente.uf.br\",\r\n"
				+ "    \"senha\" : \"00000000\",\r\n"
				+ "    \"cep\" : \"74382056\",\r\n"
				+ "    \"estado\" : \"Goiás\",\r\n"
				+ "    \"cidade\" : \"Goiânia\",\r\n"
				+ "    \"logradouro\" : \"Rua 10\",\r\n"
				+ "    \"numero\" : 10,\r\n"
				+ "    \"bairro\" : \"Perto da UFG\",\r\n"
				+ "    \"complemento\" : \"Perto da ufg\"\r\n"
				+ "}";
	
		URI uri = new URI("/pacientes");
		
		mockMvc.perform( post(uri).contentType("application/json").content(json))
				.andExpect(status().isCreated());
	}
	@Test
	void GetPacientes() throws Exception {
		URI uri = new URI("/pacientes");
		mockMvc.perform( get(uri))
				.andExpect(status().isOk());
	}
	@Test
	void GetPaciente() throws Exception {
		Long id = 1L;
		URI uri = new URI("/pacientes/"+id.intValue());
		
		mockMvc.perform( get(uri))
				.andExpect(status().isOk());
	}
	@Test
	void DeletePaciente1() throws Exception {
		Long id =1L;
		URI uri = new URI("/pacientes/"+id.intValue());
		
		mockMvc.perform( delete(uri))
				.andExpect(status().isOk());
	}
	
	


}
