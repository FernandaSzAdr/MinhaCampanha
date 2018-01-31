package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class Usuario extends GenericDomain {
	private String email;
	private Login login;
	private LocalDate data_criacao;
	private int instituicao_vinculada;
	private LocalDate data_vl_inicio, data_vl_fim;
	private int ativo;
	
	public Usuario(){
		data_criacao = LocalDate.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String text = data_criacao.format(formatters);
	    data_criacao = LocalDate.parse(text, formatters);
		ativo = 1;
	}
	
	public Usuario(String email, Login login) {
		this.email = email;
		this.login = login;
		this.data_criacao = LocalDate.now();
	}
	
	public Usuario(String email, Login login, int instituicao_vinculada) {
		this.email = email;
		this.login = login;
		this.data_criacao = LocalDate.now();
		this.instituicao_vinculada = instituicao_vinculada;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getInstituicao_vinculada() {
		return instituicao_vinculada;
	}

	public void setInstituicao_vinculada(int instituicao_vinculada) {
		this.instituicao_vinculada = instituicao_vinculada;
	}
	
	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
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

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	
}
