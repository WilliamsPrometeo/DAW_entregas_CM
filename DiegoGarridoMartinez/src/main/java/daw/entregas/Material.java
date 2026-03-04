package daw.entregas;

import java.util.Objects;

public abstract class Material {

    // atributos
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    //Constructor del material
    public Material(String codigo, String titulo, String autor, int anioPublicacion) {

        if (!codigo.matches("[A-Za-z]{3}\\d{2}")) {
            System.out.println("El codigo no es valido");
        }

        this.codigo = codigo.toUpperCase();
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    //Metodo para mostrar
    public abstract String mostrarDetalle();


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Material material = (Material) obj;
        return codigo.equals(material.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
