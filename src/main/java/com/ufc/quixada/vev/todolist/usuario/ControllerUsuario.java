package com.ufc.quixada.vev.todolist.usuario;

public class ControllerUsuario {

	private IRepositoryUsuario rep;
	
	public ControllerUsuario(String environment){
		rep = RepositoryFactoryUsuario.FactoryRepository(environment);
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