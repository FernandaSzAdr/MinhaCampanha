package br.ufrpe.minhacapanha.domain;

public class Login extends GenericDomain {
	private String login;
	private int senha;
	
	public Login(String login, int senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
}
