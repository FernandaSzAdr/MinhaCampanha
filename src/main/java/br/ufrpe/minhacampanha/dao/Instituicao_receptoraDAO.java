package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Instituicao_receptora;
import br.ufrpe.minhacampanha.util.ConnectionFactory;
/**
 * 
 * @author raiss
 *
 */
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
				instituicao.setId_recep(resultSet.getInt("id_recep"));
				instituicao.setDt_ultima_recep(resultSet.getDate("dt_ultima_recep"));
				instituicao.setNum_doacoes_recebi(resultSet.getInt("num_doacoes_recebi"));
			
				
				
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
			stmt = connection.prepareStatement("UPDATE Instituicao_receptora SET   dt_ultima_recep = ?	,"
					+ "num_doacoes_recebi = ? WHERE cod = ?");
		
			
			stmt.setDate(1, instituicao.getDt_ultima_recep());
			stmt.setInt(2, instituicao.getNum_doacoes_recebi());
			stmt.setLong(3, instituicao.getCodigo());	
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
