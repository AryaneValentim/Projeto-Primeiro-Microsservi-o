package br.com.nava.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nava.dtos.UsuarioDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getAllTest() throws Exception {
		ResultActions response = mockMvc.perform(
											get("/usuarios")
											.contentType("application/json")
											);
		
		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString();
		System.out.println(responseStr);
		ObjectMapper mapper = new ObjectMapper();
		UsuarioDTO[] lista = mapper.readValue(responseStr, UsuarioDTO[].class);
		
		assertThat(lista).isNotEmpty();
				
	}
}
