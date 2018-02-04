package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.EnderecoDAO;
import br.ufrpe.minhacampanha.domain.Endereco;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoPessoaBean implements Serializable{
	private Endereco endereco, editado;
	private List<Endereco> enderecos;
	private Connection connection = null;
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public Endereco getEditado() {
		return editado;
	}
	
	public void setEditado(Endereco editado) {
		this.editado = editado;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void novoEndereco(){
		endereco = new Endereco();
	}
	
	public void novoEditar(){
		editado = new Endereco();
	}
	/**
	 * TODO listar todos os endereços daquela pessoa (no caso um endereço apenas)
	 */
	@PostConstruct
	public void listar(){
		try {
			connection = ConnectionFactory.getConnection();
			FacesContext context = FacesContext.getCurrentInstance();
		
			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.buscar(pessoa.getEndereco(), connection);
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar mostrar o endereço!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public void atualizar(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
