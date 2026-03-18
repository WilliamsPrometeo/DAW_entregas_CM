package Videojuegos;

import java.io.*;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Videojuego> lista = new ArrayList<>();
    private MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    public void agregar(Videojuego v) {
        for (Videojuego juego : lista) {
            if (juego.getId().equals(v.getId())) {
                System.out.println("Error: ID duplicado.");
                return;
            }
        }
        lista.add(v);
    }

    public void mostrar() {
        for (Videojuego v : lista) {
            System.out.println(v);
        }
    }

    public Videojuego buscarPorId(String id) {
        for (Videojuego v : lista) {
            if (v.getId().equalsIgnoreCase(id)) {
                return v;
            }
        }
        return null;
    }

    public void guardar() {
        try {
            File archivo = new File(RUTA, "inventario.txt");

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

            for (Videojuego v : lista) {
                bw.write(v.getId() + ";" + v.getTitulo() + ";" + v.getPlataforma() + ";" + v.getPrecio());
                bw.newLine();
            }
            System.out.println("Inventario guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    public void cargar() {
        try {
            File archivo = new File(RUTA);

            if (!archivo.exists()) {
                System.out.println("El archivo no existe.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            lista.clear();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                String id = partes[0];
                String titulo = partes[1];
                Plataforma plataforma = Plataforma.valueOf(partes[2]);
                double precio = Double.parseDouble(partes[3]);

                lista.add(new Videojuego(id, titulo, plataforma, precio));
            }

            br.close();
            System.out.println("Inventario cargado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
        }
    }

    private String getId () {
        String regex = "^[A-Z]{2}[0-9]{2}";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 1 número): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}