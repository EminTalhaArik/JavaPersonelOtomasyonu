package Management;

import java.sql.*;

public class DBConnection {

	public Connection connect() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3325/personel-takip-sistemi?user=root&password=12345");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

}
