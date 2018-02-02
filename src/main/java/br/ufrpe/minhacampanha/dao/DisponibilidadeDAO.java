package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Track;

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
			
			stmt.setTime(1, java.sql.Time.valueOf(disponibilidade.getHora_inicio()));
			stmt.setTime(2, java.sql.Time.valueOf(disponibilidade.getHora_fim()));
			stmt.setDate(3, java.sql.Date.valueOf(disponibilidade.getDia()));
			stmt.setBoolean(4,disponibilidade.isDia_de_semana());
			stmt.setBoolean(5,disponibilidade.isInd_feriado());
			stmt.setBoolean(6, disponibilidade.isConfirmacao_dia());
			stmt.setString(7, disponibilidade.getPeriodo_dia());
			System.out.println(disponibilidade.getCod_pf_voluntaria());
			stmt.setInt(8, disponibilidade.getCod_pf_voluntaria());
			
			stmt.execute();
			System.out.println("atualizou");
			ConnectionFactory.closeConnection(connection, stmt);
			System.out.println("fechou");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<DisponibilidadePessoaFisica> listar(int pessoa) {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;

		List<DisponibilidadePessoaFisica> disponibilidades = new ArrayList<DisponibilidadePessoaFisica>();

		try {

			stmt = connection.prepareStatement("SELECT * from pf_disponibilidade "
					+ "where cod_pf_voluntaria = ?");
			resultSet = stmt.executeQuery();
			stmt.setInt(1, pessoa);

			while (resultSet.next()) {
				DisponibilidadePessoaFisica disponibilidade = new DisponibilidadePessoaFisica();
				
				disponibilidade.setCodigo(resultSet.getInt("id"));
				disponibilidade.setConfirmacao_dia(resultSet.getBoolean("confirmacao_dia"));
				disponibilidade.setCod_pf_voluntaria(resultSet.getInt("cod_pf_voluntaria"));
				disponibilidade.setDia(resultSet.getDate("dia").toString());
				disponibilidade.setDia_de_semana(resultSet.getBoolean("dia_de_semana"));
				disponibilidade.setHora_fim(resultSet.getTime("hora_fim").toString());
				disponibilidade.setHora_inicio(resultSet.getTime("hora_inicio").toString());
				disponibilidade.setInd_feriado(resultSet.getBoolean("ind_feriado"));
				disponibilidade.setPeriodo_dia(resultSet.getString("periodo_dia"));

				disponibilidades.add(disponibilidade);
			}

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		} finally {
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		return disponibilidades;
}
	
	public void atualizar(DisponibilidadePessoaFisica disponibilidade) {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("UPDATE  pf_disponibilidade SET \r\n" + 
					"    hora_inicio	=?,\r\n" + 
					"  hora_fim = ?,\r\n" + 
					" dia= ?, dia_semana = ?,\r\n" + 
					"ind_feriado = ?,\r\n" + 
					"  confirmacao_dia = ?,\r\n" + 
					" periodo_dia = ?,\r\n" + 
					" cod_pf_voluntaria = ?  WHERE id = ?");
			
			stmt.setTime(1, java.sql.Time.valueOf(disponibilidade.getHora_inicio()));
			stmt.setTime(2, java.sql.Time.valueOf(disponibilidade.getHora_fim()));
			stmt.setDate(3, java.sql.Date.valueOf(disponibilidade.getDia()));
			stmt.setBoolean(4,disponibilidade.isDia_de_semana());
			stmt.setBoolean(5,disponibilidade.isInd_feriado());
			stmt.setBoolean(6, disponibilidade.isConfirmacao_dia());
			stmt.setString(7, disponibilidade.getPeriodo_dia());
			stmt.setInt(8, disponibilidade.getCod_pf_voluntaria());
			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Cliente atualizado com
			// sucesso");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao atualizar - " + ex);

		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}

	}

	public void excluir(DisponibilidadePessoaFisica disponibilidade) {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("DELETE FROM pf_disponibilidade WHERE id = ?");
			stmt.setLong(1, disponibilidade.getCodigo());

			stmt.executeUpdate();

			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - " + ex);

		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
}
