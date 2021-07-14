package com.ufc.quixada.vev.todolist.usuario;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RepositoryUsuarioTest {

	private RepositoryUsuario rep;
	private ModelUsuario model;

	@BeforeEach
	public void setUp() {
		rep = new RepositoryUsuario();
		
		model = new ModelUsuario();
		model.setId(UUID.randomUUID());
		model.setName("new name");
		model.setUsername("new Username");
		model.setIdAgenda(UUID.randomUUID());
	}
	
	@AfterEach
	public void tearDown() {
		model = null;
		rep = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de novo usuario
	 */

	@Test
	public void shouldCreateNewUsuario() {
		assertTrue(rep.create(model));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioNull() {
		assertThrows(NullPointerException.class, () -> rep.create(null));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de busca de usuario
	 */

	@Test
	public void shouldFindUsuario() {
		rep.create(model);
		assertEquals(model, rep.findByUsername(model.getUsername()));
	}
	
	@Test
	public void shouldThrowWhenTryFindUsuarioWithNullUsername() {
		assertThrows(NullPointerException.class, () -> rep.findByUsername(null));
	}
	
	@Test
	public void shouldThrowWhenTryFindWithUnknownUsuario() {
		assertThrows(IllegalArgumentException.class, () -> rep.findByUsername("unknown username"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de atualizacao de usuario
	 */

	@Test
	public void shouldUpdateUsuario() {
		rep.create(model);
		
		model.setName("name updated");
		assertTrue(rep.update(model));
		
		ModelUsuario usr = rep.findByUsername(model.getUsername());
		assertEquals(usr.getName(), model.getName());
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithNullUsuario() {
		rep.create(model);
		assertThrows(NullPointerException.class, () -> rep.update(null));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithUnknownUsuario() {
		rep.create(model);
		model = new ModelUsuario(); 
		model.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.update(model));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de remocao de usuario
	 */

	@Test
	public void shouldDeleteUsuario() {
		rep.create(model);
		
		assertTrue(rep.delete(model.getId()));
		
		assertThrows(IllegalArgumentException.class, () -> rep.findByUsername(model.getUsername()));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithNullUsuario() {
		assertThrows(NullPointerException.class, () -> rep.delete(null));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithUnknownUsuario() {
		rep.create(model);
		model = new ModelUsuario();
		model.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.delete(model.getId()));
	}
	
}
