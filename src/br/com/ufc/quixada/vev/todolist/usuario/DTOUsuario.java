package br.com.ufc.quixada.vev.todolist.usuario;

import java.util.UUID;

public class DTOUsuario {

	private UUID id;
	private String name;
	private String username;
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

	ModelUsuario toModel() {
		// TODO - implement DTOUsuario.toModel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param model
	 */
	void readModel(ModelUsuario model) {
		// TODO - implement DTOUsuario.readModel
		throw new UnsupportedOperationException();
	}

}