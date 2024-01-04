package controller;

import entity.User;

import java.util.*;

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

    public User addUser() throws NumberFormatException {
        User user = new User();
        boolean check;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id пользователя:");
        do {
            try {
                Scanner newScanner = new Scanner(System.in);
                int id = newScanner.nextInt();
                user.setId(id);
                check = false;
            } catch (InputMismatchException d) {
                check = true;
                System.out.println("Введите правильный id");
            }
        } while(check);

        System.out.println("Введите имя пользователя:");
        do {
            try {
                Scanner new1Scanner = new Scanner(System.in);
                String firstName = new1Scanner.next();
                if (firstName.matches("^[a-zA-Z]+$")) {
                    user.setFirstName(firstName);
                    check = false;
                } else {
                    throw new NumberFormatException();
                };
            } catch (NumberFormatException d) {
                check = true;
                System.out.println("Введите буквы");
            }
        } while (check);

        System.out.println("Введите фамилию пользователя:");
        user.setSecondName(scanner.next());
        System.out.println("Введите возраст пользователя:");
        user.setAge(scanner.nextInt());
        System.out.println("Введите город проживания пользователя:");
        user.setHometown(scanner.next());
        System.out.println("Введите работу пользователя:");
        user.setJobName(scanner.next());
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

    public boolean isEmptyList() {
        if (users.isEmpty()) {
            System.out.println();
            return true;
        } else {
            System.out.println(getUsers());
            System.out.println("Введите id пользователя которого хотите изменить");
            return false;
        }
    }

    public String editUser() {

        if (isEmptyList()) {
            return "Пользователей не добавлено";
        }
        ;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == num) {
                System.out.println("Введите имя пользователя:");
                users.get(i).setFirstName(scanner.next());
                System.out.println("Введите фамилию пользователя:");
                users.get(i).setSecondName(scanner.next());
                System.out.println("Введите возраст пользователя:");
                users.get(i).setAge(scanner.nextInt());
                System.out.println("Введите город проживания пользователя:");
                users.get(i).setHometown(scanner.next());
                System.out.println("Введите работу пользователя:");
                users.get(i).setJobName(scanner.next());
                return "Вы изменили пользователя";
            }
        }
        return "Пользователя с таким айди нет";
    }

    public ArrayList<User> sortUsers() {
        Collections.sort(users);
        return users;
    }
}
