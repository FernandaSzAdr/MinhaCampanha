package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AtividadeAtribuidaPessoaDAO {
	/**
	 * Recebe os IDs para vincular a tabela,
	 * preencher a data com a data atual (tem um atributo data).
	 * @throws RuntimeException, SQLException 
	 */
	public void criar(int pessoa, int atividade, Connection connection)
			throws RuntimeException, SQLException{		
		PreparedStatement stmt;

		try {
			if (!existe(atividade, connection)) {
				connection.setAutoCommit(false);
				stmt = connection.prepareStatement("INSERT INTO atividade_atribuido_pessoa (id, id_pf, data_atividade)"
						+ "VALUES (?,?,?)");
					stmt.setInt(1, atividade);
					stmt.setInt(2, pessoa);
					stmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
					connection.commit();
			}

		} catch (SQLException|RuntimeException e) {
			connection.rollback();
			e.printStackTrace();
			throw e;				
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
	
	public boolean existe( int atividade, Connection connection){
		ResultSet resultSet = null;
		PreparedStatement stmt;
		boolean resultado = false;
		try {
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement("SELECT * FROM atividade_atribuido_pessoa WHERE id = ?");
			stmt.setInt(1, atividade);
			resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
				resultado = true;
			}
		}catch (SQLException e) {
			//TODO
			return resultado;
		}
		
		return resultado;
	}
}	

