package permissions.db;

import java.util.List;

import permissions.domain.User;

public interface UserRepository extends Repository<User> {
	public List<User> withUsername(String username, PagingInfo page);
	public List<User> withPassword(String password, PagingInfo page);
}
