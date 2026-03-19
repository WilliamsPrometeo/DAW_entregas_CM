package entrega_06.src;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== INVENTARIO VIDEOJUEGOS ===" +
                    "\n1. Agregar videojuego" +
                    "\n2. Mostrar videojuegos" +
                    "\n3. Mostrar videojuego por id" +
                    "\n4. Guardar en fichero" +
                    "\n5. Cargar videojuegos desde fichero" +
                    "\n6. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    inventario.addVideojuego();
                    break;
                case 2:
                    inventario.mostrarVideojuegos();
                    break;

                case 3:
                    inventario.showVideojuegoById();
                    break;
                case 4:
                    inventario.guardarVideojuegos();
                    break;
                case 5:
                    inventario.loadVideojuegos();
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
