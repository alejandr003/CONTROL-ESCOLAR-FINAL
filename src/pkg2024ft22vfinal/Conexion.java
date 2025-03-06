package pkg2024ft22vfinal;

/**
 *
 * @author aleja
 */

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;

    public Connection conectar() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.cnx = DriverManager.getConnection("jdbc:mariadb://localhost/ce22", "root", "");
            System.out.println("\n:D");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexion..." + ex.getMessage());
        }
        return this.cnx;
    }

    public void desconectar() {
        try {
            cnx.close();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion...");
        }
    }
}