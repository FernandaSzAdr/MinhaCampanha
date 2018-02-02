package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VoluntarioBean implements Serializable{
	private List<Campanha> campanhas;
	private List<Atividade> atividades;
	private List<DisponibilidadePessoaFisica> disponiblidades;
	private PessoaFisicaVoluntario voluntario;
	private DisponibilidadePessoaFisica disponibilidade;
	private Carro carro;
	private Atividade atividade;

	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public List<DisponibilidadePessoaFisica> getDisponiblidades() {
		return disponiblidades;
	}
	
	public Carro getCarro() {
		return carro;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
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

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public void novoVoluntario(){
		voluntario = new PessoaFisicaVoluntario();
		atividade = new Atividade();
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
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar();
			
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			atividades = atividadeDAO.listar();
			
			FacesContext context = FacesContext.getCurrentInstance();
			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			DisponibilidadeDAO disponibilidaDAO = new DisponibilidadeDAO();
			disponiblidades = disponibilidaDAO.listar(pessoa.getCodigo());
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os dados do sistema.");
			erro.printStackTrace();
		}
	}
	
	public void cadastrarCarro(){
		voluntario.setCarro(carro);
	}
	
	public void cadastrar(){
		try {
			/**
			 * TODO acho que precisa fazer uma transaction aqui
			 */
			FacesContext context = FacesContext.getCurrentInstance();
			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			voluntario.setCodigo(pessoa.getCodigo());
			
			if (voluntario.getCarro() != null) {
				voluntario.setTem_veiculo(true);
			}else {
				voluntario.setTem_veiculo(false);
			}
			
			PessoaFisicaVoluntarioDAO voluntarioDAO = new PessoaFisicaVoluntarioDAO();
			voluntarioDAO.criar(voluntario);
			
			/**
			 * TODO fazer o cadastro!!!
			 */
			AtividadeAtribuidaPessoaDAO atividadepessoaDAO = new AtividadeAtribuidaPessoaDAO();
			atividadepessoaDAO.criar(pessoa.getCodigo(), atividade.getCodigo());
			
		} catch (RuntimeException|SQLException e) {
			Messages.addGlobalError("Erro ao tentar se voluntariar!");
		}
	}
	
	public void cadastrarDisponibilidade(){
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			disponibilidade.setCod_pf_voluntaria(pessoa.getCodigo());
			DisponibilidadeDAO disponibilidadeDAO = new DisponibilidadeDAO();
			disponibilidadeDAO.criar(disponibilidade);
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar cadastrar disponibilidade!");
		}
	}
}
