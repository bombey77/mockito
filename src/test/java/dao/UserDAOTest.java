package dao;

import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

//Unit tests
public class UserDAOTest {

    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = new UserDAOImpl();
    }

    @Test
    public void getUserByUserNamePositiveTest() throws Exception {
        User expectedUser = new User("roman@gmail.com");
        User actualUser = userDAO.getUserByUserName(expectedUser.getUserName());
        Assert.assertEquals(true, !Objects.isNull(actualUser));
        Assert.assertEquals(expectedUser.getUserName(), actualUser.getUserName());
    }

    @Test
    public void getUserByUserNameNegativeTest() throws Exception {
        User expectedUser = userDAO.getUserByUserName("timur@gmail.com");
        Assert.assertEquals(true, Objects.isNull(expectedUser));
    }

    @Test
    public void checkUserContainsTest() throws Exception {
        User expectedUser = new User("roman@gmail.com");
        List<User> users = userDAO.findAllUsers();

        Assert.assertEquals(true, users.contains(expectedUser));
    }
}
