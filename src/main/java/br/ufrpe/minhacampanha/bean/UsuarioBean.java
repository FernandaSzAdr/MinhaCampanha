package br.ufrpe.minhacampanha.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Login login;
	private Usuario usuario;
	private Instituicao instituicao;
	private PessoaFisica pessoa;
	
	public Login getLogin() {
		return login;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public PessoaFisica getPessoa() {
		return pessoa;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}
	
	public void novoLogin(){
		login = new Login();
	}
	
	/**
	 * TODO resolver esse erro maluco .-.
	 */
	public void novoUsuario(){
		usuario = new Usuario() {
		};
	}
	
	public void novoInstituicao(){
		instituicao = new Instituicao();
	}
	
	public void novoPessoa(){
		pessoa = new PessoaFisica();
	}
	
	public void salvarInstituicao(){
		/**
		 * TODO Esse but�o vai verificar se existe a institui��o que est�
		 * se tentando vincular, se existir vai levanter uma mensagem de 
		 * confirma��o, se n�o tbm vai levantar uma mensagem.
		 */
	}
	
	public void criarUsuario(){
		/**
		 * TODO pegar informa��es de pessoa, usuario, instituicao, login...
		 */
		
	}
	
}
