package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.UUID;

public class RepositoryMemoryTask implements IRepositoryTask {

	private ArrayList<ModelTask> list;
	
	public RepositoryMemoryTask() {
		list = new ArrayList<ModelTask>();
	}

	@Override
	public ArrayList<ModelTask> findByPage(UUID id) {
		ArrayList<ModelTask> list = new ArrayList<>();
		
		if(id == null) 
			throw new NullPointerException("id de pagina esta vazio");
		
		for(ModelTask model: this.list) 
			if(model.getIdPage().equals(id)) 
				list.add(model);
		
		if(list.isEmpty())
			throw new IllegalArgumentException("pagina sem tasks");
		
		return list;
	}
 
	@Override
	public ModelTask findByName(String name) {
		if(name == null) 
			throw new NullPointerException("nome vazio");
		for(ModelTask model: list) 
			if(model.getName().equals(name)) 
				return model;
		throw new IllegalArgumentException("task nao encontrada");
	}

	@Override
	public boolean create(ModelTask task) {
		if(task == null) 
			throw new NullPointerException("task vazia");
		if(!list.add(task))
			throw new IllegalArgumentException("task invalida");
		return true;
	}

	@Override
	public boolean update(ModelTask task) {
		if(task == null) 
			throw new NullPointerException("task vazia");
		for(ModelTask model: list) 
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
		for(ModelTask model: list) 
			if(model.getId().equals(id)) {
				list.remove(model);
				return true;				
			}
		throw new IllegalArgumentException("task nao encontrada");
	}
	
}
