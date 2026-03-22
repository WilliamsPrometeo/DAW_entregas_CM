/**
 * Clase que representa un videojuego.
 *
 * Contiene informacion basica como id, titulo, plataforma y precio.
 * El id debe tener formato: 2 letras y  2 numeros.
 *
 * @author Jeremy
 * @version 1.0
 */
public class Videojuego {
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**
     * Constructor de la clase videojuego
     * @param id identificador del videojuego
     * @param titulo nombre del videojuego
     * @param plataforma plataforma del videojuego
     * @param precio precio del videojuego
     */
    public Videojuego(String id, String titulo, Plataforma plataforma, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

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

    @Override
    public String toString() {
        return String.format("ID:%s | Titulo:%s | Plataforma:%s | Precio:%.2f€", id, titulo,plataforma, precio);
    }
}
