package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.DisponibilidadePessoaFisica;

public class DisponibilidadeDAO {
	/**
	 * Terminar de salvar no banco
	 * 
	 * @param disponibilidade
	 * @throws SQLException
	 */
	public void criar(DisponibilidadePessoaFisica disponibilidade, Connection connection)
			throws SQLException{
		try {
			PreparedStatement stmt;
			
			String SQL;
			SQL = "INSERT INTO pf_disponibilidade(hora_inicio, hora_fim, dia, periodo_dia, "
					+ "cod_pf_voluntaria) values (?,?,?,?,?)";
			stmt = connection.prepareStatement(SQL);
			
			stmt.setTime(1, java.sql.Time.valueOf(disponibilidade.getHora_inicio()));
			stmt.setTime(2, java.sql.Time.valueOf(disponibilidade.getHora_fim()));
			stmt.setDate(3, java.sql.Date.valueOf(disponibilidade.getDia()));
			stmt.setString(4, disponibilidade.getPeriodo_dia());
			stmt.setInt(5, disponibilidade.getCod_pf_voluntaria());
			System.out.println("passou");
			stmt.executeUpdate();
			System.out.println("atualizou");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<DisponibilidadePessoaFisica> listar(int pessoa, Connection connection) {
		ResultSet resultSet = null;
		PreparedStatement stmt;

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
		}
		return disponibilidades;
}
	
	public void atualizar(DisponibilidadePessoaFisica disponibilidade, Connection connection) {
		try {
			PreparedStatement stmt;

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

		}	
	}

	public void excluir(DisponibilidadePessoaFisica disponibilidade,
			Connection connection) {
		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement("DELETE FROM pf_disponibilidade WHERE id = ?");
			stmt.setLong(1, disponibilidade.getCodigo());

			stmt.executeUpdate();

			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - " + ex);

		} 
	}
}
