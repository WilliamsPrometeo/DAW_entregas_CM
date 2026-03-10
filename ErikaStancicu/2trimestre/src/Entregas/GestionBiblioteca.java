package Entregas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionBiblioteca {

    private static final MyScanner sc = new MyScanner();

    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();

    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTIÓN DE BIBLIOTECA DIGITAL =====" +
                    "\n1. Registrar Material" +
                    "\n2. Mostrar Stock" +
                    "\n3. Prestar Material" +
                    "\n4. Mostrar Material disponible" +
                    "\n5. Salir");
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
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }


    public static void agregarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);


        if (m != null) {
            stockMateriales.put(m, stockMateriales.get(m) + 1);
            System.out.println("¡Material registrado!");
        } else {
            String titulo = sc.pideTexto("Introduce el titulo: ");
            String autor = sc.pideTexto("Introduce el autor: ");
            Integer anioPublicacion = sc.pedirNumero("Introduce el anio de publicacion: ");
            boolean correcto;
            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" +
                        "\n1. Libro" +
                        "\n2. Revista" +
                        "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        Libro l = new Libro(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el numero de páginas: "));
                        listaMateriales.add(l);
                        stockMateriales.put(l, 1);
                        break;
                    case 2:
                        Revista r = new Revista(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el numero de edición: "));
                        listaMateriales.add(r);
                        stockMateriales.put(r, 1);
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
        }
    }


    public static Integer consultarStock() {
        for (Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()) {
            Material m = mapa.getKey();
            Integer stock = mapa.getValue();
            System.out.println("Stock: " + stock);
        }
        return null;
    }

    public static boolean prestarMaterial() {
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

    public static void mostrarMateriales() {
        for (Material m : listaMateriales) {
            System.out.println(m.mostrarDetalle());
        }
    }

    private static Material getMaterial(String codigo) {
        for (Material material : listaMateriales) {
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    private static String getCodigo() {
        String codigo;
        String regex = "^[A-Z]{3}[1-9]{2}$";

        do {
            codigo = sc.pideTexto("Introduce el codigo, 3 letras seguidas de 2 números: ").toUpperCase();
        } while (!codigo.matches(regex));

        return codigo;
    }
}



