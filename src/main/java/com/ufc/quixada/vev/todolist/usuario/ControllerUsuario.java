package com.ufc.quixada.vev.todolist.usuario;

public class ControllerUsuario {
	
	IRepositoryUsuario rep;
	
	public ControllerUsuario(String environment){
		rep = RepositoryFactoryUsuario.getRepository(environment);
	}
	
	public DTOUsuario signIn(String username, String password) {
		DTOUsuario dto = rep.findByUsername(username);
		
		if(password == null) 
			throw new NullPointerException("senha nula");
		if(!dto.getPassword().equals(password)) 
			throw new IllegalArgumentException("senha incorreta");
		
		return dto;
	} 
	
	public DTOUsuario create(DTOUsuario dto) {
		try {			
			rep.findByUsername(dto.getUsername());
		}catch (IllegalArgumentException e) {
			return rep.create(dto)? dto: null;
		}
		throw new IllegalArgumentException("Tentando criar usuario com username ja existente");
	}

}