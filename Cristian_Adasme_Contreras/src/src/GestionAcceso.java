package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionAcceso {
    public static void main(String[] args) {
        opcion();
    }
    public static void menu () {
        System.out.println("1. Validar identificador de acceso");
        System.out.println("2. Validar clave de seguridad");
        System.out.println("3. Salir");
    }
    public static void opcion () {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            menu();
            try {
                System.out.print("Ingrese opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Valide su nombre: ");
                        if (validarIdentificador() != null) {
                            System.out.println(validarIdentificador());
                            System.out.println("Validación correcta");
                        }else
                            System.out.println("Validación incorrecta");
                        break;
                    case 2:
                        System.out.println("Valide su clave de seguridad: ");
                        if (validarClave() != null) {
                            System.out.println(validarClave());
                            System.out.println("Clave correcta");
                        }else
                            System.out.println("Clave incorrecta");
                        break;
                    case 3:
                        System.out.println("Saliendo.");
                    default:
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Opción incorrecta, pruebe los números en pantalla.");
                sc.nextLine();
            }
        }while (opcion != 3);
    }
    public static String validarIdentificador () {
        Scanner sc = new Scanner(System.in);
        try {
            String Identificación = introducirIdent();
            return Identificación;
        } catch (ValidacionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static String introducirIdent () throws ValidacionException {
        Scanner sc = new Scanner(System.in);
        String identificador = sc.nextLine();
        if (identificador.length() >= 3 && identificador.matches("[A-Za-z0-9]+")) {
            return identificador;
        }
        throw new ValidacionException ("Identificación erronea.");
    }
    public static String validarClave () {
        Scanner sc = new Scanner(System.in);
        try {
            String Clave = introducirClave();
            return Clave;
        } catch (ValidacionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static String introducirClave () throws ValidacionException {
        Scanner sc = new Scanner(System.in);
        String clave = sc.nextLine();
        String corta = "Contraseña muy corta.";
        String numeral = "Contraseña no contiene un número al menos.";
        String mayusculas = "Contraseña no continene una mayúscula por lo menos.";
        if (clave.length() >= 6 && clave.matches(".*[0-9].*") && clave.matches(".*[A-Z].*")) {
            return clave;
        }
        else if (clave.length() < 6) {
            throw new ValidacionException(corta);
        } else if (!clave.matches(".*[0-9].*")) {
            throw new ValidacionException(mayusculas + corta);
        } else if (!clave.matches(".*[A-Z].*")) {
            throw new ValidacionException(mayusculas + corta + numeral);
        } if (!clave.matches(".*[A-Z].*")) {
            throw new ValidacionException(mayusculas);
        } else if (!clave.matches(".*[A-Z].*") && !clave.matches(".*[0-9].*")) {
            throw new ValidacionException(mayusculas + numeral);
        } else
            throw new ValidacionException(numeral);
    }
}
