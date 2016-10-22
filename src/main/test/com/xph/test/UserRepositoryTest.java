package com.xph.test;

import com.xph.web.Application;
import com.xph.web.Repositories.UserRepository;
import com.xph.web.entity.User;
import com.xph.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserRepositoryTest {
   @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    public void find(){
        User user=userService.getid(new Long(1));
        System.out.println("111"+user.getUname()  );
    }

 @Test
    public void findALL(){
       List<User> userList= userRepository.findAll();
        for(User user:userList){
            System.out.println("111"+user.getUname()  );
        }
        ;
    }

    @Test
    public void add(){
        User user=new User();
        user.setUname("33333");
        userService.save(user);
        System.out.println("111"+user.getId() );
    }
}
