package br.com.ufc.quixada.vev.todolist.app;

import java.util.Scanner;

import br.com.ufc.quixada.vev.todolist.usuario.ControllerUsuario;
import br.com.ufc.quixada.vev.todolist.usuario.DTOUsuario;

public class Login {
	private String username = "";
	private String password = "";

	public DTOUsuario signIn() {
		do{
			receiveDataMenu();
			try{
				return new ControllerUsuario().signIn(username, password);
			}catch(Exception error){
				System.out.println("\nErro: " + error.getMessage() + "\n");
			}
		}while(true);
	}

	private void receiveDataMenu() {
		showHeader();

		System.out.println("Digite seu nome de usuario\n");
		username = receiveData();

		System.out.println("Digite sua senha\n");
		password = receiveData();
	}

	private void showHeader() {
		System.out.println(
			"=== You TodoList ===\n"+ 
			"------ Login -------\n"
		);
	}

	private String receiveData(){
		return new Scanner(System.in).nextLine().trim();
	}

}