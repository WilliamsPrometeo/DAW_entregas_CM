package ejercicios.P6;

import ejercicios.P6.Clases.Inventario;
import ejercicios.P6.Clases.Videojuego;
import recursos.MyScanner;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario(new ArrayList <Videojuego>());
    
    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            opcion = sc.pedirNumero("""
                
                Opcion 1: Registrar videojuego
                Opcion 2: Mostrar innventario
                Opcion 3: Mostrar videojuego por id
                Opcion 4: Guardar Inventario en un archivo.txt
                Opcion 5: Cargar inventario de un archivo.txt
                Opcion 6: Salir
                
                Seleccione una opción:""");
            switch (opcion) {
                case 1:
                    inventario.agregarVideojuego(getId());
                    break;
                case 2:
                    inventario.mostrarVideojugos();
                    break;
                case 3:
                    System.out.println(inventario.mostrarVideojuegoPorId(getId()));
                    break;
                case 4:
                    inventario.guardarInventarioEnArchivo();
                    break;
                case 5:
                    inventario.cargarInventarioDesdeArchivo();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (opcion != 6);
    }
    
    private static String getId() {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 2 números): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}

