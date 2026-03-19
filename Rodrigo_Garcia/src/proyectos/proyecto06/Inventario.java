package proyectos.proyecto06;

import recursos.MyScanner;
import recursos.Utilidades;
import simulacros.simulacro04.Tipo;

import java.io.*;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Videojuego> videojuegos;
    private static final MyScanner sc = new MyScanner();
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Proyectos/";

    public Inventario() {
        this.videojuegos = new ArrayList<>();
        if(!Utilidades.existDirectory(RUTA)){
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void agregarVideojuego(){

        String id = getId();

        for(Videojuego vid : videojuegos){

            if(vid.getId().equals(id)){
                System.out.println("Ya hay un Videojuego para ese id");
                return;
            }
        }

        String titulo = sc.pideTexto("Ingrese un titulo: ");
        Plataforma plataforma = Utilidades.pedirEnum(Plataforma.class, "Elige el tipo de plataforma: ");
        double precio = sc.pedirDecimal("Ingrese el precio: ");

        videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
        System.out.println("El Videojuego se ha añadido");
    }

    public void mostrarVideojuegos(){

        if(videojuegos.isEmpty()){
            System.out.println("No hay videojuegos registrados");
            return;
        }
        for(Videojuego vid : videojuegos){
            System.out.println(vid);
        }
    }

    public void guardarVideojuegos(){

        File fichero = new File(RUTA, "inventario.txt");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

            for(Videojuego vid : videojuegos){
                String linea;
                linea = vid.getId() + ";" +
                        vid.getTitulo() + ";" +
                        vid.getPlataforma() + ";" +
                        vid.getPrecio();

                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Videojuegos escritos exitosamente");

        }catch(IOException e){
            System.out.println("Error al escribir el fichero");
        }
    }

    public void cargarVideojuegos(){

        File fichero = new File(RUTA, "inventario.txt");

        if (!fichero.exists()) {
            System.out.println("El fichero no existe");
            return;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){

            String linea;

            while((linea = br.readLine()) != null){

                String datos[] = linea.split(";");

                if(datos.length == 4){

                    String id = datos[0];
                    String titulo = datos[1];
                    Plataforma plataforma = Enum.valueOf(Plataforma.class, datos[2]);
                    double precio = Double.parseDouble(datos[3]);

                    Videojuego videojuego = new Videojuego(id, titulo, plataforma, precio);

                    boolean existe = false;

                    for (Videojuego vid : videojuegos) {
                        if (vid.getId().equals(id)) {
                            existe = true;
                            break;
                        }
                    }

                    if (!existe) {
                        videojuegos.add(videojuego);
                    }
                }
            }

            System.out.println("Videojuegos cargados exitosamente");

        }catch(IOException e){
            System.out.println("Error al leer el fichero");
        }
    }

    public static String getId(){

        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Ingrese un id (2 letras y 2 números): ").toUpperCase();
        }while(!id.matches(regex));
        return id;
    }
}
