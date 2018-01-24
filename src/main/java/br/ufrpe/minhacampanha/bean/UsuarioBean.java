package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Login loginInstituicao;
	private Login loginPessoa;
	private Usuario usuarioPessoa;
	private Usuario usuarioInst;
	private Instituicao instituicaoPesquisa;
	private Instituicao instituicao;
	private PessoaFisica pessoa;
	
	public Login getLoginInstituicao() {
		return loginInstituicao;
	}
	
	public Login getLoginPessoa() {
		return loginPessoa;
	}
	
	public Usuario getUsuarioInst() {
		return usuarioInst;
	}
	
	public Usuario getUsuarioPessoa() {
		return usuarioPessoa;
	}
	
	public Instituicao getInstituicaoPesquisa() {
		return instituicaoPesquisa;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public PessoaFisica getPessoa() {
		return pessoa;
	}
	
	public void setLoginInstituicao(Login loginInstituicao) {
		this.loginInstituicao = loginInstituicao;
	}
	
	public void setLoginPessoa(Login loginPessoa) {
		this.loginPessoa = loginPessoa;
	}
	
	public void setUsuarioInst(Usuario usuarioInst) {
		this.usuarioInst = usuarioInst;
	}
	
	public void setUsuarioPessoa(Usuario usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	public void setInstituicaoPesquisa(Instituicao instituicaoPesquisa) {
		this.instituicaoPesquisa = instituicaoPesquisa;
	}
	
	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}
	
	public void novoLoginInstituicao(){
		loginInstituicao = new Login();
	}
	
	public void novoLoginPessoa(){
		loginPessoa = new Login();
	}
	
	
	/**
	 * TODO RESOLVER ESSE ERRO MALUCO!!!
	 */
	public void novoUsuarioPessoa(){
		usuarioPessoa = new Usuario() {
		};
	}
	
	public void novoUsuariInst(){
		usuarioInst = new Usuario() {
		};
	}
	
	public void novoInstituicaoPesquisa(){
		instituicaoPesquisa = new Instituicao();
	}
	
	public void novoInstituicao(){
		instituicao = new Instituicao();
		
		novoLoginInstituicao();
		novoUsuariInst();
	}
	
	public void novoPessoa(){
		pessoa = new PessoaFisica();
		
		novoLoginPessoa();
		novoUsuarioPessoa();
	}
	
	public void pegarInstituicao(){
		/**
		 * TODO Esse butão vai verificar se existe a instituição que está
		 * se tentando vincular, se existir vai levanter uma mensagem de 
		 * confirmação, se não tbm vai levantar uma mensagem.
		 */
	}
	
	/**
	 * TODO para fazer esses dois metodos olhar esse negocio aqui
	 * https://stackoverflow.com/questions/32843135/redirect-login-page-to-another-page-in-jsf
	 */
	
	public void criarUsuarioInstituicao(){
		/**
		 * TODO pegar informações de pessoa, usuario, instituicao, login...
		 */
	}
	
	public String criarUsuarioPessoa(){
		/**
		 * TODO pegar informações de pessoa, usuario, instituicao, login...
		 */
		
		return "pages/menu_pessoa.xhtml?faces-redirect=true";
	}
	
}
