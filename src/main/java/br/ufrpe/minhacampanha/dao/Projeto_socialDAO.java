package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.ProjetoSocial;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class Projeto_socialDAO {
	public void criar(ProjetoSocial projeto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO PROJETO_SOCIAL (tipo, nome, objetivo, descricao, data_inicio, "
					+ "data_fim,id_inst, qtd_volunt_atual, qtd_volunt_nec)VALUES(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, projeto.getTipo());
			stmt.setString(2, projeto.getNome());
			stmt.setString(3, projeto.getObjetivo());
			stmt.setString(4, projeto.getDescricao());
			stmt.setDate(5, java.sql.Date.valueOf(projeto.getData_inicio()));
			stmt.setDate(6, java.sql.Date.valueOf(projeto.getData_fim()));
			stmt.setInt(7, projeto.getId_inst());
			stmt.setInt(8, projeto.getQtd_volunt_atual());
			stmt.setInt(9, projeto.getQtd_volunt_nec());
			
			//JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<ProjetoSocial> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<ProjetoSocial> projetos = new ArrayList<ProjetoSocial>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM projeto_social");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				ProjetoSocial projeto = new ProjetoSocial();
				projeto.setCodigo(resultSet.getInt("cod"));
				projeto.setData_fim(resultSet.getDate("data_fim").toLocalDate());
				projeto.setData_inicio(resultSet.getDate("data_inicio").toLocalDate());
				projeto.setDescricao(resultSet.getString("descricao"));
				projeto.setId_inst(resultSet.getInt("id_inst"));
				projeto.setNome(resultSet.getString("nome"));
				projeto.setObjetivo(resultSet.getString("objetivo"));
				projeto.setQtd_volunt_atual(resultSet.getInt("qtd_volunt_atual"));
				projeto.setQtd_volunt_nec(resultSet.getInt("qtd_volunt_nec"));
				projeto.setTipo(resultSet.getString("tipo"));
				
				projetos.add(projeto);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return projetos;
		
	}
	
	public void update(ProjetoSocial projeto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE PROJETO_SOCIAL SET  tipo = ?,nome = ?,objetivo = ?,"
					+ "descricao = ?,data_inicio = ?,data_fim = ?	"
					+ ",qtd_volunt_atual = ?, qtd_volunt_nec = ?,");
			stmt.setString(1, projeto.getTipo());
			stmt.setString(2, projeto.getNome());
			stmt.setString(3, projeto.getObjetivo());
			stmt.setString(4, projeto.getDescricao());
			stmt.setDate(5, java.sql.Date.valueOf(projeto.getData_inicio()));
			stmt.setDate(6, java.sql.Date.valueOf(projeto.getData_fim()));
			stmt.setInt(7, projeto.getQtd_volunt_atual());
			stmt.setInt(8, projeto.getQtd_volunt_nec());
		
			
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(ProjetoSocial projeto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM projeto_social WHERE cod = ?");
			stmt.setLong(1, projeto.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
}
