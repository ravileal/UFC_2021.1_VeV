package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.NoResultException;


public class ControllerTask {

	private IRepositoryTask rep;
	
	public ControllerTask(String environment){
		rep = RepositoryFactoryTask.FactoryRepository(environment);
	}
	
	public ControllerTask(IRepositoryTask rep){
		this.rep = rep;
	}
	
	public ArrayList<DTOTask> findByPage(UUID id) {
		ArrayList<DTOTask> list = new ArrayList<>();
		
		for(DTOTask dto: rep.findByPage(id)) 
			list.add(dto);
			
		return list;
	} 
	
	public DTOTask findByName(String name) {
		DTOTask dto = rep.findByName(name);
		
		if(dto == null) 
			throw new NullPointerException("task nao encontrada");
		
		return dto;
	}

	public DTOTask create(DTOTask dto) {
		try {			
			rep.findByName(dto.getName());
		} catch (IllegalArgumentException e) {
			return rep.create(dto)? dto: null;
		} catch (NoResultException e) {
			return rep.create(dto)? dto: null;
		}
		throw new IllegalArgumentException("Tentando criar task com nome ja existente");
	}

}