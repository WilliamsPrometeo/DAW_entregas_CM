package P6_GestiónDeInventarioDeVideojuegos;


import recursos.MyScanner;

/**
 * Clase principal
 */
public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {
        menu();
    }

    /**
     * Menú principal del programa
     */
    private static void menu() {
        int opcion;

        do {
            opcion = sc.pedirNumero(
                    "=== INVENTARIO VIDEOJUEGOS ===" +
                            "\n1. Registrar videojuego" +
                            "\n2. Mostrar inventario" +
                            "\n3. Mostrar videojuego por ID" +
                            "\n4. Guardar inventario" +
                            "\n5. Cargar inventario" +
                            "\n6. Salir" +
                            "\nOpción: "
            );

            switch (opcion) {
                case 1:
                    inventario.agregarVideojuego();
                    break;
                case 2:
                    inventario.mostrarVideojuegos();
                    break;
                case 3:
                    inventario.buscarPorId();
                    break;
                case 4:
                    inventario.guardar();
                    break;
                case 5:
                    inventario.cargar();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 6);
    }
}