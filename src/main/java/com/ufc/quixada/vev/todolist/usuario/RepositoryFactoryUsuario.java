package com.ufc.quixada.vev.todolist.usuario;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryUsuario {
	
	private static IRepositoryUsuario usuarioRepository;
	
	private RepositoryFactoryUsuario() {}
	
	public static IRepositoryUsuario getRepository(String environment){
		switch(environment) {
			case "TEST":
				usuarioRepository = usuarioRepository == null ? new RepositoryMemoryUsuario() : usuarioRepository;
				return usuarioRepository;
			case "DEVELOPMENT":
				usuarioRepository = usuarioRepository == null ? new RepositoryUsuario() : usuarioRepository;
				return usuarioRepository;
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
