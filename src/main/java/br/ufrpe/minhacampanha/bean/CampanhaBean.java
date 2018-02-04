package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.Donativo_financeiro;
import br.ufrpe.minhacampanha.domain.Donativo_produto;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CampanhaBean implements Serializable{
	private Campanha campanha;
	private Donativo_produto doacaoP;
	private Donativo_financeiro doacaoF;
	private List<Campanha> campanhas;
	private Connection connection = null;
	
	public Donativo_financeiro getDoacaoF() {
		return doacaoF;
	}
	
	public Donativo_produto getDoacaoP() {
		return doacaoP;
	}
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public Campanha getCampanha() {
		return campanha;
	}
	
	public void setDoacaoF(Donativo_financeiro doacaoF) {
		this.doacaoF = doacaoF;
	}
	
	public void setDoacaoP(Donativo_produto doacaoP) {
		this.doacaoP = doacaoP;
	}
	
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	
	@PostConstruct
	public void listar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar(connection);
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as campanhas existentes no sistema.");
			erro.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void novaDoacaoP(){
		doacaoP = new Donativo_produto();
	}
	
	public void novaDoacaoF(){
		doacaoF = new Donativo_financeiro();
	}
	
	public void novoCampanha(){
		campanha = new Campanha();
	}	
	
	public void doarFinanceiro(){
		
	}
	
	public void doarProduto(){
		
	}
}
