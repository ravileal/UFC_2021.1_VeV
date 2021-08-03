package com.ufc.quixada.vev.todolist.task;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RepositoryTaskTest {

	private RepositoryMemoryTask rep;
	private ModelTask model;

	@BeforeEach
	public void setUp() {
		rep = new RepositoryMemoryTask();
		
		model = new ModelTask();
		model.setId(UUID.randomUUID());
		model.setName("new name");
		model.setIdPage(UUID.randomUUID());
	}
	
	@AfterEach
	public void tearDown() {
		model = null;
		rep = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova task
	 */

	@Test
	public void shouldCreateNewTask() {
		assertTrue(rep.create(model));
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
		rep.create(model);
		assertEquals(model, rep.findByName(model.getName()));
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
		rep.create(model);
		
		model.setName("name updated");
		assertTrue(rep.update(model));
		
		ModelTask usr = rep.findByName(model.getName());
		assertEquals(usr.getName(), model.getName());
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithNullTask() {
		rep.create(model);
		assertThrows(NullPointerException.class, () -> rep.update(null));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithUnknownTask() {
		rep.create(model);
		model = new ModelTask(); 
		model.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.update(model));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de remocao de task
	 */

	@Test
	public void shouldDeleteTask() {
		rep.create(model);
		
		assertTrue(rep.delete(model.getId()));
		
		assertThrows(IllegalArgumentException.class, () -> rep.findByName(model.getName()));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithNullTask() {
		assertThrows(NullPointerException.class, () -> rep.delete(null));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithUnknownTask() {
		rep.create(model);
		model = new ModelTask();
		model.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.delete(model.getId()));
	}
	
}
