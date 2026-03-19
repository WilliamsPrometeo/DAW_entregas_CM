package Entrega06;

public class Videojuego {

    /**
     * Clase Videojuego
     * @author Alumno - German Villar
     * @version 1.0
     */
        private String id;
        private String titulo;
        private TipoPlataforma plataforma;
        private double precio;

    /**
     *
     * @param id
     * @param titulo
     * @param plataforma
     * @param precio
     */
    public Videojuego(String id, String titulo, TipoPlataforma plataforma, double precio) {
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
     * @param id del videojuego
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
     * @param titulo del videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Getter del atributo plataforma
     * @return el plataforma del videojuego
     */
    public TipoPlataforma getPlataforma() {
        return plataforma;
    }
    /**
     * Setter del atributo plataforma
     * @param plataforma del videojuego
     */
    public void setPlataforma(TipoPlataforma plataforma) {
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
     * @param precio del videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
         *
         * @return
         */
        @Override
        public String toString() {
            return String.format("Cliente: %s - Nombre: %s - Plataforma: %s - Precio: %f",
                    getId(),
                    getTitulo(),
                    getPlataforma(),
                    getPrecio());
        }
}

