package com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

public interface IRepositoryUsuario {

	ModelUsuario findByUsername(String username);

	boolean create(ModelUsuario usuario);

	boolean update(ModelUsuario usuario);
	
	boolean delete(UUID id);
	
}