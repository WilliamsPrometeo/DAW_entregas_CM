package GestionPlataforma_Renzo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionPlataforma
{
    private static final Scanner sc = new Scanner(System.in);

    private static void menu()
    {
        System.out.println("===== GESTIÓN DE ACCESO =====");
        System.out.print("1. Validar identificador de acceso" +
                "\n2. Validar clave de seguridad" +
                "\n3. Salir" +
                "\nSeleccione una opcion: ");

    }
    public static String pideIdentificador() throws InvalidIdentificatorException
    {
        String  nombre;

        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine();
        if (nombre.length() >= 3 && nombre.matches("[A-Za-z0-9]+"))
            return nombre;
        throw new InvalidIdentificatorException("Nombre incorrecto.");
    }


    public static String validarIdentificador()
    {
        String nombre;

        try
        {
            nombre = pideIdentificador();
            return nombre;
        } catch (InvalidIdentificatorException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String pideClave() throws InvalidClaveException
    {
        String password;

        System.out.print("Ingrese la clave de seguridad: ");
        password = sc.nextLine();
        if (password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*"))
            return password;
        throw new InvalidClaveException("La contraseña debe tener al menos un numero y una mayuscula.");

    }

    public static String validarClave()
    {
        String password;

        try
        {
            password = pideClave();
            return password;
        } catch (InvalidClaveException e){
            System.out.println(e.getMessage());
            return null;
        }
    }




    public static void main(String[] args)
    {
        int opcion = 0;
        String  validacionIdentificador;
        String  validacionClave;

        do
        {
            try
            {
                menu();
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion)
                {
                    case 1:
                        do
                        {
                            validacionIdentificador = validarIdentificador() != null ? "Validacion correcta" : "Validacion incorrecta";
                            System.out.println(validacionIdentificador);
                        } while (validacionIdentificador.equals("Validacion incorrecta"));
                        break;
                    case 2:
                        do
                        {
                            validacionClave = validarClave() != null ? "Validacion correcta" : "Validacion incorrecta";
                            System.out.println(validacionClave);
                        } while (validacionClave.equals("Validacion incorrecta"));
                        break;
                    case 3:
                        System.out.println("....Saliendo...");
                        break;
                    default:
                        System.out.println("Error.Ingrese solo numeros en el rango de 1 a 3\n");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("La opcion tiene que ser numerica.");
                sc.nextLine();
            }
        } while(opcion != 3);

    }
}
