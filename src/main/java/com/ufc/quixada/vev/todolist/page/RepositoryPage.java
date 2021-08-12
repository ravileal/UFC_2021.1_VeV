package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class RepositoryPage implements IRepositoryPage{
	
	private ArrayList<DTOPage> list;
	
	public RepositoryPage() {
		list = new ArrayList<DTOPage>();
	}

	private DTOPage findById(UUID id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		ModelPage model = entityManager.find(ModelPage.class, id);

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return new DTOPage(model);
	}
	
	public ArrayList<DTOPage> findByAgenda(UUID id){
		if(id == null) 
			throw new NullPointerException("username vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ModelPage> crit = criteriaBuilder.createQuery(ModelPage.class);
        Root<ModelPage> root = crit.from(ModelPage.class);
        crit.where(criteriaBuilder.equal(root.get("idAgenda"), id))
            .distinct(true);
        ModelPage model = entityManager.createQuery(crit).getSingleResult();
        
		if(model == null) throw new IllegalArgumentException("nenhuma page encontrada");
		
		return new DTOPage(model);
	}
	
	public DTOPage findByName(String name){
		if(name == null) 
			throw new NullPointerException("username vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ModelPage> crit = criteriaBuilder.createQuery(ModelPage.class);
        Root<ModelPage> root = crit.from(ModelPage.class);
        crit.where(criteriaBuilder.equal(root.get("name"), name))
            .distinct(true);
        ModelPage model = entityManager.createQuery(crit).getSingleResult();
        
		if(model == null) throw new IllegalArgumentException("page nao encontrada");
		
		return new DTOPage(model);
	}
 
	@Override
	public boolean create(DTOPage page) {
		if(page == null) 
			throw new NullPointerException("page vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(page.toModel());

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

	@Override
	public boolean update(DTOPage page) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		if(page == null) 
			throw new NullPointerException("page vazia");
		
		if(this.findById(page.getId()) == null) 
			throw new IllegalArgumentException("page nao encontrada");
		
		entityManager.merge(page.toModel());			
		
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
		
		DTOPage page = this.findById(id);
		if(page == null) throw new IllegalArgumentException("page nao encontrada");
		
		ModelPage model = page.toModel();
		entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));			
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

}
