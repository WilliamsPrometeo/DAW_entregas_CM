import clases.Libro;
import clases.Material;
import clases.Revista;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca
{
    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();

    public static void main(String[] args)
    {
        Biblioteca biblioteca = new Biblioteca();
        boolean salir = false;

        do {

            int opcion = sc.pedirNumero(
                    "\n===== GESTIÓN DE BIBLIOTECA DIGITAL =====" +
                            "\n1. Registrar Material" +
                            "\n2. Mostrar Stock" +
                            "\n3. Prestar Material" +
                            "\n4. Mostrar Material disponible" +
                            "\n5. Salir\n" +
                            "Ingrese una opcion: ");


            switch (opcion)
            {
                case 1:
                    biblioteca.agregarMaterial();
                    break;

                case 2:
                    biblioteca.consultarStock();
                    break;

                case 3:
                    if (biblioteca.prestarMaterial())
                        System.out.println("Stock actualizado");
                    else
                        System.out.println("Material no encontrado");
                    break;
                case 4:
                    biblioteca.mostrarMateriales();
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (!salir);
    }

    public void agregarMaterial()
    {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);

        if (m != null)
        {
            stockMateriales.put(m, stockMateriales.get(m)+1);

        }
        else
        {
            String titulo = sc.pideTexto("Introduce el titulo del material: ");
            String autor = sc.pideTexto("Introduce el autor del material: ");
            int anioPublicacion = sc.pedirNumero("Introduce el año de publicacion: ");
            boolean correcto;

            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" +
                        "\n1. Libro" +
                        "\n2. Revista" +
                        "\n3. Salir ");
                switch (opcion)
                {
                    case 1:
                        Material libro = new Libro(codigo,titulo,autor,anioPublicacion,
                                sc.pedirNumero("Introduce el numero de paginas: "));

                        break;
                    case 2:
                        Material revista = new Revista(codigo,titulo,autor,anioPublicacion,
                                sc.pedirNumero("Introduce el numero de edicion: "));

                        break;
                    default:
                        correcto = false;
                        break;
                }

            }while (!correcto);
        }
    }

    public void consultarStock()
    {
        for (Map.Entry<Material, Integer> mapa : stockMateriales .entrySet()) {
            Material v = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(v + " Stock: " + valor);
        }
    }

    public boolean prestarMaterial()
    {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);

        if (m != null)
        {
            int nuevoStock = stockMateriales.get(m);
            if (nuevoStock - 1 == 0) {
                stockMateriales.remove(m);
                listaMateriales.remove(m);
            } else{

                stockMateriales.put(m, stockMateriales.get(m)-1);
            }
            return true;
        }
        return false;
    }

    public void mostrarMateriales()
    {
        for (Material v : listaMateriales ) {
            System.out.println(v.mostrarDetalle());
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
        String regex = "^[A-Z]{3}[1-9]{2}$";
        String codigo;

        do {
            codigo = sc.pideTexto("Introduce el codigo: ").toUpperCase();
        } while (!codigo.matches(regex));

        return codigo;
    }

}
