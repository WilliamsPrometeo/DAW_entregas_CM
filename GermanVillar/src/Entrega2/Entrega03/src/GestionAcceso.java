package Entrega2.Entrega03.src;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GestionAcceso {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        //Creamos bucle en el cual no se dejara de repetir hasta el usuario pulse salir.
        // Implementando las clases.
        do {
            try {
                Menu();
                opcion = sc.nextInt();
                sc.nextLine();
                //Utilizamos Switch para gestionar el manu.
                switch (opcion) {
                    case 1:
                        validarIdentificador(sc);
                        break;
                    case 2:
                        validarClave(sc);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número.");
                sc.nextLine();
            }

        } while (opcion != 3);

        sc.close();
    }
    //Configuramos como va ser el menu que se visualizara.
    public static void Menu() {

        System.out.println("=== MENÚ ===");
        System.out.println("1. Validar identificador");
        System.out.println("2. Validar clave de seguridad");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }
    //Creamos la clase para validar el identificador.
    public static void validarIdentificador(Scanner sc) {
        System.out.print("Introduce identificador: ");
        String id = sc.nextLine();

        //Con .matches controlamos que contenga letras
        //(mayúsculas/minúsculas) y números.
        try {
            //Si no cumple la condición anteriormente expuesta salta la excepción.
            if (!id.matches("[a-zA-Z0-9]{3,}")) {
                throw new ErrorIdentificadorException(
                        "El identificador debe tener al menos 3 caracteres y solo letras o números.");
            }
            System.out.println("Validación correcta");

        } catch (ErrorIdentificadorException e) {
          System.out.println("Error: " + e.getMessage());
        }
    }
    //Validamos la clave y lo dividimos para que lance el error según alla sido el error.
    public static void validarClave(Scanner sc) {
        System.out.print("Introduce clave de seguridad: ");
        String clave = sc.nextLine();
        //Con if vamos controlando tanto el tamaño como que contenga el al menos un número y una letra.
        try {
            if (clave.length() < 6) {
                throw new ClaveInvalidaException("La clave debe tener al menos 6 caracteres.");
            }
            if (!clave.matches(".*[0-9].*")) {
                throw new ClaveInvalidaException("La clave debe contener al menos un número.");
            }
            if (!clave.matches(".*[A-Z].*")) {
                throw new ClaveInvalidaException("La clave debe contener al menos una letra mayúscula.");
            }

            System.out.println("Clave válida");

        } catch (ClaveInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
