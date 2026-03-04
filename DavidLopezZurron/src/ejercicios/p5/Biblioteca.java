package ejercicios.p5;

import ejercicios.p5.Clases.Libro;
import ejercicios.p5.Clases.Material;
import ejercicios.p5.Clases.Revista;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {
    private static final MyScanner sc = new MyScanner();
    private static final ArrayList <Material> listaMateriales = new ArrayList <>();
    private static final Map <Material, Integer> stockMateriales = new LinkedHashMap <>();
    
    public static void main(String[] args) {
        int op;
        do {
            op = sc.pedirNumero("""
                
                ===== GESTIÓN DE BIBLIOTECA DIGITAL =====
                    1. Registrar Material
                    2. Mostrar Stock
                    3. Prestar Material
                    4. Mostrar Material disponible
                    5. Salir
                Opción:""");
            
            switch (op) {
                case 1:
                    agregarMaterial();
                    break;
                case 2:
                    consultarStock();
                    break;
                case 3:
                    System.out.println(prestarMaterial() ?
                        "El material se ha prestado correctamente" :
                        "El material no ha podido prestarse, revise el código de material introducido");
                    break;
                case 4:
                    mostraMateriales();
                    break;
                case 5:
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Opción invalida.");
                    break;
            }
        } while (op != 5);
        
    }
    
    //Metodos
    public static void agregarMaterial() {
        //Creamos un objeto de la clase material con el codigo introducido por el usuraio
        //El codigo es correcto, ya que se valida en el metodo getCodigo
        String codigo = getCodigo();
        Material m = getMateriales(codigo);
        
        //Si el objeto creado de la clase material devuelve null decimos que ya está creado, ya que
        //El método getMateriales devuelve null si ya hay un objeto con ese codigo
        //Sino, creamos un objeto nuevo con dicho codigo
        if (m != null) {
            System.out.println("El material ya existe.");
        } else {
            String titulo = sc.pideTexto("Introduce el titulo del material: ");
            String autor = sc.pideTexto("Introduce el autor del material: ");
            int anioPublicacion = sc.pedirNumero("Introduce el año de publicación del material: ");
            boolean correcto;
            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" + "\n1. Libro" + "\n2. Revista" + "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        Material libro = new Libro(codigo, titulo, autor, anioPublicacion, sc.pedirNumero("Introduce el numero de paginas: "));
                        listaMateriales.add(libro);
                        stockMateriales.put(libro, 1);
                        System.out.println("Se ha añadido el libro correctamente");
                        break;
                    case 2:
                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion, sc.pedirNumero("Introduce el numero de edición: "));
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
        for (Map.Entry <Material, Integer> mapa : stockMateriales.entrySet()) {
            Material m = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.printf("El libro con código %s tiene un stock de %d\n", m.getCodigo(), valor);
        }
    }
    
    public static boolean prestarMaterial() {
        //Misma lógica que el agregar material
        String codigo = getCodigo();
        Material m = getMateriales(codigo);
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
    
    public static void mostraMateriales() {
        int contador = 1;
        
        for (Material m : listaMateriales) {
            System.out.printf("\nMaterial %d:\n%s\n", contador++, m.mostrarDetalle());
        }
    }
    
    private static Material getMateriales(String matricula) {
        for (Material m : listaMateriales) {
            if (m.getCodigo().equals(matricula)) {
                return m;
            }
        }
        return null;
    }
    
    private static String getCodigo() {
        //Obligamos a que el codigo tenga un tipo de formato (Tres mayusculas y dos numeros)
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;
        
        do {
            codigo = sc.pideTexto("Introduce el código (3 letras mayúsculas y dos números): ").toUpperCase();
        } while (!codigo.matches(regex));
        
        return codigo;
    }
}
