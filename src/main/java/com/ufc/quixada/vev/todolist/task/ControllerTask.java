package com.ufc.quixada.vev.todolist.task;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.UUID;

public class ControllerTask {

	private static IRepositoryTask rep = new RepositoryTask();
	
	public ControllerTask(String environment){
		if(rep != null ) return;
		if(environment.equals("DEVELOPMENT"))
			rep = new RepositoryTask();
		else if (environment.equals("PRODUCTION"))
			throw new UndeclaredThrowableException(null, "Ambiente de producao ainda nao configurado");
		else 
			throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
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