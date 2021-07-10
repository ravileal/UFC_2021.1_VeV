package br.com.ufc.quixada.vev.todolist.test;

import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.ufc.quixada.vev.todolist.usuario.ModelUsuario;


@TestMethodOrder(OrderAnnotation.class)
public class ModelUsuarioTest {

	private ModelUsuario usuario;

	@Before
	public void setUp() {
		usuario = new ModelUsuario();
	}
	
	@After
	public void tearDown() {
		usuario = null;
	}
	
	/* *
	 * Testes de manipulacao de id
	 */ 
	
	@Test
	public void setIDModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		usuario.setId(id);
		Assert.assertEquals( id, usuario.getId());
	}
	
	@Test
	public void notSetIDNullModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		usuario.setId(id);
		usuario.setId(null);
		Assert.assertEquals( id, usuario.getId());
	}
	

	/* *
	 * Testes de manipulacao de nome 
	 */ 
	
	@Test
	public void setNameModelUsuarioTest() {
		usuario.setName("newName");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test
	public void notSetNameNullModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName(null);
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test
	public void notSetNameEmptyModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName("");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test
	public void notSetNameEmptyWithSpacesModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName("               ");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test // nome de usuario nao deve ser setado se for menor que cinco caracteres
	public void notSetNameSmallModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName("abc");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test // nome de usuario nao deve ser setado se for maior que vinte caracteres
	public void notSetNameBigModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName("abcdeabcdeabcdeabcdeX");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test
	public void notSetNameSpecialCharacterModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName("newName@$%");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	@Test
	public void notSetNameNumberModelUsuarioTest() {
		usuario.setName("newName");
		usuario.setName("name654654654");
		Assert.assertEquals("newName", usuario.getName());
	}
	
	/* *
	 * Testes de manipulacao de username
	 */ 
	
	@Test
	public void setUsernameModelUsuarioTest() {
		usuario.setUsername("Username");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test
	public void notSetUsernameNullModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername(null);
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test
	public void notSetUsernameEmptyModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername("");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test
	public void notSetUsernameEmptyWithSpacesModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername("               ");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test // nome de usuario nao deve ser setado se for menor que cinco caracteres
	public void notSetUsernameSmallModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername("abc");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test // nome de usuario nao deve ser setado se for maior que vinte caracteres
	public void notSetUsernameBigModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername("abcdeabcdeabcdeabcdeX");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test
	public void notSetUsernameSpecialCharacterModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername("newUser@$%");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	
	@Test
	public void notSetUsernameNumberModelUsuarioTest() {
		usuario.setUsername("Username");
		usuario.setUsername("name654654654");
		Assert.assertEquals("Username", usuario.getUsername());
	}
	

	/* *
	 * Testes de manipulacao de password
	 */ 
	
	@Test
	public void setPasswordModelUsuarioTest() {
		usuario.setPassword("Password");
		Assert.assertEquals("Password", usuario.getPassword());
	}

	@Test
	public void setPasswordWithNumberModelUsuarioTest() {
		usuario.setPassword("Password12345");
		Assert.assertEquals("Password12345", usuario.getPassword());
	}
	
	@Test
	public void notSetPasswordNullModelUsuarioTest() {
		usuario.setPassword("Password");
		usuario.setPassword(null);
		Assert.assertEquals("Password", usuario.getPassword());
	}
	
	@Test
	public void notSetPasswordEmptyModelUsuarioTest() {
		usuario.setPassword("Password");
		usuario.setPassword("");
		Assert.assertEquals("Password", usuario.getPassword());
	}
	
	@Test
	public void notSetPasswordEmptyWithSpacesModelUsuarioTest() {
		usuario.setPassword("Password");
		usuario.setPassword("               ");
		Assert.assertEquals("Password", usuario.getPassword());
	}
	
	@Test // nome de usuario nao deve ser setado se for menor que cinco caracteres
	public void notSetPasswordSmallModelUsuarioTest() {
		usuario.setPassword("Password");
		usuario.setPassword("abc");
		Assert.assertEquals("Password", usuario.getPassword());
	}
	
	@Test // nome de usuario nao deve ser setado se for maior que vinte caracteres
	public void notSetPasswordBigModelUsuarioTest() {
		usuario.setPassword("Password");
		usuario.setPassword("abcdeabcdeabcdeabcdeX");
		Assert.assertEquals("Password", usuario.getPassword());
	}
	
	@Test
	public void notSetPasswordSpecialCharacterModelUsuarioTest() {
		usuario.setPassword("Password");
		usuario.setPassword("newPass@$%");
		Assert.assertEquals("Password", usuario.getPassword());
	}
	
	/* *
	 * Testes de manipulacao de agendaID
	 */ 
		
	@Test
	public void setAgendaIDModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		usuario.setIdAgenda(id);
		Assert.assertEquals( id, usuario.getIdAgenda());
	}
	
	@Test
	public void notSetAgendaIDNullModelUsuarioTest() {
		UUID id = UUID.randomUUID();
		usuario.setIdAgenda(id);
		usuario.setIdAgenda(null);
		Assert.assertEquals( id, usuario.getIdAgenda());
	}
	
}
