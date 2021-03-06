package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Instituicao_receptora;
/**
 * 
 * @author raiss
 *
 */
public class Instituicao_receptoraDAO {
	
	public void criar(Instituicao_receptora instituicao,
			Connection connection) throws SQLException{
		try{
			PreparedStatement stmt = null;

			String SQL;
			if (instituicao.getDt_ultima_recep() == null && instituicao.getNum_doacoes_recebi() == 0) {
				SQL = "INSERT INTO instituicao_receptora (id_recep) values(?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setInt(1, instituicao.getCodigo());
			} else if (instituicao.getDt_ultima_recep() == null) {
				SQL = "INSET INTO instituicao_receptora (id_recep, dt_ultima_recep)"
						+ "values (?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setInt(1, instituicao.getCodigo());
				stmt.setDate(2, java.sql.Date.valueOf(instituicao.getDt_ultima_recep()));
			} else if (instituicao.getNum_doacoes_recebi() == 0) {
				SQL = "INSERT INTO instituicao_receptora (id_recep, num_doacoes_recebi) values(?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setInt(1, instituicao.getCodigo());
				stmt.setInt(2, instituicao.getNum_doacoes_recebi());
			}
			
			stmt.executeUpdate();
		}catch (SQLException ex){
			throw ex;
		}
	}
	
	public List<Instituicao_receptora> listar(Connection connection) 
			throws SQLException {
		ResultSet rs = null;
		PreparedStatement stmt;
		List<Instituicao_receptora> instituicaos = new ArrayList<Instituicao_receptora>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Instituicao_receptora JOIN Instituicao "
					+ "ON Instituicao_receptora.id_recep = Instituicao.id");
			rs =stmt.executeQuery();
			while (rs.next()){
				Instituicao_receptora instituicao = new Instituicao_receptora();
				instituicao.setCodigo(rs.getInt("id_recep"));
				instituicao.setDt_ultima_recep(rs.getDate("dt_ultima_recep").toLocalDate());
				instituicao.setNum_doacoes_recebi(rs.getInt("num_doacoes_recebi"));
				instituicao.setCnpj(rs.getString("cnpj"));
				instituicao.setData_entrada(rs.getDate("data_entrada").toLocalDate());
				instituicao.setRamo_atuacao(rs.getString("ramo_atuacao"));
				instituicao.setRazao_social(rs.getString("razao_social"));
				instituicao.setNome_fantasia(rs.getString("nome_fantasia"));
				instituicao.setEmail_geral_instituicao(rs.getString("email"));
				instituicao.setTelefone1(rs.getString("tele1"));
				instituicao.setTelefone2(rs.getString("tele2"));
				instituicao.setNome_contato(rs.getString("nome_contato"));
				instituicao.setId_inst_S(Integer.toString(rs.getInt("id_recep")));
			
				instituicaos.add(instituicao);
			 }
			
		}catch (SQLException ex){
			throw ex;
		}
		return instituicaos;
		
	}
	
	public void update(Instituicao_receptora instituicao,
			Connection connection) throws SQLException{
		PreparedStatement stmt;

		try{
			stmt = connection.prepareStatement("UPDATE Instituicao_receptora SET   dt_ultima_recep = ?	,"
					+ "num_doacoes_recebi = ? WHERE cod = ?");
		
			
			stmt.setDate(1, java.sql.Date.valueOf(instituicao.getDt_ultima_recep()));
			stmt.setInt(2, instituicao.getNum_doacoes_recebi());
			stmt.setInt(3, instituicao.getCodigo());	
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}
	}
	
	public void excluir(Instituicao_receptora instituicao,
			Connection connection) throws SQLException{
		PreparedStatement stmt;

		try{
			stmt = connection.prepareStatement("DELETE FROM Instituicao_receptora WHERE id = ?");
			stmt.setInt(1, instituicao.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}
	}
	
	public boolean buscar(Instituicao instituicao,
			Connection connection) throws SQLException{
		ResultSet rs = null;
		PreparedStatement stmt;
		boolean retorno = false;
		try {
			stmt = connection.prepareStatement("SELECT * FROM instituicao_receptora WHERE id_recep = ?");
			stmt.setInt(1, instituicao.getCodigo());
			rs = stmt.executeQuery();
			
			if(rs.next()) retorno = true;
			
		} catch (SQLException e) {
			throw e;
		}
		return retorno;
	}
}
