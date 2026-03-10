package P5_GestiónDeBibliotecaDigital;

import java.util.Scanner;

//Clase principal que muestra el menú de la aplicación.
public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE BIBLIOTECA DIGITAL =====");
            System.out.println("1. Registrar Material");
            System.out.println("2. Mostrar Stock");
            System.out.println("3. Prestar Material");
            System.out.println("4. Mostrar Material disponible");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    biblioteca.agregarMaterial();
                    break;

                case 2:
                    biblioteca.consultarStock();
                    break;

                case 3:
                    biblioteca.prestarMaterial();
                    break;

                case 4:
                    biblioteca.mostrarMateriales();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 5);
    }
}
