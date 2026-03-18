package Entrega06;

import java.io.*;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Videojuego> videojuegos;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    public Inventario() {
        this.videojuegos = new ArrayList<>();
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void agregarVideojuego() {
        String id = getId();
        for (Videojuego v: videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println("El id ya está asociado!");
                return;
            }
        }
        String titulo = sc.pideTexto("Introduce el nombre del juego: ");
        TipoPlataforma plataforma = Utilidades.pedirEnum(TipoPlataforma.class, "Introduce la plataforma: ");
        double precio = sc.pedirNumero("Introduce el precio del juego: ");
        videojuegos.add(new Videojuego(id, titulo, plataforma, precio ));
        System.out.println("El juego a sido registrado correctamente!");
    }

    public void mostrarVideojuego() {
        for (Videojuego v: videojuegos) {
            System.out.println(v);
        }
    }

    public void guardarViedeojuego() {
        File archivo = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Videojuego v: videojuegos) {
                String linea = v.getId() + ";" + v.getTitulo() + ";" + v.getPlataforma() + ";" + v.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Videojuegos guardados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarVideojuego() {
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
                TipoPlataforma plataforma = datos[2];
                double precio = datos[3];
                videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
            }

            System.out.println("Clientes cargados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private String getId () {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}

