package com.xph.web.service;

import com.xph.web.Repositories.UserRepository;
import com.xph.web.annotation.TargetDataSource;
import com.xph.web.config.datasource.DbKey;
import com.xph.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */
@Service
@TargetDataSource(DbKey.READ)
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @TargetDataSource(DbKey.READ)
    @Order(1)
    public User getid(  long id){
        return userRepository.findOne(id);
    }
    @TargetDataSource(DbKey.WRITE)
    //@Transactional(rollbackOn = Exception.class)
    public void save(User user){
        userRepository.save(user);
    }





}
