package com.ufc.quixada.vev.todolist.usuario;

import java.util.ArrayList;
import java.util.UUID;

public class RepositoryMemoryUsuario implements IRepositoryUsuario{
	
	private ArrayList<ModelUsuario> list;
	
	public RepositoryMemoryUsuario() {
		list = new ArrayList<ModelUsuario>();
	}
	
	@Override
	public DTOUsuario findByUsername(String username) {
		if(username == null) 
			throw new NullPointerException("username vazio");
		for(ModelUsuario model: list) 
			if(model.getUsername().equals(username)) 
				return new DTOUsuario(model);
		throw new IllegalArgumentException("usuario nao encontrado");
	}
 
	@Override
	public boolean create(DTOUsuario usuario) {
		if(usuario == null) 
			throw new NullPointerException("usuario vazio");
		if(!list.add(usuario.toModel()))
			throw new IllegalArgumentException("usuario invalido");
		return true;
	}

	@Override
	public boolean update(DTOUsuario usuario) {
		if(usuario == null) 
			throw new NullPointerException("usuario vazia");
		for(ModelUsuario model: list) 
			if(model.getId().equals(usuario.getId())) {
				model = usuario.toModel();
				return true;				
			}
		throw new IllegalArgumentException("usuario nao encontrado");
	}

	@Override
	public boolean delete(UUID id) {
		if(id == null) 
			throw new NullPointerException("id vazio");
		for(ModelUsuario model: list) 
			if(model.getId().equals(id)) {
				list.remove(model);
				return true;				
			}
		throw new IllegalArgumentException("usuario nao encontrado");
	}
	
}
