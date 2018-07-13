package br.ufrpe.minhacampanha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.minhacampanha.domain.Entrega;

public class EntregaDAO {
	public List<Entrega> listar(Connection connection) throws SQLException{
		ResultSet resultSet = null;
		
		List<Entrega> entregas = new ArrayList<Entrega>();
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement("SELECT * FROM entrega LEFT JOIN doc_protocolo ON entrega.id = doc_protocolo.id_entrega");
			resultSet = stmt.executeQuery();
			while (resultSet.next()){
				Entrega entrega = new Entrega();
				entrega.setCodigo(resultSet.getInt("id"));
				if(resultSet.getDate("data_entrega") != null){
					entrega.setData_entrega(resultSet.getDate("data_entrega").toString());
				}else {
					entrega.setData_entrega("");
				}
				
				entrega.setStatus_entrega(resultSet.getString("status_entrega"));
				entrega.setHora_agendada(resultSet.getTime("hora_agendada").toString());
				entrega.setObservacao(resultSet.getString("obs"));
				entrega.setData_agendada(resultSet.getDate("data_agendada").toString());
				entrega.setId_receptora(resultSet.getInt("id_receptora"));
				entrega.setId_voluntario(resultSet.getInt("id_voluntario"));
				entrega.setCod_ponto_coleta(resultSet.getInt("cod_ponto_coleta"));
				
				entrega.setNum_doc(resultSet.getInt("doc_protocolo.num_doc"));
				entrega.setNum_protocolo(resultSet.getInt("doc_protocolo.num_protocolo"));
				entrega.setArquivo_protocolo(resultSet.getString("doc_protocolo.arquivo_protocolo"));
				entrega.setDesc_protocolo(resultSet.getString("doc_protocolo.desc_protocolo"));
				if (resultSet.getDate("doc_protocolo.data_geracao_protocolo") != null ) {
					entrega.setData_geracao_protocolo(resultSet.getDate("doc_protocolo.data_geracao_protocolo").toString());
				}
		
				entregas.add(entrega);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return entregas;
	}
	
	public List<Entrega> listarAtivas (Connection connection) throws SQLException{
		ResultSet resultSet = null;
		
		List<Entrega> entregas = new ArrayList<Entrega>();
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement("SELECT * FROM entrega WHERE status_entrega != 'entregue'");
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()){
				Entrega entrega = new Entrega();
				
				entrega.setCodigo(resultSet.getInt("id"));
				entrega.setId_S(Integer.toString(resultSet.getInt("id")));
				
				entregas.add(entrega);
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
		
		return entregas;
	}
	
	public void cadastrar(Connection connection, Entrega entrega) throws SQLException{
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO entrega (status_entrega,  "
					+ "hora_agendada, obs, data_agendada, id_receptora, id_voluntario,"
					+ "cod_ponto_coleta) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, entrega.getStatus_entrega());
			stmt.setTime(2, java.sql.Time.valueOf(entrega.getHora_agendada()));
			stmt.setString(3, entrega.getObservacao());
			stmt.setDate(4, java.sql.Date.valueOf(entrega.getData_agendada()));
			stmt.setInt(5, entrega.getId_receptora());
			stmt.setInt(6, entrega.getId_voluntario());
			stmt.setInt(7, entrega.getCod_ponto_coleta());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void atualizar(Connection connection, Entrega entrega) throws SQLException{
		try {
			String sql = "UPDATE entrega SET status_entrega = ?, data_entrega = ? WHERE id=?";
			
		    PreparedStatement ps = connection.prepareStatement(sql);
		    ps.setString(1, entrega.getStatus_entrega());
		    ps.setDate(2, java.sql.Date.valueOf(entrega.getData_entrega()));
		    ps.setInt(3, entrega.getCodigo());
		    
		    ps.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		   throw ex;
		}
	}
}