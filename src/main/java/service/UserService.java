package service;

import dao.UserDAO;
import model.User;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean checkUserPresence(User user) throws Exception {
        User usr = userDAO.getUserByUserName(user.getUserName());
        return usr != null;
    }
}
