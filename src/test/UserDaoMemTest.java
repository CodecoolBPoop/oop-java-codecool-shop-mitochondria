import com.codecool.shop.dao.UsersDao;
import com.codecool.shop.dao.implementation.UsersDaoMem;
import com.codecool.shop.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class UserDaoMemTest {

    private UsersDao userDao = UsersDaoMem.getTestInstance();
    private Users testUser1 = new Users("testName1", "email", "address", "city", "state", 1000);
    private Users testUser2 = new Users("testName2", "email", "address", "city", "state", 1000);


    @BeforeEach
    void clearTestDao() {
        for (int i = 0; i < 10; i++) {
            userDao.remove(i);
        }
    }


    @Test
    void testAdd() {

        userDao.add(testUser1);
        userDao.add(testUser2);

        List<Users> testUsers = Arrays.asList(testUser1, testUser2);

        assertEquals(userDao.getAll(), testUsers);
    }


    @Test
    void testFindById() {

        testUser1.setId(1);
        userDao.add(testUser1);
        userDao.add(testUser2);

        assertEquals(userDao.find(1), testUser1);
    }


    @Test
    void testRemoveById() {

        testUser1.setId(1);
        userDao.add(testUser1);
        userDao.remove(1);

        assertNull(userDao.find(1));
    }


    @Test
    void testGetAll() {

        userDao.add(testUser1);
        userDao.add(testUser2);

        List<Users> testUsers = Arrays.asList(testUser1, testUser2);

        assertEquals(userDao.getAll(), testUsers);
    }
}
