package com.ufc.quixada.vev.todolist.task;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryTask {
	
	private static IRepositoryTask repositoryMemoryTask;
	
	private RepositoryFactoryTask() {}
	
	public static IRepositoryTask FactoryRepository(String environment){
		switch(environment) {
			case "DEVELOPMENT":
				repositoryMemoryTask = repositoryMemoryTask == null ? new RepositoryMemoryTask() : repositoryMemoryTask;
				return repositoryMemoryTask;
			case "PRODUCTION":
				throw new UndeclaredThrowableException(null, "Ambiente de producao ainda nao configurado");
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
