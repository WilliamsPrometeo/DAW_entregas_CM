package daw.entregas.GestionBiblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    private ArrayList<Material> lista = new ArrayList<>();
    private Map<Material, Integer> stock = new HashMap<>();

    public void agregarMaterial(Material material) {
        if (lista.contains(material))
            System.out.println("Ya existe una.");
        else {
            lista.add(material);
            stock.put(material, 1);
        }
    }

    public void consultarMaterial(String codigo) {
        for (Material material : stock.keySet())
            if (material.getCodigo().equals(codigo.toUpperCase())) {
                System.out.println("Stock es: " + stock.get(material));
                return;
            }
    }
    public void prestarMaterial(String codigo) {
        for (Material material : lista)
            if (material.getCodigo().equals(codigo.toUpperCase())) {
                int s = stock.get(material);
                if (s > 1)
                    stock.put(material, s - 1);
                else {
                    stock.remove(material);
                    lista.remove(material);
                }
                System.out.println("Ha sido prestado.");
                return;
            }
        System.out.println("No encontrado.");
    }

    public void mostrarMateriales() {
        if (lista == null) {
            System.out.println("No hay materiales.");
            return;
        }

        for (Material material : lista)
            System.out.println(material.mostrarDetalle());
    }

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        Biblioteca b = new Biblioteca();
        int n;

        do {
            System.out.println("Gestion de materiales: ");
            System.out.println("1. Agregar material" );
            System.out.println("2. Mostrar Stock ");
            System.out.println("3. Prestar material ");
            System.out.println("4. Mostrar material ");
            System.out.println("5. Salir ");
            n = sc.pedirNumero("opción:");

            if (n == 1) {

                int tipo = sc.pedirNumero("1.Libro 2.Revista");
                String codigo = sc.pideTexto("Codigo:");
                String titulo = sc.pideTexto("Titulo:");
                String autor = sc.pedirSoloTexto("Autor:");
                int num = sc.pedirNumero("año:");

                if (tipo == 1) {
                    int p = sc.pedirNumero("paginas:");
                    b.agregarMaterial(new Libro(codigo, titulo, autor, num, p));
                } else {
                    int e = sc.pedirNumero("edicion:");
                    b.agregarMaterial(new Revista(codigo, titulo, autor, num, e));
                }
            }

            if (n == 2) {
                b.consultarMaterial(sc.pideTexto("codigo:"));
            }

            if (n == 3) {
                b.prestarMaterial(sc.pideTexto("codigo:"));
            }

            if (n == 4) {
                b.mostrarMateriales();
            }

        } while (n != 5);

        sc.cerrar();
    }
}