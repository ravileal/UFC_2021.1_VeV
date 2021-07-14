package com.ufc.quixada.vev.todolist.app;

import java.util.Scanner;
import java.util.UUID;

import com.ufc.quixada.vev.todolist.usuario.ControllerUsuario;
import com.ufc.quixada.vev.todolist.usuario.DTOUsuario;

public class Register {
	
	private DTOUsuario dtoUsuario;
	private String input;
	private boolean returnToBack;
	private ControllerUsuario ctrl;
	
	public Register(String environment) {
		ctrl = new ControllerUsuario(environment);
	}
	
	public void run() {
		do{
			receiveDataMenu();
			try{
				executeAction();
				if(this.returnToBack) return;
			}catch(Exception error){
				System.out.println("\nErro: " + error.getMessage() + "\n");
			}
		}while(true);
	}
	
	private void receiveDataMenu() {
		showMenu();
		receiveData();
	}

	private void showMenu() {
		String menu = "=== You TodoList ===\n" +
					 "-- Criacao de usuario --\n" +
					 "__ Acoes __\n" +
					 " * Criar novo \n" +
					 " * Voltar\n";
		
		menu += "Digite o nome da acao desejada\n";
		System.out.println(menu);
	}
	
	private void receiveData(){
		this.input = new Scanner(System.in).nextLine().trim().toLowerCase();
	}
	
	private void executeAction() {
		if( this.input.equals("voltar") ) this.returnToBack = true;
		if( this.input.equals("criar novo") ) create();
	}
	
	private void create() {
		do {
			try {
				dtoUsuario = new DTOUsuario();
				dtoUsuario.setId(UUID.randomUUID());
				dtoUsuario.setIdAgenda(UUID.randomUUID());
				
				System.out.println(" * Digite o nome do novo usuario\n");
				dtoUsuario.setName(receiveDataUser());
				
				System.out.println(" * Digite o username do novo usuario\n");
				dtoUsuario.setUsername(receiveDataUser());
				
				System.out.println(" * Digite a senha do novo usuario\n");
				dtoUsuario.setPassword(receiveDataUser());
				
				ctrl.create(dtoUsuario);
				return;
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage() + "\n");
			}
		} while(true);
	}
	
	private String receiveDataUser(){
		return new Scanner(System.in).nextLine().trim();
	}
	
	private void showMenuCreate(){
		String menu = "=== You TodoList ===\n" + 
				 "-- Criar novo usuario --\n";
		System.out.println(menu);
	}

}