package daw.entregas;

public class Libro extends Material {

    private int numeroPaginas;

    public Libro(String codigo, String titulo, String autor,
                 int anioPublicacion, int numeroPaginas) {

        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarDetalle() {
        return "LIBRO -> Código: " + getCodigo()
                + ", Título: " + getTitulo()
                + ", Autor: " + getAutor()
                + ", Año: " + getAnioPublicacion()
                + ", Páginas: " + numeroPaginas;
    }
}
