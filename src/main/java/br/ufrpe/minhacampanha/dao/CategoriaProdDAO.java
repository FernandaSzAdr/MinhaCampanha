package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.CategoriaProduto;
import br.ufrpe.minhacampanha.domain.ProdutoREF;

public class CategoriaProdDAO {

	public void criar(CategoriaProduto produto, Connection connection, ProdutoREF prod) throws SQLException{
		try{
			PreparedStatement stmt;
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement("INSERT INTO CategoriaProduto (descricao, observacao) "
					+ "VALUES(?,?)");
		
			//stmt.setDate(1, produto.getDataDoacao());
			stmt.setString(2, produto.getObservacao());
			stmt.setString(1, produto.getDescricao());
			stmt.execute();
			
			stmt = connection.prepareStatement("INSERT INTO produto_ref_esta_em_categoria_prod (cod_produto, id_categoria) "
					+ "VALUES(?,?)");
			stmt.setInt(1, prod.getCodigo());
			stmt.setInt(2, produto.getCodigo());
			stmt.execute();
			connection.commit();
			
			connection.setAutoCommit(true);
		}catch (SQLException ex){
			connection.rollback();
			ex.printStackTrace();
			throw ex;
		}
	}

	public List<CategoriaProduto> listar(Connection connection) 
			throws SQLException{
		ResultSet resultSet = null;
		
		List<CategoriaProduto> categorias = new ArrayList<CategoriaProduto>();
		
		try{
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM categoria_prod");
			resultSet =stmt.executeQuery();
			while (resultSet.next()){			
				CategoriaProduto categoria = new CategoriaProduto();
				categoria.setCodigo(resultSet.getInt("id"));
				categoria.setObservacao(resultSet.getString("obs"));
				categoria.setDescricao(resultSet.getString("descricao"));
				categoria.setId_S(Integer.toString(resultSet.getInt("id")));
				
				categorias.add(categoria);
			 }
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return categorias;
		
	}
	
	public void update(CategoriaProduto produto, 
			Connection connection) throws SQLException{
		
		try{
			PreparedStatement stmt;
			stmt = connection.prepareStatement("UPDATE CategoriaProduto SET  observacao = ?, descricao = ? WHERE cod = ?");
			stmt.setString(1, produto.getObservacao());
			stmt.setString(2, produto.getDescricao());	
			stmt.setInt(3,produto.getCodigo());
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}
	}
	
	public void excluir(CategoriaProduto produto, 
			Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
		try{
			stmt = connection.prepareStatement("DELETE FROM CategoriaProduto WHERE id = ?");
			stmt.setLong(1, produto.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}
	}

}
