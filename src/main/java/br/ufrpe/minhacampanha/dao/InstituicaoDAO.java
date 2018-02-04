package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.Instituicao;
/**
 * 
 * @author raiss
 *
 */
public class InstituicaoDAO {
	public Instituicao buscar(int codigo,Connection connection) throws SQLException{
		Instituicao instituicao = new Instituicao();
		PreparedStatement stmt;
		try {			
			String SQL = "SELECT * FROM instituicao WHERE id = ?";
			stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, codigo);
			
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
		} catch (SQLException erro) {
			throw erro;
		}
		
		return instituicao;
	}
	
	
	public Instituicao buscar(String cnpj,
			Connection connection) throws SQLException{
		PreparedStatement stmt;
		Instituicao instituicao = new Instituicao();
		try {			
			String SQL = "SELECT * FROM instituicao WHERE cnpj = ?";
			stmt = connection.prepareStatement(SQL);
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
			
		} catch (SQLException erro) {
			throw erro;
		}
		
		return instituicao;
	}
	
	public void criar(Instituicao instituicao,
			Connection connection) throws SQLException {
		try {
			PreparedStatement stmt;
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
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;

		} 
	}

	public List<Instituicao> listar(Connection connection) 
			throws SQLException{
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Instituicao");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Instituicao instituicao = new Instituicao();

				instituicao.setCodigo(resultSet.getInt("id"));
				instituicao.setCnpj(resultSet.getString("cnpj"));
				instituicao.setData_entrada(resultSet.getDate("data_entrada").toLocalDate());
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
			throw ex;
		}		
		return instituicoes;
	}

	public void atualizar(Instituicao Instituicao,
			Connection connection) throws SQLException {
		PreparedStatement stmt;
		try {
			stmt = connection
					.prepareStatement("UPDATE Instituicao SET telefone = ?, nomeCli = ?, email = ? WHERE cpf = ?");

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Instituicao atualizado com
			// sucesso");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);

		}

	}

	public void excluir(Instituicao instituicao,
			Connection connection) throws SQLException {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM instituicao WHERE id = ?");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);

		}
	}
}
