package Practica5;

import Clases.Biblioteca;
import Clases.Libro;
import Clases.Material;
import Clases.Revista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;

        do {
            System.out.println("=====GESTION DE BIBLIOTECA DIGITAL=====");
            System.out.println("1. Registrar material");
            System.out.println("2. Mostrar stock");
            System.out.println("3. Prestar material");
            System.out.println("4. Mostrar material disponible");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("1. Libro");
                    System.out.println("2. Revista");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Anio publicacion: ");
                    int anioPublicacion = sc.nextInt();

                    if (tipo == 1) {
                        System.out.print("Numero paginas: ");
                        int paginas = sc.nextInt();

                        Material libro = new Libro(codigo, titulo, autor, anioPublicacion, paginas);

                        biblioteca.agregarMaterial(libro);

                    } else {
                        System.out.print("Numero edicion: ");
                        int edicion = sc.nextInt();

                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion, edicion);

                        biblioteca.agregarMaterial(revista);
                    }
                    break;

                case 2:
                    System.out.println("Codigo material: ");
                    String codStock = sc.nextLine();

                    biblioteca.consultarStock(codStock);
                    break;

                case 3:
                    System.out.println("Codigo material: ");
                    String codPrestar = sc.nextLine();

                    biblioteca.prestarMatertial(codPrestar);
                    break;

                case 4:
                    biblioteca.mostrarMateriales();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opcion != 5);

        sc.close();
    }
}
