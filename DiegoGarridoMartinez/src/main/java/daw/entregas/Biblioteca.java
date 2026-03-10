package daw.entregas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import daw.entregas.recursos.MyScanner;


public class Biblioteca {

    private ArrayList<Material> listaMateriales;
    private Map<Material, Integer> stockMateriales;

    public Biblioteca() {
        listaMateriales = new ArrayList<>();
        stockMateriales = new HashMap<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE BIBLIOTECA DIGITAL =====");
            System.out.println("1. Registrar Material");
            System.out.println("2. Mostrar Stock");
            System.out.println("3. Prestar Material");
            System.out.println("4. Mostrar Material disponible");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("1. Libro");
                    System.out.println("2. Revista");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Año publicación: ");
                    int anio = sc.nextInt();

                    if (tipo == 1) {

                        System.out.print("Número páginas: ");
                        int paginas = sc.nextInt();

                        biblioteca.agregarMaterial(
                                new Libro(codigo, titulo, autor, anio, paginas));

                    } else {

                        System.out.print("Número edición: ");
                        int edicion = sc.nextInt();

                        biblioteca.agregarMaterial(
                                new Revista(codigo, titulo, autor, anio, edicion));
                    }

                    break;

                case 2:

                    System.out.print("Código material: ");
                    String codStock = sc.nextLine();

                    Integer stock = biblioteca.consultarStock(codStock);

                    if (stock == null)
                        System.out.println("Material no encontrado.");
                    else
                        System.out.println("Stock disponible: " + stock);

                    break;

                case 3:

                    System.out.print("Código material: ");
                    String codPrestamo = sc.nextLine();

                    biblioteca.prestarMaterial(codPrestamo);

                    break;

                case 4:
                    biblioteca.mostrarMateriales();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    // Agregar material
    public void agregarMaterial(Material material) {

        if (listaMateriales.contains(material)) {
            System.out.println("El material ya existe.");
            return;
        }

        listaMateriales.add(material);
        stockMateriales.put(material, 1);

        System.out.println("Material agregado correctamente.");
    }

    // Consultar stock (USANDO MAP)
    public Integer consultarStock(String codigo) {

        for (Material m : stockMateriales.keySet()) {
            if (m.getCodigo().equals(codigo.toUpperCase())) {
                return stockMateriales.get(m);
            }
        }
        return null;
    }

    // Prestar material
    public boolean prestarMaterial(String codigo) {

        Material encontrado = null;

        for (Material m : stockMateriales.keySet()) {
            if (m.getCodigo().equals(codigo.toUpperCase())) {
                encontrado = m;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("Material no encontrado.");
            return false;
        }

        int stock = stockMateriales.get(encontrado);

        if (stock > 1) {
            stockMateriales.put(encontrado, stock - 1);
        } else {
            stockMateriales.remove(encontrado);
            listaMateriales.remove(encontrado);
        }

        System.out.println("Préstamo realizado.");
        return true;
    }

    // Mostrar materiales
    public void mostrarMateriales() {

        if (listaMateriales.isEmpty()) {
            System.out.println("No hay materiales.");
            return;
        }

        for (Material m : listaMateriales) {
            System.out.println(m.mostrarDetalle());
        }
    }
}
