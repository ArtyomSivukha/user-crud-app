package controller;

import entity.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.*;

public class UserController {

    private final UserServiceImpl userService;

    public UserController() {
        userService = new UserServiceImpl();
    }

    public ArrayList<User> getUsers() {
        return userService.getAll();
    }

    public User addOne(){
        return userService.addOne();
    }

    public void deleteUser(int num) {
        userService.deleteOne(num);
    }

    public String editUser() {
        return userService.editOne();
    }

    public ArrayList<User> sortUsers() {
        return userService.sort();
    }
}
