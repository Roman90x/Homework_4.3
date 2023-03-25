package dao;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserDaoTest {
    public static final User CORRECT_USER = new User("user1");
    public static final User INCORRECT_USER = new User("user123");

    private final UserDao out = new UserDaoImpl();

    @Test
    public void shouldReturnUserWhenUserIsExist() {
        assertEquals(CORRECT_USER, out.getUserByName(CORRECT_USER.getName()));
    }

    @Test
    public void shouldReturnNullWhenUserIsNotExist() {
        assertNull(out.getUserByName(INCORRECT_USER.getName()));
    }
}
