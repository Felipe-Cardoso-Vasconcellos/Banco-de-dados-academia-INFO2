package com.mycompany.academia.dao.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

public class Conexao {
	private static String url = "jdbc:postgresql://200.18.128.54/aula";
	private static String usuario = "aula";
	private static String senha = "aula";
	
	private static Connection minhaconexao = null;

	public static Connection getConexao() {
		try {
		if (Conexao.minhaconexao == null) {
			Conexao.minhaconexao = DriverManager.getConnection(url, usuario, senha);
		} 
		return minhaconexao;
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Erro de conexão:" + ex.getMessage());
		}
                return null;
	}
}
