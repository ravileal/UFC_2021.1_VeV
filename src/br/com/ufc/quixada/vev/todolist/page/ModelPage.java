package br.com.ufc.quixada.vev.todolist.Page;

import java.util.UUID;

class ModelPage {

	private UUID id;
	private String name;
	private UUID idAgenda;
	
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

	
	
}