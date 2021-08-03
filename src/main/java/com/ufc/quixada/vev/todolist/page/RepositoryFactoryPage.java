package com.ufc.quixada.vev.todolist.page;

import java.lang.reflect.UndeclaredThrowableException;

public class RepositoryFactoryPage {
	
	private static IRepositoryPage repositoryMemoryPage;
	
	private RepositoryFactoryPage() {}
	
	public static IRepositoryPage FactoryRepository(String environment){
		switch(environment) {
			case "DEVELOPMENT":
				repositoryMemoryPage = repositoryMemoryPage == null ? new RepositoryMemoryPage() : repositoryMemoryPage;
				return repositoryMemoryPage;
			case "PRODUCTION":
				throw new UndeclaredThrowableException(null, "Ambiente de producao ainda nao configurado");
			default:
				throw new UndeclaredThrowableException(null, "Nenhum ambinte de execucao especificado");
		}
			
	}

}
