package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.util.ConnectionFactory;
import br.ufrpe.minhacapanha.domain.ProdutoREF;

public class ProdutoREFDAO {

	public void criar(ProdutoREF produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO produto_ref (cod, descricao, cod_barras, marca)VALUES(?,?,?,?)");
			stmt.setLong(1, produto.getCodigo());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getCodigo_barras());
			stmt.setString(4, produto.getMarca());
			
			//JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<ProdutoREF> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<ProdutoREF> produtos = new ArrayList<ProdutoREF>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM produto_ref");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				ProdutoREF produto = new ProdutoREF();
				produto.setCodigo(resultSet.getLong("cod"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setCodBarras(resultSet.getString("cod_barras"));
				
				
				produtos.add(produto);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return produtos;
		
	}
	
	public void update(ProdutoREF produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE produto_ref SET descricao = ?, cod_barras = ?, marca = ? WHERE cod = ?");
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getCodigo_barras());
			stmt.setString(3, produto.getMarca());
			stmt.setLong(4, produto.getCodigo());
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(ProdutoREF produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM produto_ref WHERE cod = ?");
			stmt.setLong(1, produto.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
}
