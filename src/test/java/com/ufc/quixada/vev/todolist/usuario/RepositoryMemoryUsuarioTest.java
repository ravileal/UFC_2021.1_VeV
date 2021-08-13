package com.ufc.quixada.vev.todolist.usuario;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RepositoryMemoryUsuarioTest {

	private RepositoryMemoryUsuario rep;
	private DTOUsuario dto;

	@BeforeEach
	public void setUp() {
		rep = new RepositoryMemoryUsuario();
		
		dto = new DTOUsuario();
		dto.setId(UUID.randomUUID());
		dto.setName("new name");
		dto.setUsername("new Username");
		dto.setPassword("new password");
		dto.setIdAgenda(UUID.randomUUID());
	}
	
	@AfterEach
	public void tearDown() {
		dto = null;
		rep = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de novo usuario
	 */

	@Test
	public void shouldCreateNewUsuario() {
		assertTrue(rep.create(dto));
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
		rep.create(dto);
		DTOUsuario result = rep.findByUsername(dto.getUsername());
		assertTrue(dto.equals(result));
	}
	
	@Test
	public void shouldThrowWhenTryFindUsuarioWithNullUsername() {
		assertThrows(NullPointerException.class, () -> rep.findByUsername(null));
	}
	
	@Test
	public void shouldThrowWhenTryFindWithUnknownUsuario() {
		assertThrows(NoResultException.class, () -> rep.findByUsername("unknown username"));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de atualizacao de usuario
	 */

	@Test
	public void shouldUpdateUsuario() {
		rep.create(dto);
		
		dto.setName("name updated");
		assertTrue(rep.update(dto));
		
		DTOUsuario usr = rep.findByUsername(dto.getUsername());
		assertTrue(usr.equals(usr));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithNullUsuario() {
		rep.create(dto);
		assertThrows(NullPointerException.class, () -> rep.update(null));
	}
	
	@Test
	public void shouldThrowWhenTryUpdateWithUnknownUsuario() {
		rep.create(dto);
		dto = new DTOUsuario(); 
		dto.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.update(dto));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de remocao de usuario
	 */

	@Test
	public void shouldDeleteUsuario() {
		rep.create(dto);
		
		assertTrue(rep.delete(dto.getId()));
		
		assertThrows(NoResultException.class, () -> rep.findByUsername(dto.getUsername()));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithNullUsuario() {
		assertThrows(NullPointerException.class, () -> rep.delete(null));
	}
	
	@Test
	public void shouldThrowWhenTryDeleteWithUnknownUsuario() {
		rep.create(dto);
		dto = new DTOUsuario();
		dto.setId(UUID.randomUUID());
		assertThrows(IllegalArgumentException.class, () -> rep.delete(dto.getId()));
	}
	
}
