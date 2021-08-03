package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;


public class ControllerPage {

	private IRepositoryPage rep;
	
	public ControllerPage(String environment){
		rep = RepositoryFactoryPage.FactoryRepository(environment);
	}
	
	public ArrayList<DTOPage> findByAgenda(UUID id) {
		ArrayList<DTOPage> list = new ArrayList<>();
		for(ModelPage model: rep.findByAgenda(id)) {
			DTOPage dto = new DTOPage();
			dto.readModel(model); 
			list.add(dto);
		}
		return list;
	}
	
	public DTOPage findByName(String name) {
		ModelPage model = rep.findByName(name);
		
		if(model == null) 
			throw new NullPointerException("pagina nao encontrado");
		
		DTOPage page = new DTOPage();
		page.readModel(model);
		return page;
	}

	public DTOPage create(DTOPage dto) {
		ModelPage model = dto.toModel();
		try {			
			rep.findByName(dto.getName());
		}catch (IllegalArgumentException e) {
			return rep.create(model)? dto: null;
		}
		throw new IllegalArgumentException("Tentando criar pagina com nome ja existente");
	}

}