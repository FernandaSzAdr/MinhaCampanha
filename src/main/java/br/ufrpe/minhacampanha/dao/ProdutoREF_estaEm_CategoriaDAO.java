package br.ufrpe.minhacampanha.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.minhacampanha.domain.*;
import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.ProdutoREF;
public class ProdutoREF_estaEm_CategoriaDAO {
	public void criar(ProdutoREF produto, CategoriaProdDAO categoria,
			Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
		try {
			connection.setAutoCommit(false);
			//ProdutoREFDAO.criar( produto, connection,   stmt);
			connection.commit();
			//Categori
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
