package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Donativo_produto;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class Donativo_produtoDAO {

	public void criar(Donativo_produto produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Donativo_produto (data_doacao, status_donativo, id_inst_doadora,"
					+ " id_pessoa_doadora, id_campanha, qtd_donativo_doado)VALUES(?,?,?,?,?,?)");
		
			//stmt.setDate(1, produto.getDataDoacao());
			stmt.setString(2, produto.getStatus_donativo());
			stmt.setLong(3,produto.getId_inst_doadora());
			stmt.setLong(4, produto.getId_pessoa_doadora());
			stmt.setLong(4, produto.getId_campanha());
			stmt.setLong(4, produto.getQtd_donativo_doado());
			

			
			//JOptionPane.showMessageDialog(null, "Donativo_produto, regustrado");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<Donativo_produto> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Donativo_produto> produtos = new ArrayList<Donativo_produto>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Donativo_produto");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Donativo_produto produto = new Donativo_produto();
				produto.setCodigo(resultSet.getLong("id"));
				//produto.setDataDoacao(resultSet.getDate("data_doacao"));
				produto.setId_campanha(resultSet.getInt("id_campanha"));
				produto.setId_inst_doadora(resultSet.getInt("id_inst_doadora"));
				produto.setId_pessoa_doadora(resultSet.getInt("id_pessoa_doadora"));
				produto.setQtd_donativo_doado(resultSet.getInt("qtd_donativo_doado"));
				produto.setStatus_donativo(resultSet.getString("status_donativo"));
				
				
				produtos.add(produto);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return produtos;
		
	}
	
	public void update(Donativo_produto produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE donativo_produto SET  status_donativo = ?, id_campanha = ? WHERE cod = ?");
			stmt.setString(1, produto.getStatus_donativo());
			stmt.setInt(2, produto.getId_campanha());	
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(Donativo_produto produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM Donativo_produto WHERE id = ?");
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
