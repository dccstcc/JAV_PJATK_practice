package permissions.db;

import java.util.List;

import permissions.domain.Permission;


public interface PermissionRepository {
	//public List<Permission> withId(int id, PagingInfo page);
	public List<Permission> withName(String name, PagingInfo page);
}
