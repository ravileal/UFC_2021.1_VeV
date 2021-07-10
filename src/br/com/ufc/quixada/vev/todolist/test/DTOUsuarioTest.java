package br.com.ufc.quixada.vev.todolist.test;

import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.ufc.quixada.vev.todolist.usuario.DTOUsuario;

@TestMethodOrder(OrderAnnotation.class)
public class DTOUsuarioTest {

	private DTOUsuario usuario;

	@Before
	public void setUp() {
		usuario = new DTOUsuario();
	}
	
	@After
	public void tearDown() {
		usuario = null;
	}
	
	@Test
	public void testUsuarioSetID() {
		UUID id = UUID.randomUUID();
		usuario.setId(id);
		Assert.assertEquals(usuario.getId(), id);
	}

	@Test
	public void testUsuarioSetName() {
		usuario.setName("Nome");
		Assert.assertEquals(usuario.getName(), "Nome");
	}

	@Test
	public void testUsuarioSetUsername() {
		usuario.setUsername("Username");
		Assert.assertEquals(usuario.getUsername(), "Username");
	}
		
	@Test
	public void testUsuarioSetAgendaID() {
		UUID id = UUID.randomUUID();
		usuario.setIdAgenda(id);
		Assert.assertEquals(usuario.getIdAgenda(), id);
	}
	
}
