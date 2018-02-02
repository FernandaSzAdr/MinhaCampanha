package br.ufrpe.minhacampanha.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Endereco;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class EnderecoDAO {
	public void salvar(Endereco endereco) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try {
			String SQL;
			if (endereco.getPonto_ref().isEmpty()) {
				SQL = "INSERT INTO endereco (cep, nome, numero, estado, cidade, "
						+ "bairro, tipo_logrado) VALUES(?,?,?,?,?,?,?)";
				stmt = connection.prepareCall(SQL);
				
				stmt.setString(1, endereco.getCep());
				stmt.setString(2, endereco.getNome());
				stmt.setString(3, endereco.getNumero());
				stmt.setString(4, endereco.getEstado());
				stmt.setString(5, endereco.getCidade());
				stmt.setString(6, endereco.getBairro());
				stmt.setString(7, endereco.getTipo_logradoro());
			} else {
				SQL = "INSERT INTO endereco (cep, nome, numero, estado, cidade, "
						+ "bairro, ponto_ref, tipo_logrado) VALUES (?,?,?,?,?,?,?,?)";
				stmt = connection.prepareCall(SQL);
				
				stmt.setString(1, endereco.getCep());
				stmt.setString(2, endereco.getNome());
				stmt.setString(3, endereco.getNumero());
				stmt.setString(4, endereco.getEstado());
				stmt.setString(5, endereco.getCidade());
				stmt.setString(6, endereco.getBairro());
				stmt.setString(7, endereco.getPonto_ref());
				stmt.setString(8, endereco.getTipo_logradoro());
			}
			
			stmt.executeUpdate();
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public Endereco buscar(String cep) throws SQLException{
		Endereco endereco = new Endereco();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String SQL = "SELECT * from endereco where cep = ?";
			java.sql.PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setString(1, cep);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				endereco.setCodigo(rs.getInt("sequencial"));
			}
			
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException erro) {
			throw erro;
		}
		
		return endereco;
	}
	
	/**
	 * Buscar endereço de pessoa
	 * 
	 * @param codigo
	 * @return
	 * @throws SQLException
	 */
	public List<Endereco> buscar(int codigo) throws SQLException{
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		Endereco endereco = new Endereco();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String SQL = "SELECT * from endereco where sequencial = ?";
			java.sql.PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, codigo);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				endereco.setCodigo(rs.getInt("sequencial"));
				endereco.setCep(rs.getString("cep"));
				endereco.setNome(rs.getString("nome"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setPonto_ref(rs.getString("ponto_ref"));
				endereco.setTipo_logradoro(rs.getString("tipo_logrado"));
			}
			
			enderecos.add(endereco);
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException erro) {
			throw erro;
		}
		
		return enderecos;
	}
	
	/**
	 * TODO
	 * Listar endereços de instituição
	 * @return
	 */
	public List<Endereco> listar()throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM instituicao_tem_endereco ");
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				Endereco end = new Endereco();
				end.setBairro(resultSet.getString("bairro"));
				end.setCep(resultSet.getString("cep"));
				end.setCidade(resultSet.getString("cidade"));
				end.setCodigo(resultSet.getInt("codigo"));
				end.setEstado(resultSet.getString("estado"));
				end.setNome(resultSet.getString("nome"));
				end.setNumero(resultSet.getString("numero"));
				end.setPonto_ref(resultSet.getString("ponto_ref"));
				end.setTipo_logradoro(resultSet.getString("tipo_logradoro"));
				
				enderecos.add(end);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return enderecos;
	}
	
	public void atualizar(){
		
	}
}
