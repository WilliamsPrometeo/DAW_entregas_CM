package Entregas;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();


    public static void main(String[] args) {
     menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== VIDEOJUEGOS ===" +
                    "\n1. Registrar videjuego" +
                    "\n2. Mostrar Videojuego" +
                    "\n3. Mostrar datos del videojuego por id" +
                    "\n4. Guardar inventario en archivo" +
                    "\n5. Cragar inventario desde archivo" +
                    "\n6. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    inventario.agregarVideojuego();
                    break;
                case 2:
                    inventario.mostrarVideojuego();
                    break;
                case 3:
                    inventario.mostrarVideojuegoPorId();
                    break;
                case 4:
                    inventario.guardarVideojuego();
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
        } while (opcion != 5);
    }
}

