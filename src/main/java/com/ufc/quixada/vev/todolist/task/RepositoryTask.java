package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RepositoryTask implements IRepositoryTask {


	private DTOTask findById(UUID id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		ModelTask model = entityManager.find(ModelTask.class, id);

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return new DTOTask(model);
	}
	
	@Override
	public ArrayList<DTOTask> findByPage(UUID id){
		if(id == null) 
			throw new NullPointerException("id vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ModelTask> crit = criteriaBuilder.createQuery(ModelTask.class);
        Root<ModelTask> root = crit.from(ModelTask.class);
        crit.where(criteriaBuilder.equal(root.get("idPage"), id))
            .distinct(true);
        List<ModelTask> modelList = entityManager.createQuery(crit).getResultList();
        
		if(modelList == null) throw new IllegalArgumentException("nenhuma task encontrada");
		
		ArrayList<DTOTask> dtoList = new ArrayList<>();
		
		for(ModelTask model: modelList)
			dtoList.add(new DTOTask(model));
		
		return dtoList;
	}
	
	@Override
	public DTOTask findByName(String name){
		if(name == null) 
			throw new NullPointerException("username vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ModelTask> crit = criteriaBuilder.createQuery(ModelTask.class);
        Root<ModelTask> root = crit.from(ModelTask.class);
        crit.where(criteriaBuilder.equal(root.get("name"), name))
            .distinct(true);
        ModelTask model = entityManager.createQuery(crit).getSingleResult();
        
		if(model == null) throw new IllegalArgumentException("task nao encontrada");
		
		return new DTOTask(model);
	}
 
	@Override
	public boolean create(DTOTask task) {
		if(task == null) 
			throw new NullPointerException("task vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(task.toModel());

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

	@Override
	public boolean update(DTOTask task) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		if(task == null) 
			throw new NullPointerException("task vazia");
		
		if(this.findById(task.getId()) == null) 
			throw new IllegalArgumentException("task nao encontrada");
		
		entityManager.merge(task.toModel());			
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

	@Override
	public boolean delete(UUID id) {
		if(id == null) 
			throw new NullPointerException("id vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		DTOTask task = this.findById(id);
		if(task == null) throw new IllegalArgumentException("task nao encontrada");
		
		ModelTask model = task.toModel();
		entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));			
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

	
}
