package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Mysql_BD {
    private static final String driver ="com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/prueba";
    private final String user = "root";
    private final String password = "";

    public  Connection conectar() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            if(conn!=null){
                System.out.println("Conexion establecida :D ");
            }
            return conn;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}
