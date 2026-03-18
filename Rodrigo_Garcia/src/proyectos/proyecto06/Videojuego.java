package proyectos.proyecto06;

/**
 * Clase Videojuego
 * @author rodrigo
 * @version 1.0
 */
public class Videojuego {

    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**
     * Constructor
     * @param id id del videojuego
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

    /**
     * Getter id videojuego
     * @return id videojuego
     */
    public String getId() {
        return id;
    }

    /**
     * Setter id videojuego
     * @param id establece id videojuego
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter titulo videojuego
     * @return titulo videojuego
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter titulo videojuego
     * @param titulo establece titulo videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter plataforma videojuego
     * @return plataforma videojuego
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Setter plataforma videojuego
     * @param plataforma establece plataforma videojuego
     */
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Getter precio videojuego
     * @return precio videojuego
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter precio videojuego
     * @param precio establece precio videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo toString de videojuego
     * @return retorna un videojuego
     */
    @Override
    public String toString() {
        return String.format("Videojuego{ id: %s, título: %s, plataforma: %s, precio: %f }",
                getId(),
                getTitulo(),
                getPlataforma(),
                getPrecio());
    }
}
