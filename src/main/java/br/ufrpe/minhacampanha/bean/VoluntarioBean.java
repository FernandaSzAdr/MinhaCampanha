package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.AtividadeAtribuidaPessoaDAO;
import br.ufrpe.minhacampanha.dao.AtividadeDAO;
import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.dao.DisponibilidadeDAO;
import br.ufrpe.minhacampanha.dao.PessoaFisicaVoluntarioDAO;
import br.ufrpe.minhacampanha.domain.Atividade;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.Carro;
import br.ufrpe.minhacampanha.domain.DisponibilidadePessoaFisica;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.PessoaFisicaVoluntario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class VoluntarioBean implements Serializable{
	private List<Campanha> campanhas;
	private List<Atividade> atividades;
	private List<Atividade> selectAtividades;
	private List<DisponibilidadePessoaFisica> disponiblidades;
	private PessoaFisicaVoluntario voluntario;
	private DisponibilidadePessoaFisica disponibilidade;
	private Carro carro;
	private Atividade atividade;
	private FacesContext context = FacesContext.getCurrentInstance();
	private PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
	private Connection connection = null;

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

	public List<Atividade> getSelectAtividades() {
		return selectAtividades;
	}

	public void setSelectAtividades(List<Atividade> selectAtividades) {
		this.selectAtividades = selectAtividades;
	}

	public List<DisponibilidadePessoaFisica> getDisponiblidades() {
		return disponiblidades;
	}

	public void setDisponiblidades(List<DisponibilidadePessoaFisica> disponiblidades) {
		this.disponiblidades = disponiblidades;
	}

	public PessoaFisicaVoluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(PessoaFisicaVoluntario voluntario) {
		this.voluntario = voluntario;
	}

	public DisponibilidadePessoaFisica getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadePessoaFisica disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public void novoVoluntario(){
		try {
			connection = ConnectionFactory.getConnection();
			voluntario = new PessoaFisicaVoluntario();
			atividade = new Atividade();
			
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			selectAtividades = atividadeDAO.listar(connection);
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo voluntario.");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public void novaDisponibilidade(){
		disponibilidade = new DisponibilidadePessoaFisica();
	}
	
	public void novoCarro(){
		carro = new Carro();
	}
	
	@PostConstruct
	public void listar(){
		try {			
			connection = ConnectionFactory.getConnection();
			
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar(connection);
			
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			atividades = atividadeDAO.listar(connection);
			
			DisponibilidadeDAO disponibilidaDAO = new DisponibilidadeDAO();
			if (disponibilidaDAO.listar(pessoa.getCodigo(), connection) != null) {
				disponiblidades = disponibilidaDAO.listar(pessoa.getCodigo(), connection);
			}
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os dados do sistema.");
			erro.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void cadastrarCarro(){
		voluntario.setCarro(carro);
	}
	
	public void cadastrar() throws SQLException{
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			voluntario.setCodigo(pessoa.getCodigo());
			atividade.setCodigo(Integer.parseInt(atividade.getCodigoS()));
			
			if (voluntario.getCarro() != null) {
				voluntario.setTem_veiculo(true);
			}else {
				voluntario.setTem_veiculo(false);
			}
			
			AtividadeAtribuidaPessoaDAO atividadepessoaDAO = new AtividadeAtribuidaPessoaDAO();
			PessoaFisicaVoluntarioDAO voluntarioDAO = new PessoaFisicaVoluntarioDAO();
			if(atividadepessoaDAO.existe(atividade.getCodigo(), connection)){
				Messages.addGlobalError("Atividade já esta sendo realizada, escolha outra!");
			}else{
				voluntarioDAO.criar(voluntario, connection);
				atividadepessoaDAO.criar(pessoa.getCodigo(), atividade.getCodigo(), connection);
			}
			
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			Messages.addGlobalError("Erro ao tentar se voluntariar!");
		}catch (RuntimeException e) {
			Messages.addGlobalError("Já existe pessoas nessa atividade.");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void cadastrarDisponibilidade(){
		try {
			connection = ConnectionFactory.getConnection();
			
			FacesContext context = FacesContext.getCurrentInstance();
			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			disponibilidade.setCod_pf_voluntaria(pessoa.getCodigo());
			
			DisponibilidadeDAO disponibilidadeDAO = new DisponibilidadeDAO();
			disponibilidadeDAO.criar(disponibilidade, connection);
			
			Messages.addGlobalInfo("Cadastro realizado com sucesso");
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar cadastrar disponibilidade!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
}
