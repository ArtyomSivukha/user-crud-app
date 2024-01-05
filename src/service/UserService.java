package service;

import entity.User;

import java.util.ArrayList;

public interface UserService {
    ArrayList<User> getAll();
    User addOne();
    void deleteOne(int num);
    String editOne();
    ArrayList<User> sort();
}
