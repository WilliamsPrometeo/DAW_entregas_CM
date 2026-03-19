package Entrega06;



public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario i = new Inventario();

    public static void main(String[] args) {

        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== GESTION CLIENTES ===" +
                    "\n1. Agrear Cliente" +
                    "\n2. Mostrar Clientes" +
                    "\n3. Guardar clientes en fichero" +
                    "\n4. Cargar clientes desde fichero" +
                    "\n5. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    i.agregarVideojuego();
                    break;
                case 2:
                    i.mostrarVideojuego();
                    break;
                case 3:
                    i.guardarVideojuego();
                    break;
                case 4:
                    i.cargarVideojuego();
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

