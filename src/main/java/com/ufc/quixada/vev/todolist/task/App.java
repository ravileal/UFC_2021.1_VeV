package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
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
		
		UUID idPage = UUID.fromString("0d8e92a8-d779-4e32-aa74-073f4aab1dd1");
		
		ArrayList<DTOTask> list = rep.findByPage(idPage);
		
		for (DTOTask dtoTask : list) 
			System.out.println(dtoTask.getName());
		
		
//		DTOTask dto = rep.findByName("task 3");
//		
//		rep.delete(dto.getId());
		
//		DTOTask task = new DTOTask();
		
		
//		task.setId(UUID.randomUUID());
//		task.setName("task 1");
//		task.setIdPage(idPage);
		
//		rep.create(task);
		
//		rep.update(dto);
		
//		rep.delete(dto.getId());

//		DTOTask task2 = new DTOTask();
//		task2.setId(UUID.randomUUID());
//		task2.setName("task 2");
//		task2.setIdPage(idPage);
//
//		DTOTask task3 = new DTOTask();
//		task3.setId(UUID.randomUUID());
//		task3.setName("task 3");
//		task3.setIdPage(idPage);
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