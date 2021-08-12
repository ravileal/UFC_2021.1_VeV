package com.ufc.quixada.vev.todolist.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DTOTaskTest {

	private DTOTask dto;
	private static ModelTask model;
	
	private UUID id = UUID.randomUUID();
	private String name = "new Name";
	private UUID pageId = UUID.randomUUID();

	@BeforeEach
	public void setUp() {
		dto = new DTOTask();
		model = new ModelTask();
		model.setId(id);
		model.setName(name);
		model.setIdPage(pageId);
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
	public void setIDDTOTaskTest() {
		UUID id = UUID.randomUUID();
		dto.setId(id);
		assertEquals( id, dto.getId());
	}
		

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de nome 
	 */ 
	
	@Test
	public void setNameDTOTaskTest() {
		dto.setName("newName");
		assertEquals("newName", dto.getName());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de pageID
	 */ 
		
	@Test
	public void setPageIDDTOTaskTest() {
		UUID id = UUID.randomUUID();
		dto.setIdPage(id);
		assertEquals( id, dto.getIdPage());
	}

	/* *
	 * == DESCRICAO ==
	 * Testes de funcoes de conversao
	 */ 
		
	@Test
	public void shouldConvertToModel() {
		dto.setId(id);
		dto.setName(name);
		dto.setIdPage(pageId);
		
		ModelTask model = dto.toModel();
		
		assertEquals(dto.getId(), model.getId());
		assertEquals(dto.getName(), model.getName());
		assertEquals(dto.getIdPage(), model.getIdPage());
	}
	
	@Test
	public void shouldReadAndInsertModel() {
		dto.readModel(model);
		
		assertEquals(model.getId(), dto.getId());
		assertEquals(model.getName(), dto.getName());
		assertEquals(model.getIdPage(), dto.getIdPage());
	}

	@Test
	public void shouldReturnTrueCompareBothObjectsEquals() {
		dto.setId(id);
		dto.setName(name);
		dto.setIdPage(pageId);
		
		assertTrue(dto.equals(dto));
	}
	
	@Test
	public void shouldReturnFalseInCompareBothObjectsDifferents() {
		dto.setId(id);
		dto.setName(name);
		dto.setIdPage(pageId);
		
		assertFalse(dto.equals(new DTOTask()));
	}
}
