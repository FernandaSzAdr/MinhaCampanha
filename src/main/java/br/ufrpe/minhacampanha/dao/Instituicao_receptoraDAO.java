package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Instituicao_receptora;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class Instituicao_receptoraDAO {
	
	public void criar(Instituicao_receptora instituicao) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Instituicao_receptora (id_recep , dt_ultima_recep"
					+ " ,num_doacoes_recebi)VALUES(?,?,?)");
		
			
			
			stmt.setInt(1, instituicao.getId_recep());
			stmt.setDate(2,instituicao.getData_entrada());
			stmt.setInt(3, instituicao.getNum_doacoes_recebi());
		

			
			//JOptionPane.showMessageDialog(null, "Donativo_instituicao, regustrado");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<Instituicao_receptora> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Instituicao_receptora> instituicaos = new ArrayList<Instituicao_receptora>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Instituicao_receptora");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				
				Instituicao_receptora instituicao = new Instituicao_receptora();
				instituicao.setId_doador(resultSet.getInt("id_doador"));
				instituicao.setDt_ultima_doacao(resultSet.getDate("dt_ultima_doacao"));
				instituicao.setNum_doacoes_prod(resultSet.getInt("num_doacoes_prod"));
				instituicao.setNum_doacoes_fin(resultSet.getInt("num_doacoes_fin"));
			
				
				
				instituicaos.add(instituicao);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return instituicaos;
		
	}
	
	public void update(Instituicao_receptora instituicao) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE Instituicao_receptora SET   dt_ultima_doacao= ?,  num_doacoes_prod= ?, "
					+ "num_doacoes_fin  = ? WHERE cod = ?");
			stmt.setDate(1, instituicao.getDt_ultima_doacao());
			stmt.setInt(2, instituicao.getNum_doacoes_prod());
			stmt.setInt(3,instituicao.getNum_doacoes_fin());
			stmt.setLong(4, instituicao.getCodigo());	
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(Instituicao_receptora instituicao) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM Instituicao_receptora WHERE id = ?");
			stmt.setLong(1, instituicao.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
}
