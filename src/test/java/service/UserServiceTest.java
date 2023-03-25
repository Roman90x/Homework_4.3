package service;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    public static final String CORRECT_NAME = "user1";
    public static final User CORRECT_USER = new User(CORRECT_NAME);
    public static final String INCORRECT_NAME = "user123";
    public static final User INCORRECT_USER = new User(INCORRECT_NAME);

    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserServiceImpl out;

    @Test
    public void shouldReturnTrueWhenUserIsExist() {
        when(userDaoMock.getUserByName(eq(CORRECT_NAME)))
                .thenReturn(CORRECT_USER);
        assertTrue(out.checkUserExist(CORRECT_USER));

    }

    @Test
    public void shouldReturnFalseWhenUserIsNotExist() {
        when(userDaoMock.getUserByName(eq(INCORRECT_NAME)))
                .thenReturn(null);
        assertFalse(out.checkUserExist(INCORRECT_USER));
    }
}