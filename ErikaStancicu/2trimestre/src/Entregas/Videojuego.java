package Entregas;

/**
 * Clase videojuego
 * @author Alumno - Erika Stancicu
 * @version 1.0
 */
public class Videojuego {
    private String id;
    private String titulo;
    Plataforma plataforma;
    private double precio;


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
     * @return el id del videojuego
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
     * @return el titulo del videjuego
     */
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
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Titulo: %s - Plataforma: %s - Precio: %.2f",
                getId(),
                getTitulo(),
                getPlataforma(),
                getPrecio());
    }
}
