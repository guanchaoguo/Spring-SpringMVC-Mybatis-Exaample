package com.sugon.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sugon.student.model.User;
import com.sugon.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public String listAllUsers(Model model) {
        List<User> userList = userService.listAllUsers();
        model.addAttribute("list", userList);
        return "list";
    }

    @ResponseBody
    @RequestMapping(value = "/listUsers", method = {RequestMethod.POST, RequestMethod.GET})
    public Object listAllUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.listAllUsers();
        Map<String, Object> map = new HashMap<>(0);
        map.put("users", userList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getUser", method = {RequestMethod.POST, RequestMethod.GET})
    public Object getUser(Integer id) {
        User user = userService.getUser(id);
        Map<String, Object> map = new HashMap<>(0);
        map.put("user", user);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST, RequestMethod.GET})
    public Object insertUser(User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.saveUser(user);
            result.put("success", true);
            result.put("user", user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/editUser", method = {RequestMethod.POST, RequestMethod.GET})
    public Object editUser(User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.updateUser(user);
            result.put("success", true);
            result.put("user", user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            return result;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = {RequestMethod.POST, RequestMethod.GET})
    public Object deleteUser(Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            userService.deleteUser(id);
            result.put("success", true);
            result.put("userid", id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            return result;
        }
    }

}
