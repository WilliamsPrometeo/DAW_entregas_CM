package daw.entregas.GestionBiblioteca;

public class Revista extends Material {

    private int numeroEdicion;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarDetalle() {
        return "REVISTA - Código: " + getCodigo() +
                ", Título: " + getTitulo() +
                ", Autor: " + getAutor() +
                ", Año: " + getAnioPublicacion() +
                ", Edición: " + numeroEdicion;
    }
}