package br.ufrpe.minhacampanha.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.util.ConnectionFactory;
/**
 * 
 * @author raiss
 *
 */
public class InstituicaoDAO {
	
	public Instituicao buscar(String cnpj) throws SQLException{
		Instituicao instituicao = new Instituicao();
		try {			
			Connection connection = ConnectionFactory.getConnection();
			String SQL = "SELECT * FROM instituicao WHERE cnpj = ?";
			java.sql.PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setString(1, cnpj);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				instituicao.setCodigo(rs.getInt("id"));
				instituicao.setCnpj(rs.getString("cnpj"));
				instituicao.setData_entrada(rs.getDate("data_entrada").toLocalDate());
				instituicao.setRamo_atuacao(rs.getString("ramo_atuacao"));
				instituicao.setRazao_social(rs.getString("razao_social"));
				instituicao.setNome_fantasia(rs.getString("nome_fantasia"));
				instituicao.setEmail_geral_instituicao(rs.getString("email"));
				instituicao.setTelefone1(rs.getString("tele1"));
				instituicao.setTelefone2(rs.getString("tele2"));
				instituicao.setNome_contato(rs.getString("nome_contato"));
			}
			
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException erro) {
			throw erro;
		}
		
		return instituicao;
	}
	
	public void criar(Instituicao instituicao) throws SQLException {
		try {
			Connection connection = ConnectionFactory.getConnection();
			java.sql.PreparedStatement stmt = null;
			
			if (!instituicao.getTelefone2().isEmpty()) {
				stmt = connection.prepareStatement("INSERT INTO Instituicao (cnpj, data_entrada, "
						+ "ramo_atuacao, razao_social, nome_fantasia, email, tele1, tele2, nome_contato)"
						+ "VALUES(?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, instituicao.getCnpj());
				stmt.setDate(2, java.sql.Date.valueOf(instituicao.getData_entrada()));
				stmt.setString(3, instituicao.getRamo_atuacao());
				stmt.setString(4, instituicao.getRazao_social());
				stmt.setString(5, instituicao.getNome_fantasia());
				stmt.setString(6, instituicao.getEmail_geral_instituicao());
				stmt.setString(7, instituicao.getTelefone1());
				stmt.setString(8, instituicao.getTelefone2());
				stmt.setString(9, instituicao.getNome_contato());
			}else{
				stmt = connection.prepareStatement("INSERT INTO Instituicao (cnpj, data_entrada, "
						+ "ramo_atuacao, razao_social, nome_fantasia, email, tele1, nome_contato)"
						+ "VALUES(?,?,?,?,?,?,?,?)");
				stmt.setString(1, instituicao.getCnpj());
				stmt.setDate(2, java.sql.Date.valueOf(instituicao.getData_entrada()));
				stmt.setString(3, instituicao.getRamo_atuacao());
				stmt.setString(4, instituicao.getRazao_social());
				stmt.setString(5, instituicao.getNome_fantasia());
				stmt.setString(6, instituicao.getEmail_geral_instituicao());
				stmt.setString(7, instituicao.getTelefone1());
				stmt.setString(8, instituicao.getNome_contato());
			}

			stmt.executeUpdate();
			
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;

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
