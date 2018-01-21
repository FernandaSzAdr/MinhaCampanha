package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public abstract class Usuario extends GenericDomain {
	private static int id = 0;
	private String email;
	private Login login;
	private LocalDate data_criacao;
	private Instituicao instituicao_vinculada;
	private LocalDate data_vl_inicio, data_vl_fim;

	public Usuario(String email, Login login) {
		this.email = email;
		this.login = login;
		this.data_criacao = LocalDate.now();
	}
	
	public Usuario(String email, Login login, Instituicao instituicao_vinculada) {
		this.email = email;
		this.login = login;
		this.data_criacao = LocalDate.now();
		this.instituicao_vinculada = instituicao_vinculada;
	}

	public Instituicao getInstituicao_vinculada() {
		return instituicao_vinculada;
	}

	public static int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Login getLogin() {
		return login;
	}

	public LocalDate getData_criacao() {
		return data_criacao;
	}

	public LocalDate getData_vl_inicio() {
		return data_vl_inicio;
	}

	public void setData_vl_inicio(LocalDate data_vl_inicio) {
		this.data_vl_inicio = data_vl_inicio;
	}

	public LocalDate getData_vl_fim() {
		return data_vl_fim;
	}

	public void setData_vl_fim(LocalDate data_vl_fim) {
		this.data_vl_fim = data_vl_fim;
	}
	
}
