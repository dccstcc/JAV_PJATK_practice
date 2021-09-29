package permissions.db.catalogs;

import java.sql.Connection;

import permissions.db.PermissionRepository;
import permissions.db.PersonRepository;
import permissions.db.RepositoryCatalog;
import permissions.db.RoleRepository;
import permissions.db.UserRepository;
import permissions.db.AddressRepository;
import permissions.db.repos.HsqlPermissionRepository;
import permissions.db.repos.HsqlPersonRepository;
import permissions.db.repos.HsqlRoleRepository;
import permissions.db.repos.HsqlUserRepository;
import permissions.db.repos.HsqlAddressRepository;

public class HsqlRepositoryCatalog implements RepositoryCatalog{

	Connection connection;
	
	public HsqlRepositoryCatalog(Connection connection) {
		this.connection = connection;
	}

	public PersonRepository people() {
		return new HsqlPersonRepository(connection);
	}
		
	public AddressRepository address(){
		return new HsqlAddressRepository(connection);
	}

	public UserRepository user() {
		return new HsqlUserRepository(connection);
	}

	public PermissionRepository permission() {
		return new HsqlPermissionRepository(connection);
	}

	public RoleRepository role() {
		return new HsqlRoleRepository(connection);
	}
	

}