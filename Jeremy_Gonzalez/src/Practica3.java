import Recursos.ClaveInvalidaException;
import Recursos.IdentificadorInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Practica3 {
    /*
    Empezaremos poniendo un scanner fuera para poder utilizarlo en todas las funciones
     */
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        En el main empezamos creando un boolean para asi hacer el bucle
        Creameos el bucle haciendo que mientras el boolean sea falso se siga ejecutando
        Hacemos un try catch con el menu y guardamos la opcion en un int
        En el caso de que no se ponga un numero saltara la exception
        En el switch guardaremos las 3 opciones ValidarIdentificador, ValidarClave, Y en la 3 el boolean pasara a ser true y termina el bucle
         */
        boolean salir = false;

        while (!salir) {
            try {
                MostrarMenu();
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        ValidarIdentificador();
                        break;
                    case 2:
                        ValidarClave();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

            }catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un numero.");
                sc.nextLine();
            }
        }
    }
    public static void MostrarMenu(){
        /*
        En esta funcion solo se imprimira las opciones del menu
         */
        System.out.println("=====MENU=====");
        System.out.println("1. Validar identificador de acceso");
        System.out.println("2. Validar clave de seguridad");
        System.out.println("3. Salir");
        System.out.println("Opcion:");
    }

    public static void ValidarIdentificador(){
        /*
        En esta funcion validaremos el identificador
        Guardamos el id introducido en un String
        Lanzamos un try catch para lanzar los mensajes de error
        Si el id puesto por el usuario no es como se indica(3 letras, de la a-z tanto en mayuscula como en minusculas y del 0 al 9) se lanza el catch
        Seesta bien se imprime un mensaje de validacion
         */
        System.out.println("Introduce el identificador de acesso");
        String id  = sc.nextLine();

        try{
            if (!Pattern.matches("^[a-zA-Z0-9]{3,}+", id)){
                throw new IdentificadorInvalidoException(
                        "El identificador debe tener al menos 3 caracteres y solo letras o numeros");
            }
            System.out.println("Validacion correcta");
        }catch(IdentificadorInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void ValidarClave(){
        /*
        En esta funcion se valida la clave de seguridad
        Igual que antes se guarda la clave introducida por el usuario en un string
        Se lanza un try catch en el caso de que la clave sea menor que 6, no tenga ningun numero y no tenga ninguna mayuscula se lanza la excepcion
        En otro caso se lanza el mensaje de clave valida
         */
        System.out.println("Introduce la clave de seguridad");
        String clave = sc.nextLine();

        try{
            if (clave.length() < 6){
                throw new ClaveInvalidaException("La clave debe tener al menos 6 caracteres");
            }
            if (!Pattern.matches(".*[0-9].*", clave)){
                throw new ClaveInvalidaException("La clave debe contener al menos un numero");
            }
            if (!Pattern.matches(".*[A-Z].*", clave)){
                throw new ClaveInvalidaException("La clave debe contener al menos una letra mayuscula");
            }

            System.out.println("Clave valida");

        }catch(ClaveInvalidaException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
