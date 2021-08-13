package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.NoResultException;

import com.ufc.quixada.vev.todolist.task.IRepositoryTask;


public class ControllerPage {

	private IRepositoryPage rep;
	
	public ControllerPage(String environment){
		rep = RepositoryFactoryPage.FactoryRepository(environment);
	}
	
	public ControllerPage(IRepositoryPage rep){
		this.rep = rep;
	}
	
	public ArrayList<DTOPage> findByAgenda(UUID id) {
		ArrayList<DTOPage> list = new ArrayList<>();
		
		for(DTOPage dto: rep.findByAgenda(id)) 
			list.add(dto);
		
		return list;
	}
	
	public DTOPage findByName(String name) {
		DTOPage dto = rep.findByName(name);
		
		if(dto == null) 
			throw new NullPointerException("pagina nao encontrado");
		
		return dto;
	}

	public DTOPage create(DTOPage dto) {
		try {			
			rep.findByName(dto.getName());
		} catch (IllegalArgumentException e) {
			return rep.create(dto)? dto: null;
		} catch (NoResultException e) {
			return rep.create(dto)? dto: null;
		}
		throw new IllegalArgumentException("Tentando criar pagina com nome ja existente");
	}

}