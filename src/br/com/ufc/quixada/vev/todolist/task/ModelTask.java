package br.com.ufc.quixada.vev.todolist.task;

import java.time.LocalDate;
import java.util.UUID;

class ModelTask {

	private UUID id;
	private String name;
	private String description;
	private LocalDate dateTodo;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateTodo() {
		return dateTodo;
	}
	public void setDateTodo(LocalDate dateTodo) {
		this.dateTodo = dateTodo;
	}
	public UUID getIdPage() {
		return idPage;
	}
	public void setIdPage(UUID idPage) {
		this.idPage = idPage;
	}

	
	
}