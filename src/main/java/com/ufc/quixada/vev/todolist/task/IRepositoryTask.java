package com.ufc.quixada.vev.todolist.task;

import java.util.ArrayList;
import java.util.UUID;

public interface IRepositoryTask {

	ArrayList<ModelTask> findByPage(UUID id);
	
	ModelTask findByName(String name);

	boolean create(ModelTask task);

	boolean update(ModelTask task);

	boolean delete(UUID id);

}