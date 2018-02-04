package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.Campanha;

public class CampanhaDAO {
	public List<Campanha> listar(Connection connection)
			throws SQLException{
		List<Campanha> campanhas = new ArrayList<Campanha>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM campanha");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Campanha campanha = new Campanha();
				
				campanha.setCodigo(resultSet.getInt("idCampanha"));
				campanha.setData_fim(resultSet.getDate("dataFim").toLocalDate());
				campanha.setData_inicio(resultSet.getDate("dataIni").toLocalDate());
				campanha.setQtd_donativo_atual(resultSet.getInt("qtd_d_atual"));
				campanha.setQtd_donativo_necessario(resultSet.getInt("qtd_d_nece"));
				campanha.setQtd_valor_atual(resultSet.getInt("qtd_vl_atual"));
				campanha.setQtd_valor_necessario(resultSet.getInt("qtd_vl_necessario"));
				campanha.setNome(resultSet.getString("nome"));
				campanha.setPublico_alvo(resultSet.getString("publico_alvo"));
				campanha.setStatus_campanha_enum(resultSet.getString("status_campanha"));
				
				campanhas.add(campanha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return campanhas;
	}
	public List<Campanha> listar(Connection connection, int instituicao) throws SQLException{
		List<Campanha> campanhas = new ArrayList<Campanha>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM campanha "
					+ "JOIN instituicao_promove_campanha "
					+ "ON campanha.idCampanha = instituicao_promove_campanha.idCampanha "
					+ "WHERE instituicao_promove_campanha.id_inst = ?");
			stmt.setInt(1, instituicao);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				Campanha campanha = new Campanha();
				
				campanha.setCodigo(resultSet.getInt("idCampanha"));
				campanha.setData_fim(resultSet.getDate("dataFim").toLocalDate());
				campanha.setData_inicio(resultSet.getDate("dataIni").toLocalDate());
				campanha.setQtd_donativo_atual(resultSet.getInt("qtd_d_atual"));
				campanha.setQtd_donativo_necessario(resultSet.getInt("qtd_d_nece"));
				campanha.setQtd_valor_atual(resultSet.getInt("qtd_vl_atual"));
				campanha.setQtd_valor_necessario(resultSet.getInt("qtd_vl_necessario"));
				campanha.setNome(resultSet.getString("nome"));
				campanha.setPublico_alvo(resultSet.getString("publico_alvo"));
				campanha.setStatus_campanha_enum(resultSet.getString("status_campanha"));
				campanha.setId_S(Integer.toString(resultSet.getInt("idCampanha")));
				campanhas.add(campanha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return campanhas;
	}
}
