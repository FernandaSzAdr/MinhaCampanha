package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.NovoUsuarioDAO;
import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioInstituicaoBean implements Serializable{
	
	private Login loginInstituicao;
	private Usuario usuarioInst;
	private Instituicao instituicao;
	
	@PostConstruct
	public void inicia(){
		instituicao = new Instituicao();
		loginInstituicao = new Login();
		usuarioInst = new Usuario();
	}
	
	public Login getLoginInstituicao() {
		return loginInstituicao;
	}
	
	public Usuario getUsuarioInst() {
		return usuarioInst;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public void setLoginInstituicao(Login loginInstituicao) {
		this.loginInstituicao = loginInstituicao;
	}
	
	public void setUsuarioInst(Usuario usuarioInst) {
		this.usuarioInst = usuarioInst;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	/* ------------------------------------------------------------------------------------- */
	
	/**
	 * TODO para fazer esses dois metodos olhar esse negocio aqui
	 * https://stackoverflow.com/questions/32843135/redirect-login-page-to-another-page-in-jsf
	 * 
	 * https://www.youtube.com/watch?v=DnMl1xfmB70
	 * @throws Exception 
	 * @throws SQLException 
	 */
	
	public String criarUsuarioInstituicao(){
		try {
			NovoUsuarioDAO cadastroDAO = new NovoUsuarioDAO();
			
			cadastroDAO.novoInst(usuarioInst, instituicao, loginInstituicao);
			Messages.addGlobalInfo("Cadastro realizado com Sucesso");
			
			return "/pages/login?faces-redirect=true";
		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar o usuário.");
			erro.printStackTrace();
			
		}
		return "/pages/cadastroUsuarioInstituicao?faces-redirect=true";
	}	
}
