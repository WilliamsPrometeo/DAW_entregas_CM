package src.practica5.Clases;

public class Revista extends Material{
    private int numEdicion;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numEdicion = numEdicion;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }

    @Override
    public String mostrarDetalle() {
        return String.format("Revista: %s, %s, %s, %d, %d",
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion(),
                numEdicion);
    }
}
