package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ufc.quixada.vev.todolist.page.DTOPage;
import com.ufc.quixada.vev.todolist.page.RepositoryPage;
import com.ufc.quixada.vev.todolist.task.DTOTask;
import com.ufc.quixada.vev.todolist.task.RepositoryTask;

public class App {
	public static void main(String[] args) {

//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
		
		RepositoryPage rep = new RepositoryPage();
		
		UUID idAgenda = UUID.fromString("6bb754f4-784b-4929-a4cd-2f3f5313c090");
		
		ArrayList<DTOPage> list = rep.findByAgenda(idAgenda);
		
		for (DTOPage dto : list) 
			System.out.println(dto.getName());
		
//		DTOPage dto = rep.findByName("page 4");
//		
//		rep.delete(dto.getId());
		
//		DTOPage page = new DTOPage();
		
//		page.setId(UUID.fromString("172cb1b9-8f8d-4d18-9717-75aac727c7e2"));
//		page.setName("page 1");
//		page.setIdAgenda(idAgenda);
		
//		rep.create(page);
		
//		rep.update(dto);
		
//		rep.delete(dto.getId());

//		DTOPage page2 = new DTOPage();
//		page2.setId(UUID.fromString("718500ab-9181-47f2-a5d9-576cb0019e78"));
//		page2.setName("page 2");
//		page2.setIdAgenda(idAgenda);
//
//		DTOPage page3 = new DTOPage();
//		page3.setId(UUID.fromString("46838d7e-8477-4494-a376-6a3bea63b69c"));
//		page3.setName("page 3");
//		page3.setIdAgenda(idAgenda);
//		
//		rep.create(page);
//		rep.create(page2);
//		rep.create(page3);

//		entityManager.persist(dto);
//		entityManager.persist(page2);
//		entityManager.persist(page3);
//
//		entityManager.getTransaction().commit();
//		entityManager.close();
	}
}