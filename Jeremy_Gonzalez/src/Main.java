import Recursos.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;

        do {
            opcion = sc.pedirNumero(
                    "\n ====INVENTARIO DE VIDEOJUEGOS====" +
                            "\n1. Registrar videojuego" +
                            "\n2. Mostrar inventario" +
                            "\n3. Buscar por ID" +
                            "\n4. Guardar en archivo" +
                            "\n5. Cargar desde archivo" +
                            "\n6. Salir"
            );

            switch (opcion) {
                case 1 -> inventario.agregarVideojuego();
                case 2 -> inventario.mostrarVideojuego();
                case 3 -> inventario.buscarPorId();
                case 4 -> inventario.guardar();
                case 5 -> inventario.cargar();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (op != 6);
    }
}


