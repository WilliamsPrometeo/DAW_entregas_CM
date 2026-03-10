package src.practica5.Clases;

public class Libro extends Material{
    private int numPaginas;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String mostrarDetalle() {
        return String.format("Libro: %s, %s, %s, %d, %d",
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion(),
                numPaginas);
    }
}
