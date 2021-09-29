package Roles;

import Entity.Entity;
import Entity.EntityState;

public class UserRole extends Entity {
    private int userId, roleId;

    public UserRole(int id, EntityState state,
                    int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int id) {
        this.userId = id;
    }
    public int getRoleId() {
        return this.roleId;
    }
    public void setRoleId(int id) {
        this.roleId = id;
    }
}
