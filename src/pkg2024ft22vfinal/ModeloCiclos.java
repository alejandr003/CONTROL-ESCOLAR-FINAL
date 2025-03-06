package pkg2024ft22vfinal;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class ModeloCiclos extends Conexion {

    ArrayList<Ciclos> carteraCiclos = new ArrayList<>();

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
            this.ps = this.cnx.prepareStatement("select * from ciclos");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                carteraCiclos.add(new Ciclos(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException ex) {
            System.out.println("Error al realizar listado..." + ex.getMessage());
        }
        System.out.println("Ciclos listados con exito...");
        return carteraCiclos;
    }

    public ArrayList create(String newciclo) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("insert into ciclos (nombre) values (?)");
            ps.setString(1, newciclo);
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al crear ciclo..." + ex.getMessage());
        }
        System.out.println("Agregado con exito...");
        return carteraCiclos;
    }

    public ArrayList read() {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from ciclos");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                carteraCiclos.add(new Ciclos(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException ex) {
            System.out.println("Error al realizar consulta..." + ex.getMessage());
        }
        System.out.println("Consulta de ciclos realizada con exito...");
        return carteraCiclos;
    }

    public ArrayList update(int ide, String upciclo) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("update ciclos set nombre = ? where id = ?");
            ps.setString(1, upciclo);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println("Actualizando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar ciclo..." + ex.getMessage());
        }
        System.out.println("Actualizado con exito!!!");
        return carteraCiclos;
    }

    public ArrayList delete(int iddelete) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("delete from ciclos where id = ? ");
            ps.setInt(1, iddelete);
            ps.executeQuery();
            System.out.println("Eliminando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar ciclo..." + ex.getMessage());
        }

        return carteraCiclos;
    }

    public ArrayList search(String ciclob) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from ciclos where nombre =?");
            ps.setString(1, ciclob);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                int id = this.rs.getInt("id");
                String nombre = this.rs.getString("nombre");
                System.out.println("Resultado de la búsqueda:");
                System.out.println("|ID: " + id + "| Nombre: " + nombre + " |");
            } else {
                System.out.println("No se pudo encontrar el ciclo '" + ciclob + "'");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar..." + ex.getMessage());
        }

        return carteraCiclos;
    }
}
