package practica_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private ArrayList<Material> listaMateriales = new ArrayList<>();
    private Map<Material, Integer> stockMateriales = new HashMap<>();

    public void agregarMaterial(Material material) {
        listaMateriales.add(material);
        stockMateriales.put(material, 999);
    }

    public void prestarMaterial(int opcion) {
        if (stockMateriales.get(getListaMateriales().get(opcion)) == 1) {
            stockMateriales.replace(getListaMateriales().get(opcion), stockMateriales.get(getListaMateriales().get(opcion)) - 1);
            stockMateriales.remove(getListaMateriales().get(opcion));
        } else {
            stockMateriales.replace(getListaMateriales().get(opcion), stockMateriales.get(getListaMateriales().get(opcion)) - 1);
        }
    }

    public void consultarTotalStock() {
        int stockTotal = 0;
        for (Material listaMateriale : listaMateriales) {
            stockTotal += stockMateriales.get(listaMateriale);
        }
        System.out.println("Stock Total: " + stockTotal);
    }

    public ArrayList<Material> getListaMateriales() {
        return listaMateriales;
    }

    public Map<Material, Integer> getStockMateriales() {
        return stockMateriales;
    }

    public void mostrarMaterialDisponible() {
        for (Material listaMateriale : listaMateriales) {
            System.out.println(listaMateriale.mostrarDetalle());
        }
    }
}
