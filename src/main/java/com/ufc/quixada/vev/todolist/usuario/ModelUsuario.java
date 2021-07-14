package com.ufc.quixada.vev.todolist.usuario;

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
		if(id == null) throw new NullPointerException("o id do usuario esta nulo");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null) name = name.trim();
		isValide(name, "nome");
		this.name = name;
	}
 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username != null) username = username.trim();
		isValide(username, "usuario");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password != null) password = password.trim();
		isValide(password, "senha");
		this.password = password;
	}

	public UUID getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(UUID idAgenda) {
		if(idAgenda == null) throw new NullPointerException("o id da agenda do usuario esta nulo");
		this.idAgenda = idAgenda;
	}
	
	private boolean isValide(String label, String message) {
		if(label == null) throw new NullPointerException("o campo "+message+" esta nulo");
		if(label.equals("")) throw new IllegalArgumentException("o campo "+message+" esta vazio");
		if(label.length() < 5) throw new IllegalArgumentException("o campo "+message+" deve ter mais de 4 digitos");
		if(label.length() > 20) throw new IllegalArgumentException("o campo "+message+" deve ter menos de 21 digitos");
		return true;
	}

}