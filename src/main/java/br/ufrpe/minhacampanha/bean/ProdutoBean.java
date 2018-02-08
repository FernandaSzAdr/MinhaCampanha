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

import br.ufrpe.minhacampanha.dao.CategoriaProdDAO;
import br.ufrpe.minhacampanha.dao.ProdutoREFDAO;
import br.ufrpe.minhacampanha.domain.CategoriaProduto;
import br.ufrpe.minhacampanha.domain.ProdutoREF;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{
	private ProdutoREF produto;
	private List<CategoriaProduto> categorias;
	private List<ProdutoREF> produtos;
	private CategoriaProduto categoria;
	private Connection connection = null;
	
	public ProdutoREF getProduto() {
		return produto;
	}
	
	public List<ProdutoREF> getProdutos() {
		return produtos;
	}
	
	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public List<CategoriaProduto> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaProduto> categorias) {
		this.categorias = categorias;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public void setProduto(ProdutoREF produto) {
		this.produto = produto;
	}
	
	public void setProdutos(List<ProdutoREF> produtos) {
		this.produtos = produtos;
	}
	
	@PostConstruct
	public void listar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			ProdutoREFDAO produtoDAO = new ProdutoREFDAO();
			
			produtos = produtoDAO.listar(connection);
		} catch (SQLException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos cadastrados!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public void novoProduto(){
		try {
			connection = ConnectionFactory.getConnection();
			CategoriaProdDAO categoriaDAO = new CategoriaProdDAO();
	
			produto = new ProdutoREF();
			categoria = new CategoriaProduto();
			categorias = categoriaDAO.listar(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as categorias");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void salvar(){
		try {
			System.out.println("começando a salvar...");
			System.out.println("categoria selecionada = " + categoria.getId_S());
			connection = ConnectionFactory.getConnection();
			
			ProdutoREFDAO produtoDAO = new ProdutoREFDAO();
			produto.setIdCategoria(Integer.parseInt(categoria.getId_S()));
			
			produtoDAO.criar(produto, connection);
			
			produtos = produtoDAO.listar(connection);
			
			Messages.addGlobalInfo("Produto cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao salvar o produto!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			connection = ConnectionFactory.getConnection();
			produto = new ProdutoREF();
			produto = (ProdutoREF) evento.getComponent().getAttributes().get("produtoSelectionado");
			
			ProdutoREFDAO produtoDAO = new ProdutoREFDAO();
			produtoDAO.excluir(produto, connection);
			
			produtos = produtoDAO.listar(connection);
			
			Messages.addGlobalInfo("Remoção efetuada com sucesso!");
		} catch (SQLException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o produto!");
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
}
