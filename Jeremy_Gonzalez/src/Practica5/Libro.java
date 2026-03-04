package Practica5;

public class Libro extends Material {

    private int numeroPaginas;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo,titulo,autor,anioPublicacion);
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
        return String.format(
                "Clases.Libro: %s, %s, %s, %d, %d paginas",
                getCodigo(),
                getTitulo(),
                getAutor(),
                getAnioPublicacion(),
                numeroPaginas
        );
    }
}
