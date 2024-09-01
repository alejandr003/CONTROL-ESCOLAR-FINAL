package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author aleja
 */
public class ModeloCarreras extends Conexion {

    ArrayList<Carreras> carteraCarreras = new ArrayList<>();

    public void time() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500L);
            System.out.println(".");
        }
        System.out.println(" ");
    }

    public ArrayList index() {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from carreras");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {

                carteraCarreras.add(new Carreras(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar..." + ex.getMessage());
        }

        return carteraCarreras;
    }

    public ArrayList create(String newcarrera) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("insert into carreras (nombre) values (?)");
            ps.setString(1, newcarrera);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al crear carrera..." + ex.getMessage());
        }
        return carteraCarreras;
    }

    public ArrayList read() {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from carreras");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {

                carteraCarreras.add(new Carreras(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar..." + ex.getMessage());
        }

        return carteraCarreras;
    }

    public ArrayList update(int ide, String upcarrera) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("update carreras set nombre = ? where id = ?");
            ps.setString(1, upcarrera);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println("Actualizando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar carrera..." + ex.getMessage());
        }
        System.out.println("Actualizado con exito!!!");
        return carteraCarreras;
    }

    public ArrayList delete(int iddelete) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("delete from carreras where id = ? ");
            ps.setInt(1, iddelete);
            ps.executeQuery();
            System.out.println("Eliminando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar carrera..." + ex.getMessage());
        }
        return carteraCarreras;
    }

    public ArrayList search(String carrerab) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from carreras where nombre =?");
            ps.setString(1, carrerab);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                int id = this.rs.getInt("id");
                String nombre = this.rs.getString("nombre");
                System.out.println("Resultado de la búsqueda:");
                System.out.println("|ID: " + id + "| Nombre: " + nombre + " |");
            } else {
                System.out.println("No se pudo encontrar la carrera '" + carrerab + "'");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar..." + ex.getMessage());
        }

        return carteraCarreras;
    }
}
