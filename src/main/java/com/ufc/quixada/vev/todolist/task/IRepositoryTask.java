package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.UUID;

public interface IRepositoryTask {

	ArrayList<DTOTask> findByPage(UUID id);
	
	DTOTask findByName(String name);

	boolean create(DTOTask task);

	boolean update(DTOTask task);

	boolean delete(UUID id);

}