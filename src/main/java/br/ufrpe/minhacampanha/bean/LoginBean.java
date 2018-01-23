package br.ufrpe.minhacampanha.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.domain.Login;

@ManagedBean 
@ViewScoped
public class LoginBean {
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public void novo(){
		login = new Login();
	}
	
	public void logar(){
		/**
		 * TODO quando clicar nesse botao vai levar para a tela referente
		 * ao tipo de usuario:
		 */
		novo();
		
		Messages.addGlobalInfo("Login realizado com sucesso!");
		
	}
	
}
