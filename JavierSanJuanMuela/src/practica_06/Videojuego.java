import java.util.Locale;
import java.util.Objects;

/**
 * Clase VideoJuego
 * @author Javier -
 * @version 1.0
 */

public class Videojuego {
    private String id;
    private String titulo;
    private Plataforma platform;
    private double precio;

    /**
     *
     * @param id
     * @param titulo
     * @param platform
     * @param precio
     */

    public Videojuego(String id, String titulo, Plataforma platform, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.platform = platform;
        this.precio = precio;
    }

    /**
     * Getter del atributo platform
     * @return el id del platform
     */

    public Plataforma getPlatform() {
        return platform;
    }

    public void setPlatform(Plataforma platform) {
        this.platform = platform;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Objects.equals(id, that.id);
    }

    /**
     *
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return String.format(Locale.US, "%s;%s;%s;%.2f", id, titulo, platform.toString(), precio);
    }
}