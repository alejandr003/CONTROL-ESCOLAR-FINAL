package pkg2024ft22vfinal;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class ModeloCuatrimestres extends Conexion {

    ArrayList<Cuatrimestres> carteraCuatrimestres = new ArrayList<>();

    public void time() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500L);
            System.out.println(".");
        }
        System.out.println("");
    }

    public ArrayList index() {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from cuatrimestres");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                carteraCuatrimestres.add(new Cuatrimestres(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException ex) {
            System.out.println("Error al realizar listado..." + ex.getMessage());
        }
        System.out.println("Cuatrimestres listados con exito...");
        return carteraCuatrimestres;
    }

    public ArrayList create(String newcuatri) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("insert into cuatrimestres (nombre) values (?)");
            ps.setString(1, newcuatri);
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al crear cuatrimestres..." + ex.getMessage());
        }
        System.out.println("Agregado con exito...");
        return carteraCuatrimestres;
    }

    public ArrayList read() {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from cuatrimestres");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                carteraCuatrimestres.add(new Cuatrimestres(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException ex) {
            System.out.println("Error al realizar consulta..." + ex.getMessage());
        }
        return carteraCuatrimestres;
    }

    public ArrayList update(int ide, String upcuatri) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("update cuatrimestres set nombre = ? where id = ?");
            ps.setString(1, upcuatri);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println("Actualizando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar cuatrimestre..." + ex.getMessage());
        }
        System.out.println("Actualizado con exito!!!");
        return carteraCuatrimestres;
    }

    public ArrayList delete(int iddelete) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("delete from cuatrimestres where id = ? ");
            ps.setInt(1, iddelete);
            ps.executeQuery();
            System.out.println("Eliminando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar cuatrimestres..." + ex.getMessage());
        }

        return carteraCuatrimestres;
    }

    public ArrayList search(String cuatrib) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from cuatrimestres where nombre =?");
            ps.setString(1, cuatrib);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                int id = this.rs.getInt("id");
                String nombre = this.rs.getString("nombre");
                System.out.println("Resultado de la búsqueda:");
                System.out.println("|ID: " + id + "| Nombre: " + nombre + " |");
            } else {
                System.out.println("No se pudo encontrar el cuatrimestre '" + cuatrib + "'");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar..." + ex.getMessage());
        }

        return carteraCuatrimestres;
    }
}
