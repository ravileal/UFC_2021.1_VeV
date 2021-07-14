package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;

public interface IRepositoryPage {

	ArrayList<ModelPage> findByAgenda(UUID id);
	
	ModelPage findByName(String name);

	boolean create(ModelPage page);

	boolean update(ModelPage page);

	boolean delete(UUID id);

}