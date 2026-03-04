package Practica05.Clases;

import Practica05.Material;

public class Libro extends Material {
    int numeroPaginas;

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
        return String.format("Codigo: %s\nTitulo: %s\nAutor: %s\nAnio de publicacion: %d\nNumero de paginas: %d",
                getCodigo(), getTitulo(), getAutor(), getAnioPublicacion(), numeroPaginas);
    }

}
