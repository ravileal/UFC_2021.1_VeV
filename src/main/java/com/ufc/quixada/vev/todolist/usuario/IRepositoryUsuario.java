package com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

public interface IRepositoryUsuario {

	DTOUsuario findByUsername(String username);

	boolean create(DTOUsuario usuario);

	boolean update(DTOUsuario usuario);
	
	boolean delete(UUID id);
	
}