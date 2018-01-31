package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.LoginDAO;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean 
@SessionScoped
public class LoginBean implements Serializable{
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	
	
	public void setLogin(Login loginExistente) {
		this.login = loginExistente;
	}
	
	@PostConstruct
	public void novoLogin(){
		login = new Login();
	}
	
	
	public String logar(){
		/**
		 * TODO quando clicar nesse botao vai levar para a tela referente
		 * ao tipo de usuario:
		 */		
		try {			
			LoginDAO loginDAO = new LoginDAO();
			Usuario verificado = loginDAO.pegaUser(login);
			
			if (verificado != null) {
				if (verificado.getInstituicao_vinculada() != 0L) {
		
					return "/pages/menuInstituicao?faces-redirect=true";
				} else {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", verificado);
					return "/pages/menuPessoa?faces-redirect=true";
				}
			} else {
				Messages.addGlobalError("Usuario ou senha incorretos!");
			}
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar logar no sistema.");
			erro.printStackTrace();
		}
		return null;
	}	
}
