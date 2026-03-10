package Practica05.Clases;

import Practica05.Material;

public class Revista extends Material {
    int numeroEdicion;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarDetalle() {
        return String.format("Codigo: %s\nTitulo: %s\nAutor: %s\nAnio de publicacion: %d\nNumero de edicion: %d",
                getCodigo(), getTitulo(), getAutor(), getAnioPublicacion(), numeroEdicion);
    }
}
