package Entregas;

import Ejemplos.Vehiculo;

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
        for (Videojuego v : videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println("El id ya está asociado a un videojuego!");
                return;
            }
        }
        String titulo = sc.pideTexto("Introduce el titulo del videojuego: ");
        Plataforma tipo = Utilidades.pedirEnum(Plataforma.class, "Seleccione el tipo de plataforma: ");
        double precio = sc.pedirDecimal("Introduce el precio del videjuego: ");
        videojuegos.add(new Videojuego(id, titulo, tipo, precio));
        System.out.println("El videojuego a sido registrado correctamente!");
    }

    public void guardarVideojuego() {
        File archivo = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Videojuego v : videojuegos) {
                String linea = v.getId() + ";" + v.getTitulo() + ";" + v.getPlataforma() + ";" + v.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Videojuego guardado correctamente");

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
                videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
            }

            System.out.println("Videojuegos cargados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarVideojuego() {
        for (Videojuego v: videojuegos) {
            System.out.println(v);
        }
    }

    public void mostrarVideojuegoPorId(){
        for(Videojuego v : videojuegos){
            if (v.getId().equals(getId())) {
                System.out.println(v);
            } else {

            }
        }
    }

        private static String getId () {
            String id;
            String regex = "^[A-Z]{2}[1-9]{2}$";

            do {
                id = sc.pideTexto("Introduce el id (2 letras y 2 números): ").toUpperCase();
            } while (!id.matches(regex));
            return id;
        }
    }
