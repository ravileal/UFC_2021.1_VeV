package br.com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

class ModelUsuario {

	private UUID id;
	private String name;
	private String username;
	private String password;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UUID getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(UUID idAgenda) {
		this.idAgenda = idAgenda;
	}	

}