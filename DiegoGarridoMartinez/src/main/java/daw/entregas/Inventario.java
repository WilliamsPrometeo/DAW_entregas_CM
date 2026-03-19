package daw.entregas;
import java.io.*;
import java.util.ArrayList;
import daw.entregas.recursos.Utilidades;
import daw.entregas.recursos.MyScanner;

public class Inventario {

    private ArrayList<Videojuego> videojuegos;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    public Inventario() {
        videojuegos = new ArrayList<>();

        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void agregarVideojuego() {
        String id = getId();

        for (Videojuego v : videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println("Ese ID ya existe!");
                return;
            }
        }

        String titulo = sc.pideTexto("Introduce el título:");
        Plataforma plataforma = elegirPlataforma();
        double precio = sc.pedirDecimal("Introduce el precio:");

        videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
        System.out.println("Videojuego añadido correctamente!");
    }

    public void mostrarInventario() {
        for (Videojuego v : videojuegos) {
            System.out.println(v);
        }
    }

    public void mostrarPorId() {
        String id = sc.pideTexto("Introduce el ID a buscar:").toUpperCase();

        for (Videojuego v : videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println(v);
                return;
            }
        }

        System.out.println("No se encontró el videojuego.");
    }

    public void guardarInventario() {
        File archivo = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Videojuego v : videojuegos) {
                String linea = v.getId() + ";" + v.getTitulo() + ";" +
                        v.getPlataforma() + ";" + v.getPrecio();

                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Inventario guardado correctamente!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarInventario() {
        File archivo = new File(RUTA, "inventario.txt");

        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
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

            System.out.println("Inventario cargado correctamente!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getId() {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;

        do {
            id = sc.pideTexto("Introduce el ID (2 letras y 2 números):").toUpperCase();
        } while (!id.matches(regex));

        return id;
    }

    private Plataforma elegirPlataforma() {
        int opcion;

        do {
            opcion = sc.pedirNumero("""
                    Selecciona plataforma:
                    1. PC
                    2. PLAYSTATION
                    3. XBOX
                    4. NINTENDO
                    """);

        } while (opcion < 1 || opcion > 4);

        return switch (opcion) {
            case 1 -> Plataforma.PC;
            case 2 -> Plataforma.PLAYSTATION;
            case 3 -> Plataforma.XBOX;
            case 4 -> Plataforma.NINTENDO;
            default -> null;
        };
    }
}
