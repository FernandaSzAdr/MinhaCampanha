package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class PessoaFisicaDAO {
	/**
	 * Busca a pessoa pelo id de usuario, para poder vincular a pessoa
	 * no LoginBean
	 * @param idUsuario
	 * @throws SQLException 
	 */
	public PessoaFisica buscar(int idUsuario) throws SQLException{		
		PessoaFisica pessoa = new PessoaFisica();
		try {			
			Connection connection = ConnectionFactory.getConnection();
			String SQL = "SELECT * from pessoa_fisica where id_usuario = ?";
			java.sql.PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, idUsuario);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pessoa.setPrimeiro_nome(rs.getString("p_nome"));
				pessoa.setMedio_nome(rs.getString("m_nome"));
				pessoa.setUltimo_nome(rs.getString("u_nome"));
				pessoa.setAnonimato(rs.getInt("anonimato"));
				pessoa.setNascimento(rs.getDate("dt_nasc").toLocalDate());
				pessoa.setTelefone1(rs.getString("num1"));
				pessoa.setTelefone2(rs.getString("num"));
				pessoa.setTipo_pessoa(rs.getString("tipo_pessoa"));
				pessoa.setId_usuario(idUsuario);
				pessoa.setEndereco(rs.getInt("seque_end"));
			}
			
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException erro) {
			throw erro;
		}
		
		return pessoa;
	}
	
	public void criar(PessoaFisica pessoa) {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("INSERT INTO pessoa_fisica (cpf, p_nome, m_nome, u_name, "
					+ "anonimato, dt_nasc, num1, num, tipo_pessoa, seque_end, id_usuario)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getPrimeiro_nome());
			stmt.setString(3, pessoa.getMedio_nome());
			stmt.setString(4, pessoa.getUltimo_nome());
			stmt.setInt(5, pessoa.getAnonimato());
			stmt.setDate(6, pessoa.getNascimento());
			stmt.setString(7, pessoa.getTelefone1());
			stmt.setString(8, pessoa.getTelefone2());
			stmt.setString(9, pessoa.getTipoPessoa());
			stmt.setLong(10, pessoa.getCodigoEndereco());
			stmt.setLong(11, pessoa.getCodigoUsuario());

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);

		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}

	public List<PessoaFisica> listar() {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;

		List<PessoaFisica> pessoas = new ArrayList<PessoaFisica>();

		try {

			stmt = connection.prepareStatement("SELECT * FROM pessoa_fisica");
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				PessoaFisica pessoa = new PessoaFisica();
				pessoa.setCodigo(resultSet.getLong("id"));
				pessoa.setCpf(resultSet.getString("cpf"));
				pessoa.setPrimeiro_nome(resultSet.getString("p_nome"));
				pessoa.setMedio_nome(resultSet.getString("m_nome"));
				pessoa.setUltimo_nome(resultSet.getString("u_nome"));
				pessoa.setAnonimato(resultSet.getInt("anonimato"));
				pessoa.setNascimento(resultSet.getDate("dt_nasc"));
				pessoa.setTelefone1(resultSet.getString("num1"));
				pessoa.setTelefone2(resultSet.getString("num"));
				pessoa.setTipoPessoa(resultSet.getString("tipo_pessoa"));
				pessoa.setCodigoEndereco(resultSet.getLong("seque_end"));
				pessoa.setCodigoUsuario(resultSet.getLong("id_usuario"));

				pessoas.add(pessoa);
			}

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		} finally {
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}

		return pessoas;

	}

	public void atualizar(PessoaFisica pessoa) {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("UPDATE pessoa_fisica SET cpf = ?, p_nome = ?,m_nome = ?,u_nome = ?,"
					+ "anonimato = ?,dt_nasc = ?,num1 = ?,num = ?,tipo_pessoa = ?, seque_end = ?  WHERE id = ?");
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getPrimeiro_nome());
			stmt.setString(3, pessoa.getMedio_nome());
			stmt.setString(4, pessoa.getUltimo_nome());
			stmt.setInt(5, pessoa.getAnonimato());
			stmt.setDate(6, pessoa.getNascimento());
			stmt.setString(7, pessoa.getTelefone1());
			stmt.setString(8, pessoa.getTelefone2());
			stmt.setInt(9, pessoa.getTipoPessoa());
			stmt.setLong(10, pessoa.getCodigoEndereco());
			stmt.setLong(11, pessoa.getCodigo());

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "Cliente atualizado com
			// sucesso");

		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Erro ao atualizar - " + ex);

		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}

	}

	public void excluir(PessoaFisica pessoa) {

		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("DELETE FROM cliente WHERE id = ?");
			stmt.setLong(1, pessoa.getCodigo());

			stmt.executeUpdate();

			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");

		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - " + ex);

		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
}