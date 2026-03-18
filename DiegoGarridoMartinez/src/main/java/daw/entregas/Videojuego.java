package daw.entregas;

public class Videojuego {

    /**Atributos**/
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**Constructor Videojuego**/
    public Videojuego(String id, String titulo, Plataforma plataforma, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }
    /**Getters y Setters de los Atributos**/
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

    /**TO STRING de Videojuego**/
    @Override
    public String toString() {
        return String.format("ID: %s - Titulo: %s - Plataforma: %s - Precio: %.2f€",
                id, titulo, plataforma, precio);
    }
}
