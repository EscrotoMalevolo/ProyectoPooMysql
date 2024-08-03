package controller.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controller.implement.Item;

public class ServicesItem {
    private final String tabla_Item = "item";
    
    public void guardar_item(Connection conexion, String Username, Item item ){
        try{
            PreparedStatement consulta;
            double Base = item.getBase(), Altura = item.getAltura(), Profundidad = item.getProfundidad();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla_Item + "(usuario, base, altura, profundidad) VALUES(?, ?, ?, ?)");
            consulta.setString(1, Username);
            consulta.setDouble(2, Base);
            consulta.setDouble(3, Altura);
            consulta.setDouble(4, Profundidad);
            
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. " + ex.getMessage());
        }
    }
}