package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.PontoColeta;

public class PontoColetaDAO {
	public List<PontoColeta> listar(Connection connection) throws SQLException{
		ResultSet resultSet = null;
		PreparedStatement stmt;
		List<PontoColeta> pontos = new ArrayList<PontoColeta>();
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM pontocoleta");
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				PontoColeta ponto = new PontoColeta();
				ponto.setCodigo(resultSet.getInt("cod_pontocoleta"));
				ponto.setDescricao(resultSet.getString("descricao"));
				ponto.setEndereco(resultSet.getInt("sequ_end"));
				ponto.setId_S(Integer.toString(resultSet.getInt("cod_pontocoleta")));
				
				pontos.add(ponto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return pontos;
	}
}
