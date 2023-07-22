package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conecxão {
	public Connection Connection()  {
		
		final String host = "localhost";
		final String port = "3306";
		final String user = "root";
		final String password = "16160";
		
		Connection  conn = null;
		
	try {
		
		String url = "jdbc:Mysql://"+ host+ ":"+ port +"/calc?"+" user="+ user+"&password=" + password;
		conn = DriverManager.getConnection(url);
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Erro de Conecxão\n" + e.getMessage());
		
	
	}
		return conn;
		
	}

	
}
