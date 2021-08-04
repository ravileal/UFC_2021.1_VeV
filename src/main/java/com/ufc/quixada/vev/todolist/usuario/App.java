package com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {

//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
		
		RepositoryUsuario rep = new RepositoryUsuario();
		
		DTOUsuario dto = rep.findByUsername("usuário 12345");
//		
		rep.delete(dto.getId());
		
//		DTOUsuario dto = new DTOUsuario();
//		dto.setId(UUID.randomUUID());
//		dto.setUsername("usuário 12345");
//		dto.setPassword("12345");
//		dto.setName("levi feijao a1231");
//		dto.setIdAgenda(UUID.randomUUID());
		
//		rep.create(dto);
		
//		rep.update(dto);

//		DTOUsuario usuario2 = new DTOUsuario();
//		usuario2.setUsername("usuário 2");
//		usuario2.setPassword("12345");
//
//		DTOUsuario usuario3 = new DTOUsuario();
//		usuario3.setUsername("usuário 3");
//		usuario3.setPassword("12345");
//		
//		rep.create(usuario);
//		rep.create(usuario2);
//		rep.create(usuario3);

//		entityManager.persist(dto);
//		entityManager.persist(usuario2);
//		entityManager.persist(usuario3);
//
//		entityManager.getTransaction().commit();
//		entityManager.close();
	}
}