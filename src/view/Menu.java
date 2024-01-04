package view;

import controller.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private void showMenu() {
        System.out.println("\t\nМеню\n" +
                "1.\tПросмотреть список всех пользователей\n" +
                "2.\tДобавить пользователя \n" +
                "3.\tУдалить пользователь по айди\n" +
                "4.\tРедактировать пользователя по айди\n" +
                "5.\tСортировать пользователей\n" +
                "6.\tВыход из программы\n\n" +
                "\tВведите число\n");
    }

    private void showContextDeleteMenu() {
        System.out.println("Введите айди");
    }

    public void chooseOption() {
        UserController userController = new UserController();
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                showMenu();
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println(userController.getUsers());
                        break;
                    case 2:
                        System.out.println(userController.addUser());
                        break;
                    case 3:
                        showContextDeleteMenu();
                        userController.deleteUser(scanner.nextInt());
                        break;
                    case 4:
                        System.out.println(userController.editUser());
                        break;
                    case 5:
                        System.out.println(userController.sortUsers());
                        break;
                    case 6:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Введите значение в диапозоне 1-5");
                }

                System.out.println("Введите любое число");
                scanner.nextInt();
                System.out.println("\n\n\n\n\n\n");
                System.out.println("\n\n\n\n\n\n");
                System.out.println("\n\n\n\n\n\n");

            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Введите число!");
            }

        }


    }
}
