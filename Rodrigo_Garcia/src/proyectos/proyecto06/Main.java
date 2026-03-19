package proyectos.proyecto06;

import recursos.MyScanner;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Inventario inventario = new Inventario();

    public static void main(String[] args) {

        int opcion;
        do{
            opcion = sc.pedirNumero(
                    "\n==== GESTIÓN VIDEOJUEGOS ==== \n" +
                            "\n1. Añadir videojuego" +
                            "\n2. Mostrar videojuegos" +
                            "\n3. Guardar videojuegos en fichero" +
                            "\n4. Cargar videojuegos desde fichero" +
                            "\n5. Salir" +
                            "\n\nOpción (1-5): "
            );
            switch(opcion){
                case 1 -> {
                    inventario.agregarVideojuego();
                }
                case 2 -> {
                    inventario.mostrarVideojuegos();
                }
                case 3 -> {
                    inventario.guardarVideojuegos();
                }
                case 4 -> {
                    inventario.cargarVideojuegos();
                }
                case 5 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        }while(opcion != 5);
    }
}
