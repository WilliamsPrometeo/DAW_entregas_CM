package entrega_03.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionAcceso {
    private static final Scanner sc = new Scanner(System.in);


    // main loop
    static void main() {
        int option = 0;
        System.out.println("== ACCESS VALIDATOR ==");
        do {
            try {
                System.out.println(
                        "1. Validate username." +
                        "\n2. Validar password." +
                        "\n3. Exit");

                option = sc.nextInt();
                sc.nextLine();
                switch (option) {

                    // calls username validator and receives boolean
                    case 1:
                        String username_validation = validateUsername() ? "Successful validation" : "Unsuccessful validation";
                        System.out.println(username_validation + "\n");
                        break;
                    // calls password validator and receives boolean
                    case 2:
                        String password_validation = validatePassword() ? "Successful validation" : "Unsuccessful validation";
                        System.out.println(password_validation + "\n");
                        break;
                    case 3:
                        System.out.println("Exiting");
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Option must be an integer.");
                sc.nextLine();
            }
        } while (option != 3);
    }

    // functions that call their respective requesters and catch exceptions
    public static boolean validateUsername() {
        try {

            return requestUsername();

        //
        } catch (InvalidUsernameException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validatePassword() {
        try {

            return requestPassword();

        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //

    // functions that request user input and validate it
    // if input is invalid then an exception is thrown, which the "validator" -
    // functions catch
    public static boolean requestUsername() throws InvalidUsernameException {
        System.out.println("Input username: ");
        String username = sc.nextLine();
        if (username.length() >= 3 && username.matches("[A-Za-z0-9]+")) {
            return true;
        }
        throw new InvalidUsernameException("Invalid username; username must contain only letters and numbers and it's length must be at least 3 characters.");
    }


    public static boolean requestPassword() throws InvalidPasswordException {
        System.out.println("Input password: ");
        String password = sc.nextLine();
        // 0-9 -> password must contain a number || A-Z -> password must contain an uppercase letter
        if (password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")) {
            return true;
        }
        throw new InvalidPasswordException("Invalid password. Password must contain at least 1 number, an uppercase letter and it's length must be at least 6 characters.");
    }
    //
}