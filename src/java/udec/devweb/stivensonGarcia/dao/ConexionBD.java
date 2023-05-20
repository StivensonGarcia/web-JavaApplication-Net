package udec.devweb.stivensonGarcia.dao;
/*
autor: Stivenson Garcia Romero
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/music";
    private static final String USUARIO = "s_garcia";
    private static final String CONTRASENA = "12345678";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

