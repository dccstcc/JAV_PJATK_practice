package User;

import Entity.Entity;
import Roles.RolePermissions;
import Roles.UserRole;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

public class User extends Entity {
    private String login, password;
    private Set<UserRole> userRoles;
    private Set<RolePermissions> userPermissions;

    public User(String login, String password) {
        this(login, password,
                new HashSet<UserRole>(), new HashSet<RolePermissions>());
    }
    public User(String login, String password,
                Set<UserRole> userRoles, Set<RolePermissions> userPermissions) {
        this.login = login;
        this.password = password;

        this.userRoles = userRoles;
        this.userPermissions = userPermissions;
    }

    public String getLogin() {
        return this.login;
    }
    public String getPassword() {
        return this.password;
    }
    public Set<UserRole> getUserRoles() {
        return  this.userRoles;
    }
    public Set<RolePermissions> getUserPermissions() {
        return this.userPermissions;
    }

    public void addUserToRole(UserRole role) {
        this.userRoles.add(role);
    }
    public void removeUserFromRole(UserRole role) {
        this.userRoles.remove(role);
    }
    public void addUserPermission(RolePermissions permissions) {
        this.userPermissions.add(permissions);
    }
    public void removeUserPermission(RolePermissions permissions) {
        this.userPermissions.remove(permissions);
    }
}
