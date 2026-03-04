package daw.entregas.clases;

public class Libro extends Material {
    //Atributo

    private int numeroPaginas;

    //Constructor

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    //Getters y Setters

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    //Metodo

    @Override
    public String mostrarDetalle() {
        return String.format("Libro: %s, %s, %s, %d, %d",
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion(),
                this.getNumeroPaginas());
    }
}
