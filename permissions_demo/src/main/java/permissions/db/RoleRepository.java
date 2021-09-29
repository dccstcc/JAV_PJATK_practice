package permissions.db;

import java.util.List;

import permissions.domain.Role;

public interface RoleRepository extends Repository<Role> {
	//public List<Role> withId(int id, PagingInfo page);
	public List<Role> withName(String name, PagingInfo page);
}
