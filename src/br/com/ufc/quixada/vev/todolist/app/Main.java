package br.com.ufc.quixada.vev.todolist.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		do{
			switch (receiveActionMenu()) {
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

	private static String receiveActionMenu() {
		String action = "";
		do {
			showMainMenu();
			Scanner scanner = new Scanner(System.in);
			action = filterInput(scanner);
		} while (isAction(action));
		return action;
	}
	
	private static void showMainMenu() {
		String menu = "=== You TodoList ===\n" + 
					 "-- Menu Principal --\n" + 
					 " * Acessar\n"+
					 " * Cadastrar\n"+
					 " * Sair\n\n"+
				"Digite o nome de uma das opcoes desejadas acima\n";
		System.out.println(menu);
	}

	private static boolean isAction(String action) {
		return (action.equals("acessar") || action.equals("cadastrar") || action.equals("sair"));
	}

	private static String filterInput(Scanner scanner){
		return scanner.nextLine().trim().toLowerCase();
	}

}