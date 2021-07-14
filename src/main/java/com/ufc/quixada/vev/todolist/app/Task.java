package com.ufc.quixada.vev.todolist.app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.ufc.quixada.vev.todolist.page.DTOPage;
import com.ufc.quixada.vev.todolist.task.ControllerTask;
import com.ufc.quixada.vev.todolist.task.DTOTask;

public class Task {

	private DTOTask dtoTask;
	private DTOPage dtoPage;
	private ArrayList<DTOTask> list;
	private String input;
	private boolean returnToBack;
	private ControllerTask ctrl;
		
	public Task(String environment, DTOPage dtoPage) {
		this.ctrl = new ControllerTask(environment);
		this.dtoPage = dtoPage;
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
					 "== Pagina "+ dtoPage.getName() +" ==\n" +
					 "-- Lista de tasks --\n" +
					 "__ Acoes __\n" +
					 " * Criar nova\n" +
					 " * Voltar\n" +
					 " * Sair\n" +
					 "__ Tasks __\n";
		menu += showList();
		menu += "Digite o nome da acao desejada\n";
		System.out.println(menu);
	}
	
	private String showList() {
		String menu = "";
		try {
			list = ctrl.findByPage(dtoPage.getId());
			for(DTOTask page: list) 
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
	}
	
	private void create() {
		do {
			try {
				showMenuCreate();
				receiveData();
				configureNewCreated();
				ctrl.create(dtoTask);
				return;
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage() + "\n");
			}
		} while(true);
	}
		
	private void showMenuCreate(){
		String menu = "=== You TodoList ===\n" + 
				 "-- Criar nova task --\n" +
				 " * Digite o nome da nova task\n";
		System.out.println(menu);
	}
	
	private void configureNewCreated() {
		dtoTask = new DTOTask();
		dtoTask.setId(UUID.randomUUID());
		dtoTask.setIdPage(dtoPage.getId());
		dtoTask.setName(input);
	}
}