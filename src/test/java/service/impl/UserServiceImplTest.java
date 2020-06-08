package service.impl;

import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import java.util.List;


/**
 * Created by zwl on 2017/9/6.
 * May god bless me
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {
    @Autowired
  private UserService userService;
    @Test
    public void  accessTest(){
        User u=new User();
        u.setUsername("test");
        u.setPassword("test");
        u.setPhone("15638520435");
        User access = userService.access(u);
        System.out.println(access.getId());
    }
    @Test
    public void  getCountTest(){
        int allUserNumber = userService.getAllTNumber();
        System.out.println(allUserNumber);
    }
    @Test
    public void  deleteTest(){
        int allUserNumber =  userService.removeT("3");
        System.out.println(allUserNumber);
    }
    @Test
    public void  getAllUserTest(){
        List<User> allUser = userService.getAllT(0, 0, "1 = 1");
        allUser.stream().forEach(user -> {
            System.out.println(user.getId());
        });
    }

}
