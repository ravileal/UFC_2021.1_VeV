package com.ufc.quixada.vev.todolist.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ControllerTaskTest {

	private static ControllerTask ctrl;
	private static DTOTask dto;

	@BeforeEach
	public void setUp() {
		ctrl = new ControllerTask("DEVELOPMENT");
		
		dto = new DTOTask();
		dto.setId(UUID.randomUUID());
		dto.setName("New Name");
		dto.setIdPage(UUID.randomUUID());
	}
	 

	@AfterEach
	public void tearDown() {
		ctrl = null;
	}

	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova task
	 */

	@Test
	public void shouldCreateNewTask() {
		assertEquals(dto, ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithNullId() {
		dto.setId(null);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskNull() {
		assertThrows(NullPointerException.class, () -> ctrl.create(null));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithNullName() {
		dto.setName(null);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithNullIdPage() {
		dto.setIdPage(null);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithDuplicatedName() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de task por nome
	 */

	@Test
	public void shouldDoFindByTaskName() {
		dto.setName("the new name");
		ctrl.create(dto);
		assertTrue(dto.equals(ctrl.findByName("the new name")));
	}

	@Test
	public void shouldThrowWhenTryDoFindByTaskWithNullName() {
		assertThrows(NullPointerException.class, () -> ctrl.findByName(null));
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByTaskWithUnknownName() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.findByName("This is a unknown name"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de task por pagina
	 */

	@Test
	public void shouldDoFindByPageId() {
		UUID id = UUID.randomUUID();
		dto.setName("outher new name");
		dto.setIdPage(id);
		ctrl.create(dto);
		for (DTOTask task: ctrl.findByPage(id))
			assertTrue(dto.equals(task));
	}

	@Test
	public void shouldThrowWhenTryDoFindByTaskWithNullPageId() {
		assertThrows(NullPointerException.class, () -> ctrl.findByPage(null));
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByTaskWithUnknownPageId() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.findByPage(UUID.randomUUID()));
	}
	
}
