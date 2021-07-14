package com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

public class DTOUsuario {

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

	public UUID getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(UUID idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ModelUsuario toModel() {
		ModelUsuario model = new ModelUsuario();
		model.setId(id);
		model.setName(name);
		model.setUsername(username);
		model.setPassword(password);
		model.setIdAgenda(idAgenda);
		return model;
	}

	void readModel(ModelUsuario model) {
		this.id = model.getId();
		this.name = model.getName();
		this.username = model.getUsername();
		this.password = model.getPassword();
		this.idAgenda = model.getIdAgenda();
	}
	
	public boolean equals(DTOUsuario dto) {
		return 	this.id.equals(dto.getId()) && 
				this.name.equals(dto.getName()) && 
				this.username.equals(dto.getUsername()) && 
				this.password.equals(dto.getPassword()) &&
				this.idAgenda.equals(dto.getIdAgenda()) ;
	}

}