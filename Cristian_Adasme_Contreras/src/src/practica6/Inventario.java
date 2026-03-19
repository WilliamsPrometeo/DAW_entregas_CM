package src.practica6;

import java.io.*;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Videojuegos> videojuegos;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    public void GestionVideojuegos() {
        this.videojuegos = new ArrayList<>();
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void agregarVideojuegos() {
        String id = getId();
        for (Videojuegos v: videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println("El id ya está asociado a un videojuego");
                return;
            }
        }
        String titulo = sc.pideTexto("Introduce el titulo del videojuego: ");
        Plataforma plataforma = Utilidades.pedirEnum(Plataforma.class, "Introduce la platarforma del videojuego: ");
        double precio = sc.pedirDecimal("Introduce el precio del videojuego: ");
        videojuegos.add(new Videojuegos(id, titulo, plataforma, precio));
        System.out.println("El videojuego ha sido agregado");
    }

    public void guardarVideojuegos() {
        File archivo = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Videojuegos c: videojuegos) {
                String linea = c.getId() + ";" + c.getTitulo() + ";" + c.getPlataforma() + ";" + c.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Videojuegos guardados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarVideojuegos() {
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
                videojuegos.add(new Videojuegos(id, titulo, plataforma, precio));
            }

            System.out.println("Videojuegos cargados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void mostrarVideojuegos() {
        for (Videojuegos v: videojuegos) {
            System.out.println(v);
        }
    }


    private String getId () {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 2 numeros): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}
