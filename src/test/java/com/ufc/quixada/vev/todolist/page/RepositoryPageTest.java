package com.ufc.quixada.vev.todolist.page;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RepositoryPageTest {

	private RepositoryMemoryPage rep;
	private ModelPage model;

	@BeforeEach
	public void setUp() {
		rep = new RepositoryMemoryPage();
		
		model = new ModelPage();
		model.setId(UUID.randomUUID());
		model.setName("new name");
		model.setIdAgenda(UUID.randomUUID());
	}
	
	@AfterEach
	public void tearDown() {
		model = null;
		rep = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova page
	 */

	@Test
	public void shouldCreateNewPage() {
		assertTrue(rep.create(model));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageNull() {
		assertThrows(NullPointerException.class, () -> rep.create(null));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de busca de pagina
	 */

	@Test
	public void shouldFindPage() {
		rep.create(model);
		assertEquals(model, rep.findByName(model.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryFindPageWithNullName() {
		assertThrows(NullPointerException.class, () -> rep.findByName(null));
	}
	
	@Test
	public void shouldThrowWhenTryFindWithUnknownPage() {
		assertThrows(IllegalArgumentException.class, () -> rep.findByName("unknown name"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de atualizacao de pagina
	 */

	@Test
	public void shouldUpdatePage() {
		rep.create(model);
		
		model.setName("name updated");
		assertTrue(rep.update(model));
		
		ModelPage usr = rep.findByName(model.getName());
		assertEquals(usr.getName(), model.getName());
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithNullPage() {
		rep.create(model);
		assertThrows(NullPointerException.class, () -> rep.update(null));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithUnknownPage() {
		rep.create(model);
		model = new ModelPage(); 
		model.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.update(model));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de remocao de pagina
	 */

	@Test
	public void shouldDeletePage() {
		rep.create(model);
		
		assertTrue(rep.delete(model.getId()));
		
		assertThrows(IllegalArgumentException.class, () -> rep.findByName(model.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithNullPage() {
		assertThrows(NullPointerException.class, () -> rep.delete(null));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithUnknownPage() {
		rep.create(model);
		model = new ModelPage();
		model.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.delete(model.getId()));
	}
	
}
