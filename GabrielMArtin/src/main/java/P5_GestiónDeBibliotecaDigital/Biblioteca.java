package P5_GestiónDeBibliotecaDigital;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//Clase que gestiona los materiales de la biblioteca. También controla la lista de materiales y el stock
public class Biblioteca {

    private ArrayList<Material> listaMateriales;
    private Map<Material, Integer> stockMateriales;
    private Scanner sc;

    public Biblioteca() {
        listaMateriales = new ArrayList<>();
        stockMateriales = new LinkedHashMap<>();
        sc = new Scanner(System.in);
    }

    //MÉTODO para registrar un nuevo material, no permite que haya duplicados en el ArrayListt
    public void agregarMaterial() {

        String codigo = pedirCodigo();

        Material existente = buscarMaterial(codigo);

        if (existente != null) {
            System.out.println("El material ya existe en la biblioteca.");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Año publicación: ");
        int anio = sc.nextInt();
        sc.nextLine();

        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.print("Seleccione opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        Material nuevo = null;

        switch (opcion) {

            case 1:
                System.out.print("Número de páginas: ");
                int paginas = sc.nextInt();
                sc.nextLine();
                nuevo = new Libro(codigo, titulo, autor, anio, paginas);
                break;

            case 2:
                System.out.print("Número de edición: ");
                int edicion = sc.nextInt();
                sc.nextLine();
                nuevo = new Revista(codigo, titulo, autor, anio, edicion);
                break;

            default:
                System.out.println("Opción incorrecta.");
                return;
        }

        //se añade a ambas estructuras
        listaMateriales.add(nuevo);
        stockMateriales.put(nuevo, 1);

        System.out.println("Material registrado correctamente.");
    }

    //Consulta el stock usando directamente el Map
    public Integer consultarStock() {

        String codigo = pedirCodigo();

        Material m = buscarMaterial(codigo);

        if (m != null && stockMateriales.containsKey(m)) {
            Integer stock = stockMateriales.get(m);
            System.out.println("Stock disponible: " + stock);
            return stock;
        }

        System.out.println("Material no encontrado.");
        return null;
    }

    //Hace la simulasión del préstamo de un materiall
    public boolean prestarMaterial() {

        String codigo = pedirCodigo();

        Material m = buscarMaterial(codigo);

        if (m != null && stockMateriales.containsKey(m)) {

            int stockActual = stockMateriales.get(m);

            if (stockActual > 1) {
                stockMateriales.put(m, stockActual - 1);
            } else {
                //si el stock llega a 0 se elimina de las estructuras
                stockMateriales.remove(m);
                listaMateriales.remove(m);
            }

            System.out.println("Préstamo realizado correctamente.");
            return true;
        }

        System.out.println("Material no disponible.");
        return false;
    }

    //Muestra todos los materiales, recorrre el ArrayList
    public void mostrarMateriales() {

        for (Material m : listaMateriales) {
            System.out.println(m.mostrarDetalle());
        }
    }

    //Busca un material por código en el ArrayList
    private Material buscarMaterial(String codigo) {

        for (Material m : listaMateriales) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }

        return null;
    }

    //Valida el código
    private String pedirCodigo() {

        String regex = "^[A-Za-z]{3}[0-9]{2}$";
        String codigo;

        do {
            System.out.print("Código (3 letras + 2 números): ");
            codigo = sc.nextLine().toUpperCase();
        } while (!codigo.matches(regex));

        return codigo;
    }
}
