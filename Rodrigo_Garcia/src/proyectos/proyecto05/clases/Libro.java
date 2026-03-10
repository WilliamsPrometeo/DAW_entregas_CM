package proyectos.proyecto05.clases;

public class Libro extends Material {

    private int numeroPaginas;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarDetalle() {
        return String.format("Libro{Nº de páginas: %d, código: %5s, titulo: %s, autor: %s, año de publicación: %d}",
                this.getNumeroPaginas(),
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion());
    }
}
