package com.ufc.quixada.vev.todolist.task;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryTask {
	
	private static IRepositoryTask repositoryTask;
	
	private RepositoryFactoryTask() {}
	
	public static IRepositoryTask FactoryRepository(String environment){
		switch(environment) {
			case "TEST":
				repositoryTask = repositoryTask == null ? new RepositoryMemoryTask() : repositoryTask;
				return repositoryTask;
			case "PRODUCTION":
				repositoryTask = repositoryTask == null ? new RepositoryTask() : repositoryTask;
				return repositoryTask;
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
