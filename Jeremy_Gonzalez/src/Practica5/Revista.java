package Practica5;

public class Revista extends  Material{

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
        return String.format(
                "Clases.Revista: %s, %s, %s, %d, edicion %d",
                getCodigo(),
                getTitulo(),
                getAutor(),
                getAnioPublicacion(),
                numeroEdicion
        );
    }
}
