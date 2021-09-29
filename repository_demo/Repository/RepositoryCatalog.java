package Repository;

import Entity.EnumerationValue;
import User.User;

import java.util.Set;

public interface RepositoryCatalog {
    Set<EnumerationValue> enumerations();
    Set<User> users();
}
