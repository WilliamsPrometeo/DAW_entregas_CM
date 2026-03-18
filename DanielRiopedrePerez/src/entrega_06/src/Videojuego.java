package entrega_06.src;

public class Videojuego {
    /** Clase Videojuego
     * @author grog
     * @version 1.0
     */
    private String id;
    private String title;
    private Plataforma plataforma;
    private double price;

    /**
     *
     * @param id
     * @param title
     * @param plataforma
     * @param price
     */
    public Videojuego(String id, String title, Plataforma plataforma, double price) {
        this.id = id;
        this.title = title;
        this.plataforma = plataforma;
        this.price = price;
    }


    /**
     * Getter del atributo id
     * @return id del videojuego
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del atributo title
     * @return title del videojuego
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter del atributo plataforma
     * @return plataforma del videojuego
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Getter del atributo price
     * @return price del videojuego
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Videojuego{" +
                "id='" + this.getId() + '\'' +
                ", title='" + this.getTitle() + '\'' +
                ", plataforma=" + this.getPlataforma() +
                ", price=" + this.getPrice() +
                '}';
    }
}
