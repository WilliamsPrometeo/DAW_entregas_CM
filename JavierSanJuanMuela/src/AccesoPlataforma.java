import java.util.InputMismatchException;
import java.util.Scanner;
import exceptions.PasswordNotValidException;
import exceptions.UserNotValidException;

public class AccesoPlataforma {

    // se declara scanner
    private static final Scanner sc = new Scanner(System.in);

    // clase para checkear con regex los requisitios del usuario
    private static boolean checkUserRequirements(String usuario) throws UserNotValidException {
        if ((usuario.toLowerCase()).matches(".*[a-z].*") && (usuario.toLowerCase()).matches(".*[0-9].*") && usuario.length() >= 3) {
            return true;
        } else {
            throw new UserNotValidException("El usuario debe tener mínimo 3 letras y debe ser alfanumérico (solo letras y números)");
        }
    }
    // clase para checkear con regex los requisitios de la contraseña
    private static boolean checkPasswordRequirements(String password) throws PasswordNotValidException {
        if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*") && password.length() >= 6) {
            return true;
        } else {
            throw new PasswordNotValidException("La contraseña debe tener mínimo 6 letras y debe contener al menos una mayúscula y un número");
        }
    }
    // menu para validar identificador
    private static void validarIdentificador() {
        System.out.print("Identificador? -> ");
        String usuario = sc.next();
        try {
            if (checkUserRequirements(usuario)) {
                System.out.println("El identificador es válido!");
            } else {
                System.out.println("El identificar no es válido.");
            }
        } catch (UserNotValidException e) {
            System.out.println(e.getMessage());
        }
    }

    // menu para checkear la contraseña
    private static void validarClaveSeguridad() {
        System.out.print("Clave de Seguridad? -> ");
        String claveSeguridad = sc.next();
        try {
            if (checkPasswordRequirements(claveSeguridad)) {
                System.out.println("La clave de seguridad es válida!");
            } else {
                System.out.println("La clave de seguridad no es válida.");
            }
        } catch (PasswordNotValidException e) {
            System.out.println(e.getMessage());
        }
    }

    // menu principal
    private static void menuInteractivo() {
        boolean bucle = true;
        while (bucle) {
            System.out.print("1. Validar identificador de acceso\n2. Validar clave de seguridad\n3. Salir\nOpción: ");
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        validarIdentificador();
                        break;
                    case 2:
                        validarClaveSeguridad();
                        break;
                    case 3:
                        bucle = false;
                        break;
                    default:
                        System.out.println("Introduce una opción correcta (1-3)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se admiten valores numéricos");
                sc.nextLine();
            }
        }
    }
    // se llama al menuInteractivo (menu principal)
    public static void main(String[] args) {
        menuInteractivo();
    }


}
