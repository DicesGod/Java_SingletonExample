package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDBServer {
	
	private static ConnDBServer instance = null;
	private Connection connection = null;
	
	private ConnDBServer() {
		//super();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db1";
			connection  = DriverManager.getConnection(url, "root", "root");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}

	public static ConnDBServer getInstance() {
		try {
			if (instance == null || instance.getConnection().isClosed()) {

				instance = new ConnDBServer();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return instance;
	}


	

}



