package com.ufc.quixada.vev.todolist.task;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ufc.quixada.vev.todolist.task.DTOTask;
import com.ufc.quixada.vev.todolist.task.RepositoryTask;

public class App {
	public static void main(String[] args) {

//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
		
		RepositoryTask rep = new RepositoryTask();
		
//		DTOTask dto = rep.findByUsername("usuário 12345");
//		
//		rep.delete(dto.getId());
		
		DTOTask dto = new DTOTask();
		
		dto.setId(UUID.randomUUID());
		dto.setName("task 1");
		dto.setIdPage(UUID.randomUUID());
		
		rep.create(dto);
		
//		rep.update(dto);

//		DTOTask task2 = new DTOTask();
//		task2.setName("task 2");
//		task2.setIdPage(UUID.randomUUID());
//
//		DTOTask task3 = new DTOTask();
//		task3.setName("task 3");
//		task3.setIdPage(UUID.randomUUID());
//		
//		rep.create(task);
//		rep.create(task2);
//		rep.create(task3);

//		entityManager.persist(dto);
//		entityManager.persist(task2);
//		entityManager.persist(task3);
//
//		entityManager.getTransaction().commit();
//		entityManager.close();
	}
}