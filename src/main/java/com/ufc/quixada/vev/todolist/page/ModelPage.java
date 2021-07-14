package com.ufc.quixada.vev.todolist.page;

import java.util.UUID;

public class ModelPage {

	private UUID id;
	private String name;
	private UUID idAgenda;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		if(id == null) throw new NullPointerException("o id da pagina esta nulo");
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
	
	public UUID getIdAgenda() {
		return idAgenda;
	}
	
	public void setIdAgenda(UUID idAgenda) {
		if(idAgenda == null) throw new NullPointerException("o id da agenda da pagina esta nulo");
		this.idAgenda = idAgenda;
	}
	
	private boolean isValide(String label, String message) {
		if(label == null) throw new NullPointerException("o campo "+message+" esta nulo");
		if(label.equals("")) throw new IllegalArgumentException("o campo "+message+" esta vazio");
		if(label.length() < 1) throw new IllegalArgumentException("o campo "+message+" deve ter mais de 0 digitos");
		if(label.length() > 20) throw new IllegalArgumentException("o campo "+message+" deve ter menos de 21 digitos");
		return true;
	}
	
}