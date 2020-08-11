package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    User getUserByUserName(String name) throws Exception;

    List<User> findAllUsers() throws Exception;
}
