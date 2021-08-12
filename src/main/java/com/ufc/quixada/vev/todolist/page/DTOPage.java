package com.ufc.quixada.vev.todolist.page;

import java.util.UUID;

public class DTOPage {

	private UUID id;
	private String name;
	private UUID idAgenda;
	
	public DTOPage() {}
	
	public DTOPage(ModelPage model) {
		this.id = model.getId();
		this.name = model.getName();
		this.idAgenda = model.getIdAgenda();
	}
	
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

	public UUID getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(UUID idAgenda) {
		this.idAgenda = idAgenda;
	}

	ModelPage toModel() {
		ModelPage page = new ModelPage();
		page.setId(id);
		page.setName(name);
		page.setIdAgenda(idAgenda);
		return page;
	}

	void readModel(ModelPage model) {
		this.id = model.getId();
		this.name = model.getName();
		this.idAgenda = model.getIdAgenda();
	}
	
	public boolean equals(DTOPage dto) {
		return 	this.id.equals(dto.getId()) && 
				this.name.equals(dto.getName()) && 
				this.idAgenda.equals(dto.getIdAgenda()) ;
	}

}