package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.CategoriaProduto;
import br.ufrpe.minhacampanha.domain.ProdutoREF;

public class CategoriaProdDAO {

public void criar(CategoriaProduto produto, 
		Connection connection,  java.sql.PreparedStatement stmt, ProdutoREF prod) throws SQLException{
	try{
		connection.setAutoCommit(false);
		stmt = connection.prepareStatement("INSERT INTO CategoriaProduto (descricao, observacao)"
				+ "VALUES(?,?)");
	
		//stmt.setDate(1, produto.getDataDoacao());
		stmt.setString(2, produto.getObservacao());
		stmt.setString(1, produto.getDescricao());
		stmt.execute();
		
		stmt = connection.prepareStatement("INSERT INTO produto_ref_esta_em_categoria_prod (cod_produto, id_categoria"
				+ "VALUES(?,?)");
		stmt.setInt(1, prod.getCodigo());
		stmt.setInt(2, produto.getCodigo());
		stmt.execute();
		connection.commit();
		
		//JOptionPane.showMessageDialog(null, "CategoriaProduto, regustrado");
		
	}catch (SQLException ex){
		//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
		
	}
}

public List<CategoriaProduto> listar(Connection connection,  java.sql.PreparedStatement stmt) 
		throws SQLException{
	ResultSet resultSet = null;
	
	List<CategoriaProduto> produtos = new ArrayList<CategoriaProduto>();
	
	try{
	
		stmt = connection.prepareStatement("SELECT * FROM CategoriaProduto");
		resultSet =stmt.executeQuery();
	
		while (resultSet.next()){
			
			CategoriaProduto produto = new CategoriaProduto();
			produto.setCodigo(resultSet.getInt("id"));
			produto.setObservacao(resultSet.getString("observacao"));
			produto.setDescricao(resultSet.getString("descricao"));		
			
			produtos.add(produto);
		 }
		
	}catch (SQLException ex){
		//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
	}
	
	return produtos;
	
}

public void update(CategoriaProduto produto, 
		Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
	
	try{
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
