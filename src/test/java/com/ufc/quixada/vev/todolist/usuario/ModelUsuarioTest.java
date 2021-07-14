package com.ufc.quixada.vev.todolist.usuario;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ModelUsuarioTest {

	private ModelUsuario model;

	@BeforeEach
	public void setUp() {
		model = new ModelUsuario();
	}
	
	@AfterEach
	public void tearDown() {
		model = null;
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de id
	 */ 
	
	@Test
	public void setIDModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		model.setId(id); 
		assertEquals( id, model.getId());
	}
	
	@Test
	public void notSetIDNullModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		model.setId(id);
		assertThrows(NullPointerException.class, () -> model.setId(null));
		assertEquals( id, model.getId());
	}
	

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de nome 
	 */ 
	
	@Test
	public void setNameModelUsuarioTest() {
		model.setName("newName");
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameNullModelUsuarioTest() {
		model.setName("newName");
		assertThrows(NullPointerException.class, () -> model.setName(null));
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameEmptyModelUsuarioTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName(""));
		assertEquals("newName", model.getName());
	}
	
	@Test
	public void notSetNameEmptyWithSpacesModelUsuarioTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("               "));
		assertEquals("newName", model.getName());
	}
	
	@Test // nome de usuario nao deve ser setado se for menor que cinco caracteres
	public void notSetNameSmallModelUsuarioTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("abc"));
		assertEquals("newName", model.getName());
	}
	
	@Test // nome de usuario nao deve ser setado se for maior que vinte caracteres
	public void notSetNameBigModelUsuarioTest() {
		model.setName("newName");
		assertThrows(IllegalArgumentException.class, () -> model.setName("abcdeabcdeabcdeabcdeX"));
		assertEquals("newName", model.getName());
	}
	
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de username
	 */ 
	
	@Test
	public void setUsernameModelUsuarioTest() {
		model.setUsername("Username");
		assertEquals("Username", model.getUsername());
	}
	
	@Test
	public void notSetUsernameNullModelUsuarioTest() {
		model.setUsername("Username");
		assertThrows(NullPointerException.class, () -> model.setUsername(null));
		assertEquals("Username", model.getUsername());
	}
	
	@Test
	public void notSetUsernameEmptyModelUsuarioTest() {
		model.setUsername("Username");
		assertThrows(IllegalArgumentException.class, () -> model.setUsername(""));
		assertEquals("Username", model.getUsername());
	}
	
	@Test
	public void notSetUsernameEmptyWithSpacesModelUsuarioTest() {
		model.setUsername("Username");
		assertThrows(IllegalArgumentException.class, () -> model.setUsername("               "));
		assertEquals("Username", model.getUsername());
	}
	
	@Test // nome de usuario nao deve ser setado se for menor que cinco caracteres
	public void notSetUsernameSmallModelUsuarioTest() {
		model.setUsername("Username");
		assertThrows(IllegalArgumentException.class, () -> model.setUsername("abc"));
		assertEquals("Username", model.getUsername());
	}
	
	@Test // nome de usuario nao deve ser setado se for maior que vinte caracteres
	public void notSetUsernameBigModelUsuarioTest() {
		model.setUsername("Username");
		assertThrows(IllegalArgumentException.class, () -> model.setUsername("abcdeabcdeabcdeabcdeX"));
		assertEquals("Username", model.getUsername());
	}
	

	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de password
	 */ 
	
	@Test
	public void setPasswordModelUsuarioTest() {
		model.setPassword("Password");
		assertEquals("Password", model.getPassword());
	}

	@Test
	public void setPasswordWithNumberModelUsuarioTest() {
		model.setPassword("Password12345");
		assertEquals("Password12345", model.getPassword());
	}
	
	@Test
	public void notSetPasswordNullModelUsuarioTest() {
		model.setPassword("Password");
		assertThrows(NullPointerException.class, () -> model.setPassword(null));
		assertEquals("Password", model.getPassword());
	}
	
	@Test
	public void notSetPasswordEmptyModelUsuarioTest() {
		model.setPassword("Password");
		assertThrows(IllegalArgumentException.class, () -> model.setPassword(""));
		assertEquals("Password", model.getPassword());
	}
	
	@Test
	public void notSetPasswordEmptyWithSpacesModelUsuarioTest() {
		model.setPassword("Password");
		assertThrows(IllegalArgumentException.class, () -> model.setPassword("               "));
		assertEquals("Password", model.getPassword());
	}
	
	@Test // nome de usuario nao deve ser setado se for menor que cinco caracteres
	public void notSetPasswordSmallModelUsuarioTest() {
		model.setPassword("Password");
		assertThrows(IllegalArgumentException.class, () -> model.setPassword("abc"));
		assertEquals("Password", model.getPassword());
	}
	
	@Test // nome de usuario nao deve ser setado se for maior que vinte caracteres
	public void notSetPasswordBigModelUsuarioTest() {
		model.setPassword("Password");
		assertThrows(IllegalArgumentException.class, () -> model.setPassword("abcdeabcdeabcdeabcdeX"));
		assertEquals("Password", model.getPassword());
	}
	
	/* *
	 * == DESCRICAO ==
	 * Testes de manipulacao de agendaID
	 */ 
		
	@Test
	public void setAgendaIDModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		model.setIdAgenda(id);
		assertEquals( id, model.getIdAgenda());
	}
	
	@Test
	public void notSetAgendaIDNullNotModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		model.setIdAgenda(id);
		assertThrows(NullPointerException.class, () -> model.setIdAgenda(null));
		assertEquals( id, model.getIdAgenda());
	}
	
}
