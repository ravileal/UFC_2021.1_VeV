package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.NoResultException;


public class RepositoryMemoryPage implements IRepositoryPage{
	
	private ArrayList<DTOPage> list;
	
	public RepositoryMemoryPage() {
		list = new ArrayList<DTOPage>();
	}

	@Override
	public ArrayList<DTOPage> findByAgenda(UUID id) {
		ArrayList<DTOPage> list = new ArrayList<>();
		
		if(id == null) 
			throw new NullPointerException("id de agenda esta vazio");
		
		for(DTOPage dto: this.list) 
			if(dto.getIdAgenda().equals(id)) 
				list.add(dto); 
		
		if(list.isEmpty())
			throw new IllegalArgumentException("agenda sem paginas");
		
		return list;
	}

	@Override
	public DTOPage findByName(String name) {
		if(name == null) 
			throw new NullPointerException("nome vazio");
		for(DTOPage dto: list) 
			if(dto.getName().equals(name)) 
				return dto;
		throw new NoResultException("pagina nao encontrada");
	}

	@Override
	public boolean create(DTOPage page) {
		if(page == null) 
			throw new NullPointerException("pagina vazia");
		if(!list.add(page))
			throw new IllegalArgumentException("pagina invalido");
		return true;
	}

	@Override
	public boolean update(DTOPage page) {
		if(page == null) 
			throw new NullPointerException("pagina vazia");
		for(DTOPage dto: list) 
			if(dto.getId().equals(page.getId())) {
				dto = page;
				return true;				
			}
		throw new IllegalArgumentException("pagina nao encontrada");
	}

	@Override
	public boolean delete(UUID id) {
		if(id == null) 
			throw new NullPointerException("id vazio");
		for(DTOPage dto: list) 
			if(dto.getId().equals(id)) {
				list.remove(dto);
				return true;				
			}
		throw new IllegalArgumentException("pagina nao encontrada");
	}

}
