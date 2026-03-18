package ejercicios.P6.Clases;

import ejercicios.P6.enums.Plataforma;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;
import java.util.ArrayList;

public class Inventario {
    
    private final ArrayList <Videojuego> videojuegos;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";
    
    public Inventario(ArrayList <Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }
    
    public void agregarVideojuego(String id) {
        for (Videojuego v : videojuegos) {
            if (v.getId().equals(id)) {
                System.out.println("El id ya está asociado a un videojuego!");
                return;
            }
        }
        String titulo = sc.pideTexto("Introduce el titulo del videojuego: ");
        Plataforma plataforma = Utilidades.pedirEnum(Plataforma.class, "Escoja el tipo de plataforma: ");
        double precio = sc.pedirDecimal("Introduzca el precio del videojuego:");
        videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
        
        System.out.println("El videojuego a sido registrado correctamente!");
    }
    
    public void mostrarVideojugos() {
        if (videojuegos.isEmpty()){
            System.out.println("Aun no se han agregado videojuegos");
            return;
        }
        
        for (Videojuego videojuego : videojuegos) {
            System.out.println(videojuego + "\n");
        }
    }
    
    public String mostrarVideojuegoPorId(String id) {
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getId().equals(id)) {
                return String.format("El videojuego con id: %s es:\n%s", id, videojuego);
            }
        }
        return String.format("No se encontró ningun videojuego con el id %s", id);
    }
    
    public void guardarInventarioEnArchivo() throws IOException {
        File archivo = new File(RUTA, "inventario.txt");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Videojuego v : videojuegos) {
                String linea = v.getId() + ";" + v.getTitulo() + ";" + v.getPlataforma() + ";" + v.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
            
            System.out.println("Videojuegos guardados correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cargarInventarioDesdeArchivo() throws IOException {
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
                Plataforma plataforma = Enum.valueOf(Plataforma.class, datos[2]);
                double precio = Double.parseDouble(datos[3]);
                
                videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
            }
            
            System.out.println("Videojugos cargados correctamente");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
