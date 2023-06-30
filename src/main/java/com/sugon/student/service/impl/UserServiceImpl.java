package com.sugon.student.service.impl;


import java.util.List;

import com.sugon.student.dao.UserDao;
import com.sugon.student.model.User;
import com.sugon.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        userDao.updateUser(user);
        return userDao.getUser(user.getUserId());
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

}