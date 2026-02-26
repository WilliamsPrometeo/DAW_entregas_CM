package daw.entregas;

import daw.entregas.accesoException;
import daw.entregas.ClaveException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionPlataforma {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { menu(); }

    public static void menu() {
        int prueba = 0;
        do {
            try {
                System.out.println("==== GESTIÓN DE PLATAFORMA ====");
                System.out.println("1. Validar identificador de acceso" +
                        "\n2. Validar clave de seguridad" +
                        "\n3. Salir");
                prueba = sc.nextInt();
                sc.nextLine();
                switch (prueba) {
                    case 1:
                        String validacion_acceso = validaracceso() != null ? "Validación correcta" : "Validación incorrecta";
                        System.out.println(validacion_acceso);
                        break;
                    case 2:
                        String validacion_clave = validarclave() != null ? "Validación correcta" : "Validación incorrecta";
                        System.out.println(validacion_clave);
                        break;
                    case 3:
                        System.out.println("Salir");
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La opcion tiene que ser numerica para continuar.");
                sc.nextLine();
            }
        } while (prueba != 3);
    }

    public static String validaracceso() {
        try {
            String acceso= pideacceso();
            return acceso;
        } catch (accesoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String validarclave() {
        try {
            String clave = pideclave();
            return clave;
        } catch (ClaveException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

public static String pideacceso() throws accesoException {
    System.out.println("Introuce el numero de acceso: ");
    String acceso = sc.nextLine();
    if (acceso.length() >= 3 && acceso.matches("[A-Za-z0-9]+")) {
        return acceso;
    }
    throw new accesoException("Acceso denegado.");
}

public static String pideclave() throws ClaveException {
    System.out.println("Introduce la clave de seguridad: ");
    String clave = sc.nextLine();
    if (clave.length() >= 6 && clave.matches(".*[0-9].*") && clave.matches(".*[A-Za-z].*")) {
        return clave;
    }
    throw new ClaveException("Clave erronea, intentelo de nuevo");
    }
}





