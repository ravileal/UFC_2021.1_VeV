package com.ufc.quixada.vev.todolist.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DTOUsuarioTest {

	private DTOUsuario dto;
	private static ModelUsuario model;
	
	private UUID id = UUID.randomUUID();
	private String name = "new Name";
	private String username = "new Username";
	private String password = "password12345";
	private UUID agendaId = UUID.randomUUID();

	@BeforeEach
	public void setUp() {
		dto = new DTOUsuario();
		model = new ModelUsuario();
		model.setId(id);
		model.setName(name);
		model.setUsername(username);
		model.setPassword(password);
		model.setIdAgenda(agendaId);
	}
	 
	@AfterEach
	public void tearDown() {
		dto = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de id
	 */ 
	
	@Test
	public void setIDDTOUsuarioTest() {
		UUID id = UUID.randomUUID();
		dto.setId(id);
		assertEquals( id, dto.getId());
	}
		

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de nome 
	 */ 
	
	@Test
	public void setNameDTOUsuarioTest() {
		dto.setName("newName");
		assertEquals("newName", dto.getName());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de username
	 */ 
	
	@Test
	public void setUsernameDTOUsuarioTest() {
		dto.setUsername("Username");
		assertEquals("Username", dto.getUsername());
	}
	

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de password
	 */ 
	
	@Test
	public void setPasswordDTOUsuarioTest() {
		dto.setPassword("Password");
		assertEquals("Password", dto.getPassword());
	}
	
	/* *
	 * == DESCRICAO == 
	 * Testes de manipulacao de agendaID
	 */ 
		
	@Test
	public void setAgendaIDDTOUsuarioTest() {
		UUID id = UUID.randomUUID();
		dto.setIdAgenda(id);
		assertEquals( id, dto.getIdAgenda());
	}

	/* *
	 * == DESCRICAO == 
	 * Testes de funcoes de conversao
	 */ 
		
	@Test
	public void shouldConvertToModel() {
		dto.setId(id);
		dto.setName(name);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setIdAgenda(agendaId);
		
		ModelUsuario model = dto.toModel();
		
		assertEquals(dto.getId(), model.getId());
		assertEquals(dto.getName(), model.getName());
		assertEquals(dto.getUsername(), model.getUsername());
		assertEquals(dto.getPassword(), model.getPassword());
		assertEquals(dto.getIdAgenda(), model.getIdAgenda());
	}
	
	@Test
	public void shouldReadAndInsertModel() {
		dto.readModel(model);
		
		assertEquals(model.getId(), dto.getId());
		assertEquals(model.getName(), dto.getName());
		assertEquals(model.getUsername(), dto.getUsername());
		assertEquals(model.getPassword(), dto.getPassword());
		assertEquals(model.getIdAgenda(), dto.getIdAgenda());
	}

	@Test
	public void shouldReturnTrueCompareBothObjectsEquals() {
		dto.setId(id);
		dto.setName(name);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setIdAgenda(agendaId);
		
		assertTrue(dto.equals(dto));
	}
	
	@Test
	public void shouldReturnFalseInCompareBothObjectsDifferents() {
		dto.setId(id);
		dto.setName(name);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setIdAgenda(agendaId);
		
		assertFalse(dto.equals(new DTOUsuario()));
	}
}
