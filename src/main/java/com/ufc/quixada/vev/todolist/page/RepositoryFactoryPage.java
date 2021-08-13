package com.ufc.quixada.vev.todolist.page;

import java.lang.reflect.UndeclaredThrowableException;

import com.ufc.quixada.vev.todolist.task.RepositoryTask;

public class RepositoryFactoryPage {
	
	private static IRepositoryPage repository;
	
	private RepositoryFactoryPage() {}
	
	public static IRepositoryPage FactoryRepository(String environment){
		switch(environment) {
			case "TEST":
				repository = repository == null ? new RepositoryMemoryPage() : repository;
				return repository;
			case "DEVELOPMENT":
				repository = repository == null ? new RepositoryPage() : repository;
				return repository;
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
