package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Carro;
import br.ufrpe.minhacampanha.domain.PessoaFisicaVoluntario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class PessoaFisicaVoluntarioDAO {
	public void criar(PessoaFisicaVoluntario pessoa) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try {
			String SQL;
			if (pessoa.getTem_veiculo()) {
				SQL = "INSERT INTO pf_voluntario (id_ps, data_inicio, placa, marca, cidade, estado, tem_veiculo)"
						+ " values (?,?,?,?,?,?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setInt(1, pessoa.getId_ps());
				stmt.setDate(2, java.sql.Date.valueOf(pessoa.getData_inicio()));
				stmt.setString(3, pessoa.getCarro().getPlaca());
				stmt.setString(4, pessoa.getCarro().getMarca());
				stmt.setString(5, pessoa.getCarro().getCidade());
				stmt.setString(6, pessoa.getCarro().getEstado());
				stmt.setInt(7, 1);
			}else {
				SQL = "INSERT INTO pf_voluntario (id_ps, data_inicio, tem_veiculo)"
						+ " values (?,?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setInt(1, pessoa.getId_ps());
				stmt.setDate(2, java.sql.Date.valueOf(pessoa.getData_inicio()));
				stmt.setInt(3, 1);
			}
			
			stmt.executeUpdate();
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public List<PessoaFisicaVoluntario> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<PessoaFisicaVoluntario> pessoas = new ArrayList<PessoaFisicaVoluntario>();
		
		try{
			
			stmt = connection.prepareStatement("SELECT * FROM pf_voluntario");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
			
				PessoaFisicaVoluntario pessoa = new PessoaFisicaVoluntario();
				Carro car = new Carro();
				car.setCidade(resultSet.getString("cidade"));
				car.setEstado(resultSet.getString("estado"));
				car.setMarca(resultSet.getString("marca"));
				car.setPlaca(resultSet.getString("placa"));
				pessoa.setCarro(car);
				pessoa.setCodigo(resultSet.getInt("codigo"));;
				pessoa.setData_fim(resultSet.getDate("data_fim").toLocalDate());
				pessoa.setData_inicio(resultSet.getDate("data_inicio").toLocalDate());
				pessoa.setId_ps(resultSet.getInt("id_ps"));
				
				
				pessoas.add(pessoa);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return pessoas;
		
	}
	
	public void updateCarro(PessoaFisicaVoluntario pessoa) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE pf_voluntario SET cidade = ?, estado = ?, placa = ?,marca = ?"
					+ ", tem_veiculo = ? WHERE cod = ?");
			stmt.setString(1, pessoa.getCarro().getCidade());
			stmt.setString(2, pessoa.getCarro().getEstado());
			stmt.setString(3, pessoa.getCarro().getPlaca());
			stmt.setString(4, pessoa.getCarro().getMarca());
			stmt.setBoolean(5, true);		
			
			stmt.executeUpdate();
		
		}catch (SQLException ex){
			throw ex;
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	/**
	 * Remove o carro da Pessoa
	 * @param pessoa
	 * @throws SQLException
	 */
	public void removeCarro(PessoaFisicaVoluntario pessoa) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE pf_voluntario SET cidade = ?, estado = ?, placa = ?,marca = ?"
					+ ", tem_veiculo = ? WHERE cod = ?");
			stmt.setString(1, null);
			stmt.setString(2, null);
			stmt.setString(3, null);
			stmt.setString(4, null);
			stmt.setBoolean(5, false);		
			
			stmt.executeUpdate();
			
		}catch (SQLException ex){
			throw ex;
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(PessoaFisicaVoluntario pessoa) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM pf_voluntario WHERE cod = ?");
			stmt.setLong(1, pessoa.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	/**
	 * Cata a pessoa no banco, dado seu codigo (REF pessoa fisica)
	 * @param cod
	 * @return
	 * @throws SQLException
	 */
	public PessoaFisicaVoluntario catar(int cod ) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		PessoaFisicaVoluntario pessoa = new PessoaFisicaVoluntario();
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM pf_voluntario WHERE cod = ?");
			stmt.setInt(1, cod);
			
			resultSet =stmt.executeQuery();
			
			
			
			while (resultSet.next()){
				pessoa.setData_fim(resultSet.getDate("data_fim").toLocalDate());
				pessoa.setData_inicio(resultSet.getDate("data_inicio").toLocalDate());
				pessoa.setId_ps(resultSet.getInt("cod"));
				pessoa.setTem_veiculo(resultSet.getBoolean("tem_veiculo"));
				if(pessoa.getTem_veiculo()) {
					Carro carro = new Carro();
					carro.setCidade(resultSet.getString("cidade"));
					carro.setEstado(resultSet.getString("estado"));
					carro.setMarca(resultSet.getString("marca"));
					carro.setPlaca(resultSet.getString("placa"));
					pessoa.setCarro(carro);
				}
					
			}
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		return pessoa;
	}
}
