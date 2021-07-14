package com.ufc.quixada.vev.todolist.task;

import java.util.UUID;

public class DTOTask {

	private UUID id;
	private String name;
	private UUID idPage;

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public UUID getIdPage() {
		return idPage;
	}

	public void setIdPage(UUID idPage) {
		this.idPage = idPage;
	}

	ModelTask toModel() {
		ModelTask task = new ModelTask();
		task.setId(id);
		task.setName(name);
		task.setIdPage(idPage);
		return task;
	}

	void readModel(ModelTask model) {
		this.id = model.getId();
		this.name = model.getName();
		this.idPage = model.getIdPage();
	}
	
	public boolean equals(DTOTask dto) {
		return 	this.id.equals(dto.getId()) && 
				this.name.equals(dto.getName()) && 
				this.idPage.equals(dto.getIdPage()) ;
	}

}