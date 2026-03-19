package Ejercicios;

import Clases.Inventario;
import Recursos.MyScanner;

public class GestionInventarioVideojuegos {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== INVENTARIO DE VIDEOJUEGOS ===" +
                    "\n1. Registrar videojuego" +
                    "\n2. Mostrar inventario de videojuegos" +
                    "\n3. Mostrar datos del videojuegos por ID" +
                    "\n4. Guardar videojuegos en fichero" +
                    "\n5. Cargar inventario desde el archivo" +
                    "\n6. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    inventario.agregarVideojuegos();
                    break;
                case 2:
                    inventario.mostrarVideojuegos();
                    break;
                case 3:
                    inventario.mostrarPorID();
                    break;
                case 4:
                    inventario.guardarVideojuegos();
                    break;
                case 5:
                    inventario.cargarVideojuegos();
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
}