package br.com.ufc.quixada.vev.todolist.app;

import java.util.Scanner;

public class Main {
	private static String action = "";
	
	public static void main(String[] args) {
		do{
			receiveDataMenu();
			switch (action) {
				case "acessar":
					new Login().signIn();	
					break;
				case "cadastrar":
					new Register().signUp();
					break;
				case "sair":
					System.exit(0);
					break;
				default:
			}				
		} while (true);
	}

	private static void receiveDataMenu() {
		do {
			showMenu();
			receiveData();
		} while (!isAction());
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

	private static boolean isAction() {
		return (action.equals("acessar") || action.equals("cadastrar") || action.equals("sair"));
	}

	private static void receiveData(){
		action = new Scanner(System.in).nextLine().trim().toLowerCase();
	}

}