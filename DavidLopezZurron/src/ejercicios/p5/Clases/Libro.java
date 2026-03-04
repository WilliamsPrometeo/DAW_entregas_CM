package ejercicios.p5.Clases;

public class Libro extends Material {
    //Atributos
    private int numeroPaginas;
    
    //Constructor
    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }
    
    //Getters y setters
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    //Metodos
    @Override
    public String mostrarDetalle() {
        return String.format("""
            Los detalles del libro son:
            Código: %s
            Titulo: %s
            Autor: %s
            Año de publicación: %d
            Numero de paginas: %d""", super.getCodigo(), super.getTitulo(), super.getAutor(), super.getAnioPublicacion(), this.numeroPaginas);
    }
}
