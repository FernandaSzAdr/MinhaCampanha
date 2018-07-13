package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.EntregaDAO;
import br.ufrpe.minhacampanha.dao.Instituicao_receptoraDAO;
import br.ufrpe.minhacampanha.dao.PessoaFisicaVoluntarioDAO;
import br.ufrpe.minhacampanha.dao.PontoColetaDAO;
import br.ufrpe.minhacampanha.domain.Entrega;
import br.ufrpe.minhacampanha.domain.Instituicao_receptora;
import br.ufrpe.minhacampanha.domain.PessoaFisicaVoluntario;
import br.ufrpe.minhacampanha.domain.PontoColeta;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EntregaBean implements Serializable{
	public List<Entrega> entregas;
	public List<Entrega> entregasNaoFinalizadas;
	public List<Instituicao_receptora> instituicoes;
	public List<PessoaFisicaVoluntario> pessoas;
	public List<PontoColeta> pontos;
	public Instituicao_receptora instituicao;
	public PessoaFisicaVoluntario pessoa;
	public PontoColeta ponto;
	public Entrega entrega;
	public Entrega entrega_aux;
	private Connection connection = null;
	
	public Instituicao_receptora getInstituicao() {
		return instituicao;
	}
	
	public PessoaFisicaVoluntario getPessoa() {
		return pessoa;
	}
	
	public PontoColeta getPonto() {
		return ponto;
	}
	
	public List<Entrega> getEntregas() {
		return entregas;
	}
	
	public List<Instituicao_receptora> getInstituicoes() {
		return instituicoes;
	}
	
	public List<PessoaFisicaVoluntario> getPessoas() {
		return pessoas;
	}
	
	public List<PontoColeta> getPontos() {
		return pontos;
	}
	
	public Entrega getEntrega() {
		return entrega;
	}
	
	public Entrega getEntrega_aux() {
		return entrega_aux;
	}
	
	public List<Entrega> getEntregasNaoFinalizadas() {
		return entregasNaoFinalizadas;
	}
	
	public void setEntregasNaoFinalizadas(List<Entrega> entregasNaoFinalizadas) {
		this.entregasNaoFinalizadas = entregasNaoFinalizadas;
	}
	
	public void setEntrega_aux(Entrega entrega_aux) {
		this.entrega_aux = entrega_aux;
	}
	
	public void setInstituicao(Instituicao_receptora instituicao) {
		this.instituicao = instituicao;
	}
	
	public void setPessoa(PessoaFisicaVoluntario pessoa) {
		this.pessoa = pessoa;
	}
	
	public void setPonto(PontoColeta ponto) {
		this.ponto = ponto;
	}
	
	public void setInstituicoes(List<Instituicao_receptora> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	public void setPessoas(List<PessoaFisicaVoluntario> pessoas) {
		this.pessoas = pessoas;
	}
	
	public void setPontos(List<PontoColeta> pontos) {
		this.pontos = pontos;
	}
	
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
	
	@PostConstruct
	public void listar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			EntregaDAO entregaDAO = new EntregaDAO();
			entregas = entregaDAO.listar(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as entregas!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public void novaEntrega(){
		try {
			connection = ConnectionFactory.getConnection();
			
			Instituicao_receptoraDAO instituicaoDAO = new Instituicao_receptoraDAO();
			instituicoes = instituicaoDAO.listar(connection);
			instituicao = new Instituicao_receptora();
			
			PessoaFisicaVoluntarioDAO pessoaDAO = new PessoaFisicaVoluntarioDAO();
			pessoas = pessoaDAO.listar(connection);
			pessoa = new PessoaFisicaVoluntario();
			
			PontoColetaDAO pontoDAO = new PontoColetaDAO();
			pontos = pontoDAO.listar(connection);
			ponto =  new PontoColeta();
			
			entrega = new Entrega();
		} catch (SQLException e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar informações do banco!");
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void cadastrar(){
		try {
			entrega.setCod_ponto_coleta(Integer.parseInt(ponto.getId_S()));
			entrega.setId_receptora(Integer.parseInt(instituicao.getId_inst_S()));
			entrega.setId_voluntario(Integer.parseInt(pessoa.getId_S()));
			entrega.setStatus_entrega("não entregue");
			
			connection = ConnectionFactory.getConnection();
			
			EntregaDAO entregaDAO = new EntregaDAO();
			entregaDAO.cadastrar(connection, entrega);
			
			entregas = entregaDAO.listar(connection);
			Messages.addGlobalInfo("Entrega cadastrada com sucesso!");
		} catch (SQLException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar cadastrar a entrega!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public void novoAtualizar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			EntregaDAO entregaDAO = new EntregaDAO();
			entregasNaoFinalizadas = entregaDAO.listarAtivas(connection);

			entrega_aux = new Entrega();
			
			System.out.println(entregasNaoFinalizadas);
		} catch (SQLException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as entregas que ainda não foram entregues");
		} finally {
			ConnectionFactory.closeConnection(connection);
		}		
	}
	
	public void atualizar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			EntregaDAO entregaDAO = new EntregaDAO();
			entrega_aux.setStatus_entrega("entregue");
			entrega_aux.setCodigo(Integer.valueOf(entrega_aux.getId_S()));
			
			entregaDAO.atualizar(connection, entrega_aux);
			
			Messages.addGlobalInfo("Atualização efetuada com sucesso!");
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao efetuar a entrega.");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
}
