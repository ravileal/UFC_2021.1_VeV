package com.ufc.quixada.vev.todolist.task;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ModelTaskTest {

	private ModelTask model;

	@BeforeEach
	public void setUp() {
		model = new ModelTask();
	}
	
	@AfterEach
	public void tearDown() {
		model = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de id
	 */ 
	
	@Test
	public void setIDModelTaskTest() {
		UUID id = UUID.randomUUID();
		model.setId(id); 
		assertEquals( id, model.getId());
	}
	
	@Test
	public void notSetIDNullModelTaskTest() {
		UUID id = UUID.randomUUID();
		model.setId(id);
		assertThrows(NullPointerException.class, () -> model.setId(null));
		assertEquals( id, model.getId());
	}
	

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de nome 
	 */ 
	
	@Test
	public void setNameModelTaskTest() {
		model.setName("newName");
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameNullModelTaskTest() {
		model.setName("newName");
		assertThrows(NullPointerException.class, () -> model.setName(null));
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameEmptyModelTaskTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName(""));
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameEmptyWithSpacesModelTaskTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("               "));
		assertEquals("newName", model.getName());
	}
	
	@Test // nome de task nao deve ser setado se for maior que vinte caracteres
	public void notSetNameBigModelTaskTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("abcdeabcdeabcdeabcdeX"));
		assertEquals("newName", model.getName());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de agendaID
	 */ 
		
	@Test
	public void setAgendaIDModelTaskTest() {
		UUID id = UUID.randomUUID();
		model.setIdPage(id);
		assertEquals( id, model.getIdPage());
	}
	
	@Test
	public void notSetAgendaIDNullNotModelTaskTest() {
		UUID id = UUID.randomUUID();
		model.setIdPage(id);
		assertThrows(NullPointerException.class, () -> model.setIdPage(null));
		assertEquals( id, model.getIdPage());
	}
	
}
