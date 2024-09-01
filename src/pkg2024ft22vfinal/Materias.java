/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2024ft22vfinal;

/**
 *
 * @author aleja
 */
public class Materias {

    private int id;
    private String nombre;

    Materias(int id, String nuevonombre) {
        this.id = id;
        this.nombre = nuevonombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
