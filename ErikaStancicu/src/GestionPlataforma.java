import Ejemplo_gestionUsuarios.InvalidPasswordException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionPlataforma {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { menu();}

    public static void menu() {
        int opcion = 0;

        //este bucle se repetira, mientras no se eliga la opción 3.
        do {
            try {
                //menú
                System.out.println("==== GESTIÓN DE PLATAFORMA ====");
                System.out.println("1. Validar identificador de acceso" +
                        "\n2. Validar clave de seguridad" +
                        "\n3. Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                //bucle de opciones
                switch (opcion) {
                    case 1:
                        String validacion_identificador = validaridentificador() != null ? "Validación correcta" : "Validación incorrecta";
                        System.out.println(validacion_identificador);
                        break;
                    case 2:
                        String validacion_clave = validarclave() != null ? "Validación correcta" : "Validación incorrecta";
                        System.out.println(validacion_clave);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                }
            //si la opción no es numerica, se lanza el mensaje de error.
            } catch (InputMismatchException e) {
                System.out.println("!La opcion tiene que ser numerica!");
                sc.nextLine();
            }
        } while (opcion != 3);
    }

    //función para validar el identificador
    public static String validaridentificador() {
        try {
            String identificador = pideidentificador();
            return identificador;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //función para validar la clave
    public static String validarclave() {
        try {
            String clave = pideclave();
            return clave;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //función para pedir el identificador
    public static String pideidentificador() throws InputMismatchException {
        System.out.println("Introduce el identificador del plataforma: ");
        String identificador = sc.nextLine();

        if (identificador.length() >= 3 && identificador.matches(".*[0-9].*") && identificador.matches(".*[A-Za-z].*")) {
            return identificador;
        }
        //si no se cumple lo del if, lanza el mensaje de errores.
        throw new InputMismatchException("El identificador de plataforma es incorrecta. Debe contener al menos 3 caracteres, letras y números. ");
    }

    //función para pedir la clave
    public static String pideclave() throws InputMismatchException {
        System.out.println("Introduce la clave de plataforma: ");
        String clave = sc.nextLine();

        if (clave.length() >= 6 && clave.matches(".*[0-9].*") && clave.matches(".*[A-Z].*")) {
        return clave;
    }
        //si no se cumple el if, lanza el mensaje de errores.
        throw new InputMismatchException("La clave de plataforma es incorrecta. Debe contener al menos 6 caracteres, un numero y una mayúscula.");

    }
}
