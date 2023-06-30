package com.sugon.student.service;

import com.sugon.student.model.User;

import java.util.List;

public interface UserService {

    List<User> listAllUsers();

    User getUser(Integer id);

    void saveUser(User user);

    User updateUser(User user);

    void deleteUser(Integer id);

}