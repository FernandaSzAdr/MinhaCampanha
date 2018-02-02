package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.omnifaces.util.Messages;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Atividade;
import br.ufrpe.minhacampanha.util.ConnectionFactory;
import java.sql.Date;

public class AtividadeAtribuidaPessoaDAO {
	/**
	 * Recebe os IDs para vincular a tabela,
	 * preencher a data com a data atual (tem um atributo data).
	 */
	public void criar(int pessoa, int atividade)throws SQLException{
	
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;

		
		try {
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement("SELECT data_atividade FROM atividade where id = ?");
			stmt.setInt(1, atividade);
			resultSet =stmt.executeQuery();
			Date data_atividade = null;
			
			while(resultSet.next()) {
				data_atividade = resultSet.getDate("data_atividade");
			}
				
			if(data_atividade != null) {
				stmt = connection.prepareStatement("INSERT INTO atividade_atribuido_pessoa (id, id_pf, data_atividade)"
					+ "VALUES (?,?,?)");
				stmt.setInt(1, pessoa);
				stmt.setInt(2, atividade);
				stmt.setDate(3,data_atividade);
			}
			else {
				connection.rollback();
			}
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw e;
				
			}
		}
	
		
}	

