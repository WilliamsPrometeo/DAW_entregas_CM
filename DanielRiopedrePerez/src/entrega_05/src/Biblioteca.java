package entrega_05.src;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {
    private static final MyScanner sc = new MyScanner();

    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();


    public boolean agregarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        if (m != null) {
            stockMateriales.put(m, stockMateriales.get(m)+1);
            return false;
        } else {
            String titulo = sc.pideTexto("Introduce el título del material: ");
            String autor = sc.pideTexto("Introduce el precio del material: ");
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
            return true;
        }
    }

    public void consultarStock() {
        for (Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()) {
            Material v = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(v + " Stock: " + valor);
        }
    }

    public void mostrarMateriales() {
        for (Material v : listaMateriales) {
            System.out.println(v.mostrarDetalles());
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

    private static Material getMaterial(String codigo) {
        for (Material material : listaMateriales){
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    private static String getCodigo() {
        String regex = "^[0-9]{4}[A-Z]{3}$";
        String codigo;

        do {
            codigo = sc.pideTexto("Introduce el código: ").toUpperCase();
        } while (!codigo.matches(regex));

        return codigo;
    }
}



