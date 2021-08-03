package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;


public class RepositoryMemoryPage implements IRepositoryPage{
	
	private ArrayList<ModelPage> list;
	
	public RepositoryMemoryPage() {
		list = new ArrayList<ModelPage>();
	}

	@Override
	public ArrayList<ModelPage> findByAgenda(UUID id) {
		ArrayList<ModelPage> list = new ArrayList<>();
		
		if(id == null) 
			throw new NullPointerException("id de agenda esta vazio");
		
		for(ModelPage model: this.list) 
			if(model.getIdAgenda().equals(id)) 
				list.add(model); 
		
		if(list.isEmpty())
			throw new IllegalArgumentException("agenda sem paginas");
		
		return list;
	}

	@Override
	public ModelPage findByName(String name) {
		if(name == null) 
			throw new NullPointerException("nome vazio");
		for(ModelPage model: list) 
			if(model.getName().equals(name)) 
				return model;
		throw new IllegalArgumentException("pagina nao encontrada");
	}

	@Override
	public boolean create(ModelPage page) {
		if(page == null) 
			throw new NullPointerException("pagina vazia");
		if(!list.add(page))
			throw new IllegalArgumentException("pagina invalido");
		return true;
	}

	@Override
	public boolean update(ModelPage page) {
		if(page == null) 
			throw new NullPointerException("pagina vazia");
		for(ModelPage model: list) 
			if(model.getId().equals(page.getId())) {
				model = page;
				return true;				
			}
		throw new IllegalArgumentException("pagina nao encontrada");
	}

	@Override
	public boolean delete(UUID id) {
		if(id == null) 
			throw new NullPointerException("id vazio");
		for(ModelPage model: list) 
			if(model.getId().equals(id)) {
				list.remove(model);
				return true;				
			}
		throw new IllegalArgumentException("pagina nao encontrada");
	}

}
