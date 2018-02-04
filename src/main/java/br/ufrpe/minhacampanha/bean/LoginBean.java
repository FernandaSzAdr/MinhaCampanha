package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.dao.InstituicaoDAO;
import br.ufrpe.minhacampanha.dao.Instituicao_receptoraDAO;
import br.ufrpe.minhacampanha.dao.LoginDAO;
import br.ufrpe.minhacampanha.dao.PessoaFisicaDAO;
import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.Usuario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

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
			FacesContext context = FacesContext.getCurrentInstance();
			Connection connection = ConnectionFactory.getConnection();
			java.sql.PreparedStatement stmt = null;
			context.getExternalContext().getSessionMap().put("connection", connection);
			context.getExternalContext().getSessionMap().put("stmt", stmt);
			
			LoginDAO loginDAO = new LoginDAO();
			Usuario verificado = loginDAO.pegaUser(login, connection, stmt);

			
			if (verificado != null) {
				context.getExternalContext().getSessionMap().put("usuario", verificado);
				
				if (verificado.getInstituicao_vinculada() != 0) {
					Instituicao_receptoraDAO instituicao_receDAO = new Instituicao_receptoraDAO();
					InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
					Instituicao instituicao = instituicaoDAO.buscar(verificado.getInstituicao_vinculada(), connection, stmt);
					
					context.getExternalContext().getApplicationMap().put("instituicao", instituicao);
					if (instituicao_receDAO.buscar(instituicao, connection, stmt)) {
						return "/pages/menuInstituicaoRece?faces-refirect=true";
					} else {
						return "/pages/menuInstituicao?faces-redirect=true";
					}
				} 
				else {
					PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
					PessoaFisica pessoa = pessoaDAO.buscar(verificado.getCodigo(), connection, stmt);
					
					context.getExternalContext().getApplicationMap().put("pessoa", pessoa);
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
