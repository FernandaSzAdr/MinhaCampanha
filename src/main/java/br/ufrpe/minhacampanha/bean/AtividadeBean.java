package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.AtividadeDAO;
import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.domain.Atividade;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AtividadeBean implements Serializable{
	private Atividade atividade;
	private List<Atividade> atividades;
	private List<Campanha> campanhas;
	private Campanha campanha;
	private FacesContext context = FacesContext.getCurrentInstance();
	private Connection connection = null;
	private Instituicao instituicao = (Instituicao) context.getExternalContext().getApplicationMap().get("instituicao");;
	
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	public Campanha getCampanha() {
		return campanha;
	}
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	public void novaAtividade(){
		try {
			connection = ConnectionFactory.getConnection();
			
			atividade = new Atividade();
			campanha = new Campanha();
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar(connection, instituicao.getCodigo());
		} catch (SQLException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar preencher o campo 'campanha'.");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	@PostConstruct
	public void listar(){
		try {			
			connection = ConnectionFactory.getConnection();
			
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			
			atividades = atividadeDAO.listar(instituicao.getCodigo(), connection);
		} catch (SQLException e) {
			Messages.addGlobalFatal("Ocorreu um erro ao tentar listar as atividades dessa instituição");
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void salvar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			atividade.setCodigoCampanha(Integer.valueOf(campanha.getId_S()));
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			atividadeDAO.criar(atividade, connection);

			Messages.addGlobalInfo("Atividade cadastrada com sucesso!");
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar cadastrar nova atividade!");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
}
