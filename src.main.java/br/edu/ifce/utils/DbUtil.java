package br.edu.ifce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection connection;
	
	public static Connection getConnection() {
		
		if(connection != null) {
			return connection;
		} else {
			String url = "jdbc:mysql://localhost:3301/clientes";
			String uname = "root";
			String pwd = "Familha1";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, uname, pwd);
				System.out.println("Conexão concluida");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		return connection;
	}

}
