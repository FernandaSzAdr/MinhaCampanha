package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.PessoaFisica;

public class PessoaFisicaDAO {
	
	public PessoaFisica buscar(int codigo, Connection connection)
			throws SQLException{		
		PreparedStatement stmt;

		PessoaFisica pessoa = new PessoaFisica();
		try {			
			String SQL = "SELECT * from pessoa_fisica where id = ?";
			stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, codigo);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pessoa.setCodigo(rs.getInt("id"));
				pessoa.setPrimeiro_nome(rs.getString("p_nome"));
				pessoa.setMedio_nome(rs.getString("m_nome"));
				pessoa.setUltimo_nome(rs.getString("u_nome"));
				pessoa.setAnonimato(rs.getInt("anonimato"));
				pessoa.setNascimento(rs.getDate("dt_nasc").toLocalDate());
				pessoa.setTelefone1(rs.getString("num1"));
				pessoa.setTelefone2(rs.getString("num"));
				pessoa.setTipo_pessoa(rs.getString("tipo_pessoa"));
				pessoa.setId_usuario(rs.getInt("id_usuario"));
				pessoa.setEndereco(rs.getInt("seque_end"));
				pessoa.setCpf(rs.getString("cpf"));
			}
			
		} catch (SQLException erro) {
			erro.printStackTrace();
			throw erro;
		}
		
		return pessoa;
	}
	
	
	/**
	 * Busca a pessoa pelo id de usuario, para poder vincular a pessoa
	 * no LoginBean
	 * @param idUsuario
	 * @throws SQLException 
	 */
	public PessoaFisica buscar(String cpf, Connection connection) 
			throws SQLException{		
		PreparedStatement stmt;
		PessoaFisica pessoa = new PessoaFisica();
		try {			
			String SQL = "SELECT * from pessoa_fisica where cpf = ?";
			stmt = connection.prepareStatement(SQL);
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pessoa.setCodigo(rs.getInt("id"));
				pessoa.setPrimeiro_nome(rs.getString("p_nome"));
				pessoa.setMedio_nome(rs.getString("m_nome"));
				pessoa.setUltimo_nome(rs.getString("u_nome"));
				pessoa.setAnonimato(rs.getInt("anonimato"));
				pessoa.setNascimento(rs.getDate("dt_nasc").toLocalDate());
				pessoa.setTelefone1(rs.getString("num1"));
				pessoa.setTelefone2(rs.getString("num"));
				pessoa.setTipo_pessoa(rs.getString("tipo_pessoa"));
				pessoa.setId_usuario(rs.getInt("id_usuario"));
				pessoa.setEndereco(rs.getInt("seque_end"));
				pessoa.setCpf(rs.getString("cpf"));
			}
			
		} catch (SQLException erro) {
			erro.printStackTrace();
			throw erro;
		}
		
		return pessoa;
	}
	
	public void criar(PessoaFisica pessoa, Connection connection) 
			throws SQLException {
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement("INSERT INTO pessoa_fisica (cpf, p_nome, m_nome, u_nome, "
					+ "anonimato, dt_nasc, num1, num, tipo_pessoa, seque_end, id_usuario)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getPrimeiro_nome());
			stmt.setString(3, pessoa.getMedio_nome());
			stmt.setString(4, pessoa.getUltimo_nome());
			stmt.setInt(5, pessoa.isAnonimato());
			stmt.setDate(6, java.sql.Date.valueOf(pessoa.getNascimento()));
			stmt.setString(7, pessoa.getTelefone1());
			stmt.setString(8, pessoa.getTelefone2());
			stmt.setString(9, pessoa.getTipo_pessoa());
			stmt.setInt(10, pessoa.getEndereco());
			stmt.setInt(11, pessoa.getId_usuario());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public List<PessoaFisica> listar(Connection connection) {
		ResultSet resultSet = null;
		PreparedStatement stmt;

		List<PessoaFisica> pessoas = new ArrayList<PessoaFisica>();

		try {
			stmt = connection.prepareStatement("SELECT * FROM pessoa_fisica");
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				PessoaFisica pessoa = new PessoaFisica();
				pessoa.setCodigo(resultSet.getInt("id"));
				pessoa.setCpf(resultSet.getString("cpf"));
				pessoa.setPrimeiro_nome(resultSet.getString("p_nome"));
				pessoa.setMedio_nome(resultSet.getString("m_nome"));
				pessoa.setUltimo_nome(resultSet.getString("u_nome"));
				pessoa.setAnonimato(resultSet.getInt("anonimato"));
				pessoa.setNascimento(resultSet.getDate("dt_nasc").toLocalDate());
				pessoa.setTelefone1(resultSet.getString("num1"));
				pessoa.setTelefone2(resultSet.getString("num"));
				pessoa.setTipo_pessoa(resultSet.getString("tipo_pessoa"));
				pessoa.setEndereco(resultSet.getInt("seque_end"));
				pessoa.setId_usuario(resultSet.getInt("id_usuario"));

				pessoas.add(pessoa);
			}

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}
		return pessoas;

	}

	public void atualizar(PessoaFisica pessoa, Connection connection) {
		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement("UPDATE pessoa_fisica SET cpf = ?, p_nome = ?,m_nome = ?,u_nome = ?,"
					+ "anonimato = ?,dt_nasc = ?,num1 = ?,num = ?,tipo_pessoa = ?, seque_end = ?  WHERE id = ?");
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getPrimeiro_nome());
			stmt.setString(3, pessoa.getMedio_nome());
			stmt.setString(4, pessoa.getUltimo_nome());
			stmt.setInt(5, pessoa.getAnonimato());
			stmt.setDate(6,java.sql.Date.valueOf(pessoa.getNascimento()) );
			stmt.setString(7, pessoa.getTelefone1());
			stmt.setString(8, pessoa.getTelefone2());
			stmt.setString(9, pessoa.getTipo_pessoa());
			stmt.setLong(10, pessoa.getEndereco());
			stmt.setLong(11, pessoa.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao atualizar - " + ex);

		}

	}

	public void excluir(PessoaFisica pessoa, Connection connection) {
		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement("DELETE FROM pessoa_fisica WHERE id = ?");
			stmt.setLong(1, pessoa.getCodigo());

			stmt.executeUpdate();

			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - " + ex);

		} 
	}
}