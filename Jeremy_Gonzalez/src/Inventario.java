import Recursos.MyScanner;
import Recursos.Utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Videojuego> lista;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    public Inventario() {
        lista = new ArrayList<>();
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void agregarVideojuego() {
        String id = pedirId();

        for (Videojuego videojuego : lista) {
            if (videojuego.getId().equals(id)) {
                System.out.println("ID duplicado");
                return;
            }
        }

        String titulo = sc.pideTexto("Introduce el titulo:");
        Plataforma plataforma = Utilidades.pedirEnum(Plataforma.class, "Elige plataforma:");
        double precio = sc.pedirDecimal("Introduce el precio:");

        lista.add(new Videojuego(id, titulo, plataforma, precio));
        System.out.println("El videojuego se agregado correctamente");
    }

    public void mostrarVideojuego() {
        Utilidades.imprimirLista(lista);
    }

    public void buscarPorId(Videojuego videojuego) {
        String id = sc.pideTexto("Introduce el ID:");
        for (Videojuego videojuego1 : lista) {
            if (videojuego.getId().equalsIgnoreCase(id)) {
                System.out.println(videojuego);
                return;
            }
        }
        System.out.println("Videojuego no encontrado");
    }

    public void cargar() {
        File archivo = new File(RUTA, "inventario.txt");

        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return;
        }

        lista.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos.length == 4) {
                    String id = datos[0];
                    String titulo = datos[1];
                    Plataforma plataforma =  Plataforma.valueOf(datos[2]);
                    double precio = Double.parseDouble(datos[3]);

                    lista.add(new Videojuego(id, titulo, plataforma, precio));
                }
            }
            System.out.println("Inventario guardado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String pedirId() {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;

        do {
            id = sc.pideTexto("ID (2 letras y 2 numeros):").toUpperCase();
        } while (!id.matches(regex));

        return id;
    }
}
