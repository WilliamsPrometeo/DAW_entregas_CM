package daw.entregas;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Identificar {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //llamamos al menú principal del programa
        menu();

    }

    public static void menu() {
        int opcion = 0;
        // El menú se repite hasta que el usuario elige salir (opción 3)
        while (opcion != 3){

            try {
                    //este es el menu que se va a estar repitiendo hasta que se salga
                    System.out.println("");
                    System.out.println("           \\MENU/        ");
                    System.out.println("1 Validar identificador de acceso");
                    System.out.println("2 Validar clave de seguridad");
                    System.out.println("3 Salir");

                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                case 1:
                    //si la identificación es correcta devuelve un String distinto de null
                    String validacionidentificacion = validarIdentificacion() != null ? "Validación correcta" : "Validación incorrecta";
                    System.out.println(validacionidentificacion);
                    break;
                case 2:
                    //validación de la clave de seguridad
                    String validacionclave = validarClave() != null ? "Validación correcta" : "Validación incorrecta";
                    System.out.println(validacionclave);
                    break;
                case 3:
                    // Si pone el 3 se sale del programa
                    System.out.println("Salir");
                    break;

                default:

                    break;
                }


            }//aqui si el usuario pone otro numero dice que no es un numero
            catch (InputMismatchException e) {
                System.out.println("Debes introducir un número");
                sc.nextLine();
            }
        }
    }
    //pide al usuario una clave y comprueba si cumple las condiciones
    public static String pideClave() throws IntidadnoValidaException {
        System.out.println("Introduce la clave de seguridad: ");
        String clave = sc.nextLine();
        // La clave debe tener al menos 6 caracteres, un numero y una mayuscula
        if (clave.length() >= 6
                && clave.matches(".*[0-9].*")
                && clave.matches(".*[A-Z].*")) {
            return clave;
        }
        //si no clumple alguna le lanzamos esto al usuario
        throw new IntidadnoValidaException("La clave debe tener al menos un numero, una mayuscula y al menos 6 caracteres");
    }

    //valida si esta bien o no la clave
    public static String validarClave() {
        try {
            String clave = pideClave();
            return clave;
        } catch (IntidadnoValidaException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




    // Pide la identificación y comprueba si es valida o no
    public static String pideIdentificacion() throws IntidadnoValidaException {
        System.out.println("Introuce la identificacion: ");
        String identificacion = sc.nextLine();
        // Debe tener más de 3 caracteres y solo letras y numeros
        if (identificacion.length() > 3 && identificacion.matches("[A-Za-z0-9]+")) {
            return identificacion;
        }
        // Si no es valida se lanza la excepción
        throw new IntidadnoValidaException("Identificacion incorrecta");
    }

    //valida la identificación
    public static String validarIdentificacion() {
        try {
            String identificacion = pideIdentificacion();
            return identificacion;
        } catch (IntidadnoValidaException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}