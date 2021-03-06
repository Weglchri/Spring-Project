package at.fhj.swd.sequence;

import at.fhj.swd.dao.UserDao;
import at.fhj.swd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SequenceGenerator {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int generateId() {
        List<User> users = userDao.findAll();
        int size = userDao.findAll().size();
        if(size == 0){
            return 0;
        }else{
            int lastpos = size - 1;
            int id = users.get(lastpos).getId();
            return id + 1;
        }
    }
}
