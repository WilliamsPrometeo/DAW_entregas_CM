package Videojuegos;

/**
 * Clase videojuego
 * @author diegocouto
 * @version 1.0
 */

public class Videojuego {

    String id;
    String titulo;
    Enum plataforma;
    double precio;

    /**
     * @param id
     * @param  titulo
     * @param  precio
     */
    public Videojuego(String id, String titulo, Enum plataforma, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    /**
     * Getter del atributo id
     * @return el id del videojuego
     */
    public String getId() {
        return id;
    }

    /**
     * Setter del atributo id
     * @param id estable del id del cliente
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del atributo titulo
     * @return el titulo del videojuego
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo titulo
     * @param titulo estable el titulo del videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo precio
     * @return el precio del videojuego
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter del atributo precio
     * @param precio estable el precio del videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Getter del Enum plataforma
     * @return la plataforma del videojuego
     */
    public Enum getPlataforma() {
        return plataforma;
    }

    /**
     * Setter del Enum de la plataforma
     * @param plataforma estable el Enum del videojuego
     */
    public void setPlataforma(Enum plataforma) {
        this.plataforma = plataforma;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Vidiojuego: %s - titulo: %s - Id: %s - precio: %s - plataforma: %s",
                getId(),
                getPrecio(),
                getTitulo(),
                getPlataforma());
    }
}
