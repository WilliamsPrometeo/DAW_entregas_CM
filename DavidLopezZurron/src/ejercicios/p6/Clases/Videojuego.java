package ejercicios.P6.Clases;

import ejercicios.P6.enums.Plataforma;

/**
 Clase videojugo
 
 @author David Lopez Zurron
 @version 1.0 */
public class Videojuego {
    
    
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;
    
    /**
     Constructor de la clase
     
     @param id Id del videojuego
     @param titulo Título del videojuego
     @param plataforma Plataforma en la que se juega al videojuego
     @param precio Precio del videojugo
     */
    public Videojuego(String id, String titulo, Plataforma plataforma, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }
    
    /**
     Getter del atributo id
     
     @return id
     */
    public String getId() {
        return id;
    }
    
    /**
     Setter del atributo id
     
     @param id Id del videojuego
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     Getter del atributo titulo
     
     @return titulo
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     Setter del atributo id
     
     @param titulo Titulo del videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     Getter del atributo plataforma
     
     @return plataforma
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }
    
    /**
     Setter del atributo id
     
     @param plataforma Plataforma del videojuego
     */
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
    
    /**
     Getter del atributo precio
     
     @return precio
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     Setter del atributo id
     
     @param precio Precio del videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     Sobrescribe el metodo toString
     
     @return Los atributos formateados
     */
    @Override
    public String toString() {
        return String.format("""
            ID: %s
            Titulo: %s
            Plataforma: %s
            Precio: %.2f
            """, id, titulo, plataforma, precio);
    }
}
