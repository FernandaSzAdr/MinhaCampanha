package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.domain.Login;

@ManagedBean 
@ViewScoped
public class LoginBean implements Serializable{
	private Login loginExistente;
	
	public Login getLoginExistente() {
		return loginExistente;
	}
	
	
	public void setLoginExistente(Login loginExistente) {
		this.loginExistente = loginExistente;
	}
	
	public void novoLoginExistente(){
		loginExistente = new Login();
	}
	
	
	public void logar(){
		/**
		 * TODO quando clicar nesse botao vai levar para a tela referente
		 * ao tipo de usuario:
		 */		
		Messages.addGlobalInfo("Login realizado com sucesso!");
		
	}
	
}
