package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String url = "jdbc:mysql://127.0.0.1:3307/test";
	private final static String user = "root";
	private final static String pass = "example";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
}
