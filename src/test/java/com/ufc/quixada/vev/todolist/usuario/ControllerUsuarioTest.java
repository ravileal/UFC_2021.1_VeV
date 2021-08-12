package com.ufc.quixada.vev.todolist.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ControllerUsuarioTest {

	private static ControllerUsuario ctrl;
	private static DTOUsuario dto;
	private static IRepositoryUsuario repository;
	
	@BeforeEach
	public void setUp() {
		
		dto = new DTOUsuario();
		dto.setId(UUID.randomUUID());
		dto.setName("New Name");
		dto.setUsername("New Username");
		dto.setPassword("password1223");
		dto.setIdAgenda(UUID.randomUUID());
		
		repository = mock(IRepositoryUsuario.class);
		when(repository.findByUsername(dto.getUsername())).thenReturn(dto);
		when(repository.create(dto)).thenReturn(true);
		when(repository.update(dto)).thenReturn(true);
		when(repository.delete(dto.getId())).thenReturn(true);
		
		ctrl = new ControllerUsuario(repository);
	}
	 

	@AfterEach
	public void tearDown() {
		ctrl = null;
		repository = null;
	}

	/* *
	 * == DESCRICAO ==
	 * Testes de criacao de novo usuario
	 */

	@Test
	public void shouldCreateNewUsuario() {
		when(repository.findByUsername(dto.getUsername())).thenThrow(IllegalArgumentException.class);
		assertEquals(dto, ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioWithNullId() {
		dto.setId(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioNull() {
		assertThrows(NullPointerException.class, () -> ctrl.create(null));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioWithNullName() {
		dto.setName(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioWithNullUsername() {
		dto.setUsername(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioWithNullPassword() {
		dto.setPassword(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioWithNullIdAgenda() {
		dto.setIdAgenda(null);
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	@Test
	public void shouldThrowWhenTryCreateNewUsuarioWithDuplicatedUsername() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.create(dto));
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de realizacao de login
	 */

	@Test
	public void shouldDoSignIn() {
		dto.setUsername("the new username");
		when(repository.findByUsername(dto.getUsername())).thenReturn(dto);
		assertTrue(dto.equals(ctrl.signIn("the new username", "password1223")));
	}

	@Test
	public void shouldThrowWhenTryDoSignInWithNullUsername() {
		assertThrows(NullPointerException.class, () -> ctrl.signIn(null, "password1223"));
	}
	
	@Test
	public void shouldThrowWhenTryDoSignInWithNullPassword() {
		assertThrows(NullPointerException.class, () -> ctrl.signIn("New Username", null));
	}
	
	@Test
	public void shouldThrowWhenTryDoSignInWithUnknownUsername() {
		assertThrows(NullPointerException.class, () -> ctrl.signIn("This is a unknown username", "password1223"));
	}
	
	@Test
	public void shouldThrowWhenTryDoSignInWithWrongPassword() {
		assertThrows(IllegalArgumentException.class, () -> ctrl.signIn("New Username", "This is a wrong password"));
	}
	
}
