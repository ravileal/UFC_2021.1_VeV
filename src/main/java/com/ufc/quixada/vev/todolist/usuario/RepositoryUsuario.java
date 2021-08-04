package com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class RepositoryUsuario implements IRepositoryUsuario {
	
	
	@Override
	public DTOUsuario findByUsername(String username) {
		if(username == null) 
			throw new NullPointerException("username vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ModelUsuario> crit = criteriaBuilder.createQuery(ModelUsuario.class);
        Root<ModelUsuario> root = crit.from(ModelUsuario.class);
        crit.where(criteriaBuilder.equal(root.get("username"), username))
            .distinct(true);
        ModelUsuario model = entityManager.createQuery(crit).getSingleResult();
        
		if(model == null) throw new IllegalArgumentException("usuario nao encontrado");
		
		return new DTOUsuario(model);
	}
	
	private DTOUsuario findById(UUID id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		ModelUsuario model = entityManager.find(ModelUsuario.class, id);

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return new DTOUsuario(model);
	}
 
	@Override
	public boolean create(DTOUsuario usuario) {
		if(usuario == null) 
			throw new NullPointerException("usuario vazio");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		entityManager.persist(usuario.toModel());

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

	@Override
	public boolean update(DTOUsuario usuario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		if(usuario == null) 
			throw new NullPointerException("usuario vazia");
		
		if(this.findById(usuario.getId()) == null) 
			throw new IllegalArgumentException("usuario nao encontrado");
		
		entityManager.merge(usuario.toModel());			
		
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
		
		DTOUsuario usuario = this.findById(id);
		if(usuario == null) throw new IllegalArgumentException("usuario nao encontrado");
		
		ModelUsuario model = usuario.toModel();
		entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));			
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}
	
}
