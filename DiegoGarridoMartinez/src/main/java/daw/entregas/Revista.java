package daw.entregas;

//Clase de Revista heredada por Material
public class Revista extends Material {

    private int numeroEdicion;

    //Constructor
    public Revista(String codigo, String titulo, String autor,
                   int anioPublicacion, int numeroEdicion) {

        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    //mostramos los detalles

    @Override
    public String mostrarDetalle() {
        return "REVISTA -> Código: " + getCodigo()
                + ", Título: " + getTitulo()
                + ", Autor: " + getAutor()
                + ", Año: " + getAnioPublicacion()
                + ", Edición: " + numeroEdicion;
    }
}
