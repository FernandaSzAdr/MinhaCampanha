package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.ProdutoREF;

public class ProdutoREFDAO {
	
	public void criar(ProdutoREF produto, 
			Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
		try{
			stmt = connection.prepareStatement("INSERT INTO ProdutoREF (cod, descricao, cod_barras, marca)"
					+ "VALUES(?,?,?,?)");
		
			//stmt.setDate(1, produto.getDataDoacao());
			stmt.setInt(1, produto.getCodigo());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getCodigo_barras());
			stmt.setString(4, produto.getMarca());
			stmt.execute();
			//JOptionPane.showMessageDialog(null, "ProdutoREF, regustrado");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}
	}
	

	public List<ProdutoREF> listar(Connection connection,  java.sql.PreparedStatement stmt) 
			throws SQLException{
		ResultSet resultSet = null;
		
		List<ProdutoREF> produtos = new ArrayList<ProdutoREF>();
		
		try{
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement("SELECT * FROM ProdutoREF ");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				ProdutoREF produto = new ProdutoREF();
				produto.setCodigo(resultSet.getInt("id"));
				//produto.setDataDoacao(resultSet.getDate("data_doacao"));
				produto.setCodBarras(resultSet.getString("cod_barras"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setMarca(resultSet.getString("marca"));
				
				
				produtos.add(produto);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}
		
		return produtos;
		
	}
	
	public void update(ProdutoREF produto, 
			Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
		
		try{
			stmt = connection.prepareStatement("UPDATE ProdutoREF SET  marca = ?, cod_barras = ?, descricao = ? WHERE cod = ?");
			stmt.setString(1, produto.getMarca());
			stmt.setString(2,produto.getCodigo_barras());
			stmt.setString(3, produto.getDescricao());	
			stmt.setInt(4,produto.getCodigo());
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}
	}
	
	public void excluir(ProdutoREF produto, 
			Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
		try{
			stmt = connection.prepareStatement("DELETE FROM ProdutoREF WHERE id = ?");
			stmt.setLong(1, produto.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}
	}
}
