package P5_GestiónDeBibliotecaDigital;

//clasee que representa un Libro. Hereda de Material.
public class Libro extends Material {

    private int numeroPaginas;

    public Libro(String codigo, String titulo, String autor,
                 int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    //MOSTRAR DETALLE, nos va a mostrar los detalles de el libro
    @Override
    public String mostrarDetalle() {
        return String.format(
                "LIBRO -> Código: %s | Título: %s | Autor: %s | Año: %d | Páginas: %d",
                getCodigo(),
                getTitulo(),
                getAutor(),
                getAnioPublicacion(),
                numeroPaginas
        );
    }
}
