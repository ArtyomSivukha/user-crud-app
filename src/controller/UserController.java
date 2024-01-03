package controller;

import entity.User;

import java.util.ArrayList;

public class UserController {
    ArrayList<User> users;

    public UserController() {
        users = new ArrayList<User>();
    }

    @Override
    public String toString() {
        return "UserController{" +
                "users=" + users +
                '}';
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User addUser() {
        User user = new User(1, "Alex", "Gread",
                18, "Minsk", "HuiSosat");
        users.add(user);
        return user;
    }

    public void deleteUser(int num) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == num) {
                users.remove(i);
            }
        }
    }

    public String editUser(int num) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == num) {
            users.get(i).setId(3);
            users.get(i).setFirstName("Sasha");
            users.get(i).setSecondName("Blaer");
            users.get(i).setAge(34);
            users.get(i).setHometown("Lida");
            users.get(i).setJobName("GovnoSosat1");
            }
        }
        return "Вы изменили пользователя";
    }

}
