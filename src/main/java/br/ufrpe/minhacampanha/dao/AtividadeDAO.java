package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Atividade;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class AtividadeDAO {

	public void criar(Atividade atividade) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement("INSERT INTO atividade (id, id_campanha, descricao, tipo,duracao_media)VALUES(?,?,?,?)");
			stmt.setLong(1, atividade.getCodigo());
			stmt.setLong(2, atividade.getCodigoCampanha());
			stmt.setString(3, atividade.getTipo());
			stmt.setString(4, atividade.getDescricao());
			stmt.setTime(5, atividade.getDuracaoMedia());
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<Atividade> listar() throws SQLException{

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Atividade> atividades = new ArrayList<Atividade>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM atividade");
			resultSet = stmt.executeQuery();
		
			while (resultSet.next()){
				
				Atividade atividade = new Atividade();
				atividade.setCodigo(resultSet.getInt("id"));
				atividade.setCodigoCampanha(resultSet.getInt("id_campanha"));
				atividade.setDescricao(resultSet.getString("descricao"));
				atividade.setTipo(resultSet.getString("tipo"));
				atividade.setDuracaoMedia(resultSet.getTime("duracao_media"));
				
				
				atividades.add(atividade);
			 }
			
		}catch (SQLException ex){
			throw ex;
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return atividades;
	}
	
	public List<Atividade> listar(int instituicao) throws SQLException{

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Atividade> atividades = new ArrayList<Atividade>();
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM atividade JOIN campanha "
					+ "ON atividade.id_campanha = campanha.idCampanha "
					+ "JOIN instituicao_promove_campanha "
					+ "ON instituicao_promove_campanha.idCampanha = campanha.idCampanha "
					+ "WHERE instituicao_promove_campanha.id_inst = ?");
			stmt.setInt(1, instituicao);
			resultSet = stmt.executeQuery();
		
			while (resultSet.next()){
				Atividade atividade = new Atividade();
				
				atividade.setCodigo(resultSet.getInt("id"));
				atividade.setCodigoCampanha(resultSet.getInt("id_campanha"));
				atividade.setDescricao(resultSet.getString("descricao"));
				atividade.setTipo(resultSet.getString("tipo"));
				atividade.setDuracaoMedia(resultSet.getTime("duracao_media"));
				
				atividades.add(atividade);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return atividades;
	}
	
	public void update(Atividade atividade) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE atividade SET descricao =  ?, tipo = ?, duracao_media = ? WHERE id = ?");
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(Atividade atividade) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM atividade WHERE cpf = ?");
			stmt.setLong(1, atividade.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
		
	}
}
