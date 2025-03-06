package pkg2024ft22vfinal;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class ModeloMaterias extends Conexion{
    ArrayList<Materias> carteraMaterias = new ArrayList<>();
    
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
            this.ps = this.cnx.prepareStatement("select * from materias");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {

                carteraMaterias.add(new Materias(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar..." + ex.getMessage());
        }

        return carteraMaterias;
    }

    public ArrayList create(String newmateria) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("insert into materias (nombre) values (?)");
            ps.setString(1, newmateria);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al crear nueva materia..." + ex.getMessage());
        }
        return carteraMaterias;
    }

    public ArrayList read() {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from materias");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {

                carteraMaterias.add(new Materias(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar..." + ex.getMessage());
        }

        return carteraMaterias;
    }

    public ArrayList update(int ide, String upmateria) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("update materias set nombre = ? where id = ?");
            ps.setString(1, upmateria);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println("Actualizando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar materia..." + ex.getMessage());
        }
        System.out.println("Actualizado con exito!!!");
        return carteraMaterias;
    }

    public ArrayList delete(int iddelete) throws InterruptedException {
        try {
            this.ps = this.cnx.prepareStatement("delete from materias where id = ? ");
            ps.setInt(1, iddelete);
            ps.executeQuery();
            System.out.println("Eliminando ");
            this.time();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar materia..." + ex.getMessage());
        }
        return carteraMaterias;
    }

    public ArrayList search(String materiab) {
        conectar();
        try {
            this.ps = this.cnx.prepareStatement("select * from materias where nombre =?");
            ps.setString(1, materiab);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                int id = this.rs.getInt("id");
                String nombre = this.rs.getString("nombre");
                System.out.println("Resultado de la búsqueda:");
                System.out.println("|ID: " + id + "| Nombre: " + nombre + " |");
            } else {
                System.out.println("No se pudo encontrar la materia '" + materiab + "'");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar..." + ex.getMessage());
        }

        return carteraMaterias;
    }
}
