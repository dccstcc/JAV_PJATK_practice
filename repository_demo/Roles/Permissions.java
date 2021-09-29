package Roles;
public enum Permissions {
    Add(1), Delete(2), Edit(3), Other(0);

    private int permissionId;

    private Permissions(int id) {
        this.permissionId = id;
    }

    public int getPermissionId() {
        return this.permissionId;
    }
}
