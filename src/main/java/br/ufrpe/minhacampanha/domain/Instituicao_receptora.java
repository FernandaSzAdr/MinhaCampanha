package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
/**
 * 
 * @author raiss
 *
 */
@SuppressWarnings("serial")
public class Instituicao_receptora extends Instituicao{
	private LocalDate dt_ultima_recep ;	
	private int num_doacoes_recebi ;
	private String id_inst_S;
	
	public String getId_inst_S() {
		return id_inst_S;
	}
	public void setId_inst_S(String id_inst_S) {
		this.id_inst_S = id_inst_S;
	}
	public LocalDate getDt_ultima_recep() {
		return dt_ultima_recep;
	}
	public void setDt_ultima_recep(LocalDate dt_ultima_recep) {
		this.dt_ultima_recep = dt_ultima_recep;
	}
	public int getNum_doacoes_recebi() {
		return num_doacoes_recebi;
	}
	public void setNum_doacoes_recebi(int num_doacoes_recebi) {
		this.num_doacoes_recebi = num_doacoes_recebi;
	}
	
}
