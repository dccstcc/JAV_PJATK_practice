package Roles;

public enum Roles {
    Admin(0), User(1), Other(-1);

    private int roleId;

    private  Roles(int id) {
        this.roleId = id;
    }

    public int getRoleId() {
        return this.roleId;
    }
}
