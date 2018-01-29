package br.ufrpe.minhacampanha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {
	
	private Connection con = null;
	private Statement stm = null;
	private String servidor = "jdbc:mysql://localhost:3306/clinicapetcenter";
	private String usuario = "root";
	private String senha = "";
	private String driver = "com.mysql.jdbc.Driver";
	
	public Connection abrirBDCon(){
		try {
			
			Class.forName(driver);
			this.con = DriverManager.getConnection(servidor,usuario,senha);
			this.stm = con.createStatement();
			//.showMessageDialog(null, "Conexão aberta");
		}
		catch(ClassNotFoundException cnf) {
			//JOptionPane.showMessageDialog(null, cnf.getMessage());
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Erro ao abrir com o banco!");
		}
		return con;
	}
	
	public boolean estaConectado(){
		if(this.con != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void fecharBDCon() {
		try {
			con.close();
			//JOptionPane.showMessageDialog(null, "Conexao finalizada!");
		} catch (SQLException sql) {
			//JOptionPane.showMessageDialog(null, "Falha na finalização da conexão!");
		}
	}
}