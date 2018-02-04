package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.dao.EnderecoDAO;
import br.ufrpe.minhacampanha.domain.Endereco;
import br.ufrpe.minhacampanha.domain.PessoaFisica;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoPessoaBean implements Serializable{
	private Endereco endereco, editado;
	private List<Endereco> enderecos;
	
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
			FacesContext context = FacesContext.getCurrentInstance();
			
			Connection connection = (Connection) context.getExternalContext().getApplicationMap().get("connection");
			java.sql.PreparedStatement stmt = (PreparedStatement) context.getExternalContext().getApplicationMap().get("stmt");

			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.buscar(pessoa.getEndereco(), connection, stmt);
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar mostrar o endereço!");
		}
		
	}
	
	public void atualizar(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
