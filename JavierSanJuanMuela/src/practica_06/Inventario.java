import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Inventario {
    private ArrayList<Videojuego> inventario = new ArrayList<Videojuego>();

    public ArrayList<Videojuego> getInventario() {
        return inventario;
    }

    public void addVideogame(Videojuego videojuego) {
        if (inventario.add(videojuego)) {
            System.out.println("Videojuego agregado correctamente.");
        } else {
            System.out.println("Ocurrió un error al agregar un videojuego.");
        }
    }

    public void lookupInventory() {
        for (Videojuego videojuego : inventario) {
            System.out.println(videojuego.toString());
        }
    }

    public void lookupInventoryId(String id) {
        for (Videojuego videojuego : inventario) {
            if (Objects.equals(videojuego.getId(), id)) {
                System.out.println(videojuego);
                return;
            }
        }
        System.out.println("No se ha encontrado ningún resultado.");
    }

    public void saveInventory() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/Desktop/DAW/Proyectos/inventario.txt"))) {
            for (Videojuego videojuego : inventario) {
                bw.write(videojuego.toString() + "\n");
            }
            System.out.println("Se guardó correctamente el archivo.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al procesar el archivo.");
        }
    }

    public void loadInventory() {
        try (BufferedReader bf = new BufferedReader(new FileReader(System.getProperty("user.home") + "/Desktop/DAW/Proyectos/inventario.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] lines = line.split(";");
                inventario.clear();
                inventario.add(new Videojuego(lines[0], lines[1], Plataforma.valueOf(lines[2]), Double.parseDouble(lines[3])));
            }
            System.out.println("Se cargo el archivo correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo.");
        }
    }
}
