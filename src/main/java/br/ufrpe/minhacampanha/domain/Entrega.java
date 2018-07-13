package br.ufrpe.minhacampanha.domain;

@SuppressWarnings("serial")
public class Entrega extends GenericDomain{
	private String data_entrega, data_agendada, data_geracao_protocolo;
	private String hora_agendada;
	private int id_receptora, id_voluntario, cod_ponto_coleta;
	private int num_doc, num_protocolo;
	private String status_entrega, arquivo_protocolo, desc_protocolo;
	private String observacao;
	private String id_S;
	
	public String getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(String data_entrega) {
		this.data_entrega = data_entrega;
	}
	public String getData_agendada() {
		return data_agendada;
	}
	public void setData_agendada(String data_agendada) {
		this.data_agendada = data_agendada;
	}
	public String getData_geracao_protocolo() {
		return data_geracao_protocolo;
	}
	public void setData_geracao_protocolo(String data_geracao_protocolo) {
		this.data_geracao_protocolo = data_geracao_protocolo;
	}
	public String getHora_agendada() {
		return hora_agendada;
	}
	public void setHora_agendada(String hora_agendada) {
		this.hora_agendada = hora_agendada;
	}
	public int getId_receptora() {
		return id_receptora;
	}
	public void setId_receptora(int id_receptora) {
		this.id_receptora = id_receptora;
	}
	public int getId_voluntario() {
		return id_voluntario;
	}
	public void setId_voluntario(int id_voluntario) {
		this.id_voluntario = id_voluntario;
	}
	public int getCod_ponto_coleta() {
		return cod_ponto_coleta;
	}
	public void setCod_ponto_coleta(int cod_ponto_coleta) {
		this.cod_ponto_coleta = cod_ponto_coleta;
	}
	public int getNum_doc() {
		return num_doc;
	}
	public void setNum_doc(int num_doc) {
		this.num_doc = num_doc;
	}
	public int getNum_protocolo() {
		return num_protocolo;
	}
	public void setNum_protocolo(int num_protocolo) {
		this.num_protocolo = num_protocolo;
	}
	public String getStatus_entrega() {
		return status_entrega;
	}
	public void setStatus_entrega(String status_entrega) {
		this.status_entrega = status_entrega;
	}
	public String getArquivo_protocolo() {
		return arquivo_protocolo;
	}
	public void setArquivo_protocolo(String arquivo_protocolo) {
		this.arquivo_protocolo = arquivo_protocolo;
	}
	public String getDesc_protocolo() {
		return desc_protocolo;
	}
	public void setDesc_protocolo(String desc_protocolo) {
		this.desc_protocolo = desc_protocolo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getId_S() {
		return id_S;
	}
	public void setId_S(String id_S) {
		this.id_S = id_S;
	}
}
