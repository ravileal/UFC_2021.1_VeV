package com.ufc.quixada.vev.todolist.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerPageTest {

	private static ControllerPage ctrl;
	private static DTOPage dto;

	@BeforeEach
	public void setUp() {
		ctrl = new ControllerPage("DEVELOPMENT");
		
		dto = new DTOPage();
		dto.setId(UUID.randomUUID());
		dto.setName("New Name");
		dto.setIdAgenda(UUID.randomUUID());
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
		assertEquals(dto, ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithNullId() {
		dto.setId(null);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageNull() {
		assertThrows(NullPointerException.class, () -> ctrl.create(null));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithNullName() {
		dto.setName(null);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewPageWithNullIdAgenda() {
		dto.setIdAgenda(null);
		assertThrows(NullPointerException.class, () -> ctrl.create(dto));
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
		dto.setName("the new name");
		ctrl.create(dto);
		assertTrue(dto.equals(ctrl.findByName("the new name")));
	}

	@Test
	public void shouldThrowWhenTryDoFindByPageWithNullName() {
		assertThrows(NullPointerException.class, () -> ctrl.findByName(null));
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByPageWithUnknownName() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.findByName("This is a unknown name"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de busca de pagina por agenda
	 */

	@Test
	public void shouldDoFindByAgendaId() {
		UUID id = UUID.randomUUID();
		dto.setName("outher new name");
		dto.setIdAgenda(id);
		ctrl.create(dto);
		for (DTOPage task: ctrl.findByAgenda(id))
			assertTrue(dto.equals(task));
	}

	@Test
	public void shouldThrowWhenTryDoFindByPageWithNullAgendaId() {
		assertThrows(NullPointerException.class, () -> ctrl.findByAgenda(null));
	}
		
	@Test
	public void shouldThrowWhenTryDoFindByPageWithUnknownAgendaId() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.findByAgenda(UUID.randomUUID()));
	}
	
}
