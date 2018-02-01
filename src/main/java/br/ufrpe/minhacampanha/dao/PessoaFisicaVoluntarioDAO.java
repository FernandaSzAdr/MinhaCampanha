package br.ufrpe.minhacampanha.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.PessoaFisicaVoluntario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class PessoaFisicaVoluntarioDAO {
	public void criar(PessoaFisicaVoluntario pessoa) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try {
			String SQL;
			if (pessoa.getTem_veiculo() == 1) {
				SQL = "INSERT INTO pf_voluntario (id_ps, data_inicio, placa, marca, cidade, estado, tem_veiculo)"
						+ " values (?,?,?,?,?,?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setInt(1, pessoa.getPessoa());
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
				
				stmt.setInt(1, pessoa.getPessoa());
				stmt.setDate(2, java.sql.Date.valueOf(pessoa.getData_inicio()));
				stmt.setInt(3, 1);
			}
			
			stmt.executeUpdate();
			ConnectionFactory.closeConnection(connection, stmt);
		} catch (SQLException e) {
			throw e;
		}
	}
}
