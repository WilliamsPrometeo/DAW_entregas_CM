package daw.entregas.practica5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {
    
    private static final MyScanner sc = new MyScanner();
    
    private static ArrayList <Material> listaMariales = new ArrayList<>();
    private static Map <Material, Integer> stockMateriales = new LinkedHashMap <>();
    
    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("-----GESTION DE BIBLIOTECA DIGITAL------" +
                "\n1. Registrar material" +
                "\n2. Mostrar stock" +
                "\n3. Prestar material" +
                "\n4. Mostrar Material disponibles" +
                "\n5. Salir" +
                "\nIngrese la opción");
            switch (opcion) {
                case 1:
                    getMaterial(String codigo);
                    break;
                case 2:
                    getStockMateriales();
                    break;
                case 3:
                    consultarStock();
                    break;
                case 4:
                    prestarMateriales();
                    break;
                case 5:
                    ();
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
    
    public boolean agregarMaterial() {
        String codigo = getCodigo();
        Material material = getMaterial(codigo);
        if (material != null) {
            stockMateriales.put(material, stockMateriales.get(material)+1);
            return false;
        } else {
            String titulo = sc.pideTexto("Introduce el titulo del libro: ");
            String autor  = sc.pideTexto("Introduce el autor del libro: ");
            int anioPublicacion = sc.pedirNumero("Introduce el año de publicacion del libro: ");
            boolean correcto;
            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" +
                    "\n1. " +
                    "\n2. Libro" +
                    "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion,
                            sc.pedirNumero("Introduce el codigo : "));
                        listaMariales.add(revista);
                        stockMateriales.put(revista, 1);
                        break;
                    case 2:
                        Material material1 = new Libro(matricula, marca, modelo, precio,
                            sc.pedirNumero("Introduce la cilindrada: "));
                        listaMariales.add(libro);
                        stockMateriales.put(libro, 1);
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
            Material material = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(material + " Stock: " + valor);
        }
    }
    
    public void mostraMateriales() {
        for (Material material : listaMariales) {
            System.out.println(material.mostrarDetalle());
        }
    }
    
    public boolean reducirStock() {
        String material = getMaterial();
        Material material = getMaterial(material);
        if (material != null) {
            int nuevoStock = stockMateriales.get(material);
            if (nuevoStock - 1 == 0) {
                stockMateriales.remove(material);
                listaMariales.remove(material);
            } else {
                stockMateriales.put(material, stockMateriales.get(material)-1);
            }
            return true;
        }
        return false;
    }
    
    public static Material getMaterial(String codigo) {
        for (Material material : listaMariales){
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }
    
    private static String getCodigo() {
        String regex = "^[1-9]{4}[A-Z]{3}$";
        String codigo;
        
        do {
            codigo = sc.pideTexto("Introduce el codigo del material: ").toUpperCase();
        } while (!codigo.matches(regex));
        
        return codigo;
    }
}
