package daw.entregas.Practica06;

import daw.entregas.Practica06.enums.Plataforma;

/**
 * Clase cliente
 * @author Alumno -Jianing Xu Yang
 * @version 1.0
 */
public class Videojuego {
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;
    /**
     * Constructor de la clase Videojuego
     *@param id
     *@param titulo
     *@param plataforma
     *@param precio
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
     * Setter del atributo id
     * @param id estable el id del videojuego
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
     * Getter del atributo plataforma
     * @return el plataforma del videojuego
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Setter del atributo plataforma
     * @param plataforma estable el plataforma del videojuego
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
     * @param precio estable el precio del videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * ToString de videojuego formateado
     * @return Una cadena que describe el estado actual del videojuego.
     */
    @Override
    public String toString() {
        return String.format("Id: %s -Titulo: %s -Plataforma: %s -Precio: %.2f", getId(), getTitulo(), getPlataforma(), getPrecio());
    }
}
