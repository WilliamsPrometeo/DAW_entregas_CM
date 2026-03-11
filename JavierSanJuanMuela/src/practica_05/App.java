package practica_05;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static Biblioteca biblioteca = new Biblioteca();

    private static Scanner sc = new Scanner(System.in);

    public static void agregarMaterial() {
        boolean bucle = true;
        while (bucle) {
            System.out.print("Tipo? -> ");
            String tipoMaterial = sc.next();
            if (tipoMaterial.equalsIgnoreCase("libro")) {
                System.out.print("Código? -> ");
                String codigo = sc.next();
                sc.nextLine();
                String regex = "^[1-9]{4}[A-Z]{3}$";
                if (!codigo.matches(regex)){
                    bucle = false;
                }
                System.out.print("Título? -> ");
                String titulo = sc.next();
                sc.nextLine();
                System.out.print("Autor? -> ");
                String autor = sc.next();
                sc.nextLine();
                System.out.print("Año de Publicación? -> ");
                int anoPublicacion = sc.nextInt();
                sc.nextLine();
                System.out.print("Número de Páginas? -> ");
                int numeroPaginas = sc.nextInt();
                sc.nextLine();
                Libro resultado = new Libro(codigo, titulo, autor, anoPublicacion, numeroPaginas);
                biblioteca.agregarMaterial(resultado);
            } else if (tipoMaterial.equalsIgnoreCase("revista")) {
                System.out.print("Código? -> ");
                String codigo = sc.next();
                sc.nextLine();
                String regex = "^[1-9]{4}[A-Z]{3}$";
                if (!codigo.matches(regex)){
                    bucle = false;
                }
                System.out.print("Título? -> ");
                String titulo = sc.next();
                sc.nextLine();
                System.out.print("Autor? -> ");
                String autor = sc.next();
                sc.nextLine();
                System.out.print("Año de Publicación? -> ");
                int anoPublicacion = sc.nextInt();
                sc.nextLine();
                System.out.print("Número de Edición? -> ");
                int numeroEdicion = sc.nextInt();
                sc.nextLine();
                Revista resultado = new Revista(codigo, titulo, autor, anoPublicacion, numeroEdicion);
                biblioteca.agregarMaterial(resultado);
            } else {
                System.out.println("Escribe un tipo de material válido!");
            }
        }
    }

    public static void main(String[] args) {
        boolean bucle = true;
        while (bucle) {
            try {
                System.out.println("===== GESTIÓN DE BIBLIOTECA DIGITAL =====\n" +
                        "1. Registrar Material\n" +
                        "2. Mostrar Stock\n" +
                        "3. Prestar Material\n" +
                        "4. Mostrar Material disponible\n" +
                        "5. Salir");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        agregarMaterial();
                        break;
                    case 2:
                        biblioteca.consultarTotalStock();
                        break;
                    case 3:
                        prestarMaterial();
                        break;
                    case 4:
                        biblioteca.mostrarMaterialDisponible();
                        break;
                    case 5:
                        bucle = false;
                        break;
                    default:
                        System.out.println("Pon una opción correcta.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Pon un número, no una cadena de texto.");
            }
        }
    }

    private static void prestarMaterial() {
        try {
            Map<Material, Integer> mapaMateriales = biblioteca.getStockMateriales();
            for (int i = 0; i < biblioteca.getListaMateriales().size(); i++) {
                System.out.printf("Material: %s - Stock: %s", biblioteca.getListaMateriales().get(i).getTitulo(), mapaMateriales.get(biblioteca.getListaMateriales().get(i)));
            }
            System.out.print("\n-> ");
            int opcion = sc.nextInt();
            sc.nextLine();
            biblioteca.prestarMaterial(opcion - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Elije una opción correcta.");
        } catch (InputMismatchException e) {
            System.out.println("Pon un número, no una cadena de texto.");
        }
    }
}
