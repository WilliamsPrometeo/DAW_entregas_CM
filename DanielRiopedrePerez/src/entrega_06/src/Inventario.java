package entrega_06.src;

import java.io.*;
import java.util.ArrayList;

public class Inventario {
    private static final MyScanner sc =  new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    private ArrayList<Videojuego> videojuegos;

    public Inventario() {
        this.videojuegos = new ArrayList<>();
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void addVideojuego() {
        String id = getId();
        for (Videojuego videojuego: videojuegos) {
            if (videojuego.getId().equals(id)) {
                System.out.println("El id ya está asociado a un videojuego!");
                return;
            }
        }

        String title = sc.pideTexto("Introduce el título del juego: ");
        Plataforma platform = Utilidades.pedirEnum(Plataforma.class, "Introduce la plataforma del juego: ");
        double price = sc.pedirNumero("Introduce el precio del juego: ");
        videojuegos.add(new Videojuego(id, title, platform, price));
        System.out.println("El videojuego ha sido registrado correctamente!");
    }

    public void guardarVideojuegos() {
        File archivo = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Videojuego videojuego: videojuegos) {
                String linea = videojuego.getId() + ";" + videojuego.getTitle() + ";" + videojuego.getPlataforma()+ ";" + videojuego.getPrice();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Videojuegos guardados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarVideojuegos() {
        for (Videojuego videojuego: videojuegos) {
            System.out.println(videojuego);
        }
    }

    public void showVideojuegoById() {

        String id = sc.pideTexto("Introduce el id del videojuego: ");
        boolean gameFound = false;

        for (Videojuego videojuego: videojuegos) {

            if (videojuego.getId().equals(id)){
                System.out.println(videojuego);
                gameFound = true;
                break;
            }
        }
        if (!gameFound) {
            System.out.println("El videojuego no existe");
        }
    }


    public void loadVideojuegos() {
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
                String title = datos[1];
                Plataforma platform = platformFromString(datos[2]);
                double price = Double.parseDouble(datos[3]);

                videojuegos.add(new Videojuego(id, title, platform, price));
            }

            System.out.println("Videojuegos cargados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private String getId() {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }


    private Plataforma platformFromString(String platformString) {

        try {
            return Plataforma.valueOf(platformString);
        } catch (IllegalArgumentException e) {
            return Plataforma.DESKTOP;
        }

    }

}
