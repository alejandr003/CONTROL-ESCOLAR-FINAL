package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author aleja
 */
public class ModeloCC extends Conexion {

    ArrayList<Ciclocuatri> carteracc = new ArrayList<>();

    public void time() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500L);
            System.out.println(".");
        }
        System.out.println("");
    }

    public ArrayList index() {
        carteracc.clear();
        conectar();
        String consulta = "SELECT cc.id, c.id AS id_ciclo, c.nombre AS Ciclo, "
                + "q.id AS id_cuatri, q.nombre AS Cuatrimestre "
                + "FROM ciclo_cuatri cc "
                + "INNER JOIN ciclos c ON cc.id_ciclo = c.id "
                + "INNER JOIN cuatrimestres q ON cc.id_cuatri = q.id "
                + "ORDER BY c.nombre ASC, q.nombre ASC";
        try {
            this.ps = this.cnx.prepareStatement(consulta);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                String nombreciclo = this.rs.getString("Ciclo");
                String nombrecuatri = this.rs.getString("Cuatrimestre");

                carteracc.add(new Ciclocuatri(nombreciclo, nombrecuatri));
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar..." + ex.getMessage());
        }
        return carteracc;
    }

    public ArrayList create(int ciclorelacion, int cuatrirelacion) {
        this.conectar();
        try {
            this.ps = this.cnx.prepareStatement("insert into ciclo_cuatri(id_ciclo, id_cuatri) values (?,?)");
            ps.setInt(1, ciclorelacion);
            ps.setInt(2, cuatrirelacion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al crear nueva relacion..." + ex.getMessage());
        }
        System.out.println("\nAgregado con exito!");
        return carteracc;
    }

    public ArrayList read() {
        carteracc.clear();
        conectar();
        String consulta = "SELECT cc.id, c.id AS id_ciclo, c.nombre AS Ciclo, "
                + "q.id AS id_cuatri, q.nombre AS Cuatrimestre "
                + "FROM ciclo_cuatri cc "
                + "INNER JOIN ciclos c ON cc.id_ciclo = c.id "
                + "INNER JOIN cuatrimestres q ON cc.id_cuatri = q.id "
                + "ORDER BY c.nombre ASC, q.nombre ASC";
        try {
            this.ps = this.cnx.prepareStatement(consulta);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                int id = this.rs.getInt("id");
                int idciclo = this.rs.getInt("id_ciclo");
                String nombreciclo = this.rs.getString("Ciclo");
                int idcuatri = this.rs.getInt("id_cuatri");
                String nombrecuatri = this.rs.getString("Cuatrimestre");

                carteracc.add(new Ciclocuatri(id, idciclo, nombreciclo, idcuatri, nombrecuatri));
            }

        } catch (SQLException ex) {
            System.out.println("Error al crear la consulta..." + ex.getMessage());
        }
        return carteracc;
    }

    public ArrayList update(int ciclo, int cuatri, int ciclocuatri) throws InterruptedException {

        try {
            this.ps = this.cnx.prepareStatement("""
                                                update ciclo_cuatri set id_ciclo = ?,
                                                id_cuatri = ? where ciclo_cuatri.id = ?
                                                """);
            ps.setInt(1, ciclo);
            ps.setInt(2, cuatri);
            ps.setInt(3, ciclocuatri);
            ps.executeUpdate();
            System.out.println("Actualizando ");
            time();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar" + ex.getMessage());
        }
        return carteracc;
    }
    
    public ArrayList delete(int id){
        try {
            this.ps= this.cnx.prepareStatement("delete from ciclo_cuatri where id = ?");
            ps.setInt(1, id);
            ps.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar..."+ ex.getMessage());
        }
    return carteracc;
    }
}
