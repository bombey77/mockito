package dao;

import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserDAOMockTest {

    private UserDAO userDAO;

    @Before
    public void setUp() {
        //second way to make mock (first is an annotations: @RunWith(MockitoJUnitRunner.class) - for the class,
        // @Mock - for the variable)
        userDAO = mock(UserDAO.class);
    }

    @Test
    public void getUserByUserNameTest() throws Exception {
        when(userDAO.getUserByUserName("roman@gmail.com"))
                .thenReturn(new User("roman@gmail.com"));

        User expectedUser = new User("roman@gmail.com");
        User actualUser = userDAO.getUserByUserName("roman@gmail.com");
        Assert.assertEquals(expectedUser, actualUser);
        //verifies that mock method getUserByUserName was called 1 time
        verify(userDAO, times(1)).getUserByUserName("roman@gmail.com");
    }

    @Test
    public void findAllUsersTest() throws Exception {
        when(userDAO.findAllUsers())
                .thenReturn(Arrays.asList(
                        new User("roman@gmail.com"),
                        new User("kathy@gmail.com"),
                        new User("kiril@gmail.com")));

        List<User> expectedUsers = Arrays.asList(
                new User("roman@gmail.com"),
                new User("kathy@gmail.com"),
                new User("kiril@gmail.com"));
        Assert.assertEquals(true, userDAO.findAllUsers().containsAll(expectedUsers));
        verify(userDAO, times(1)).findAllUsers();
    }
}
