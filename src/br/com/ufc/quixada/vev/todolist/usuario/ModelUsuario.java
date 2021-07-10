package br.com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

public class ModelUsuario {

	private UUID id;
	private String name;
	private String username;
	private String password;
	private UUID idAgenda;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		if(id == null) return;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(isValide(name) || !name.matches("^[a-zA-Z]*$")) return;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (isValide(username) || !username.matches("^[a-zA-Z]*$")) return;
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (isValide(password) || !password.matches("^[a-zA-Z0-9]*$")) return;
		this.password = password;
	}

	public UUID getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(UUID idAgenda) {
		if(idAgenda == null) return;
		this.idAgenda = idAgenda;
	}
	
	private boolean isValide(String label) {
		return (label == null || label.equals("") || label.length() < 5 || label.length() > 20);
	}


}