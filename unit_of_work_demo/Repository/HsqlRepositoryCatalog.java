package Repository;

import Entity.EnumerationValue;
import User.User;

import java.util.Set;

public class HsqlRepositoryCatalog implements RepositoryCatalog {
    private DatabaseContext databaseContext = new DatabaseContext();

    @Override
    public Set<EnumerationValue> enumerations() {
        return this.databaseContext.EnumerationValues;
    }

    @Override
    public Set<User> users() {
        return this.databaseContext.Users;
    }
}
