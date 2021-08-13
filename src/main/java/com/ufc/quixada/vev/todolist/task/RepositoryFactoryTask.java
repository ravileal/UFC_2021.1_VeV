package com.ufc.quixada.vev.todolist.task;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryTask {
	
	private static IRepositoryTask repository;
	
	private RepositoryFactoryTask() {}
	
	public static IRepositoryTask FactoryRepository(String environment){
		switch(environment) {
			case "TEST":
				repository = repository == null ? new RepositoryMemoryTask() : repository;
				return repository;
			case "DEVELOPMENT":
				repository = repository == null ? new RepositoryTask() : repository;
				return repository;
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
