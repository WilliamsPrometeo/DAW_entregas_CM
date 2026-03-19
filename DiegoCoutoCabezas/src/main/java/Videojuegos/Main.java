package Videojuegos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {opcion = sc.nextInt();
            System.out.println("MENU");
            System.out.println("1. Registrar videojuego");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Mostrar videojuego por ID");
            System.out.println("4. Guardar inventario");
            System.out.println("5. Cargar inventario");
            System.out.println("6. Salir");

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("titulo: ");
                        String titulo = sc.nextLine();

                        System.out.print("plataforma: ");
                        Plataforma plataforma = Plataforma.valueOf(sc.nextLine().toUpperCase());

                        System.out.print("precio: ");
                        double precio = sc.nextDouble();

                        Videojuego v = new Videojuego(id, titulo, plataforma, precio);
                        inventario.agregar(v);

                    } catch (Exception e) {
                        System.out.println("Error en los datos.");
                    }
                    break;

                case 2:
                    inventario.mostrar();
                    break;

                case 3:
                    System.out.print("Introduce ID: ");
                    String idBuscar = sc.nextLine();
                    Videojuego encontrado = inventario.buscarPorId(idBuscar).getId();

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("No encontrado.");
                    }
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
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}