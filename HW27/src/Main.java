import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //todo Тут протестить работу метода
            System.out.println("Введите логин: ");
            String login = new Scanner(System.in).nextLine();
            System.out.println("Введите пароль: ");
            String password = new Scanner(System.in).nextLine();
            System.out.println("Подтвердите пароль: ");
            String confirmPassword = new Scanner(System.in).nextLine();

            confirmPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    //todo тут создать метод confirmPassword()
    public static boolean confirmPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches("^.{0,19}$")) {
            throw new WrongLoginException("Логин больше 20 символов!");
        }
        if (!password.matches("^[a-zA-Z0-9_]{1,19}$")) {
            throw new WrongPasswordException("Password должен содержать только латинские буквы, цифры " +
                    "и знак подчеркивания. Длина password должна быть меньше 20 символов. ");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Паорли не совпадают!");
        }
        return true;
    }
}