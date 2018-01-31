package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.LoginDAO;
import br.ufrpe.minhacampanha.dao.PessoaFisicaDAO;
import br.ufrpe.minhacampanha.dao.UsuarioDAO;
import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioPessoaBean implements Serializable{
	private Login login;
	private Usuario usuario;
	private Instituicao inst_pessoa;
	private PessoaFisica pessoa;
	
	@PostConstruct
	public void inicia(){
		pessoa = new PessoaFisica();
		login = new Login();
		usuario = new Usuario();
	}
	
	public void novoInstituicao(){
		inst_pessoa = new Instituicao();
	}
	
	public Instituicao getInst_pessoa() {
		return inst_pessoa;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}
	
	public void setInst_pessoa(Instituicao inst_pessoa) {
		this.inst_pessoa = inst_pessoa;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void pegarInstituicao(){
		/**
		 * TODO Esse but�o vai verificar se existe a institui��o que est�
		 * se tentando vincular, se existir vai levanter uma mensagem de 
		 * confirma��o, se n�o tbm vai levantar uma mensagem.
		 */
	}
	
	public void instituicaoPesquisa(){
		
	}
	
	public void criarUsuario(){
		try {
			LoginDAO loginDAO = new LoginDAO();
			PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar o usuario.");
			erro.printStackTrace();
		}
		
	}
}
