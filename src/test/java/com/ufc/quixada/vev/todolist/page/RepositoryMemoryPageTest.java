package com.ufc.quixada.vev.todolist.page;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RepositoryMemoryPageTest {

	private RepositoryMemoryPage rep;
	private DTOPage dto;

	@BeforeEach
	public void setUp() {
		rep = new RepositoryMemoryPage();
		
		dto = new DTOPage();
		dto.setId(UUID.randomUUID());
		dto.setName("new name");
		dto.setIdAgenda(UUID.randomUUID());
	}
	
	@AfterEach
	public void tearDown() {
		dto = null;
		rep = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova page
	 */

	@Test
	public void shouldCreateNewPage() {
		assertTrue(rep.create(dto));
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
		rep.create(dto);
		assertEquals(dto, rep.findByName(dto.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryFindPageWithNullName() {
		assertThrows(NullPointerException.class, () -> rep.findByName(null));
	}
	
	@Test
	public void shouldThrowWhenTryFindWithUnknownPage() {
		assertThrows(NoResultException.class, () -> rep.findByName("unknown name"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de atualizacao de pagina
	 */

	@Test
	public void shouldUpdatePage() {
		rep.create(dto);
		
		dto.setName("name updated");
		assertTrue(rep.update(dto));
		
		DTOPage usr = rep.findByName(dto.getName());
		assertEquals(usr.getName(), dto.getName());
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithNullPage() {
		rep.create(dto);
		assertThrows(NullPointerException.class, () -> rep.update(null));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithUnknownPage() {
		rep.create(dto);
		dto = new DTOPage(); 
		dto.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.update(dto));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de remocao de pagina
	 */

	@Test
	public void shouldDeletePage() {
		rep.create(dto);
		
		assertTrue(rep.delete(dto.getId()));
		
		assertThrows(NoResultException.class, () -> rep.findByName(dto.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithNullPage() {
		assertThrows(NullPointerException.class, () -> rep.delete(null));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithUnknownPage() {
		rep.create(dto);
		dto = new DTOPage();
		dto.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.delete(dto.getId()));
	}
	
}
