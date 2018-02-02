package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.DisponibilidadePessoaFisica;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class DisponibilidadeDAO {
	/**
	 * Terminar de salvar no banco
	 * 
	 * @param disponibilidade
	 * @throws SQLException
	 */
	public void criar(DisponibilidadePessoaFisica disponibilidade) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try {
			String SQL;
			SQL = "INSERT INTO pf_disponibilidade (hora_inicio, hora_fim, dia, dia_semana, ind_feriado, "
					+ "confirmacao_dia, periodo_dia, cod_pf_voluntaria) values (?,?,?,?,?,?,?,?)";
		
			stmt = connection.prepareStatement(SQL);
			stmt.setTime(1, disponibilidade.getHora_inicio());
			stmt.setTime(2, disponibilidade.getHora_fim());
			// converter a string para local date e pegar as informações e depois passar pra date
			//wstmt.setDate(3, x);
			
			stmt.executeUpdate();
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public List<DisponibilidadePessoaFisica> listar(int pessoa) throws SQLException {		
		List<DisponibilidadePessoaFisica> disponibilidades = new ArrayList<DisponibilidadePessoaFisica>();
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			java.sql.PreparedStatement stmt = null;
			
			
			stmt = connection.prepareStatement("SELECT * FROM pf_disponibilidade WHERE cod_pf_voluntaria = ?");
			stmt.setInt(1, pessoa);
			
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				DisponibilidadePessoaFisica disponibilidade = new DisponibilidadePessoaFisica();
				
				disponibilidade.setCodigo(resultSet.getInt("sequencial"));
				disponibilidade.setHora_inicio(resultSet.getTime("hora_inicio"));
				disponibilidade.setHora_fim(resultSet.getTime("hora_fim"));
				disponibilidade.setDia(resultSet.getDate("dia").toLocalDate());
				disponibilidade.setDia_de_semana(resultSet.getInt("dia_semana"));
				disponibilidade.setInd_feriado(resultSet.getInt("ind_feriado"));
				disponibilidade.setConfirmacao_dia(resultSet.getInt("confirmacao_dia"));
				disponibilidade.setConfirmacao_dia(resultSet.getInt("confirmacao_dia"));
				disponibilidade.setPeriodo_dia(resultSet.getString("periodo_dia"));
				disponibilidade.setCod_pf_voluntaria(resultSet.getInt("cod_pf_voluntaria"));
				
				disponibilidades.add(disponibilidade);
			}
			
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException e) {
			throw e;
		}
		
		return disponibilidades;
	}
}
