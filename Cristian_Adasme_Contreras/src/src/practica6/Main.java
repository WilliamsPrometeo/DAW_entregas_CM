package src.practica6;

public class Main {

    private static final Inventario gestion = new Inventario();
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== INVENTARIO VIDEOJUEGOS ===" +
                    "\n1. Agregar videojuegos" +
                    "\n2. Mostrar videojuegos" +
                    "\n3. Guardar videojuegos" +
                    "\n4. Cargar videojuegos" +
                    "\n5. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    gestion.agregarVideojuegos();
                    break;
                case 2:
                    gestion.mostrarVideojuegos();
                    break;
                case 3:
                    gestion.guardarVideojuegos();
                    break;
                case 4:
                    gestion.cargarVideojuegos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (opcion != 5);
    }
}
