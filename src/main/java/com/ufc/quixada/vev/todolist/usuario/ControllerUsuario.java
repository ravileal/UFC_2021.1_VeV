package com.ufc.quixada.vev.todolist.usuario;

import java.lang.reflect.UndeclaredThrowableException;

public class ControllerUsuario {

	private static IRepositoryUsuario rep = null;
	
	public ControllerUsuario(String environment){
		if(rep != null ) return;
		if(environment.equals("DEVELOPMENT"))
			rep = new RepositoryUsuario();
		else if (environment.equals("PRODUCTION")) 
			throw new UndeclaredThrowableException(null, "Ambiente de producao ainda nao configurado");
		else 
			throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
	}
	
	public DTOUsuario signIn(String username, String password) {
		ModelUsuario model = rep.findByUsername(username);
		
		if(password == null) 
			throw new NullPointerException("senha nula");
		if(!model.getPassword().equals(password)) 
			throw new IllegalArgumentException("senha incorreta");
		
		DTOUsuario usuario = new DTOUsuario();
		usuario.readModel(model);
		return usuario;
	} 
	
	public DTOUsuario create(DTOUsuario dto) {
		ModelUsuario model = dto.toModel();
		try {			
			rep.findByUsername(dto.getUsername());
		}catch (IllegalArgumentException e) {
			return rep.create(model)? dto: null;
		}
		throw new IllegalArgumentException("Tentando criar usuario com username ja existente");
	}

}