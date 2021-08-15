package com.ufc.quixada.vev.todolist.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ControllerTaskTest {

	private static ControllerTask ctrl;
	private static DTOTask dto;
	private static IRepositoryTask repository;

	@BeforeEach
	public void setUp() {
		
		dto = new DTOTask();
		dto.setId(UUID.randomUUID());
		dto.setName("New Name");
		dto.setIdPage(UUID.randomUUID());
		
		ArrayList<DTOTask> list = new ArrayList<>();
		list.add(dto);
		
		repository = mock(IRepositoryTask.class);
		when(repository.findByPage(dto.getId())).thenReturn(list);
		when(repository.findByName(dto.getName())).thenReturn(dto);
		when(repository.create(dto)).thenReturn(true);
		when(repository.update(dto)).thenReturn(true);
		when(repository.delete(dto.getId())).thenReturn(true);
		
		ctrl = new ControllerTask(repository);
	}
	 

	@AfterEach
	public void tearDown() {
		ctrl = null;
		repository = null;
	}

	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova task
	 */

	@Test
	public void shouldCreateNewTask() {
		when(repository.findByName(dto.getName())).thenThrow(NoResultException.class);
		assertEquals(dto, ctrl.create(dto));
		verify(repository).findByName(dto.getName());
		verify(repository).create(dto);
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithNullId() {
		dto.setId(null);
		when(repository.findByName(dto.getName())).thenThrow(NoResultException.class);
		when(repository.create(dto)).thenThrow(NullPointerException.class);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
		verify(repository).findByName(dto.getName());
		verify(repository).create(dto);
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskNull() {
		assertThrows(NullPointerException.class, () -> ctrl.create(null));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithNullName() {
		dto.setName(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
		verify(repository).findByName(null);
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithNullIdPage() {
		dto.setIdPage(null);
		when(repository.findByName(dto.getName())).thenThrow(NoResultException.class);
		when(repository.create(dto)).thenThrow(NullPointerException.class);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
		verify(repository).findByName(dto.getName());
		verify(repository).create(dto);
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewTaskWithDuplicatedName() {
		when(repository.findByName(dto.getName())).thenReturn(dto);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
		verify(repository).findByName(dto.getName());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de task por nome
	 */

	@Test
	public void shouldDoFindByTaskName() {
		dto.setName("the new name");
		when(repository.findByName(dto.getName())).thenReturn(dto);
		assertTrue(dto.equals(ctrl.findByName("the new name")));
		verify(repository).findByName(dto.getName());
	}

	@Test
	public void shouldThrowWhenTryDoFindByTaskWithNullName() {
		when(repository.findByName(null)).thenThrow(NullPointerException.class);
		assertThrows(NullPointerException.class, () -> ctrl.findByName(null));
		verify(repository).findByName(null);
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByTaskWithUnknownName() {
		when(repository.findByName("This is a unknown name")).thenThrow(NullPointerException.class);
		assertThrows(NullPointerException.class, () -> ctrl.findByName("This is a unknown name"));
		verify(repository).findByName("This is a unknown name");
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de task por pagina
	 */

	@Test
	public void shouldDoFindByPageId() {
		UUID id = UUID.randomUUID();
		ArrayList<DTOTask> listdto = new ArrayList<>(); 
		listdto.add(dto);
		when(repository.findByPage(dto.getId())).thenReturn(listdto);
		for (DTOTask task: ctrl.findByPage(id))
			assertTrue(dto.equals(task));
		verify(repository).findByPage(id);
	}

	@Test
	public void shouldThrowWhenTryDoFindByTaskWithNullPageId() {
		when(repository.findByPage(null)).thenThrow(NullPointerException.class);
		assertThrows(NullPointerException.class, () -> ctrl.findByPage(null));
		verify(repository).findByPage(null);
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByTaskWithUnknownPageId() {
		UUID id = UUID.randomUUID();
		when(repository.findByPage(id)).thenThrow(NullPointerException.class);
		assertThrows(NullPointerException.class, () -> ctrl.findByPage(id));
		verify(repository).findByPage(id);
	}
	
}
