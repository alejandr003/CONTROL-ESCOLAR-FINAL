package pkg2024ft22vfinal;

/**
 *
 * @author aleja
 */
public class Cuatrimestres {

    private String nombre;
    private int id;

    public Cuatrimestres(int id, String nuevonombre) {
        this.id = id;
        this.nombre = nuevonombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
