
package at.fhj.swd.app;

import at.fhj.swd.config.SpringAppConfig;
import at.fhj.swd.dao.UserDao;
import at.fhj.swd.service.UserService;
import at.fhj.swd.web.UserController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfig.class})
@WebAppConfiguration
public class ApplicationTests {


    DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

	@Test
	public void contextLoads() {
        Assert.assertTrue(dataSource instanceof DataSource);
        Assert.assertTrue(userDao instanceof UserDao);
        Assert.assertTrue(userService instanceof UserService);
        Assert.assertTrue(userController instanceof UserController);
	}

}
