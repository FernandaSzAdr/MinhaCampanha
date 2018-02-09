package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.AtividadeDAO;
import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.domain.Atividade;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CampanhaInstituicaoBean implements Serializable{
	private Instituicao instituicao;
	private Campanha campanha;
	private List<Atividade> atividades;
	private List<Campanha> campanhas;
	private Connection connection = null;
	private boolean show = false;
	
	public Campanha getCampanha() {
		return campanha;
	}
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	@PostConstruct
	public void listar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as campanhas!");
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public void listarAtividade(ActionEvent evento){
		try {
			show = true;
			connection = ConnectionFactory.getConnection();
			campanha = (Campanha) evento.getComponent().getAttributes().get("campanhaSelecionada");
			
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			atividades = atividadeDAO.listar(connection, campanha.getCodigo());
			
			Messages.addGlobalInfo("Carregamento das atividades efetuado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao carregar as atividade");
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void voltar(){
		show = false;
	}
}
