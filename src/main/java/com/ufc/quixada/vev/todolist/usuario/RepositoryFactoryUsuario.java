package com.ufc.quixada.vev.todolist.usuario;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryUsuario {
	
	private static IRepositoryUsuario repository;
	
	private RepositoryFactoryUsuario() {}
	
	public static IRepositoryUsuario getRepository(String environment){
		switch(environment) {
			case "TEST":
				repository = repository == null ? new RepositoryMemoryUsuario() : repository;
				return repository;
			case "DEVELOPMENT":
				repository = repository == null ? new RepositoryUsuario() : repository;
				return repository;
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
