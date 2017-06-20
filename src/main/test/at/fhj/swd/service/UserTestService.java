package at.fhj.swd.service;

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
public class UserTestService {

    UserService userService;

    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
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
    public void A_save() {
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
    }

    @Test
    public void B_load() {
        User userSV = userService.find(0);
        Assert.assertEquals( 0, userSV.getId());
        Assert.assertEquals( "Christopher", userSV.getFirstname());
        Assert.assertEquals( "Wegl", userSV.getLastname());
    }

    @Test
    public void C_loadAll() {
        List<User> users = userService.findAll();
        Assert.assertEquals(3, users.size());
        Assert.assertEquals( 0, users.get(0).getId());
        Assert.assertEquals( 1, users.get(1).getId());
        Assert.assertEquals( 2, users.get(2).getId());
    }

    @Test
    public void D_change() {
        user1 = new User(0, "Franz", "Schubert");
        userService.change(user1);
        User userSV = userService.find(0);
        Assert.assertEquals( 0, userSV.getId());
        Assert.assertEquals( "Franz", userSV.getFirstname() );
        Assert.assertEquals( "Schubert", userSV.getLastname());
    }

    @Test
    public void E_delete() {
        userService.delete(0);
        userService.delete(1);
        userService.delete(2);
        User userSV = userService.find(0);
        Assert.assertNull(userSV);
    }

    @AfterClass
    public static void teardown() {
        user1 = null;
        user2 = null;
        user3 = null;
    }

}
