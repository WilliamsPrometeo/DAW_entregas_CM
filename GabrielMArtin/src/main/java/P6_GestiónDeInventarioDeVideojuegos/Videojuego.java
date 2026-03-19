package P6_GestiónDeInventarioDeVideojuegos;

/**
 * Clase Videojuego
 * Representa un videojuego dentro del inventario
 *
 * @author Gabriel Martín Lafuente
 * @version 1.0
 */
public class Videojuego {

    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**
     * Constructor de la clase Videojuego
     *
     * @param id identificador del videojuego
     * @param titulo título del videojuego
     * @param plataforma plataforma del videojuego
     * @param precio precio del videojuego
     */
    public Videojuego(String id, String titulo, Plataforma plataforma, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    //GETTERS Y SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Representación en texto del videojuego
     */
    @Override
    public String toString() {
        return String.format("ID: %s - Titulo: %s - Plataforma: %s - Precio: %.2f€",
                getId(),
                getTitulo(),
                getPlataforma(),
                getPrecio());
    }
}
