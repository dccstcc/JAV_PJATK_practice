package Repository;

import Entity.EnumerationValue;
import Roles.RolePermissions;
import Roles.UserRole;
import User.User;

import java.util.HashSet;
import java.util.Set;

public class DatabaseContext {
    public Set<User> Users = new HashSet<>();
    public Set<EnumerationValue> EnumerationValues = new HashSet<>();
    public Set<UserRole> Roles = new HashSet<>();
    public Set<RolePermissions> RolePermissions = new HashSet<>();
    public void SaveChanges() { /* operacje na bazie */ }
}
