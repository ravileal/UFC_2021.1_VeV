package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.UUID;


public class ControllerTask {

	private IRepositoryTask rep;
	
	public ControllerTask(String environment){
		rep = RepositoryFactoryTask.FactoryRepository(environment);
	}
	
	public ArrayList<DTOTask> findByPage(UUID id) {
		ArrayList<DTOTask> list = new ArrayList<>();
		
		for(ModelTask model: rep.findByPage(id)) {
			DTOTask dto = new DTOTask();
			dto.readModel(model);
			list.add(dto);
		}
			
		return list;
	} 
	
	public DTOTask findByName(String name) {
		ModelTask model = rep.findByName(name);
		
		if(model == null) 
			throw new NullPointerException("task nao encontrada");
		
		DTOTask task = new DTOTask();
		task.readModel(model);
		return task;
	}

	public DTOTask create(DTOTask dto) {
		ModelTask model = dto.toModel();
		try {			
			rep.findByName(dto.getName());
		}catch (IllegalArgumentException e) {
			return rep.create(model)? dto: null;
		}
		throw new IllegalArgumentException("Tentando criar task com nome ja existente");
	}

}