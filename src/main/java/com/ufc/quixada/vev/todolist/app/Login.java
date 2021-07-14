package com.ufc.quixada.vev.todolist.app;

import java.util.Scanner;

import com.ufc.quixada.vev.todolist.usuario.ControllerUsuario;
import com.ufc.quixada.vev.todolist.usuario.DTOUsuario;


public class Login { 
	private String username = "";
	private String password = "";
	
	private DTOUsuario dtoUsuario = null;
	private String input;
	private boolean returnToBack;
	private ControllerUsuario ctrl;
	
	public Login(String environment) {
		this.ctrl = new ControllerUsuario(environment);
	}

	public DTOUsuario run() {
		do{
			receiveDataMenu();
			runAction();
			if(this.returnToBack) return null;
			if(dtoUsuario != null) return dtoUsuario;
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
					 " * Acessar \n" +
					 " * Voltar\n";
		
		menu += "Digite o nome da acao desejada\n";
		System.out.println(menu);
	}
	
	private void receiveData(){
		this.input = new Scanner(System.in).nextLine().trim().toLowerCase();
	}
	
	private void runAction() {
		try{
			executeAction();
		}catch(Exception error){
			System.out.println("\nErro: " + error.getMessage() + "\n");
		}
	}
	
	private void executeAction() {
		if(this.input.equals("voltar")) this.returnToBack = true;
		else if (this.input.equals("acessar")) tryAccess();
	}
	
	private void tryAccess(){
		try {
			System.out.println("Digite seu nome de usuario\n");
			username = receiveDataUser();

			System.out.println("Digite sua senha\n");
			password = receiveDataUser();
			
			dtoUsuario = ctrl.signIn(username, password);
			return;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage() + "\n");
		}
	}
	
	private String receiveDataUser(){
		return new Scanner(System.in).nextLine().trim();
	}
	

}