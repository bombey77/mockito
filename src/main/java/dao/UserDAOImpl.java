package dao;

import model.User;

import java.util.Arrays;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private List<User> users;

    public UserDAOImpl() {
        users = Arrays.asList(
                new User("roman@gmail.com", "ADMIN"),
                new User("kathy@gmail.com", "USER"),
                new User("kiril@gmail.com", "GUEST")
        );
    }

    public User getUserByUserName(String name) throws Exception {
        return users.stream()
                .filter(u -> u.getUserName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> findAllUsers() throws Exception {
        return users;
    }
}
