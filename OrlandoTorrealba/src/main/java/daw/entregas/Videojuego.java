package daw.entregas;

/**
 *Clase videojuego
 * @author Alumno - Orlando Torrelba
 * @version 1.0
 */
public class Videojuego {
        private String id;
        private String titulo;
        private Plataforma plataforma;
        private double precio;
    
    /**
     
     * @param id
     * @param titulo
     * @param plataforma
     * @param precio
     */
    public Videojuego(String id, String titulo, Plataforma plataforma,  double precio) {
            this.id = id;
            this.titulo = titulo;
            this.plataforma = plataforma;
            this.precio = precio;
        }
    
    /**
     * Getter del atributo id
     * @return el id del Videojuego
     */
    public String getId() {
        return id;
    }
    
    /**
     * Setter del atributo id
     * @param id establece el id del videojuego
     */
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
     *
     * @return
     */
    @Override
        public String toString() {
            return String.format("Id Videojuego: %s - Titulo: %s- Plataforma: %s - precio: %f",
                getId(),
                getTitulo(),
                getPlataforma(),
                getPrecio());
        }
    }


