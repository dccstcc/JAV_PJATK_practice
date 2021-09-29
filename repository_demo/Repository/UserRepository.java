package Repository;

import User.User;

public interface UserRepository extends Repository {
    User withLogin(String login);
    User withLoginAndPassword(String login, String password);
    void setupPermissions(User user);
}
