package utez.edu.mx.sisa.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection("jdbc:mysql://" + "localhost" + "/" + "sisa" +
                "?user=" + "root" + "&password=" + "123456" + "&useSSL=false");
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            System.out.println("(^_^) Connection successful ... ");
            con.close();
        } catch (SQLException e) {
            System.out.println("(o_O) Connection error ... " + e);
        }
    }
}

