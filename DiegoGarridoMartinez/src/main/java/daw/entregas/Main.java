package daw.entregas;

import daw.entregas.recursos.MyScanner;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;

        do {
            opcion = sc.pedirNumero("""
                    === INVENTARIO VIDEOJUEGOS ===
                    1. Registrar videojuego
                    2. Mostrar inventario
                    3. Mostrar videojuego por ID
                    4. Guardar inventario
                    5. Cargar inventario
                    6. Salir
                    Opción:
                    """);

            switch (opcion) {
                case 1 -> inventario.agregarVideojuego();
                case 2 -> inventario.mostrarInventario();
                case 3 -> inventario.mostrarPorId();
                case 4 -> inventario.guardarInventario();
                case 5 -> inventario.cargarInventario();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 6);
    }
}
