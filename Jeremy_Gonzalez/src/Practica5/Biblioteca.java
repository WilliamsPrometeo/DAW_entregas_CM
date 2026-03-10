package Practica5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    private ArrayList<Material> listaMateriales;
    private Map<Material, Integer> stockMateriales;

    public Biblioteca(){
        listaMateriales = new ArrayList<>();
        stockMateriales = new HashMap<>();
    }

    public void agregarMaterial(Material material){

        if (listaMateriales.contains(material)){
            System.out.println("El material ya existe");
            return;
        }

        listaMateriales.add(material);
        stockMateriales.put(material, 1);

        System.out.println("Clases.Material añadido correctamente");
    }

    public void consultarStock(String codigo) {

        for (Material material : stockMateriales.keySet()){
            if (material.getCodigo().equals(codigo)){

                System.out.println("Stock disponible: " + stockMateriales.get(material));
                return;
            }
        }
        System.out.println("Clases.Material no encontrado");
    }

    public boolean prestarMatertial(String codigo) {
        Material encontrado = null;

        for (Material material : listaMateriales){
            if (material.getCodigo().equals(codigo)){
                encontrado = material;
                break;
            }
        }

        if (encontrado == null){
            System.out.println("Clases.Material no encontrado");
            return false;
        }

        int stockActual = stockMateriales.get(encontrado);

        if (stockActual <= 0 ){
            System.out.println("No hay stock disponible");
            return false;
        }

        stockActual--;

        if (stockActual == 0) {
            stockMateriales.remove(encontrado);
            listaMateriales.remove(encontrado);
            System.out.println("Clases.Material prestado y eliminado (sin stock)");

        } else  {
            stockMateriales.put(encontrado, stockActual);
            System.out.println("Clases.Material prestado correctamente");
        }
        return true;
    }

    public void mostrarMateriales(){

        if (listaMateriales.isEmpty()){
            System.out.println("No hay material registrados");
            return;
        }

        for (Material material : listaMateriales){
            System.out.println(material.mostrarDetalle() + "Stock: " + stockMateriales.get(material));
        }
    }
}
