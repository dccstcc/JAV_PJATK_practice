package DBReadWrite;

import java.sql.*;

public class CreateTables {
	
	String t_sys_enums_create1 = "create table t_sys_enums (id integer primary key, role_uprawnienia varchar(30))";
	String t_sys_enums_insert11 = "insert into t_sys_enums values (1, \'projektant\')";
	String t_sys_enums_insert12 = "insert into t_sys_enums values (2, \'wlasciciel\')";
	String t_sys_enums_insert13 = "insert into t_sys_enums values (3, \'administrator\')";
	String t_sys_enums_insert14 = "insert into t_sys_enums values (4, \'moderator\')";
	String t_sys_enums_insert15 = "insert into t_sys_enums values (5, \'uzytkownik\')";
	String t_sys_enums_insert16 = "insert into t_sys_enums values (6, \'unlimited\')";
	String t_sys_enums_insert17 = "insert into t_sys_enums values (7, \'write_and_read\')";
	String t_sys_enums_insert18 = "insert into t_sys_enums values (8, \'read_only\')";

	String t_sys_users_create1 = "create table t_sys_users (id integer primary key, imie varchar(30), nazwisko varchar(30))";
	String t_sys_users_insert11 = "insert into t_sys_users values (1, \'Jan\', \'Kowalski\')";
	String t_sys_users_insert12 = "insert into t_sys_users values (2, \'Karol\', \'Nowak\')";
	String t_sys_users_insert13 = "insert into t_sys_users values (3, \'Andrzej\', \'Matejko\')";

	String t_sys_roles_create1 = "create table t_sys_roles (id integer primary key, t_sys_users_id integer, t_sys_enums_id integer)";
	String t_sys_roles_insert11 = "insert into t_sys_roles values (1, 1, 1)";
	String t_sys_roles_insert12 = "insert into t_sys_roles values (2, 2, 5)";
	
	String t_sys_permissions_create1 = "create table t_sys_permissions (id integer primary key, t_sys_users_id integer, t_sys_enums_id integer)";
	String t_sys_permissions_insert11 = "insert into t_sys_permissions values (1, 1, 6)";
	String t_sys_permissions_insert12 = "insert into t_sys_permissions values (2, 2, 8)";

	
	
	CreateTables() {
		Connection conn = setConnection();
		try {
		Statement stat = conn.createStatement();
		stat.execute(t_sys_enums_create1);
		stat.execute(t_sys_enums_insert11);
		stat.execute(t_sys_enums_insert12);
		stat.execute(t_sys_enums_insert13);
		stat.execute(t_sys_enums_insert14);
		stat.execute(t_sys_enums_insert15);
		stat.execute(t_sys_enums_insert16);
		stat.execute(t_sys_enums_insert17);
		stat.execute(t_sys_enums_insert18);
		
		stat.execute(t_sys_users_create1);
		stat.execute(t_sys_users_insert11);
		stat.execute(t_sys_users_insert12);
		stat.execute(t_sys_users_insert13);
		
		stat.execute(t_sys_roles_create1);
		stat.execute(t_sys_roles_insert11);
		stat.execute(t_sys_roles_insert12);
		
		stat.execute(t_sys_permissions_create1);
		stat.execute(t_sys_permissions_insert11);
		stat.execute(t_sys_permissions_insert12);
		
		stat.close();
		}
		catch(SQLException e) {
			System.out.println("Nieprawidlowe polecenie createStatement");
			e.printStackTrace();
		}
	}
	
	public Connection setConnection() {
		try {
			String driver = "org.hsqldb.jdbcDriver";
			Class.forName(driver);
			String url = "jdbc:hsqldb:mem:.";
			String user = "SA";
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
