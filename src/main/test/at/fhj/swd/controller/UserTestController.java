package at.fhj.swd.controller;


import at.fhj.swd.config.SpringAppConfig;
import at.fhj.swd.model.User;
import at.fhj.swd.service.UserService;
import at.fhj.swd.web.UserController;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfig.class})
@WebAppConfiguration
public class UserTestController {

    UserController userController;

    @Autowired
    public void setUserController(UserController userController){
        this.userController = userController;
    }


    UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    private static User user1;

    @BeforeClass
    public static void build() {
        user1 = new User(0, "Christopher", "Wegl");
    }

    @Test
    public void A_saveAndFindUser() {
        userController.saveUser(user1);
        User user = userService.find(0);
        Assert.assertEquals(0, user.getId());
    }

    @Test
    public void B_updateUser() {
        User user = new User(0, "Franz", "Schubert");
        userController.updateUser(user);
        User userDB = userService.find(0);
        Assert.assertEquals( 0, userDB.getId());
        Assert.assertEquals( "Franz", userDB.getFirstname() );
        Assert.assertEquals( "Schubert", userDB.getLastname());
    }

    @Test
    public void C_deleteUser() {
        userController.deleteUser(0);
        User user = userService.find(0);
        Assert.assertNull(user);
    }

    @AfterClass
    public static void teardown() {
        user1 = null;
    }

}
