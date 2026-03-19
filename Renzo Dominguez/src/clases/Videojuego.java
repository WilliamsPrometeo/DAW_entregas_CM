package clases;

import enums.Plataforma;

public class Videojuego
{
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**
     * CONSTRUCTOR DE LA CLASE
     * @param id identificador unico
     * @param titulo nombre del juego
     * @param plataforma el tipo de plataforma
     * @param precio el valor en euros
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

    /**
     * Metodo toString
     * @return los parametros
     */
    @Override
    public String toString(){
        return String.format("id: %s - titulo: %s - plataforma-> Tipo: %8s - precio: %f",titulo,id,plataforma,precio);
    }

}
