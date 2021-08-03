package com.ufc.quixada.vev.todolist.usuario;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryUsuario {
	
	private static IRepositoryUsuario repositoryMemoryUsuario;
	
	private RepositoryFactoryUsuario() {}
	
	public static IRepositoryUsuario FactoryRepository(String environment){
		switch(environment) {
			case "DEVELOPMENT":
				repositoryMemoryUsuario = repositoryMemoryUsuario == null ? new RepositoryMemoryUsuario() : repositoryMemoryUsuario;
				return repositoryMemoryUsuario;
			case "PRODUCTION":
				throw new UndeclaredThrowableException(null, "Ambiente de producao ainda nao configurado");
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
