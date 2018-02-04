package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Campanha;

public class CampanhaDAO {
	public List<Campanha> listar(Connection connection,  java.sql.PreparedStatement stmt)
			throws SQLException{
		List<Campanha> campanhas = new ArrayList<Campanha>();
		
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
}
