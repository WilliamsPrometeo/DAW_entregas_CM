package daw.entregas.practica5;

public abstract class Libro extends Material {
    //ATRIBUTOS
    int numeroPaginas;

    //CONSTRUCTOR
    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    //GETTERS
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    //SETTERS
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    //MÉTODOS
    //MÉTODO ABSTRACTO QUE MUESTRA LA INFORMACIÓN DEL LIBRO
    public abstract String mostrarDetalle();
}
