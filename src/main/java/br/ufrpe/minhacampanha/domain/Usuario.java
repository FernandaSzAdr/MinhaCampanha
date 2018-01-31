package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.sql.Date;;
@SuppressWarnings("serial")
public class Usuario extends GenericDomain {
	private String email;
	private Login login;
	private Date data_criacao;
	private long instituicao_vinculada;
	private Date data_vl_inicio, data_vl_fim;
	
	public Usuario(){
		
	}
	
	public Usuario(String email, Login login) {
		this.email = email;
		this.login = login;
		this.data_criacao = LocalDate.now();
	}
	
	public Usuario(String email, Login login, Long instituicao_vinculada) {
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



	

	public long getInstituicao_vinculada() {
		return instituicao_vinculada;
	}

	public void setInstituicao_vinculada(long instituicao_vinculada) {
		this.instituicao_vinculada = instituicao_vinculada;
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
