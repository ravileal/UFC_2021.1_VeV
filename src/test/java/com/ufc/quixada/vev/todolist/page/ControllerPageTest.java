package com.ufc.quixada.vev.todolist.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ControllerPageTest {

	private static ControllerPage ctrl;
	private static DTOPage dto;

	private static IRepositoryPage repository;
	@BeforeEach
	public void setUp() {
		
		dto = new DTOPage();
		dto.setId(UUID.randomUUID());
		dto.setName("New Name");
		dto.setIdAgenda(UUID.randomUUID());
		
		ArrayList<DTOPage> list = new ArrayList<>();
		list.add(dto);
		
		repository = mock(IRepositoryPage.class);
		when(repository.findByAgenda(dto.getId())).thenReturn(list);
		when(repository.findByName(dto.getName())).thenReturn(dto);
		when(repository.create(dto)).thenReturn(true);
		when(repository.update(dto)).thenReturn(true);
		when(repository.delete(dto.getId())).thenReturn(true);
		
		ctrl = new ControllerPage(repository);
	}

	@AfterEach
	public void tearDown() {
		ctrl = null;
	}

	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de nova pagina
	 */

	@Test
	public void shouldCreateNewPage() {
		when(repository.findByName(dto.getName())).thenThrow(NoResultException.class);
		assertEquals(dto, ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithNullId() {
		dto.setId(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageNull() {
		assertThrows(NullPointerException.class, () -> ctrl.create(null));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithNullName() {
		dto.setName(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithNullIdAgenda() {
		dto.setIdAgenda(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithDuplicatedName() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de pagina por nome
	 */

	@Test
	public void shouldDoFindByPageName() {
		assertTrue(dto.equals(ctrl.findByName(dto.getName())));
	}

	@Test
	public void shouldThrowWhenTryDoFindByPageWithNullName() {
		assertThrows(NullPointerException.class, () -> ctrl.findByName(null));
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByPageWithUnknownName() {
		assertThrows(NullPointerException.class, () -> ctrl.findByName("This is a unknown name"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de pagina por agenda
	 */

	@Test
	public void shouldDoFindByAgendaId() {
		for (DTOPage task: ctrl.findByAgenda(dto.getId()))
			assertTrue(dto.equals(task));
	}

	@Test
	public void shouldThrowWhenTryDoFindByPageWithNullAgendaId() {
		when(repository.findByAgenda(null)).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> ctrl.findByAgenda(null));
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByPageWithUnknownAgendaId() {
		UUID id = UUID.randomUUID();
		when(repository.findByAgenda(id)).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> ctrl.findByAgenda(id));
	}
	
}
