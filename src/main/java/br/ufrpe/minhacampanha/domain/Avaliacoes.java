package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public class Avaliacoes extends GenericDomain {
	private short nota_avaliacao_enum; 
	private String comentario;
	private LocalDate data_avaliacao;
	private Long usuario_fez;
	private Long campanha_recebe;
	
	public Avaliacoes(short nota, String comentario, LocalDate data_avaliacao, Long usuario_fez,
			Long campanha_recebe) {
		this.nota_avaliacao_enum = nota;
		this.comentario = comentario;
		this.data_avaliacao = data_avaliacao;
		this.usuario_fez = usuario_fez;
		this.campanha_recebe = campanha_recebe;
	}
	
	public Avaliacoes(){
		//construtor vazio para utilização dos metodos set
	}
	public short getNota() {
		return nota_avaliacao_enum;
	}

	public String getComentario() {
		return comentario;
	}

	public LocalDate getData_avaliacao() {
		return data_avaliacao;
	}

	public Long getUsuario_fez() {
		return usuario_fez;
	}

	public Long getCampanha_recebe() {
		return campanha_recebe;
	}

	public void setNota(short nota) {
		this.nota_avaliacao_enum = nota;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setData_avaliacao(LocalDate data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}
}
