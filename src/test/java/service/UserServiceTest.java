package service;

import dao.UserDAO;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDAO userDAO;
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(userDAO);
    }

    @Test
    public void checkUserPresencePositiveTest() throws Exception {
        given(userDAO.getUserByUserName("roman@gmail.com"))
                .willReturn(new User("roman@gmail.com"));

        boolean isPresence = userService.checkUserPresence(new User("roman@gmail.com"));
        Assert.assertEquals(true, isPresence);
//        verifies that method was invoked
        verify(userDAO).getUserByUserName("roman@gmail.com");
    }

    @Test
    public void checkUserPresenceNegativeTest() throws Exception {
        given(userDAO.getUserByUserName("notExistedUser@gmail.com"))
                .willReturn(null);

        boolean isPresence = userService.checkUserPresence(new User("notExistedUser@gmail.com"));
        Assert.assertEquals(false, isPresence);
    }

    @Test(expected = Exception.class)
    public void checkUserPresenceThrowExceptionTest() throws Exception {
//        given(userDAO.getUserByUserName(any(String.class))) -> is the same as next string
        given(userDAO.getUserByUserName(anyString()))
                .willThrow(new Exception());

        userDAO.getUserByUserName("roman@gmail.com");
    }

    @Test
    public void testCaptor() throws Exception {
        given(userDAO.getUserByUserName(anyString()))
                .willReturn(new User("roman@gmail.com"));

        userDAO.getUserByUserName("roman@gmail.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(userDAO).getUserByUserName(captor.capture());
        String argument = captor.getValue();//"roman@gmail.com"

        Assert.assertEquals("roman@gmail.com", argument);
    }
}
