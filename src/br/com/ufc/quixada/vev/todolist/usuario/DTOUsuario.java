package br.com.ufc.quixada.vev.todolist.Usuario;

import java.util.UUID;

public class DTOUsuario {

	private UUID id;
	private String name;
	
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

	br.com.ufc.quixada.vev.todolist.Usuario.ModelUsuario toModel() {
		// TODO - implement DTOUsuario.toModel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param model
	 */
	void readModel(br.com.ufc.quixada.vev.todolist.Usuario.ModelUsuario model) {
		// TODO - implement DTOUsuario.readModel
		throw new UnsupportedOperationException();
	}

}