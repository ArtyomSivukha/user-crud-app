package service;

import entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

    private ArrayList<User> users;

    private final String INPUT_USER_ID_MESSAGE = "Введите id пользователя:";
    private final String INPUT_USER_NAME_MESSAGE = "Введите имя пользователя:";
    private final String INPUT_LETTERS_ERROR_MESSAGE = "Введите буквы";
    private final String INPUT_NUMBERS_ERROR_MESSAGE = "Введите цифры";
    private final String INPUT_POSITIVE_NUMBERS_ERROR_MESSAGE = "Введите положительное число";
    private final String INPUT_USER_SECONDNAME_MESSAGE = "Введите фамилию пользователя:";
    private final String INPUT_USER_AGE_MESSAGE = "Введите возраст пользователя:";
    private final String INPUT_USER_AGE_LESS_THEN_100_MESSAGE = "Введите возраст меньше 100 лет";
    private final String INPUT_USER_HOMETOWN_MESSAGE = "Введите город проживания пользователя:";
    private final String INPUT_USER_JOB_MESSAGE = "Введите работу пользователя:";
    private final String INPUT_USER_ID_TO_EDIT_MESSAGE = "Введите id пользователя которого хотите изменить";
    private final String NO_USERS_MESSAGE = "Пользователей не добавлено";
    private final String SUCCESSFUL_EDIT_MESSAGE = "Вы изменили пользователя";
    private final String NO_SUCH_USER_WITH_ID_MESSAGE = "Пользователя с таким id нет";
    private final String PATTERN_LETTERS = "^[a-zA-Zа-яА-Я]+$";
    private final int MAX_AGE = 100;
    private final int MIN_AGE = 0;

    public UserServiceImpl() {
        users = new ArrayList<User>();
    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }

    @Override
    public User addOne() throws NumberFormatException {
        User user = new User();

        System.out.println(INPUT_USER_ID_MESSAGE);
        user.setId(inputPositiveInt());

        System.out.println(INPUT_USER_NAME_MESSAGE);
        user.setFirstName(inputCorectString());

        System.out.println(INPUT_USER_SECONDNAME_MESSAGE);
        user.setSecondName(inputCorectString());

        System.out.println(INPUT_USER_AGE_MESSAGE);
        user.setAge(inputCorrectAge());

        System.out.println(INPUT_USER_HOMETOWN_MESSAGE);
        user.setHometown(inputCorectString());

        System.out.println(INPUT_USER_JOB_MESSAGE);
        user.setJobName(inputCorectString());

        users.add(user);
        return user;
    }

    @Override
    public void deleteOne(int num) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == num) {
                users.remove(i);
            }
        }
    }

    @Override
    public String editOne() {
        if (isEmptyList()) {
            return NO_USERS_MESSAGE;
        }
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == num) {
                System.out.println(INPUT_USER_NAME_MESSAGE);
                users.get(i).setFirstName(inputCorectString());
                System.out.println(INPUT_USER_SECONDNAME_MESSAGE);
                users.get(i).setSecondName(inputCorectString());
                System.out.println(INPUT_USER_AGE_MESSAGE);
                users.get(i).setAge(inputCorrectAge());
                System.out.println(INPUT_USER_HOMETOWN_MESSAGE);
                users.get(i).setHometown(inputCorectString());
                System.out.println(INPUT_USER_JOB_MESSAGE);
                users.get(i).setJobName(inputCorectString());
                return SUCCESSFUL_EDIT_MESSAGE;
            }
        }
        return NO_SUCH_USER_WITH_ID_MESSAGE;
    }

    @Override
    public ArrayList<User> sort() {
        Collections.sort(users);
        return users;

    }

    private int inputPositiveInt() {
        boolean checked;
        int inputResult = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                inputResult = scanner.nextInt();
                if (inputResult < 1) {
                    throw new IllegalArgumentException();
                }
                checked = false;
            } catch (InputMismatchException e) {
                System.out.println(INPUT_NUMBERS_ERROR_MESSAGE);
                checked = true;
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_POSITIVE_NUMBERS_ERROR_MESSAGE);
                checked = true;
            }
        } while (checked);

        return inputResult;
    }

    private int inputCorrectAge() {
        int temp = inputPositiveInt();
        while (temp > MAX_AGE) {
            System.out.println(INPUT_USER_AGE_LESS_THEN_100_MESSAGE);
            temp = inputPositiveInt();
        }
        return temp;
    }

    private String inputCorectString() {
        boolean checked;
        String string = "";
        do {
            try {
                Scanner newScanner = new Scanner(System.in);
                string = newScanner.next();
                if (string.matches(PATTERN_LETTERS)) {
                    checked = false;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                checked = true;
                System.out.println(INPUT_LETTERS_ERROR_MESSAGE);
            }
        } while (checked);
        return string;
    }

    public boolean isEmptyList() {
        if (users.isEmpty()) {
            System.out.println();
            return true;
        } else {
            System.out.println(getAll());
            System.out.println(INPUT_USER_ID_TO_EDIT_MESSAGE);
            return false;
        }
    }
}
