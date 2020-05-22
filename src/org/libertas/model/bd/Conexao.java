package org.libertas.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private Connection conexao;
	
	public Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://produtos.cvjfyx7v4opa.us-east-2.rds.amazonaws.com/bdprodutos";
			conexao = DriverManager.getConnection(url, "admin", "47035119");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	
}

