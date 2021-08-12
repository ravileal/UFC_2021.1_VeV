package com.ufc.quixada.vev.todolist.task;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RepositoryMemoryTaskTest {

	private RepositoryMemoryTask rep;
	private DTOTask dto;

	@BeforeEach
	public void setUp() {
		rep = new RepositoryMemoryTask();
		
		dto = new DTOTask();
		dto.setId(UUID.randomUUID());
		dto.setName("new name");
		dto.setIdPage(UUID.randomUUID());
	}
	
	@AfterEach
	public void tearDown() {
		dto = null;
		rep = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova task
	 */

	@Test
	public void shouldCreateNewTask() {
		assertTrue(rep.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskNull() {
		assertThrows(NullPointerException.class, () -> rep.create(null));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de busca de task
	 */

	@Test
	public void shouldFindTask() {
		rep.create(dto);
		assertEquals(dto, rep.findByName(dto.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryFindTaskWithNullName() {
		assertThrows(NullPointerException.class, () -> rep.findByName(null));
	}
	
	@Test
	public void shouldThrowWhenTryFindWithUnknownTask() {
		assertThrows(IllegalArgumentException.class, () -> rep.findByName("unknown name"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de atualizacao de task
	 */

	@Test
	public void shouldUpdateTask() {
		rep.create(dto);
		
		dto.setName("name updated");
		assertTrue(rep.update(dto));
		
		DTOTask usr = rep.findByName(dto.getName());
		assertEquals(usr.getName(), dto.getName());
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithNullTask() {
		rep.create(dto);
		assertThrows(NullPointerException.class, () -> rep.update(null));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithUnknownTask() {
		rep.create(dto);
		dto = new DTOTask(); 
		dto.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.update(dto));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de remocao de task
	 */

	@Test
	public void shouldDeleteTask() {
		rep.create(dto);
		
		assertTrue(rep.delete(dto.getId()));
		
		assertThrows(IllegalArgumentException.class, () -> rep.findByName(dto.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithNullTask() {
		assertThrows(NullPointerException.class, () -> rep.delete(null));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithUnknownTask() {
		rep.create(dto);
		dto = new DTOTask();
		dto.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.delete(dto.getId()));
	}
	
}
