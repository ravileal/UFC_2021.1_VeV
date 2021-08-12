package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.UUID;

public class RepositoryTask implements IRepositoryTask {

	private ArrayList<DTOTask> list;
	
	public RepositoryTask() {
		list = new ArrayList<DTOTask>();
	}

	@Override
	public ArrayList<DTOTask> findByPage(UUID id) {
		ArrayList<DTOTask> list = new ArrayList<>();
		
		if(id == null) 
			throw new NullPointerException("id de pagina esta vazio");
		
		for(DTOTask model: this.list) 
			if(model.getIdPage().equals(id)) 
				list.add(model);
		
		if(list.isEmpty())
			throw new IllegalArgumentException("pagina sem tasks");
		
		return list;
	}
 
	@Override
	public DTOTask findByName(String name) {
		if(name == null) 
			throw new NullPointerException("nome vazio");
		for(DTOTask model: list) 
			if(model.getName().equals(name)) 
				return model;
		throw new IllegalArgumentException("task nao encontrada");
	}

	@Override
	public boolean create(DTOTask task) {
		if(task == null) 
			throw new NullPointerException("task vazia");
		if(!list.add(task))
			throw new IllegalArgumentException("task invalida");
		return true;
	}

	@Override
	public boolean update(DTOTask task) {
		if(task == null) 
			throw new NullPointerException("task vazia");
		for(DTOTask model: list) 
			if(model.getId().equals(task.getId())) {
				model = task;
				return true;				
			}
		throw new IllegalArgumentException("task nao encontrada");
	}

	@Override
	public boolean delete(UUID id) {
		if(id == null) 
			throw new NullPointerException("id vazio");
		for(DTOTask model: list) 
			if(model.getId().equals(id)) {
				list.remove(model);
				return true;				
			}
		throw new IllegalArgumentException("task nao encontrada");
	}
	
}
