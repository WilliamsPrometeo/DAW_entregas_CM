package Clases;

import enums.Plataforma;

/**
 * Clase Videojuego
 * @author David Wei Xu
 * @version 1.0
 */
public class Videojuego {
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**
     *
     * @param id el ID del videojuego
     * @param titulo el titulo del videojuego
     * @param plataforma la plataforma en el que se puede jugar
     * @param precio el precio del videojuego
     */
    public Videojuego(String id, String titulo, Plataforma plataforma, double precio) {
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
     *  Setter del atributo id
     * @param id establece el id del videojuego
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
     * @param titulo establece el titulo del videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo plataforma
     * @return la plataforma del videojuego
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Setter del atributo plataforma
     * @param plataforma establece la plataforma del videojuego
     */
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
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
     * @param precio establece el precio del videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metedo toString de videojuego
     * @return la información del videojuego
     */
    @Override
    public String toString() {
        return String.format("Videojuego: %s - Titulo: %s - Plataforma: %s - Precio: %f",
                getId(),
                getTitulo(),
                getPlataforma(),
                getPrecio());
    }
}
