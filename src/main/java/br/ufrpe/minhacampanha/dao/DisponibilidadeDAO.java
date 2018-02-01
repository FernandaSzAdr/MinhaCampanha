package br.ufrpe.minhacampanha.dao;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.DisponibilidadePessoaFisica;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class DisponibilidadeDAO {
	public void criar(DisponibilidadePessoaFisica disponibilidade) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try {
			String SQL;
			SQL = "INSERT INTO pf_disponibilidade (hora_inicio, hora_fim, dia, dia_semana, ind_feriado, "
					+ "confirmacao_dia, periodo_dia, cod_pf_voluntaria) values (?,?,?,?,?,?,?,?)";
		
			stmt = connection.prepareStatement(SQL);
			
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("hh:mm:ss");
			LocalTime hora_in = disponibilidade.getHora_inicio();
			hora_in.format(formatador);
			LocalTime hora_fim = disponibilidade.getHora_fim();
			hora_fim.format(formatador);
			
			stmt.setTime(1, java.sql.Time.valueOf(hora_in));
			stmt.setTime(2, java.sql.Time.valueOf(hora_fim));
			//stmt.setDate(3, x);
			
			stmt.executeUpdate();
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException e) {
			throw e;
		}
	}
}
