package Ejercicios;

import Exceptions.InvalidIdException;
import Exceptions.InvalidPasswordException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionAccesoPlataforma {

     private static final Scanner sc = new Scanner(System.in);

     public static void main(String[] args){menu();}

    public static void menu() {
        int opcion = 0;
        // Bucle do-while para mostrar menu hasta que el usuario eliga la opcion 3, con esto tambien controlamos los inputs númericos fuera de rango
        do {
            try {
                System.out.println("==== GESTIÓN DE ACCESO A LA PLATAFORMA ====");
                System.out.println("1. Validar identificador de acceso" +
                        "\n2. Validar clave de seguridad" +
                        "\n3. Salir");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        String validacion_id = validarId() == null ? "Validación incorrecta\n" : "Validación correcta\n";
                        System.out.println(validacion_id);
                        break;
                    case 2:
                        String validacion_password = validarPassword() == null ? "Validación incorrecta\n" : "Validación correcta\n";
                        System.out.println(validacion_password);
                        break;
                    case 3:
                        System.out.println(".... Saliendo ....\n");
                        break;
                    default:
                        // Enviamos mensaje de error porque el numero esta fuera de rango
                        System.err.println("Número inválido. Introduce solamente numeros del 1-3.\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Introduce solamente números enteros\n");
                sc.nextLine();
            }
        } while (opcion != 3);
    }

    public static String validarId() {
        try {
            return pideId();
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String validarPassword() {
        try {
            return pidePassword();
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String pideId() throws InvalidIdException {
        System.out.print("Introduce el Id: ");
        String id = sc.nextLine();
        if (id.length() >= 3 && id.matches("[A-Za-z0-9]+") && id.matches(".*[0-9].*") && id.matches(".*[A-Za-z].*")) {
            return id;
        }
        throw new InvalidIdException("Id incorrecto. El Id debe tener al menos 3 caracteres y debe contener letras y numeros");
    }

    public static String pidePassword() throws InvalidPasswordException {
        System.out.print("Introduce la contraseña: ");
        String password = sc.nextLine();
        if (password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")) {
            return password;
        }
        throw new InvalidPasswordException("Contraseña incorrecta. La contraseña debe tener una longitud mínima de 6 caracteres, que incluya un número y una mayuscula.");
    }
}