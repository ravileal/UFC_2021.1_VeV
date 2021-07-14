package com.ufc.quixada.vev.todolist.app;

import java.util.Scanner;

import com.ufc.quixada.vev.todolist.usuario.DTOUsuario;

public class Main {
	private static String action = "";
	private static String environment = ""; 
	
	public static void main(String[] args) {
		environment = (args.length != 0)? args[0]: "DEVELOPMENT";
		System.out.println("\n\nExecutando em embiente de "+ environment + "\n\n");
		run();
	}
	
	private static void run() {
		do{
			receiveDataMenu();
			runAction();
		} while (true);
	}
	
	private static void runAction() {
		switch (action) {
			case "acessar":
				DTOUsuario dtoUsuario = new Login(environment).run();
				if(dtoUsuario != null)
					new Page(environment, dtoUsuario).run();
				break;
			case "cadastrar":
				new Register(environment).run();
				break;
			case "sair":
				System.exit(0);
				break;
			default:
		}
	}

	private static void receiveDataMenu() {
		do {
			showMenu();
			receiveData();
		} while (notIsAction());
	}
	
	private static void showMenu() {
		String menu = "=== You TodoList ===\n" + 
					 "-- Menu Principal --\n" + 
					 " * Acessar\n"+
					 " * Cadastrar\n"+
					 " * Sair\n\n"+
				"Digite o nome de uma das opcoes desejadas acima\n";
		System.out.println(menu);
	}

	private static boolean notIsAction() {
		return (!action.equals("acessar") && !action.equals("cadastrar") && !action.equals("sair"));
	}

	private static void receiveData(){
		action = new Scanner(System.in).nextLine().trim().toLowerCase();
	}

}