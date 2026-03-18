package P6_GestiónDeInventarioDeVideojuegos;

import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que gestiona el inventario de los videojuegoss
 */
public class Inventario {

    private ArrayList<Videojuego> videojuegos;
    private static final MyScanner sc = new MyScanner();

    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    /**
     * Constructor
     */
    public Inventario() {
        videojuegos = new ArrayList<>();

        //Crear directorio si no existe
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    /**
     * Agrega un videojuego al inventario
     */
    public void agregarVideojuego() {
        String id = pedirId();

        //Comprobar los que están duplicados
        for (Videojuego v : videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println("Ese ID ya existe!");
                return;
            }
        }

        String titulo = sc.pideTexto("Introduce el titulo: ");
        Plataforma plataforma = Utilidades.pedirEnum(Plataforma.class, "Selecciona plataforma:");
        double precio = sc.pedirDecimal("Introduce el precio: ");

        videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
        System.out.println("Videojuego registrado correctamente!");
    }
    /**
     * Muestra todos los videojuegos
     */
    public void mostrarVideojuegos() {
        Utilidades.imprimirLista(videojuegos);
    }

    /**
     * Muestra un videojuego por ID
     */
    public void buscarPorId() {
        String id = sc.pideTexto("Introduce el ID: ").toUpperCase();

        for (Videojuego v : videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println(v);
                return;
            }
        }

        System.out.println("Videojuego no encontrado");
    }

    /**
     * Guarda el inventario en el archivo
     */
    public void guardar() {
        File archivo = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Videojuego v : videojuegos) {
                String linea = v.getId() + ";" +
                        v.getTitulo() + ";" +
                        v.getPlataforma() + ";" +
                        v.getPrecio();

                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Inventario guardado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Carga el inventario desde  el archivo
     */
    public void cargar() {
        File archivo = new File(RUTA, "inventario.txt");

        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                String id = datos[0];
                String titulo = datos[1];
                Plataforma plataforma = Plataforma.valueOf(datos[2]);
                double precio = Double.parseDouble(datos[3]);

                videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
            }

            System.out.println("Inventario cargado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Valida el ID (2 letras + 2 números)
     */
    private String pedirId() {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;

        do {
            id = sc.pideTexto("Introduce ID (2 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));

        return id;
    }
}