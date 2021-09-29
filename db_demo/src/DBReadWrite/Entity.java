package DBReadWrite;


import java.sql.*;

public abstract class Entity {
	int id;
	EntityState state;

public Connection setConnection() {
	try {
		String driver = "org.hsqldb.jdbcDriver";
		Class.forName(driver);
		String url = "jdbc:hsqldb:mem:.";
		String user = "sa";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	catch(SQLException e) {
		System.out.println("Blad podczas nawiazywania polaczenia z baza danych");
		return null;
	}
	catch(ClassNotFoundException e) {
		System.out.println("Blad podczas ladowania sterownika");
		return null;
	}
	
}
}
