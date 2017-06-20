package at.fhj.swd.dao;

import at.fhj.swd.config.SpringAppConfig;
import at.fhj.swd.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfig.class})
@WebAppConfiguration
public class UserTestData {


    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private static User user1;
    private static User user2;
    private static User user3;

    @BeforeClass
    public static void build() {
        user1 = new User(0, "Christopher", "Wegl");
        user2 = new User(1, "Johann", "Strauß");
        user3 = new User(2, "Wolfgang", "Mozart");
    }

    @Test
    public void A_insert() {
        userDao.create(user1);
        userDao.create(user2);
        userDao.create(user3);
    }

    @Test
    public void B_find() {
        User userDB = userDao.find(0);
        Assert.assertEquals( 0, userDB.getId());
        Assert.assertEquals( "Christopher", userDB.getFirstname() );
        Assert.assertEquals( "Wegl", userDB.getLastname());
    }

    @Test
    public void C_findAll() {
        List<User> users = userDao.findAll();
        Assert.assertEquals(3, users.size());
        Assert.assertEquals( 0, users.get(0).getId());
        Assert.assertEquals( 1, users.get(1).getId());
        Assert.assertEquals( 2, users.get(2).getId());
    }

    @Test
    public void D_update() {
        user1 = new User(0, "Franz", "Schubert");
        userDao.update(user1);
        User userDB = userDao.find(0);
        Assert.assertEquals( 0, userDB.getId());
        Assert.assertEquals( "Franz", userDB.getFirstname() );
        Assert.assertEquals( "Schubert", userDB.getLastname());
    }

    @Test
    public void E_delete() {
        userDao.remove(0);
        userDao.remove(1);
        userDao.remove(2);
        User userDB = userDao.find(0);
        Assert.assertNull(userDB);
    }

    @AfterClass
    public static void teardown() {
        user1 = null;
        user2 = null;
        user3 = null;
    }

}
