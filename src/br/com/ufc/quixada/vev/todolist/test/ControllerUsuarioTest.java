package br.com.ufc.quixada.vev.todolist.test;

import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.ufc.quixada.vev.todolist.usuario.ControllerUsuario;


@TestMethodOrder(OrderAnnotation.class)
public class ControllerUsuarioTest {

	private ControllerUsuario usuario;

	@Before
	public void setUp() {
		usuario = new ControllerUsuario();
	}
	
	@After
	public void tearDown() {
		usuario = null;
	}
	
	/* *
	 * Testes de manipulacao de id
	 */ 
	
	@Test
	public void testUsuarioSetID() {
		UUID id = UUID.randomUUID();
		usuario.setId(id);
		Assert.assertEquals( id, usuario.getId());
	}
	
	@Test
	public void testUsuarioNotSetIDNull() {
		UUID id = UUID.randomUUID();
		usuario.setId(id);
		usuario.setId(null);
		Assert.assertEquals( id, usuario.getId());
	}
	
	
}
