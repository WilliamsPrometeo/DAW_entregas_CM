package daw.entregas;

import daw.entregas.clases.Libro;
import daw.entregas.clases.Material;
import daw.entregas.clases.Revista;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {
    private static final MyScanner sc = new MyScanner();

    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();

    public static void main(String[] args) {
        boolean salida;
        do {
            salida = false;
            int opcion = sc.pedirNumero("===== GESTIÓN DE BIBLIOTECA DIGITAL =====\n" +
                    "1. Registrar Material\n" +
                    "2. Mostrar Stock\n" +
                    "3. Prestar Material\n" +
                    "4. Mostrar Material disponible\n" +
                    "5. Salir");
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
                    salida = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!salida);
    }

    //Metodos

    public static void agregarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        if (m != null) {
            System.out.println("Ya existe el material con mismo codigo, stock del material aumentado.");
            stockMateriales.put(m, stockMateriales.get(m) + 1);
        } else {
            String titulo = sc.pideTexto("Introduce el titulo del material: ");
            String autor = sc.pideTexto("Introduce el autor del material: ");
            int anioPublicacion = sc.pedirNumero("Introduce el anio publicacion del material: ");
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
                                sc.pedirNumero("Introduce el numero de la paginas: "));
                        listaMateriales.add(libro);
                        stockMateriales.put(libro, 1);
                        break;
                    case 2:
                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el numero Edicion: "));
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

    public static void consultarStock() {
        for (Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()) {
            Material m = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(m.mostrarDetalle() + " Stock: " + valor);
        }
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
                stockMateriales.put(m, stockMateriales.get(m) - 1);
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
        for (Material material : listaMateriales) { //recorre el Arraylist
            if (material.getCodigo().equals(codigo)) { //poner condicion
                return material; //revuelve material
            }
        }
        return null;//revuelve null
    }

    private static String getCodigo() {
        // un rango para matches
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;

        do {
            codigo = sc.pideTexto("Introduce el codigo (3 letras seguido de 2 números): ").toUpperCase();//pedir codigo
        } while (!codigo.matches(regex)); //ejercuta hasta codigo cumple el rango
        return codigo;//revuelve codigo
    }
}

