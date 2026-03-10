package src.practica5;

import Clases.Libro;
import Clases.Material;

import java.util.ArrayList;
import java.util.Map;

public class Biblioteca {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Material> listaMateriales;
    private static Map<Material, Integer> stockMateriales;

    public static void main(String[] args) {
        boolean salir = false;
        do {
            System.out.println("===== GESTIÓN DE BIBLIOTECA DIGITAL =====\n" +
                    "1. Registrar Material\n" +
                    "2. Mostrar Stock\n" +
                    "3. Prestar Material\n" +
                    "4. Mostrar Material disponible\n" +
                    "5. Salir");
            int opcion = sc.pedirNumero("Seleccione su opción: ");
            switch (opcion) {
                case 1:
                    agregarMaterial();
                    break;
                case 2:
                    consultarStock();
                    break;
                case 3:
                    prestarMateriales();
                    break;
                case 4:
                    mostrarMateriles();
                case 5:
                    System.out.println("Saliendo....");
                    salir = true;
                    break;
                default:
                    System.out.println("Numero incorrecto");
            }
        }while(!salir);
    }


    public static void agregarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        boolean salir = false;
        if (m != null) {
            stockMateriales.put(m, stockMateriales.get(m) + 1);
        } else {
            do {
                String titulo = sc.pideTexto("Introduzca el titulo del libro: ");
                String autor = sc.pideTexto("Introduzca el nombre del autor: ");
                int anio = sc.pedirNumero("Introduzca el año de publicación del libro: ");

                int opcion = sc.pedirNumero("Introduzca que quiere añadir:" +
                        "\n1.Libro." +
                        "\n2.Revista." +
                        "\n3.Salir..\"");

                switch (opcion) {
                    case 1:
                        int paginas = sc.pedirNumero("Introduzca el número de paginas del libro: ");
                        Material libro = new Libro(codigo, titulo, autor, anio, paginas);
                        listaMateriales.add(libro);
                        stockMateriales.put(libro, 1);
                        salir = true;
                        break;
                    case 2:
                        int edicion = sc.pedirNumero("Introduzca el número de la edicion del libro: ");
                        Material revista = new Libro(codigo, titulo, autor, anio, edicion);
                        listaMateriales.add(revista);
                        stockMateriales.put(revista, 1);
                        salir = true;
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion incorrecta, pruebe de nuevo");
                        salir = true;
                        break;
                }
            }while(salir);
        }
    }

    public static String getCodigo() {
        String regex = "^[A-Z]{3}[1-9]{2}$";
        String matricula;

        do {
            matricula = sc.pideTexto("Introduce el código: ").toUpperCase();
        } while (!matricula.matches(regex));
        return matricula;
    }

    public static Material getMaterial(String codigo) {
        for (Material material : listaMateriales){
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    public static void consultarStock() {
        for (Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()) {
            Material m = mapa.getKey();
            Integer stock = mapa.getValue();
            System.out.println(m + " Stock: " + stock);
        }
    }

    public static boolean prestarMateriales(){
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

    public static void mostrarMateriles() {
        for (Material material : listaMateriales) {
            System.out.println(material.mostrarDetalle());
        }
    }
}
