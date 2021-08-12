package com.ufc.quixada.vev.todolist.page;

import java.util.ArrayList;
import java.util.UUID;

public interface IRepositoryPage {

	ArrayList<DTOPage> findByAgenda(UUID id);
	
	DTOPage findByName(String name);

	boolean create(DTOPage page);

	boolean update(DTOPage page);

	boolean delete(UUID id);

}