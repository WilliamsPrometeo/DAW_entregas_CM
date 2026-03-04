package Ejercicios;

import Clases.Libro;
import Clases.Material;
import Clases.Revista;
import Recursos.MyScanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {

    private static final MyScanner sc = new MyScanner();

    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();

    // Clase main
    public void main (String[] args){
        boolean salir = false;
        do {
            System.out.println("===== GESTIÓN DE BIBLIOTECA DIGITAL =====\n" +
                    "1. Registrar Material\n" +
                    "2. Mostrar Stock\n" +
                    "3. Prestar Material\n" +
                    "4. Mostrar Material disponible\n" +
                    "5. Salir");
            int opcion = sc.pedirNumero("Seleccione opcion: ");
            switch (opcion) {
                case 1:
                    agregarMaterial();
                    break;
                case 2:
                    consultarStock();
                    break;
                case 3:
                    prestarMaterial();
                    break;
                case 4:
                    mostrarMateriales();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no válida");
                    break;
            }
        }while (!salir);
    }

    public void agregarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        if (m != null) {
            System.out.println("El material ya existe");
        } else {
            String titulo = sc.pideTexto("Introduce el título del material: ");
            String autor = sc.pideTexto("Introduce el autor del material: ");
            int anioPublicacion = sc.pedirNumero("Introduce el año de publicación del material: ");
            boolean correcto;
            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" +
                        "\n1. Libro" +
                        "\n2. Revista" +
                        "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        Material libro = new Libro(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el número de páginas: "));
                        listaMateriales.add(libro);
                        stockMateriales.put(libro, 1);
                        break;
                    case 2:
                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el número de edición: "));
                        listaMateriales.add(revista);
                        stockMateriales.put(revista, 1);
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
        }
    }

    public void consultarStock() {
        for (Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()) {
            Material m = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(m + " Stock: " + valor);
        }
    }

    public boolean prestarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        if (m != null) {
            int nuevoStock = stockMateriales.get(m);
            if (nuevoStock - 1 == 0) {
                stockMateriales.remove(m);
                listaMateriales.remove(m);
            } else {
                stockMateriales.put(m, stockMateriales.get(m)-1);
            }
            return true;
        }
        return false;
    }

    public void mostrarMateriales() {
        for (Material m : listaMateriales) {
            System.out.println(m.mostrarDetalle());
        }
    }

    private static Material getMaterial(String codigo) {
        for (Material material : listaMateriales){
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    private static String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;

        do {
            codigo = sc.pideTexto("Introduce el codigo: ").toUpperCase();
        } while (!codigo.matches(regex));

        return codigo;
    }
}
