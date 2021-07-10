package br.com.ufc.quixada.vev.todolist.app;

import br.com.ufc.quixada.vev.todolist.usuario.ControllerUsuario;
import br.com.ufc.quixada.vev.todolist.usuario.DTOUsuario;

public class Login {

	public DTOUsuario signIn() {
		String username = "";
		String password = "";
		new ControllerUsuario().signIn(username, password);
		throw new UnsupportedOperationException();
	}

}