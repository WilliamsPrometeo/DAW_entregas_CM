package practica_05;

public class Revista extends Material {
    private int numeroEdicion;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public String mostrarDetalle() {
        return String.format("Código: %s | Título: %s | Autor: %s | Año de Publicación: %s | Número de Edición: %s", getCodigo(), getTitulo(), getAutor(), getAnioPublicacion(), numeroEdicion);
    }
}
