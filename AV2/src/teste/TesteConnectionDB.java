package teste;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TesteConnectionDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		
		try {
			con = ConnectionFactory.getConnection();
			System.out.println("Connection Sucessifullty");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
