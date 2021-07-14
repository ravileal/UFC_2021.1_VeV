package com.ufc.quixada.vev.todolist.page;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ModelPageTest {

	private ModelPage model;

	@BeforeEach
	public void setUp() {
		model = new ModelPage();
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
	public void setIDModelPageTest() {
		UUID id = UUID.randomUUID();
		model.setId(id); 
		assertEquals( id, model.getId());
	}
	
	@Test
	public void notSetIDNullModelPageTest() {
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
	public void setNameModelPageTest() {
		model.setName("newName");
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameNullModelPageTest() {
		model.setName("newName");
		assertThrows(NullPointerException.class, () -> model.setName(null));
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameEmptyModelPageTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName(""));
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameEmptyWithSpacesModelPageTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("               "));
		assertEquals("newName", model.getName());
	}
	
	@Test // nome de page nao deve ser setado se for maior que vinte caracteres
	public void notSetNameBigModelPageTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("abcdeabcdeabcdeabcdeX"));
		assertEquals("newName", model.getName());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de agendaID
	 */ 
		
	@Test
	public void setAgendaIDModelPageTest() {
		UUID id = UUID.randomUUID();
		model.setIdAgenda(id);
		assertEquals( id, model.getIdAgenda());
	}
	
	@Test
	public void notSetAgendaIDNullNotModelPageTest() {
		UUID id = UUID.randomUUID();
		model.setIdAgenda(id);
		assertThrows(NullPointerException.class, () -> model.setIdAgenda(null));
		assertEquals( id, model.getIdAgenda());
	}
	
}
