package proyectos.proyecto05;


import proyectos.proyecto05.clases.Libro;
import proyectos.proyecto05.clases.Material;
import proyectos.proyecto05.clases.Revista;
import recursos.MyScanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();

    public static void main(String[] args) {

        int opcion;
        do{
            opcion = sc.pedirNumero("===== GESTIÓN DE BIBLIOTECA DIGITAL =====" +
                    "\n1. Registrar Material" +
                    "\n2. Mostrar Stock" +
                    "\n3. Mostrar Stock por código" +
                    "\n4. Prestar Material" +
                    "\n5. Mostrar Material disponible" +
                    "\n6. Salir");

            switch(opcion){
                case 1 -> agregarMaterial();
                case 2 -> consultarStock();
                case 3 -> {
                    String codigo = getCodigo();
                    consultarStock(codigo);
                }
                case 4 -> prestarMaterial();
                case 5 -> mostrarMateriales();
                case 6 -> System.out.println("Se ha salido del programa");
            }
        }while(opcion != 6);
    }

    public static boolean agregarMaterial(){

        String codigo = getCodigo();
        Material m = getMaterial(codigo);

        if(m != null){
            System.out.println("El material ya existe");
            return false;
        }
        else{
            String titulo = sc.pideTexto("Ingrese el título del material: ");
            String autor = sc.pideTexto("Ingrese el autor del material: ");
            int anioPublicacion = sc.pedirNumero("Ingrese el año del material: ");

            boolean correcto;
            do{
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opción:" +
                        "\n1.Libro" +
                        "\n2.Revista" +
                        "\nOpción: ");
                switch(opcion){
                    case 1 -> {
                        Material libro = new Libro(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Seleccione el número de páginas: "));
                        listaMateriales.add(libro);
                        stockMateriales.put(libro, 1);
                    }
                    case 2 -> {
                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Seleccione el número de edición: "));
                        listaMateriales.add(revista);
                        stockMateriales.put(revista, 1);
                    }
                    default -> correcto = false;
                }
            }while(!correcto);
        }
        return true;
    }

    // consultar stock general
    public static void consultarStock(){

        if(stockMateriales.isEmpty()){
            System.out.println("Debe haber al menos un material");
        }
        else{
            for(Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()){
                Material m = mapa.getKey();
                Integer valor = mapa.getValue();
                System.out.println(m + ", stock: " + valor);
            }
        }
    }

    // consultar stock por matrícula
    public static void consultarStock(String codigo){

        if(stockMateriales.isEmpty()){
            System.out.println("Debe haber al menos un material:");
        }
        else{
            Material m = getMaterial(codigo);
            if (m != null) {
                System.out.println(m + ", stock: " + stockMateriales.get(m));
            }
        }
    }

    public static boolean prestarMaterial(){

        if(stockMateriales.isEmpty()){
            System.out.println("Debe haber al menos un material");
        }
        else{
            String codigo = getCodigo();
            Material m = getMaterial(codigo);

            if(m != null){
                int nuevoStock = stockMateriales.get(m) - 1;
                if(nuevoStock == 0){
                    stockMateriales.remove(m);
                    listaMateriales.remove(m);
                }
                else{
                    stockMateriales.put(m, nuevoStock);
                }
                return true;
            }
        }
        return false;
    }

    public static void mostrarMateriales(){

        if(listaMateriales.isEmpty()){
            System.out.println("Debe haber al menos un material");
        }
        else{
            for(Material m : listaMateriales){
                System.out.println(m.mostrarDetalle());
            }
        }
    }

    private static Material getMaterial(String codigo){

        for(Material m : listaMateriales){
            if(m.getCodigo().equals(codigo)){
                return m;
            }
        }
        return null;
    }

    private static String getCodigo(){

        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;

        do{
            codigo = sc.pideTexto("Introduce un código: ").toUpperCase();
        }while(!codigo.matches(regex));

        return codigo;
    }
}
