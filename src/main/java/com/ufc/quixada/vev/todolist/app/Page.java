package com.ufc.quixada.vev.todolist.app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.ufc.quixada.vev.todolist.page.ControllerPage;
import com.ufc.quixada.vev.todolist.page.DTOPage;
import com.ufc.quixada.vev.todolist.usuario.DTOUsuario;

public class Page {

	private DTOUsuario dtoUsuario;
	private DTOPage dtoPage;
	private ArrayList<DTOPage> list;
	private String input;
	private boolean returnToBack;
	private ControllerPage ctrl;
	private String environment;
	
	public Page(String environment, DTOUsuario dtoUsuario) {
		ctrl = new ControllerPage(environment);
		this.environment = environment;
		this.dtoUsuario = dtoUsuario;
	}
	
	public void run() {
		do{
			try{
				receiveDataMenu();
				if(this.returnToBack) return; 
			}catch(Exception error){
				System.out.println("\nErro: " + error.getMessage() + "\n");
			}
		}while(true);
	}
	
	private void receiveDataMenu() {
		showMenu();
		receiveData();
		executeAction();
	}

	private void showMenu() {
		String menu = "=== You TodoList ===\n" + 
				 	 "== Usuario "+ dtoUsuario.getName() +" ==\n" +
					 "-- Lista de paginas --\n" +
					 "__ Acoes __\n" +
					 " * Criar nova\n" +
					 " * Voltar\n" +
					 " * Sair\n" +
					 "__ Paginas __\n";
		menu += showList();
		menu += "Digite o nome da pagina ou acao desejada\n";
		System.out.println(menu);
	}
	
	private String showList() {
		String menu = "";
		try {
			list = ctrl.findByAgenda(dtoUsuario.getIdAgenda());
			for(DTOPage page: list) 
				menu += " * nome: "+page.getName()+"\n";
		} catch (Exception error) {
			System.out.println("\nErro: " + error.getMessage() + "\n");
		}
		return menu;
	}
	
	private void receiveData(){
		this.input = new Scanner(System.in).nextLine().trim().toLowerCase();
	}
	 
	private void executeAction() {
		if( this.input.equals("sair") ) System.exit(0);
		else if( this.input.equals("voltar") ) this.returnToBack = true;
		else if( this.input.equals("criar nova") ) create();
		else goToPage();
	}
	
	private void create() {
		do {
			try {
				showMenuCreate();
				receiveData();
				configureNewCreated();
				ctrl.create(dtoPage);
				return;
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage() + "\n");
			}
		} while(true);
	}
	
	private void goToPage() {
		dtoPage = ctrl.findByName(input);
		new Task(environment, dtoPage).run();
	}
	
	private void showMenuCreate(){
		String menu = "=== You TodoList ===\n" + 
				 "-- Criar nova pagina --\n" +
				 " * Digite o nome da nova pagina\n";
		System.out.println(menu);
	}
	
	private void configureNewCreated() {
		dtoPage = new DTOPage();
		dtoPage.setId(UUID.randomUUID());
		dtoPage.setIdAgenda(dtoUsuario.getIdAgenda());
		dtoPage.setName(input);
	}
	
}