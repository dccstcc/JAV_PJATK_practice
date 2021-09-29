package DBReadWrite;

import java.sql.*;

public class RolesPermissions extends Entity{
	int roleId;
	int permissionId;
	
	Connection conn;
	RolesPermissions() {
		conn = setConnection();
	}
	

}
