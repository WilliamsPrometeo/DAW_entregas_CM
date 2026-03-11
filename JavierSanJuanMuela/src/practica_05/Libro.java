package practica_05;

public class Libro extends Material{
    private int numeroPaginas;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String mostrarDetalle() {
        return String.format("Código: %s | Título: %s | Autor: %s | Año de Publicación: %s | Número de Páginas: %s", getCodigo(), getTitulo(), getAutor(), getAnioPublicacion(), numeroPaginas);
    }
}
