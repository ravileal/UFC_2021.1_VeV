package com.ufc.quixada.vev.todolist.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DTOPageTest {

	private DTOPage dto;
	private static ModelPage model;
	
	private UUID id = UUID.randomUUID();
	private String name = "new Name";
	private UUID agendaId = UUID.randomUUID();

	@BeforeEach
	public void setUp() {
		dto = new DTOPage();
		model = mock(ModelPage.class);
		when(model.getId()).thenReturn(id);
		when(model.getName()).thenReturn(name);
		when(model.getIdAgenda()).thenReturn(agendaId);
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
	public void setIDDTOPageTest() {
		UUID id = UUID.randomUUID();
		dto.setId(id);
		assertEquals( id, dto.getId());
	}
		

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de nome 
	 */ 
	
	@Test
	public void setNameDTOPageTest() {
		dto.setName("newName");
		assertEquals("newName", dto.getName());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de agendaID
	 */ 
		
	@Test
	public void setAgendaIDDTOPageTest() {
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
		dto.setIdAgenda(agendaId);
		
		ModelPage model = dto.toModel();
		
		assertEquals(dto.getId(), model.getId());
		assertEquals(dto.getName(), model.getName());
		assertEquals(dto.getIdAgenda(), model.getIdAgenda());
	}
	
	@Test
	public void shouldReadAndInsertModel() {
		dto.readModel(model);
		
		assertEquals(model.getId(), dto.getId());
		assertEquals(model.getName(), dto.getName());
		assertEquals(model.getIdAgenda(), dto.getIdAgenda());
	}

	@Test
	public void shouldReturnTrueCompareBothObjectsEquals() {
		dto.setId(id);
		dto.setName(name);
		dto.setIdAgenda(agendaId);
		
		assertTrue(dto.equals(dto));
	}
	
	@Test
	public void shouldReturnFalseInCompareBothObjectsDifferents() {
		dto.setId(id);
		dto.setName(name);
		dto.setIdAgenda(agendaId);
		
		assertFalse(dto.equals(new DTOPage()));
	}
}
