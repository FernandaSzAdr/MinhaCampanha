package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Donativo_financeiro;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class Donativo_financeiroDAO {

	public void criar(Donativo_financeiro produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Donativo_financeiro (data_doacao, id_inst_doadora,"
					+ " id_pessoa_doadora, id_campanha, qtd_valor_doado)VALUES(?,?,?,?,?)");
		
			//stmt.setDate(1, produto.getDataDoacao());
			stmt.setLong(2,produto.getId_inst_doadora());
			stmt.setLong(3, produto.getId_pessoa_doadora());
			stmt.setLong(4, produto.getId_campanha());
			stmt.setFloat(5, produto.getQtd_valor_doado());
			

			
			//JOptionPane.showMessageDialog(null, "Donativo_produto, regustrado");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<Donativo_financeiro> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Donativo_financeiro> produtos = new ArrayList<Donativo_financeiro>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Donativo_financeiro");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Donativo_financeiro produto = new Donativo_financeiro();
				produto.setCodigo(resultSet.getLong("id"));
				//produto.setDataDoacao(resultSet.getDate("data_doacao"));
				produto.setId_campanha(resultSet.getInt("id_campanha"));
				produto.setId_inst_doadora(resultSet.getInt("id_inst_doadora"));
				produto.setId_pessoa_doadora(resultSet.getInt("id_pessoa_doadora"));
				produto.setQtd_valor_doado(resultSet.getFloat("qtd_valor_doado"));
			
				
				
				produtos.add(produto);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return produtos;
		
	}
	
	public void update(Donativo_financeiro produto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE donativo_financeiro SET   id_campanha = ? WHERE cod = ?");
			stmt.setInt(1, produto.getId_campanha());	
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(Donativo_financeiro produto) throws SQLException{
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
