package Practica5;

public abstract class Material {
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Material(String codigo, String titulo, String autor, int anioPublicacion) {
        if (!codigo.matches("[A-Za-z]{3}\\d{2}")) {
            throw new IllegalArgumentException("El codigo debe tener 3 letras y dos numeros");
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public abstract String mostrarDetalle();

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;

        }if (objeto == null || getClass() != objeto.getClass()) {
           return false;

        }
        Material material = (Material) objeto;

        return codigo != null ? codigo.equals(material.codigo) : material.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
