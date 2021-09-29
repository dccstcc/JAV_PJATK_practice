package permissions.db;

public interface RepositoryCatalog {
	
	public PersonRepository people();
	public UserRepository user();
	public AddressRepository address();
	public PermissionRepository permission();
	public RoleRepository role();
}