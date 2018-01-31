package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.LoginDAO;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.Usuario;

@SuppressWarnings("serial")
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
	
	
	public String logar() throws SQLException{
		/**
		 * TODO quando clicar nesse botao vai levar para a tela referente
		 * ao tipo de usuario:
		 */		
		try {
			LoginDAO loginDAO = new LoginDAO();
			Usuario verificado = loginDAO.pegaUser(loginExistente);
			
			if (verificado != null) {
				if (verificado.getInstituicao_vinculada() != 0L) {
					return "/pages/menuInstituicao.xhtml";
				} else {
					System.out.println("Email " + verificado.getEmail() + " Login " + verificado.getLogin().getSenha()
							+ " " + verificado.getLogin().getLogin() + " Codigo " + verificado.getCodigo());
					return "/pages/menuPessoa.xhtml";
				}
			} else {
				Messages.addGlobalError("Usuario ou senha incorretos!");
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar logar no sistema.");
			erro.printStackTrace();
		}
		return null;
	}	
}
