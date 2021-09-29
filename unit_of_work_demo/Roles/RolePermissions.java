package Roles;

import Entity.Entity;
import Entity.EntityState;

public class RolePermissions extends Entity {
    private int roleId, permissionId;

    public RolePermissions(int id, EntityState state,
                           int permissionId, int roleId) {
        super(id, state);
        this.permissionId = permissionId;
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return this.permissionId;
    }
    public void setPermissionId(int id) {
        this.permissionId = id;
    }
    public int getRoleId() {
        return this.roleId;
    }
    public void setRoleId(int id) {
        this.roleId = id;
    }
}
