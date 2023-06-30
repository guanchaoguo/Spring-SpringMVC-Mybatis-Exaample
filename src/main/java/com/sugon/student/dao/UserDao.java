package com.sugon.student.dao;

import com.sugon.student.model.User;

import java.util.List;



public interface UserDao {

    List<User> listAllUsers();

    User getUser(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

}

