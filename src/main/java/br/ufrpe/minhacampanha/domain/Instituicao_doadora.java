package br.ufrpe.minhacampanha.domain;
import java.sql.Date;
/**
 * 
 * @author raiss
 *
 */
public class Instituicao_doadora extends Instituicao{

	private int id_doador;
	private Date dt_ultima_doacao;
    private int num_doacoes_prod;		
    private int num_doacoes_fin;
    
	public int getId_doador() {
		return id_doador;
	}
	public void setId_doador(int id_doador) {
		this.id_doador = id_doador;
	}
	public Date getDt_ultima_doacao() {
		return dt_ultima_doacao;
	}
	public void setDt_ultima_doacao(Date dt_ultima_doacao) {
		this.dt_ultima_doacao = dt_ultima_doacao;
	}
	public int getNum_doacoes_prod() {
		return num_doacoes_prod;
	}
	public void setNum_doacoes_prod(int num_doacoes_prod) {
		this.num_doacoes_prod = num_doacoes_prod;
	}
	public int getNum_doacoes_fin() {
		return num_doacoes_fin;
	}
	public void setNum_doacoes_fin(int num_doacoes_fin) {
		this.num_doacoes_fin = num_doacoes_fin;
	}
    
    
}
