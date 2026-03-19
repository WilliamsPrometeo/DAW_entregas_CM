package clases;

import recursos.MyScanner;

public class Main
{
    private static final MyScanner sc = new MyScanner();
    private static final Inventario gestion = new Inventario();

    public static void main(String[] args)
    {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== GESTION CLIENTES ===" +
                    "\n1. Agregar Videojueggos" +
                    "\n2. Mostrar Videojuegos" +
                    "\n3. Guardar videojuegos en fichero" +
                    "\n4. Cargar videojuegos desde fichero" +
                    "\n5. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    gestion.agregarVideojuego();
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
