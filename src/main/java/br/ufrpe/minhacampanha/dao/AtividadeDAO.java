package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.Atividade;

public class AtividadeDAO {

	public void criar(Atividade atividade, Connection connection)
			throws SQLException{
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement("INSERT INTO atividade (id_campanha, descricao, "
					+ "tipo,duracao_media)VALUES(?,?,?,?)");
			stmt.setInt(1, atividade.getCodigoCampanha());
			stmt.setString(2, atividade.getDescricao());
			stmt.setString(3, atividade.getTipo());
			stmt.setTime(4, java.sql.Time.valueOf(atividade.getDuracaoMedia()));
			stmt.executeUpdate();			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	/**
	 * Lista todas as atividades do sistema
	 * 
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public List<Atividade> listar(Connection connection) throws SQLException{
		ResultSet resultSet = null;
		
		List<Atividade> atividades = new ArrayList<Atividade>();
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement("SELECT * FROM atividade JOIN "
					+ "atividade_atribuido_pessoa "
					+ "ON atividade.id = atividade_atribuido_pessoa.id");
			resultSet = stmt.executeQuery();
		
			while (resultSet.next()){
				Atividade atividade = new Atividade();
				atividade.setCodigo(resultSet.getInt("id"));
				atividade.setCodigoCampanha(resultSet.getInt("id_campanha"));
				atividade.setDescricao(resultSet.getString("descricao"));
				atividade.setTipo(resultSet.getString("tipo"));
				atividade.setDuracaoMedia(resultSet.getTime("duracao_media").toString());
				atividade.setPessoa(resultSet.getInt("atividade_atribuido_pessoa.id_pf"));
				atividade.setData_atividade(resultSet.getDate("atividade_atribuido_pessoa.data_atividade").toString());
				
				atividades.add(atividade);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return atividades;
	}
	
	public List<Atividade> listar(Connection connection, int campanha) throws SQLException{
		ResultSet resultSet = null;
		
		List<Atividade> atividades = new ArrayList<Atividade>();
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement("SELECT * FROM atividade "
					+ "JOIN atividade_atribuido_pessoa "
					+ "ON atividade.id = atividade_atribuido_pessoa.id "
					+ "WHERE id_campanha = ?");
			stmt.setInt(1, campanha);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()){
				Atividade atividade = new Atividade();
				atividade.setCodigo(resultSet.getInt("id"));
				atividade.setCodigoCampanha(resultSet.getInt("id_campanha"));
				atividade.setDescricao(resultSet.getString("descricao"));
				atividade.setTipo(resultSet.getString("tipo"));
				atividade.setDuracaoMedia(resultSet.getTime("duracao_media").toString());
				atividade.setPessoa(resultSet.getInt("atividade_atribuido_pessoa.id_pf"));
				atividade.setData_atividade(resultSet.getDate("atividade_atribuido_pessoa.data_atividade").toString());
				
				atividades.add(atividade);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return atividades;
	}
	
	/**
	 * Lista todas as atividades de uma instituicao
	 * 
	 * @param instituicao
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public List<Atividade> listar(int instituicao, Connection connection)
			throws SQLException{
		ResultSet resultSet = null;
		PreparedStatement stmt;
		List<Atividade> atividades = new ArrayList<Atividade>();
		
		try{
			stmt = connection.prepareStatement("select * from atividade JOIN campanha "
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
				atividade.setDuracaoMedia(resultSet.getTime("duracao_media").toString());
				atividades.add(atividade);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return atividades;
	}
	
	public void update(Atividade atividade, Connection connection)
			throws SQLException{
		try{
			PreparedStatement stmt;
			stmt = connection.prepareStatement("UPDATE atividade SET descricao =  ?, tipo = ?, duracao_media = ? WHERE id = ?");
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}
	}
	
	public void excluir(int atividade, Connection connection) throws SQLException{
		try {
			ResultSet resultSet = null;
			
			PreparedStatement ps1 = connection.prepareStatement("SELECT * "
					+ "from atividade_atribuido_pessoa WHERE id = ?");
			ps1.setInt(1, atividade);
			resultSet = ps1.executeQuery();
			
			if (resultSet.next()) {
				connection.setAutoCommit(false);
				ps1 = connection.prepareStatement("DELETE FROM ativide_atribuido_pessoa "
						+ "WHERE id = ?");
				ps1.setInt(1, atividade);
				
				String sql = "DELETE FROM atividade WHERE id = ?";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.setInt(1, atividade);
	            
	            ps.executeUpdate();
	            
	            connection.commit();
	            connection.setAutoCommit(true);
			}else{
				String sql = "DELETE FROM atividade WHERE id = ?";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.setInt(1, atividade);
	            ps.executeUpdate();
			}
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw e;
		}
	}
}
