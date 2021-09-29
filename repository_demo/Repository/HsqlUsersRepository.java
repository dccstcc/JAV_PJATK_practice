package Repository;

import Entity.EntityState;
import Entity.EnumerationValue;
import Roles.RolePermissions;
import Roles.UserRole;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class HsqlUsersRepository implements UserRepository {
    private DatabaseContext databaseContext = new DatabaseContext();

    @Override
    public User withLogin(String login) {
        User value = null;
        for(User v : this.databaseContext.Users)
            if(v.getLogin() == login)
                value = v;

        return value;
    }

    @Override
    public User withLoginAndPassword(String login, String password) {
        User value = null;
        for(User v : this.databaseContext.Users)
            if(v.getLogin() == login && v.getPassword() == password)
                value = v;

        return value;
    }

    @Override
    public void setupPermissions(User user) {
       for(UserRole role : user.getUserRoles())
           user.addUserPermission(new RolePermissions(
                   0, EntityState.New, user.getId(), role.getRoleId()
           ));
    }

    @Override
    public Object getById(int id) {
        User value = null;
        for(User v : this.databaseContext.Users)
            if(value.getId() == id)
                value = v;

        return value;
    }

    @Override
    public void add(Object o) {
        this.databaseContext.Users.add((User)o);
        this.databaseContext.SaveChanges();

    }

    @Override
    public void delete(Object o) {
        this.databaseContext.Users.remove((User) o);
        this.databaseContext.SaveChanges();
    }

    @Override
    public void modify(Object o) {
        for(User v : this.databaseContext.Users)
            if(((User)o).getId() == v.getId())
                v.setEntityState(EntityState.Modified);
        this.databaseContext.SaveChanges();
    }

    @Override
    public int count() {
        return this.databaseContext.Users.size();
    }

    @Override
    public List allOnPage(PagingInfo page) {
        List<User> values = new ArrayList<>();

        for(User v : this.databaseContext.Users)
            if(values.size() < page.getPageSize())
                values.add(v);

        return values;
    }
}
