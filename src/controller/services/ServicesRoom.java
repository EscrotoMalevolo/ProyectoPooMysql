package controller.services;

import controller.implement.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicesRoom{
    private final String tabla_Diseño = "diseño";
    
    
    public void guardar_diseño(Connection conexion, String username, Room room){
        try{
            PreparedStatement consulta;
            double Base = room.getBase(), Altura = room.getAltura(), Profundidad = room.getProfundidad();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla_Diseño + "(usuario, base, altura, profundidad) VALUES(?, ?, ?, ?)");
            consulta.setString(1, username);
            consulta.setDouble(2, Base);
            consulta.setDouble(3, Altura);
            consulta.setDouble(4, Profundidad);
            
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. "+ ex.getMessage());
        }
    }
}