package br.ufrpe.minhacampanha.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class InstituicaoDAO {
	public void criar(Instituicao instituicao) throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("INSERT INTO Instituicao (id, cnpj, data_entrada, "
					+ "ramo_atuacao, razao_social, nome_fantasia, email, tele1, tele2, nome_contato"
					+ "id_usuario)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setLong(1, instituicao.getCodigo());
			stmt.setString(2, instituicao.getCnpj());
			stmt.setDate(3, instituicao.getData_entrada());
			stmt.setString(4, instituicao.getRamo_atuacao());
			stmt.setString(5, instituicao.getRazao_social());
			stmt.setString(6, instituicao.getNome_fantasia());
			stmt.setString(7, instituicao.getEmail_geral_instituicao());
			stmt.setString(8, instituicao.getTelefone1());
			stmt.setString(9, instituicao.getTelefone2());
			stmt.setString(10, instituicao.getNome_contato());

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Instituicao salvo com
			// sucesso");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);

		} finally {
			//ConnectionFactory.closeConnection(connection, stmt);
		}
	}

	public List<Instituicao> listar(){
		Connection connection = ConnectionFactory.getConnection();
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();

		try {

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Instituicao");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Instituicao instituicao = new Instituicao();

				instituicao.setCodigo(resultSet.getLong("id"));
				instituicao.setCnpj(resultSet.getString("cnpj"));
				instituicao.setData_entrada(resultSet.getDate("data_entrada"));
				instituicao.setRamo_atuacao(resultSet.getString("ramo_atuacao"));
				instituicao.setRazao_social(resultSet.getString("razao_social"));
				instituicao.setNome_fantasia(resultSet.getString("nome_fantasia"));
				instituicao.setEmail_geral_instituicao(resultSet.getString("email"));
				instituicao.setTelefone1(resultSet.getString("tele1"));
				instituicao.setTelefone2(resultSet.getString("tele2"));
				instituicao.setNome_contato(resultSet.getString("nome_contato"));

				instituicoes.add(instituicao);
			}

		} catch (SQLException ex) {
			System.out.println(ex);
			// JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		} finally {
			//ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		return instituicoes;
	}

	public void atualizar(Instituicao Instituicao) throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection
					.prepareStatement("UPDATE Instituicao SET telefone = ?, nomeCli = ?, email = ? WHERE cpf = ?");

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Instituicao atualizado com
			// sucesso");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);

		} finally {
			//ConnectionFactory.closeConnection(connection, stmt);
		}

	}

	public void excluir(Instituicao instituicao) throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("DELETE FROM instituicao WHERE id = ?");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);

		} finally {
			//ConnectionFactory.closeConnection(connection, stmt);
		}

	}
}
