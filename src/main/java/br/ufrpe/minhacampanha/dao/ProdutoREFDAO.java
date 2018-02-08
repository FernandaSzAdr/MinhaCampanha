package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.ProdutoREF;

public class ProdutoREFDAO {
	
	public void criar(ProdutoREF produto, Connection connection) throws SQLException{
		try{
			connection.setAutoCommit(false);
			
			ResultSet resultSet = null;
			PreparedStatement stmt;
			stmt = connection.prepareStatement("INSERT INTO Produto_REF (descricao, cod_barras, marca)"
					+ "VALUES(?,?,?)");
		
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getCodigo_barras());
			stmt.setString(3, produto.getMarca());
			
			stmt.execute();
			
			ProdutoREF produto_aux = new ProdutoREF();
			
			stmt = connection.prepareStatement("SELECT * FROM Produto_REF WHERE descricao = ? and marca = ? "
					+ "and cod_barras = ?");
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCodigo_barras());
			resultSet =stmt.executeQuery();
			
			if (resultSet.next()) {
				produto_aux.setCodigo(resultSet.getInt("cod"));
			}
			
			stmt = connection.prepareStatement("INSERT INTO produto_ref_esta_em_categoria_prod "
					+ "(cod_produto, id_categoria) VALUES (?,?)");
			
			stmt.setInt(1, produto_aux.getCodigo());
			stmt.setInt(2, produto.getIdCategoria());
			
			stmt.execute();
			
			connection.commit();
			
			connection.setAutoCommit(true);
		}catch (SQLException ex){
			ex.printStackTrace();
			connection.rollback();
			throw ex;
		}
	}
	

	public List<ProdutoREF> listar(Connection connection) throws SQLException{
		List<ProdutoREF> produtos = new ArrayList<ProdutoREF>();
		
		try{
			PreparedStatement stmt;
			ResultSet resultSet = null;
			
			stmt = connection.prepareStatement("SELECT * FROM Produto_REF "
					+ "JOIN produto_ref_esta_em_categoria_prod "
					+ "ON produto_ref.cod = produto_ref_esta_em_categoria_prod.cod_produto");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				ProdutoREF produto = new ProdutoREF();
				
				produto.setCodigo(resultSet.getInt("cod"));
				produto.setCodigo_barras(resultSet.getString("cod_barras"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setMarca(resultSet.getString("marca"));
				produto.setIdCategoria(resultSet.getInt("id_categoria"));
				
				produtos.add(produto);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return produtos;
		
	}
	
	public void update(ProdutoREF produto, Connection connection) throws SQLException{
		
		try{
			PreparedStatement stmt;
			stmt = connection.prepareStatement("UPDATE Produto_REF SET  marca = ?, cod_barras = ?, descricao = ? WHERE cod = ?");
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
	
	public void excluir(ProdutoREF produto, Connection connection) throws SQLException{
		try{
			PreparedStatement stmt;
			ResultSet resultSet = null;
			connection.setAutoCommit(false);
			
			ProdutoREF produto_aux = new ProdutoREF();
			
			stmt = connection.prepareStatement("SELECT * FROM Produto_REF WHERE descricao = ? and marca = ? "
					+ "and cod_barras = ?");
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCodigo_barras());
			resultSet =stmt.executeQuery();
			
			if (resultSet.next()) {
				produto_aux.setCodigo(resultSet.getInt("cod"));
			}
			stmt = connection.prepareStatement("DELETE FROM produto_ref_esta_em_categoria_prod "
					+ "WHERE cod_produto = ?");
			stmt.setInt(1, produto_aux.getCodigo());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("DELETE FROM Produto_REF WHERE descricao = ? and marca = ? "
					+ "and cod_barras = ?");
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCodigo_barras());			
			stmt.executeUpdate();
			
			connection.commit();
			connection.setAutoCommit(true);
		}catch (SQLException ex){
			connection.rollback();
			ex.printStackTrace();
			throw ex;
		}
	}
}
